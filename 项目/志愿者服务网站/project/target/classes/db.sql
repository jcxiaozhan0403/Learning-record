#管理员账号表
create table manager (
    id int not null auto_increment primary key,     #编号
    loginId varchar(20) not null,                   #登录名
    realName varchar(10),                           #真实姓名
    pwd varchar(200),                               #密码
    loginCount int,                                 #登陆次数
    lastLoginDt datetime                            #最后登录时间
);

#图片表
create table images (
    id int not null auto_increment primary key,     #编号
    name varchar(200),                              #页面名
    url varchar(200)                                #图片链接
);