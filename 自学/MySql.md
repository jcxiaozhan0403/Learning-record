## 数据库字段类型
```
Java   MySql
byte   tinyint
short  smallint
int    int
long   bigint
float  float
double double
char/String  char/varchar  
            char(8) 不够8位用空格补齐，超出8位报错 varchar(8) 存入几位就是几位，超出8位报错
Date  date/time/datetime/timestamp
        datetime如果未存值，会用null填充
        timestamp如果未存值，会用当前系统时间填充
File   BLOB/TEXT
```

## SQL语句
数据库操作
1. 创建数据库
```
create database 数据库名称 [character 字符集 collate 字符集校对规则]
```

2. 查看数据库
```
简单展示所有数据库
show databases

查看某一个数据库的定义信息
show create database 数据库名称
```

3. 修改数据库
```
alter database 数据库名称 character set 字符集 collate 校对规则
```

4. 删除数据库
```
drop database 数据库名
```

5. 查看当前所在数据库
```
select database()
```

表操作
1. 创建表
```
create table 表名(字段名 字段类型(长度) 约束,字段名 字段类型(长度) 约束)
```

2. 查看表
```
查看某个数据库下的所有表
show tables

查看某个表的结构信息
desc 表名
```

3. 删除表
```
drop table 表名
```

4. 修改表
```
添加列
alter table 表名 add 列名 类型(长度) 约束

修改列的类型、长度、约束
alter table 表名 modify 列名 类型(长度) 约束

删除列
alter table 表名 drop 列名

修改列名
alter table 表名 change 旧列名 新列名 类型(长度) 约束

修改表名
rename table 旧表名 to 新表名

修改表的字符集
alter table 表名 character set 字符集
```

表中数据操作
1. 添加表记录
```
向表中插入某些列
insert into 表名 (列名1,列名2...) values(值1,值2...)

向表中插入所有列
insert into 表名 values(值1,值2,值3...)

注:值的类型是字符串或者是日期类型，使用单引号引起来
```

2. 修改表记录
```
update 表名 set 列名=值,列名=值 [where 条件]
```

3. 删除表记录
```
删除表中某一行记录
delete from 表名 [where 条件]

删除表中所有记录
delete from 表名 //一条一条地删除，属于DML语句

truncate table user //删除整表，复制出有相同结构的表，属于DDL语句
```

4. 查询表记录
```
普通查询
distinct用于去掉重复值
select [distinct] * 列名 from 表名 [where 条件]

给查询列取别名显示
select [distinct] * 列名 别名 from 表名 [where 条件]

条件查询
where子句
>、<、>=、<=、<>、=
like 模糊查询
in 范围查询
条件关联and、or、not

排序查询
order by 字段名称 asc/desc //升序/降序  默认升序

多个排序条件
order by 字段1 asc/desc,字段2 asc/desc

聚合函数
括号里面放列名
sum() 求和
count() 计数
max() 最大值
min() 最小值
avg() 平均值

分组查询
group by 字段名
筛选分组后的结果用having
group by score having score>50
```

## 约束
添加外键
```
alter table 表名 add foreign key(字段) references 指向表名(字段)
```

## 多表设计
一对多:在多的一方创建外键指向一的一方的主键

多对多:需要创建第三张表(中间表),在中间表中至少有两个字段分别作为外键，指向多对多双方的主键

一对一:假设一对一是一个一对多关系，需要在多的一方创建外键指向一的一方的主键，将外键设置为唯一(unique)
