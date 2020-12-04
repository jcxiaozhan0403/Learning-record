create table cls
(clsId Nvarchar(2) constraint pk_clsId primary key,
clsName Nvarchar(10) not null,
clsAdmin Nvarchar(10),
clsTime DateTime)
go

create table student
(clsId Nvarchar(2) constraint fk_clsId references cls(clsId),
stuId Nvarchar(10) constraint pk_stuId primary key,
stuName Nvarchar(10),
stuSex Nvarchar(1),
stuBirthday datetime,
stuAddress Nvarchar(30),
stuPhone Nvarchar(20))
go

create table course
(couId Nvarchar(2) constraint pk_couId primary key,
couName Nvarchar(20),
couKs Int,
couType Nvarchar(10))
go

-- 选课，主键不自增
create table xuanke
(xkId Int constraint pk_xkId primary key,
couId Nvarchar(2) constraint fk_couId references course(couId),
stuId Nvarchar(10) constraint fk_stuId references student(stuId),
couScore Int)
go

--教师
create table teacher
(teaId Nvarchar(10) constraint pk_teaId primary key,
teaName Nvarchar(10),
teaSex Nvarchar(1),
teaZc Nvarchar(10))
go

--排课
create table paike
(pkId Int constraint pk_pkId primary key,
teaId Nvarchar(10) constraint fk_teaId references teacher(teaId),
couId Nvarchar(2) constraint fk_couId references course(couId))
go

drop table cls
go
drop table student
go
drop table course
go
drop table xuanke
go
drop table teacher
go
drop table paike
go