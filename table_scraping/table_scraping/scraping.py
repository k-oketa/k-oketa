import json

import tabula
"""
{   
    往路: [
        {
            千歳駅発: --,
            南千歳駅発: --,
            研究実験棟発: --,
            本部棟着: --,
            備考: --
        },
        ...
            
    ],
    復路: [
        {
            本部棟発: --,
            研究実験棟着: --,
            南千歳駅着: --,
            千歳駅着: --,
            備考: --
        },
        ...
    ] 
}
"""


if __name__ == '__main__':
    dfs = tabula.read_pdf('./new.pdf', lattice=True, pages=1)
    outward_df = dfs[0][['千歳駅発', '南千歳駅発', '研究実験棟発', '本部棟着', '備考']]
    return_df = dfs[1][['本部棟発', '研究実験棟着', '南千歳駅着', '千歳駅着', '備考']]

    outwards = outward_df.to_dict(orient='records')
    returns = return_df.to_dict(orient='records')

    times = {'往路': outwards, '復路': returns}
    print(json.dumps(times, ensure_ascii=False))

