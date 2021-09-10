create table user (
    id int(9) primary key  not null auto_increment,
    username varchar(20) not null,
    password varchar(50) not null,
    name varchar(10),
    avatar varchar(255)
);


create table token (
    token varchar(225) primary key not null,
    user_id int(9) not null,
    foreign key(user_id) references user(id)
);

create table student (
    id int(9) primary key  not null auto_increment,
    name varchar(20) not null,
    age int(3),
    sex int(1),
    num varchar(50),
    grade varchar(10),
    clazz varchar(10),
    address varchar(50)
);

create table clazz (
    id int(9) primary key  not null auto_increment,
    grade varchar(20) not null,
    clazz varchar(20),
    headTeacher varchar(20),
    totalStudent int(10),
    currentTotalStudent int(10)
);

create table teacher (
    id int(9) primary key  not null auto_increment,
    name varchar(20) not null,
    age int(3),
    sex int(1),
    num varchar(50),
    course varchar(20)
);