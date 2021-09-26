import requests
from bs4 import BeautifulSoup


if __name__ == '__main__':
    url = 'https://www.chitose.ac.jp/info/access'
    html = requests.get(url).text
    soup = BeautifulSoup(html, features='html.parser')
    link = soup.find('div', class_='element_type_107')
    pdf_url = link.find('a').get('href')
    response = requests.get('https://www.chitose.ac.jp/' + pdf_url)
    if response.status_code == 200:
        with open('new.pdf', mode='wb') as file:
            file.write(response.content)
            file.close()
