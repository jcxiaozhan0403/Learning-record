create table user (
    id int(9) primary key  not null auto_increment,     #编号
    username varchar(20) not null unique,               #用户名
    password varchar(50) not null,                      #密码
    name varchar(10),                                   #姓名
    avatar varchar(255)                                 #头像地址
);


create table token (
    token varchar(225) primary key not null,            #密钥
    user_id int(9) not null,                            #用户id
    foreign key(user_id) references user(id)
);

create table student (
    id int(9) primary key  not null auto_increment,     #编号
    name varchar(20) not null,                          #姓名
    age int(3),                                         #年龄
    sex int(1),                                         #性别 1：男 0：女
    num varchar(50) unique,                             #学号
    grade varchar(10),                                  #年级
    clazz varchar(10),                                  #班级
    address varchar(50)                                 #家庭住址
);

create table clazz (
    id int(9) primary key  not null auto_increment,     #编号
    grade varchar(20) not null,                         #年级
    clazz varchar(20),                                  #班级
    headTeacher varchar(20),                            #班主任
    totalStudent int(10),                               #人数限定
    currentTotalStudent int(10)                         #当前人数
);

create table teacher (
    id int(9) primary key  not null auto_increment,     #编号
    name varchar(20) not null,                          #姓名
    age int(3),                                         #年龄
    sex int(1),                                         #性别 1：男 0：女
    num varchar(50) unique,                             #工号
    course varchar(20)                                  #科目
);