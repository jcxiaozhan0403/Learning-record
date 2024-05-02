import json
import os


def decrypt_file(dir_path):
    alg_path = dir_path+'/alg'
    algorithms = ''
    while True:
        # print(alg_path)
        if not os.path.exists(alg_path):
            break
        with open(alg_path, 'rb') as file:
            m8873u = bytearray(file.read())

        if not m8873u:
            print("_aaa, name :", alg_path, " buf empty, Read the last file and exit", m8873u)
            break

        bArr = bytearray([1, 7, 9])
        for i in range(len(m8873u)):
            m8873u[i] = (m8873u[i] ^ bArr[i % 3]) ^ (i & 255)

        i2 = m8873u[-1] & 255
        # i2 = m8873u[-1] & -1
        decrypted_item = m8873u[:-1].decode('utf-8')
        algorithms += decrypted_item

        alg_path = dir_path+'/alg' + str(i2)
    return algorithms

def convert_data(input_data,version):
    formatted_str = version[0] + "." + version[1:-1] + "." + version[-1]

    output_data = {
        "version": formatted_str,
        "value": input_data["algorithms"]
    }
    return json.dumps(output_data)

# 使用示例
def start(dir_path):
    decrypted_content = decrypt_file(dir_path)
    # print(decrypted_content)
    print(convert_data(eval(decrypted_content),version))


if __name__ == '__main__':
    # print('注意事项：')
    # print('1、Salt值提取程序源码仅供小伙伴们交流学习，严禁用于牟取任何不正当利益。')
    # print('2、凡是嵌入或二改该代码并外部分享时必须标注原架构开发者【B站-纸鸢花的花语】。')
    # print('3、以上事项违反或无视者均无权使用或二改源码。')
    while True:
        dir_path = input("请输入你所保存的alg文件根目录路径：")
        version = dir_path
        start(dir_path+"/alg/")
