## 安装配置

下载页：https://nginx.org/en/download.html

> Windows

1. 下载压缩包，解压

2. cmd运行`nginx.exe`，默认监听80端口查看是否启动成功`http://localhost:80/`
3. 配置文件`/conf/nginx.conf`
4. 关闭
   - 法一：输入nginx命令 `nginx -s stop`(快速停止nginx) 或 `nginx -s quit`(完整有序的停止nginx)
   - 法二：使用taskkill `taskkill /f /t /im nginx.exe`

```
taskkill是用来终止进程的，
/f是强制终止 .
/t终止指定的进程和任何由此启动的子进程。
/im示指定的进程名称 .
```

> Linux

1. 安装gcc

```
yum install gcc-c++
```

2. PCRE pcre-devel 安装

PCRE(Perl Compatible Regular Expressions) 是一个Perl库，包括 perl 兼容的正则表达式库。nginx 的 http 模块使用 pcre 来解析正则表达式，所以需要在 linux 上安装 pcre 库，pcre-devel 是使用 pcre 开发的一个二次开发库。nginx也需要此库。命令：

```
yum install -y pcre pcre-devel
```

3. zlib 安装

zlib 库提供了很多种压缩和解压缩的方式， nginx 使用 zlib 对 http 包的内容进行 gzip ，所以需要在 Centos 上安装 zlib 库。

```
yum install -y zlib zlib-devel
```

4. OpenSSL 安装

OpenSSL 是一个强大的安全套接字层密码库，囊括主要的密码算法、常用的密钥和证书封装管理功能及 SSL 协议，并提供丰富的应用程序供测试或其它目的使用。
nginx 不仅支持 http 协议，还支持 https（即在ssl协议上传输http），所以需要在 Centos 安装 OpenSSL 库。

```
yum install -y openssl openssl-devel
```

5. 手动下载压缩包安装

   - 解压

   ```
   tar -zxvf nginx-1.18.0.tar.gz
   cd nginx-1.18.0
   ```

   - 配置

   ```shell
   ./configure
   make
   make install
   ```

   - 查找安装目录

   ```shell
   whereis nginx
   ```

## Nginx常用命令

```shell
#切换到执行文件目录
cd /usr/local/nginx/sbin/

#启动
./nginx

#停止
./nginx -s stop

#安全退出
./nginx -s quit

#重新加载配置文件
./nginx -s reload

#查看nginx进程
ps aux|grep nginx
```



