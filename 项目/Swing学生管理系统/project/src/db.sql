# 创建管理员表
create table `admin` (
    `username` varchar(25) default null,
    `password` varchar(255) default null
);

# 创建学生表
create table student (
    stuId int(9) primary key  not null auto_increment,
    stuName varchar(20) not null,
    stuSex varchar(2) not null,
    stuAge int(3),
    stuCls varchar(20) not null
);