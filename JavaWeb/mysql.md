1. 查看是否安装Mysql
看服务
2. 干掉Mysql服务
```
sc delete mysql
```
3. 下载地址
```
https://downloads.mysql.com/archives/community/
```
4. 安装服务
```
管理员身份cmd进入mysql的bin目录
mysqld --install
```
5. 初始化data目录
```
普通身份cmd进入mysql的bin目录
mysqld --initialize-insecure
```
6. 启动服务
```
net start mysql
```
7. 登录
```
mysql -u用户名 -p 密码 数据库名
```
8. 创建数据库
```
create database 数据库名 charset utf8mb4
```
9. 创建用户
```
create user ``
```