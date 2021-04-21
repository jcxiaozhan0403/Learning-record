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
    signDatetime datetime not null,                 #签到时间
    signDate date not null,                         #签到日期
    temperature decimal(18,1),                      #温度
    working int not null,                           #是否在岗(1:是 0:否)
    hadTravel int not null,                         #是否出行(1:是 0:否)
    address varchar(100),                           #签到地址
    jkt int not null,                               #是否申请健康通(1:是 0:否)
    jktColor varchar(20)                            #健康通颜色(绿;红;黄)
);

#约束一天只能签一次
create unique index signIn_index on signIn(studentId, signDate);

#管理员账号表
create table manager (
    id int not null auto_increment primary key,     #编号
    loginId varchar(20) not null,                   #登录名
    realName varchar(10),                           #真实姓名
    pwd varchar(200),                               #密码
    loginCount int,                                 #登陆次数
    lastLoginDt datetime                            #最后登录时间
);

create  unique index manager_index1 on manager(loginId);

#填充学生表
insert into student(name,mobile,studentId,gender,birthday) values('王坤','15390466220','19404025','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('李家志','17745096571','19301147','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('马昆','19960796404','19301079','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('胡元鑫','17790409784','19301152','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('郑健军','13608130135','19301057','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('陶勇','18383189948','19301156','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('刘芮豪','16608012037','19301051','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('周圳南','18423068622','19301144','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('廖希','17628639137','19301160','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('李爽','18982379506','19604076','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('周强','17721995859','19415010','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('袁杨','18349284026','19301024','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('罗海人','13540549866','19301058','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('余磊','18382458947','19301142','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('陈泓如','18090984062','19301157','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('汪怀玉','17345222716','19301143','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('徐代藩','17666563520','19301070','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('邓阳','13350433242','19301204','2','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('李伟','15775726217','19404041','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('陈思源','13458907615','19405155','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('杨继顺','18090445117','19405076','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('何雨林','13648067552','19301021','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('朱锴','17745094117','19301016','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('罗乙财','15756593857','19301017','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('罗文贤','15828142923','19301205','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('廖贤龙','17780483314','19301176','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('江亨龙','18280424101','19301001','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('郑伦攀','13648119034','19301116','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('叶小春','18608249624','19301072','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('王涛','17628627515','19301132','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('李磊','18980540076','19301005','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('杨国辉','17683297124','19131067','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('彭明远','17628483471','19206219','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('廖章涛','18380139716','19301015','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('向贵敏','13419171453','19301041','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('梁古强','17760032344','19510003','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('王龙云','13086482808','19510005','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('谢玲星','18081652389','19302028','2','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('杨超','17581735542','19302076','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('王红','17790409320','19302152','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('廖超国','17398823925','19401150','1','2001-01-01');
insert into student(name,mobile,studentId,gender,birthday) values('蒋经师','15381845143','19302155','1','2001-01-01');

#签到表
insert into signIn(studentId,signDatetime,signDate,working,hadTravel,jkt) values ('19604076','2021-4/14 16:10:38','2021-4/14','1','0','1')