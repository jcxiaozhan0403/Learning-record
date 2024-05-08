import re

text = "尊敬的用户：\n\n您正在进行帐号相关操作，验证码：\n\n------\n463590\n------\n\n请及时输入验证码。若非本人操作，请忽视此邮件。"

str = re.search(r'\n(\d+)\n',text).group(1)

print(str)