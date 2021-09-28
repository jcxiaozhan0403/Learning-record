create database `student-manager-ssm`;

use `student-manager-ssm`;

create table `user` (
    id int(9) primary key  not null auto_increment,
    username varchar(20) not null,
    password varchar(50) not null,
    name varchar(10)
);

create table student (
    id int(9) primary key  not null auto_increment,
    `name` varchar(20) not null,
    age int(3),
    sex varchar(5),
    cls varchar(50),
    num varchar(50)
);