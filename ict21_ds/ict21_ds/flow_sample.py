import string

import openpyxl
import pandas as pd

import project

if __name__ == '__main__':
    df = pd.DataFrame(columns=['回答者番号', '回答内容'])
    for q_num in range(1, 24):
        q_df = pd.read_csv(project.data_dir + 'D/Q[{}].csv'.format(q_num), header=2, encoding='shift-jis')
        q_df = q_df.rename(columns={'[回答者番号': '回答者番号', ' 回答内容]': '回答内容'})
        q_df = q_df[['回答者番号', '回答内容']]
        df = pd.merge(df, q_df, on='回答者番号', suffixes=('', '_{}'.format(q_num)), how='outer')
    df = df.replace({'強くそう思う': 5, 'ややそう思う': 4, 'どちらとも言えない': 3, 'あまりそう思わない': 2, '全くそう思わない': 1})
    df = df.replace({'５点：': 5, '４点：': 4, '３点：': 3, '２点：': 2, '１点：': 1})
    df = df.replace({'非常に多い': 5, 'やや多い': 4, '適度': 3, 'やや少ない': 2, '非常に少ない': 1})
    df = df.replace({'速すぎる': 5, 'やや速い': 4, '適度': 3, 'やや遅い': 2, '非常に遅い': 1})
    df = df.replace({'10割': 5, '8・9割': 4, '8?9割': 4, '6・7割': 3, '4・5割': 2, '3割以下': 1})
    df = df.replace({'4）上記をmixした講義': 4, '3）Zoom等、リアルタイム双方向型のオンライン講義': 3, '2）ビデオ配信形式のオンライン講義': 2, '1）通常の対面講義': 1})
    df.to_csv(project.data_dir + 'tmp.csv', index_label=False, index=False)
    wb = openpyxl.load_workbook(project.data_dir + 'template.xlsx')
    ws = wb.active
    student_number_cell = ws['H122']
    student_number_cell.value = df['回答者番号'].count()
    alphabets = [alphabet for alphabet in string.ascii_uppercase][3:23]
    for alphabet, q_number in zip(alphabets, range(2, 22)):
        count_dict = {5: None, 4: None, 3: None, 2: None, 1: None}
        count_each_result = df['回答内容_{}'.format(q_number)].value_counts().to_dict()
        for score in count_dict.keys():
            try:
                count_dict[score] = count_each_result[score]
            except KeyError:
                count_dict[score] = 0
        cells = ws['{}127:{}131'.format(alphabet, alphabet)]
        for data, cell in zip(count_dict.values(), cells):
            cell[0].value = data
    q23_dict = {1: None, 2: None, 3: None, 4: None}
    q23_result = df['回答内容_21'].value_counts().to_dict()
    for score in q23_dict.keys():
        try:
            q23_dict[score] = q23_result[score]
        except KeyError:
            q23_dict[score] = 0
    cells = ws['X162':'X165']
    for data, cell in zip(q23_dict.values(), cells):
        cell[0].value = data
    wb.save(project.data_dir + 'saved.xlsx')