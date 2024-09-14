import imaplib
import email
from email.header import decode_header
import chardet
import getpass


def read_full_email_content():
    # 交互式获取用户名和密码
    username = input("请输入您的Outlook邮箱地址: ")
    password = input("请输入您的密码: ")

    # 连接到IMAP服务器
    mail = imaplib.IMAP4_SSL('outlook.office365.com')
    mail.login(username, password)
    mail.select("inbox")  # 选择收件箱

    # 搜索所有邮件
    typ, data = mail.search(None, 'ALL')
    if data and data[0]:
        # 获取最新的邮件ID
        latest_email_id = data[0].split()[-1]

        if latest_email_id:
            typ, message_parts = mail.fetch(latest_email_id, '(RFC822)')
            if typ == 'OK':
                raw_email = message_parts[0][1]
                # 解析原始邮件数据
                msg = email.message_from_bytes(raw_email)

                # 输出邮件基本信息
                print("Subject:", decode_email_header(msg['Subject']))
                print("From:", decode_email_header(msg['From']))
                print("Date:", msg.get('Date'))

                # 处理邮件正文
                for part in msg.walk():
                    content_type = part.get_content_type()
                    content_disposition = str(part.get('Content-Disposition'))

                    # 获取邮件文本内容
                    if content_type == 'text/plain' and 'attachment' not in content_disposition:
                        body = part.get_payload(decode=True)
                        encoding = chardet.detect(body)['encoding']
                        if encoding:
                            try:
                                body = body.decode(encoding)
                                print("Body (Text):")
                                print(body)
                            except UnicodeDecodeError:
                                print("Could not decode text body.")

                    # 获取HTML内容
                    elif content_type == 'text/html' and 'attachment' not in content_disposition:
                        body = part.get_payload(decode=True)
                        encoding = chardet.detect(body)['encoding']
                        if encoding:
                            try:
                                body = body.decode(encoding)
                                print("Body (HTML):")
                                print(body)
                            except UnicodeDecodeError:
                                print("Could not decode HTML body.")

                    # 处理附件
                    elif 'attachment' in content_disposition:
                        filename = part.get_filename()
                        if filename:
                            fp = open(filename, 'wb')
                            fp.write(part.get_payload(decode=True))
                            fp.close()
                            print(f'Saved attachment: {filename}')


def decode_email_header(header):
    try:
        decoded_header = decode_header(header)[0]
        if isinstance(decoded_header[0], bytes):
            return decoded_header[0].decode(decoded_header[1] or 'utf-8')
        else:
            return decoded_header[0]
    except Exception as e:
        print(f"Error decoding header: {e}")
        return header


if __name__ == "__main__":
    read_full_email_content()