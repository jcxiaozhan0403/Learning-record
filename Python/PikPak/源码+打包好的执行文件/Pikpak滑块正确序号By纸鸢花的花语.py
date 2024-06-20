def item_compare(img_list, mode_list):
    score = 0
    rank = 0
    for i in range(3):
        for j in range(3):
            if img_list[i][j] != mode_list[i][j]:
                score += 1
    print(score)
    if score == 2:
        rank += 1
    return rank


def list_compare(frames):
    # 存储差异结果
    score_list = []
    flag = 0
    # 遍历当前每一行
    for frame in frames:
        # 取出行序列
        img_list = frame["matrix"]
        scores = 0
        # 遍历当前每一行
        for mode_frame in frames:
            mode_list = mode_frame["matrix"]
            # 行序列与全部进行对比
            one_score = item_compare(img_list, mode_list)
            scores += one_score
        score_list.append(scores)
        flag += 1
    print(score_list)
    for i in range(12):
        if score_list[i] == 11:
            print("Currently verify the correct serial number of the image：", i)
            return i


# def transform_coordinates(data):
#     for item in data:
#         for i in range(len(item['matrix'])):
#             for j in range(len(item['matrix'][i])):
#                 # 分割字符串得到x和y，然后重新组合为y,x
#                 x_y = item['matrix'][i][j].split(',')
#                 item['matrix'][i][j] = ','.join(reversed(x_y))
#     return data

if __name__ == '__main__':
    # pic_list_data内需粘贴图片验证码的列表数据
    pic_list_data = [
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,0",
                    "1,1",
                    "0,2"
                ],
                [
                    "0,1",
                    "1,2",
                    "2,2"
                ],
                [
                    "2,0",
                    "1,0",
                    "2,1"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,0",
                    "0,2",
                    "1,1"
                ],
                [
                    "1,2",
                    "0,1",
                    "2,2"
                ],
                [
                    "1,0",
                    "2,0",
                    "2,1"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,2",
                    "0,0",
                    "1,1"
                ],
                [
                    "1,2",
                    "2,2",
                    "0,1"
                ],
                [
                    "2,1",
                    "1,0",
                    "2,0"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,2",
                    "1,1",
                    "0,0"
                ],
                [
                    "1,2",
                    "2,2",
                    "0,1"
                ],
                [
                    "2,1",
                    "2,0",
                    "1,0"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,2",
                    "1,1",
                    "0,0"
                ],
                [
                    "0,1",
                    "2,2",
                    "1,2"
                ],
                [
                    "1,0",
                    "2,0",
                    "2,1"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "1,1",
                    "0,0",
                    "0,2"
                ],
                [
                    "0,1",
                    "1,2",
                    "2,2"
                ],
                [
                    "1,0",
                    "2,0",
                    "2,1"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,0",
                    "0,2",
                    "1,1"
                ],
                [
                    "0,1",
                    "1,2",
                    "2,2"
                ],
                [
                    "2,0",
                    "1,0",
                    "2,1"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,0",
                    "1,1",
                    "0,2"
                ],
                [
                    "0,1",
                    "2,2",
                    "1,2"
                ],
                [
                    "2,0",
                    "1,0",
                    "2,1"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,0",
                    "1,1",
                    "0,2"
                ],
                [
                    "1,2",
                    "0,1",
                    "2,2"
                ],
                [
                    "2,0",
                    "1,0",
                    "2,1"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,0",
                    "1,1",
                    "0,2"
                ],
                [
                    "0,1",
                    "1,2",
                    "2,2"
                ],
                [
                    "2,0",
                    "1,0",
                    "2,1"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,0",
                    "0,2",
                    "1,1"
                ],
                [
                    "2,2",
                    "1,2",
                    "0,1"
                ],
                [
                    "1,0",
                    "2,1",
                    "2,0"
                ]
            ]
        },
        {
            "row": 3,
            "column": 3,
            "matrix": [
                [
                    "0,0",
                    "1,1",
                    "0,2"
                ],
                [
                    "1,2",
                    "2,2",
                    "0,1"
                ],
                [
                    "1,0",
                    "2,0",
                    "2,1"
                ]
            ]
        }
    ]

    # # 调用函数并打印结果
    # transformed_data = transform_coordinates(pic_list_data)

    list_compare(pic_list_data)
