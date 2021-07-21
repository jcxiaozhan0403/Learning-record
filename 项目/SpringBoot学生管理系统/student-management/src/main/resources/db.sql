create user 'admin'@'localhost' identified by '123456';

grant all on `student-manager`.* to 'admin'@'localhost';

#管理员账号表
create table manager (
     id int not null auto_increment primary key,     #编号
     userName varchar(20) not null,                  #用户名
     realName varchar(10) not null,                  #真实姓名
     pwd varchar(200) not null,                      #密码
     introduction varchar(200),                      #简介
     avatar varchar(200) not null,                   #头像
     lastLoginDt datetime                            #最后登录时间
);

#token表
create table token (
     id int not null auto_increment primary key,     #编号
     userName varchar(20) not null,                  #用户名
     token varchar(200) not null                     #token值
);