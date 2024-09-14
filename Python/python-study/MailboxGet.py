import pandas as pd

# 假设你的邮箱信息存储在名为'emails.txt'的文本文件中
file_path = 'email.txt'

# 读取文件，并处理每一行数据
emails_data = []
with open(file_path, 'r', encoding='utf-8') as file:
    for line in file:
        # 使用split方法按'----'分割每行，并去除首尾空白字符
        email, info = line.strip().split('----')
        emails_data.append({'Email': email, 'Info': info})

    # 使用处理后的数据创建DataFrame
df = pd.DataFrame(emails_data)

# 将DataFrame写入Excel文件，这里使用openpyxl作为引擎
excel_path = 'emails.xlsx'
df.to_excel(excel_path, index=False, engine='openpyxl')

print(f'Excel文件已保存到：{excel_path}')