import requests,base64,json,time
from threading import Thread
from lxml import html
from datetime import datetime

# 全局变量
# url
url = ""

# 计数器
count = 1

# 启动时间
start_time = time.time()

# 节点集
list = []

# 总耗时
time_total = 0.0

# 网站1：https://freeclash.org/
def get_from_freeclash():
    try:
        global url
        url = "https://freeclash.org/"
        response = requests.get(url)

        # 使用lxml的html模块来解析HTML内容
        html_tree = html.fromstring(response.content)
        # 使用XPath查询元素
        # 注意：XPath表达式可能需要根据实际的网页结构进行调整
        elements = html_tree.xpath('//*[@id="app"]/main/div/div[1]/div/ul/li[1]/div/div[3]/h2/a')
        today_link = elements[0].get('href')

        if today_link != '':
            response = requests.get(today_link)
            # 使用lxml的html模块来解析HTML内容
            html_tree = html.fromstring(response.content)
            elements = html_tree.xpath('//*[@id="app"]/main/div/div[1]/div[1]/div[2]/div[2]/div[1]/p[16]')
            v2ray_url = elements[0].text

        if v2ray_url != '':
            response = requests.get(v2ray_url)
            # 使用lxml的html模块来解析HTML内容
            html_tree = html.fromstring(response.content)
            return html_tree.text
    except Exception:
        print("网站：https://freeclash.org/ 解析失败")
        return ''


# 网站2：https://github.com/Pawdroid/Free-servers
def get_from_github():
    try:
        global url
        url = "https://github.com/Pawdroid/Free-servers"
        response = requests.get(url)
        html_tree = html.fromstring(response.content)
        elements = html_tree.xpath('//*[@id="repo-content-pjax-container"]/div/div/div[2]/div[1]/react-partial/div/div/div[3]/div[2]/div/div[2]/article/div/pre/code')
        return elements[0].text
    except Exception:
        print("网站：https://github.com/Pawdroid/Free-servers 解析失败")
        return ''

# 网站3：https://proxypool.link/vmess/sub
def get_from_proxypool():
    try:
        global url
        url = "https://proxypool.link/vmess/sub"
        response = requests.get(url)
        # 使用lxml的html模块来解析HTML内容
        html_tree = html.fromstring(response.content)
        return html_tree.text
    except Exception:
        print("网站：https://proxypool.link/vmess/sub 解析失败")
        return ''

# 网站4：https://banyunxiaoxi.icu/
def get_from_xiaoxi():
    try:
        global url
        url = "https://banyunxiaoxi.icu/"
        response = requests.get(url)
        # 使用lxml的html模块来解析HTML内容
        html_tree = html.fromstring(response.content)
        elements = html_tree.xpath('/html/body/div[2]/div/div/div[1]/div[2]/div[3]/span[3]/a')
        today_link = elements[0].get('href')

        if today_link != '':
            response = requests.get(today_link)
            # 使用lxml的html模块来解析HTML内容
            html_tree = html.fromstring(response.content)
            elements = html_tree.xpath('//*[@id="lightgallery"]/blockquote/p')
            return elements[0].text_content()
    except Exception:
        print("网站：https://banyunxiaoxi.icu/ 解析失败")
        return ''


# 网站5：https://nodefree.org/
def get_from_nodefree():
    try:
        global url
        url = "https://nodefree.org/"
        response = requests.get(url)

        # 使用lxml的html模块来解析HTML内容
        html_tree = html.fromstring(response.content)
        # 使用XPath查询元素
        # 注意：XPath表达式可能需要根据实际的网页结构进行调整
        elements = html_tree.xpath('//*[@id="wrap"]/div/main/section/div/ul/li[1]/div[2]/h2/a')
        today_link = elements[0].get('href')

        if today_link != '':
            response = requests.get(today_link)
            # 使用lxml的html模块来解析HTML内容
            html_tree = html.fromstring(response.content)
            elements = html_tree.xpath('//*[@id="post-2067"]/div[1]/div[2]/div[1]/div/div/p[1]')
            v2ray_url = elements[0].text

        if v2ray_url != '':
            response = requests.get(v2ray_url)
            # 使用lxml的html模块来解析HTML内容
            html_tree = html.fromstring(response.content)

            return html_tree.text
    except Exception:
        print("网站：https://nodefree.org/ 解析失败")
        return ''


# 写入文件
def wirte_to_file(list):
    # 获取当前日期，并格式化为字符串，用于文件名
    today = datetime.now().strftime('%Y-%m-%d')
    file_name = f'{today}.txt'

    with open(file_name, 'w') as file:
        for i in list:
            file.write(i + "\n")

def messges():
    global count
    global url
    global start_time
    global time_total
    this_time = time.time()
    print(f"网站{count}：{url}  爬取成功，用时{(this_time - start_time):.2f}秒")
    count = count + 1
    time_total = time_total + (this_time - start_time)
    start_time = time.time()

if __name__ == '__main__':
    list.append(base64.b64decode(get_from_freeclash().encode('utf-8')).decode('utf-8'))
    messges()
    list.append(get_from_github())
    messges()
    list.append(base64.b64decode(get_from_proxypool().encode('utf-8')).decode('utf-8'))
    messges()
    list.append(get_from_xiaoxi())
    messges()
    list.append(base64.b64decode(get_from_nodefree().encode('utf-8')).decode('utf-8'))
    messges()
    wirte_to_file(list)
    print(f"总耗时：{time_total:.2f}秒")