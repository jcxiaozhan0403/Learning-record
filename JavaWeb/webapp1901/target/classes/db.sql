create database webapp1901 charset utf8mb4;

create user 'webapp1901'@'localhost' identified by 'webapp1901';

grant all on webapp1901.* to 'webapp1901'@'localhost';

#学生表
create table student (
    id int not null auto_increment primary key,     #编号
    studentId varchar(8) not null,                  #学号
    pwd varbinary(100),                             #密码
    name varchar(20) not null,                      #姓名
    gender int not null,                            #性别(1:男 2:女)
    birthday date not null,                         #出生日期
    mobile char(11) not null,                       #电话
    address varchar(100)                            #地址
);

create unique index student_index1 on student(studentId);

#签到表
create table signIn (
    id int not null auto_increment primary key,     #编号
    studentId varchar(8) not null,                  #学号
    signDate date not null,                         #签到时间
    temperature decimal(18,1),                      #温度
    working int not null,                           #是否在岗(1:是 0:否)
    hadTravel int not null,                         #是否出行(1:是 0:否)
    address varchar(100),                           #签到地址
    jkt int not null,                               #是否申请健康通(1:是 0:否)
    jktColor varchar(20)                            #健康通颜色(绿;红;黄)
);

create unique index signIn_index on signIn(studentId, signDate);