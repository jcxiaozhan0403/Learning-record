## 数据库操作架构的发展史

> 单机MySQL的年代

<img src="./架构1.jpg">

90年代的网站，数据访问量不大，单个数据库足够用，所以直接通过后台操作数据库即可

缺点：

- 数据量较大之后，一个数据库无法完成存储工作
- 数据的索引，机器内存不够用
- 读写混合，较大的访问量服务器承受不了

> 缓存 + MySQL + 垂直拆分(读写分离)

网站对数据库的操作，80%都是读，我们可以使用缓存来存放查询的数据，减少与数据库的交互，提高效率

缓存的发展历程：优化数据结构和索引 ==> 文件缓存(I/O) ==> Memcached(当时最火的缓存技术)

<img src="./架构2.jpg">

> 分库分别 + 水平拆分 + MySQL集群

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
keys *

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

#删除数据
del key

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
#截取指定字符串显示[strat,end]
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

> 使用场景

value除了是我们的字符串还可以是数字

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
# 截取list的start到stop之间的所有元素，[start,stop]，这个list就已经被改变了，只剩下截取的元素
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

> 使用场景

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

## Geospatial 地理空间

Redis 的 GEO 特性在 **3.2** 版本中推出， 这个功能可以将用户给定的地理位置信息储存起来。

通常用以实现诸如附近位置、摇一摇这类依赖于地理位置信息的功能。

==geo 的数据类型为 zset==

### 添加

将给定的空间元素（纬度、经度、名字）添加到指定的键里面。

- 这些数据会以有序集的形式被储存在键里面，从而使得 `georadius` 和 `georadiusbymember` 这样的命令可以在之后通过位置查询取得这些元素。
- `geoadd` 命令以标准的x，y格式接受参数，所以用户必须先输入经度，然后再输入纬度。
- `geoadd` 能够记录的坐标是有限的：非常接近两极的区域无法被索引。
- 有效的经度介于 -180 ~ 180 度之间，有效的纬度介于 -85.05112878 ~ 85.05112878 度之间。当输入超出范围的经度或者纬度，`geoadd` 将返回一个错误。

```bash
# 向集合china:city添加北京的经纬度信息
geoadd china:city 116.23 40.22 beijing

# 向集合china:city添加多个经纬度信息
geoadd china:city 121.48 31.40 上海 113.88 22.55 深圳 120.21 120.21 30.20 杭州 106.54 29.40 重庆 108.93 34.23 西安 114.02 30.58 武汉
```

### 取值

> 经纬度

```bash
# 获取单个值
geopos china:city beijing

# 获取多个值
geopos china:city beijing shanghai
```

> 两个坐标之间的距离

返回两个给定位置之间的距离，如果两个位置之间的其中一个不存在，那么命令返回空值。

指定单位的参数 unit 必须是以下单位的其中一个：

- **m** 表示单位为米
- **km** 表示单位为千米
- **mi** 表示单位为英里
- **ft** 表示单位为英尺

如果用户没有显式地指定单位参数，那么 `geodist` 默认使用**米**作为单位。

```bash
geodist china:city beijing shanghai

geodist china:city beijing shanghai m

geodist china:city beijing shanghai km

geodist china:city beijing shanghai mi

geodist china:city beijing shanghai ft
```

> 范围内元素

以给定的经纬度为中心，找出指定半径范围内的元素。

```bash
# 找出100 30坐标半径1000km范围内的元素，返回其名称
georadius china:city 100 30 1000 km

# 找出100 30坐标半径1000km范围内的元素，返回其名称、距离
georadius china:city 100 30 1000 km withdist

# 找出100 30坐标半径1000km范围内的元素，返回其名称、经纬度信息
georadius china:city 100 30 1000 km withcoord

# 找出100 30坐标半径1000km范围内的元素，返回其名称、距离、经纬度信息，并且通过count指定查询的元素个数
georadius china:city 100 30 1000 km withcoord withdist count 1
```

```bash
# 找出北京 1000 km 内的城市，返回名称
georadiusbymember china:city beijing 1000 km
```

> 经纬度字符串(基本不使用)

```bash
# 返回一个由经纬度哈希计算的出的字符串
geohash china:city beijing
```

### 删除

GEO 没有提供删除成员的命令，但是因为 GEO 的底层实现是 zset，所以可以借用 `zrem` 命令实现对地理位置信息的删除。

```bash
# 查看全部的元素
zrange china:city 0 -1

# 移除元素
zrem china:city shanghai

# 查看全部的元素
zrange china:city 0 -1
```

## HyperLogLog 基数

Redis 在 **2.8.9** 版本添加了 HyperLogLog 结构，用来做基数统计的算法

其优点是，在输入元素的数量或者体积非常非常大时，计算基数所需的空间总是固定的，并且是很小的。

每个 HyperLogLog 键只需要花费 **12 KB** 内存，就可以计算接近 **2 ^ 64** 个不同元素的基数。

HyperLogLog 是一种算法，它提供了不精确的去重计数方案。

比如数据集 {1, 3, 5, 7, 5, 7, 8}， 那么这个数据集的基数集为 {1, 3, 5 ,7, 8}，基数（不重复元素）为 5。

> 使用场景

比如统计网页的浏览用户数量，一天内同一个用户多次访问只算一次。

传统的解决方案是使用 Set 来保存用户 id，然后统计 Set 中的元素数量。

这种方案只能承载少量用户，一旦用户数量大起来就需要消耗大量的空间。

而且目的是统计用户数量而不是保存用户，这是个吃力不讨好的方案。

使用 HyperLogLog 最多需要 12k 就可以统计大量的用户数。

尽管它大概有 **0.81%** 的错误率，但对于统计用户数量这种不需要很精确的数据是可以忽略不计的。

> 添加

```bash
pfadd mykey a b c d e f g h i j

pfadd mykey2 a b b c
```

> 统计基数集

```bash
pfcount mykey

pfcount mykey2
```

> 合并并统计基数集

```bash
pfmerge mykey3 mykey mykey2

pfcount mykey3
```

## Bitmap 位图

Redis 从 **2.2** 版本增加了 Bitmap（位图）

当需要统计用户一年的某些信息，如活跃或不活跃，登录或不登录，打卡或没打卡。

如果使用普通的 key / value存储，则要记录 365 条记录，如果用户量很大，需要的空间也会很大。

Redis 提供了 Bitmap 位图这种数据结构，Bitmap 就是通过操作二进制位来进行记录，即为 0 和 1。

如果要记录 365 天的打卡情况，使用 Bitmap 表示的形式大概如下：0101000111000111……

这样 365 天相当于 365 bit，又 1 字节 = 8 bit , 所以相当于使用 46 个字节即可。

BitMap 就是通过一个 bit 位来表示某个元素对应的值或者状态，其中的 key 就是对应元素本身。

实际上底层也是通过对字符串的操作来实现的。

==简单来说就是一种数据的存储只涉及到两个值的情况下，我们可以考虑使用位图==

> 使用 bitmap 来记录一周的打卡记录（1 为打卡，0 为没打卡）

```bash
setbit sign 0 1

setbit sign 1 0

setbit sign 2 0

setbit sign 3 1

setbit sign 4 1

setbit sign 5 0

setbit sign 6 0
```

> 取值

```bash
# 查看周四是否打卡
getbit sign 3

# 查看周六是否打卡
getbit sign 5
```

> 统计：统计 key 上位为 1 的个数

```bash
# 统计这周打卡的记录
bitcount sign
```

## 事务

