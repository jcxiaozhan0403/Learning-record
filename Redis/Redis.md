## 数据库操作架构的发展史

> 1. 单机MySQL的年代

<img src="./架构1.jpg">

90年代的网站，数据访问量不大，单个数据库足够用，所以直接通过后台操作数据库即可

缺点：

- 数据量较大之后，一个数据库无法完成存储工作
- 数据的索引，机器内存不够用
- 读写混合，较大的访问量服务器承受不了

> 2. 缓存 + MySQL + 垂直拆分(读写分离)

网站对数据库的操作，80%都是读，我们可以使用缓存来存放查询的数据，减少与数据库的交互，提高效率

缓存的发展历程：优化数据结构和索引 ==> 文件缓存(I/O) ==> Memcached(当时最火的缓存技术)

<img src="./架构2.jpg">

> 3. 分库分别 + 水平拆分 + MySQL集群

技术发展，不断优化，分库分表提高了写的效率

<img src="./架构3.jpg">

> 最近几年

MySQL等关系数据库不够用了，数据量大，数据变化快

一些大文件。比如图片、博客文章等，需要用专门的数据库进行存储，减少MySQL的压力

> 目前一个基本的互联网项目

<img src="./架构4.jpg">

## 什么是NoSQL

NoSQL： not only sql

泛指非关系型数据库，随着web2.0互联网的诞生；传统的关系型数据库很难对付web2.0时代！尤其是大规模高并发的社区！暴露出来难以克服的问题，NoSQL在当今大数据环境下发展十分迅速，Redis是发展最快的，当下要掌握的东西

关系型数据库：表格，行，列（POI技术），

很多的数据类型用户的个人信息，社交网络，地理位置，这些数据类型的存储不需要一个固定格式！不需要多余的操作就可以横向扩展！Map<String,Object>,使用键值对来控制

## NoSQL的特点

1. 方便扩展：数据之间没有关系，很好扩展
2. 大数据量高性能：Redis一秒可以写8万次，读取11万次，NoSQL的缓存记录级，是一种细粒度的缓存，性能比较高
3. 数据类型是多样型的：不需要事先设计数据库，随取随用

传统的RDBMS和NoSQL区别：

> 传统的RDBMS

```
- 结构化组织
- SQL
- 数据和关系都存在单独的表中 row col
- 数据操作，数据定义语言
- 严格的一致性
- 。。。。
```

> NoSQL

```
- 不仅仅是数据
- 没有固定的查询语言
- 键值对存储，列存储，文档存储，图形数据库（社交关系）
- 最终一致性
- CAP定理和BASE（异地多活） 初级架构师
- 高性能，高可用，高可扩展
- 。。。。
```

大数据的3V：主要是描述问题的

1. 海量Volume
2. 多样Variety
3. 实时Velocity

三高：对程序的要求

1. 高并发
2. 高可扩：随时水平拆分，机器不够了，可以扩展机器来解决
3. 高性能：保证用户体验和性能

## NoSQL四大类

### K-V键值对

- 新浪：Redis
- 美团：Redis + Tair
- 阿里，百度：Redis + Memacache

### 文档数据库

- MongoDB（一般必须要掌握）
  - MongoDB是一个基于分布式文件存储的数据库，C++编写，主要用来处理大量的文档
  - MongoDB是一个介于关系型数据库和非关系型数据库中间的产品！MongoDB是非关系型数据库中功能最丰富，最像关系型数据库的
- ConthDB

### 列存储数据库

- HBase
- 分布式文件系统

### 图关系数据库

- 不是存图形的，放的是关系
- Neo4j，InfoGrid

### 区别

![NoSQL四大类](D:\Study\Learning-record\Redis\NoSQL四大类.jpg)

## Redis概述

1. 官网：https://redis.io/
2. 中文网 ：http://www.redis.cn/

### Redis是什么

> Redis（Remote Dictionary Server )，即远程字典服务，是一个开源的使用ANSI C语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。从2010年3月15日起，Redis的开发工作由VMware主持。从2013年5月开始，Redis的开发由Pivotal赞助。

免费和开源！是当下最热门的NoSQL技术

区别的是redis会周期性的把更新的数据写入磁盘或者把修改操作写入追加的记录文件，并且在此基础上实现了master-slave(主从)同步。

### Redis能干嘛

1. 内存存储，持久化，内存中是断电即失，所以说持久化很重要，（rdb，aof）
2. 效率高，可以用于高速缓存
3. 发布订阅系统
4. 地图信息分析
5. 计时器，计数器（浏览量）

### 特性

1. 多样的数据类型
2. 持久化
3. 集群
4. 事务

## Redis安装

==官方推荐Redis在Linux环境下搭建，Windows版本已经很久没有维护了==

### Windows下安装

1. 下载windows版压缩包

https://github.com/microsoftarchive/redis/releases

2. 解压即可
3. 运行服务端`redis-server.exe`，运行客户端`redis-cli.exe`
4. 客户端测试连通性`ping`

### Linux下安装

1. 下载压缩包

最新稳定版：https://download.redis.io/redis-stable.tar.gz

2. 解压压缩包

```
tar -zxvf redis-stable.tar.gz
```

3. 进入解压出的文件夹，可以看到配置文件

![redis-linux文件目录](D:\Study\Learning-record\Redis\redis-linux文件目录.jpg)

4. 基本环境安装

```
yum install gcc-c++
make
make install
```

5. Linux的默认安装路径为`/usr/local/bin`，我们可以此路径下找到redis的启动程序
6. 将redis的配置文件复制到启动目录下，便于修改

```
cd /usr/local/bin

mkdir conf

cp /home/john/redis/redis-stable/redis.conf conf
```

7. 修改配置文件，使redis变为后台启动

![redis后台启动](D:\Study\Learning-record\Redis\redis后台启动.jpg)

7. 通过指定配置文件启动redis

- 启动服务端

```
redis-server conf/redis.conf
```

- 启动客户端

```
redis-cli -p 6379
```

![linux启动redis](D:\Study\Learning-record\Redis\linux启动redis.jpg)

8. 关闭redis

```bash
#关闭服务
shutdown

#退出
exit
```

![linux关闭redis](D:\Study\Learning-record\Redis\linux关闭redis.jpg)

## Redis基础

redis有16个基础数据库，默认使用的是第0个数据库

一些基本的操作命令

```bash
#切换数据库
select 3

#查看当前数据库大小
dbsize

#查看当前数据库所有的key
key *

#清空当前数据库
flushdb

#清空所有数据库
flushall
```

> 为什么redis是单线程的

redis是基于内存操作的，所以CPU不是redis的性能瓶颈，redis的性能瓶颈是机器的内存以及网络带宽，所以可以使用单线程来实现。

redis是C语言编写的，官方提供的数据为10w+ QPS，说明性能方面完全不比memcache差

> 为什么redis单线程还更快

- 误区一：高性能一定是多线程
- 误区二：多线程一定比单线程效率高

速度方面简单对比：CPU > 内存 > 硬盘

redis将所有数据放在内存中，所以使用单线程操作效率就是最高的，因为多线程涉及到CPU调度，CPU调度存在上下文切换，上下文切换会带来额外耗时。

对于内存系统来说，如果没有上下文切换，效率就是最高的。

## 五大数据类型

### Redis-Key

官方命令查询网址：http://www.redis.cn/commands.html

```bash
#set值
set key value

#查看当前db的所有key
keys *

#得到key的value
get key

#是否存在key，存在返回1，不存在返回0
exists key

#移动键到另外一个数据库，共有16个数据库，默认为0
move key db

#设置过期时间，单位是秒
expire key 秒数

#查看还有多少时间过期
ttl key

#查看key的具体类型
type key
```

### String

- 字符串简单操作、计数器

```bash
#向key所对应的value追加一个字符串，如果当前key不存在，就相当于set
append key "字符串"

#获取字符串长度
strlen key

#加一
incr key

#减一
decr key

#增加指定长度
incrby value 长度

#减少指定长度
decrby value 长度
```

- 字符串范围

```bash
#指定截取字符串显示[strat,end]
getrange key start end
#当end值为-1时，表示截取到字符串结束为止
getrange key 0 -1

#新的字符串从指定位置开始进行字符串替换操作
setrange key offset string
```

- 键值对时效

```bash
#设置一个键值对，在指定时间后过期，单位：秒
# setex(set with expire) 
setex key 10 value

#查看键值对剩余有效时间，-1表示永久有效
ttl key

#保证键值对唯一创建，只有在键不存在时可以创建，若键已存在，则创建失败
# setnx(set if not exist) 
setnx key value
```

```bash
#同时设置多个值
mset k1 v1 k2 v2 ...

#同时获取多个值
mget k1 k2 ...

#msetnx是一个原子性的操作，要么都成功，要么都失败
msetnx k1 v1 k2 v2 ...

#对象
#设置一个user:1对象，值为json字符串来保存一个对象
set user:1 {name:zhangsan,age:3}

#批量设置对象属性
#这里的key是一个巧妙的设计，user:{id}:{field}，如此设计在redis中是完全可以的
mset user:1:name zhangsan user:1:age 20

#获取并更新
#如果不存在值则返回nil，如果存在值怎返回现在值，然后赋新值
getset key value
```

String类似的使用场景：value除了是我们的字符串还可以是数字

- 计数器
- 统计多单位的数量 uid
- 粉丝数
- 对象缓存存储

### List

所有的list命令都是以`l`来开头的，不区分大小写命令

```bash
# 插入元素到列表
lpush list one

# 获取所有元素
lrange list 0 -1

# 获得指定集合内指定区域的元素，[0,1]
lrange list 0 1

# 从集合尾部插入元素
rpush list four

# 移除列表的第一个元素
lpop key

# 移除列表的最后一个元素
rpop key

# 获取索引位置的值
lindex key 0

# 获取列表长度
llen list

# 移除指定的值
# 删除count个value，从前往后删除，精确匹配
lrme key count value

# list截断
# 截取list的start到stop之间的所有元素，左右都闭合，这个list就已经被改变了，只剩下截取的元素
ltrim key start stop

# 移除列表的最后一个元素并添加到目的列表的第一个
rpoplpush source destination

# 设置list的index下标位置的值为element，只有存在这个index下标才可以使用，否则会报错
lset list index element

# 在pivot之前或之后插入值
linsert list before|after pivot element
```

- list实际上一个链表，before Node after，左右都可以插入
- 如果key不存在，创建新的链表
- 如果存在，新增内容
- 如果移除了所有值，空链表，不存在
- 在两边改动效率最高，中间元素效率会低一点

消息排队，消息队列（Lpush Rpop），栈空间（Lpush Lpop）

### Set

set中的值是不能重复的

```bash
# 向set中添加元素
sadd myset value

# 查看set里面的所有值
smembers myset

# 获取set的元素个数
scard myset

# 判断value值是否在set中
sismember myset value

# 移除value元素
srem myset value
```

```bash
# 随机抽出指定个数元素
srandmember myset count

# 随机删除一些set集合中的元素
spop myset count

# 一个集合中的指定元素移动到另一个集合中
smove source destination value
```

```bash
# 数字集合类：
# 差集
sdiff key1 key2

# 交集
# 共同好友就可以这样实现
sinter key1 key2

# 并集
sunion key1 key2 
```

共同关注，共同爱好，二度好友

### Hash

```bash
# 存入一个键值对
hset myhash filed value

# 存入多个键值对
hmset myhash f1 v1 f2 v2 f3 v3

# 获取一个指定键的值
hget myhash field

# 获取多个指定键的值
hmget myhash f1 f2 f3

# 获取所有的键值对
hgetall myhash

# 删除指定键值对
hdel myhash filed

# 获取hash的内容长度
hlen myhash

# 判断hash中的某个filed是否存在
hexists key field

# 获取hash的所有键（key）
hkeys key

# 获取hash的所有值
hvals key

# 自增count
hincrby key filed count

# 自减
hdecrby key field count
```

hash存储变更的数据user name age，尤其是用户信息之类的，经常变动的信息，hash更适用于对象的存储，String更适合字符串的存储。

### Zset

```bash
# 添加值，score代表优先级，可以一次添加多个
zadd key score value [score2 value2]

# 获取start-end的值，0 -1代表获取所有值
zrange key start end

# 排序如何实现
# 对集合通过score排序， 默认升序，不显示score
zrangebyscore key startscore endscore

# 降序排列所有值
zrevrange salary 0 -1

# 显示score
zrangebyscore key -inf inf withscores

# 移除元素
zrem key member [member]

# 获取集合中值的个数
zcard key

# 获取集合中指定范围的值的个数
zcount key start end
```

案例思路：set 排序 存储班级成绩表，工资表排序

普通消息：1.重要消息 2.带权重进行判断

排行榜应用实现，取top n测试

