数据库操作架构的发展史

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

9. 查看redis进程

```bash
ps -ef | grep redis
```

10. 杀死redis进程

```bash
kill -9 PID
```

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

Redis 事务的本质是一组命令的集合

事务支持一次执行多个命令，一个事务中所有命令都会被序列化。

Redis事务的执行类似于队列：先进先出，先添加的命令先执行

所以说：Redis 事务就是**一次性**、**顺序性**、**排他性**的执行一个队列中的一系列命令。

- 一次性：一次执行多条命令
- 顺序性：多条命令的执行顺序不会发生变化
- 排他性：在事务执行过程，会按照顺序串行化执行队列中的命令，其他客户端提交的命令请求不会插入到事务执行命令序列中

> Redis 事务没有隔离级别的概念

批量操作在发送 `EXEC` 命令前被放入队列缓存，并不会被实际执行。

> Redis 事务不保证原子性

Redis中，单条命令是原子性执行的，但事务不保证原子性，且没有回滚。

事务中任意命令执行失败，其余的命令仍会被执行。

> Redis事务的三个阶段

1. 开始事务
2. 命令入队
3. 执行事务

### 乐观锁和悲观锁

> 悲观锁

悲观锁（Pessimistic Lock），顾名思义，就是很悲观。

每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁。

这样别人想拿到这个数据就会 block 直到它拿到锁。

传统的关系型数据库里面就用到了很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在操作之前先上锁。

> 乐观锁

乐观锁（Optimistic Lock），顾名思义，就是很乐观。

每次去拿数据的时候都认为别人不会修改，所以不会上锁。

但是在更新的时候会判断一下再此期间别人有没有去更新这个数据，可以使用版本号等机制。

乐观锁适用于多读的应用类型，这样可以提高吞吐量。

乐观锁策略：提交版本必须大于记录当前版本才能执行更新。

### 事务监听

监视一或多个 key，如果在事务执行之前，被监视的 key 被其他命令改动，则事务不会被执行（类似乐观锁）。

```bash
# 进行监听
watch key1 key2 ...

# 取消监听
unwatch
```

事务操作

```bash
# 标记一个事务块的开始，形成队列（queued）。
multi

# 执行
exec

# 取消事务
discard
```

- 一旦执行 `exec` 开启事务后，无论事务是否执行成功， `watch` 对变量的监听都将被取消。
- 当事务执行失败后，需重新执行 `watch` 命令对变量进行监听，并开启新的事务进行操作。
- `watch` 指令类似于乐观锁，在事务提交时，如果 `watch` 监控的多个 key 中任何 key 的值已经被其他客户端更改。则使用 `exec` 执行事务时，事务队列将不会被执行，同时返回 **(nil)** 应答以通知调用者事务执行失败。

### 事务操作Demo

> 正常执行

开启事务后，会出现 **TX** 标志，此时所有的操作不会马上有结果，而是形成队列（QUEUED），待执行事务后，会将所有命令按顺序执行。

```bash
# 开启事务
multi

# 命令入队
set k1 v1

# 命令入队
set k2 v2

# 命令入队
get k2

# 命令入队
set k3 v3

# 执行事务
exec

# set命令执行成功
get k1

# set命令执行成功
get k2
```

> 放弃事务

```bash
# 开启事务
multi

# 命令入队
set k1 v1

# 命令入队
set k2 v2

# 命令入队
set k3 33

# 取消事务
discard

# set命令未执行
get k3
```

> 事务中存在命令性错误

若在事务队列中存在命令性错误（类似于java编译性错误），则执行 `exec` 命令时，所有命令都不会执行。

```bash
# 开启事务
multi

# 命令入队
set k1 11

# 错误命令，报错
getset k2

(error) ERR wrong number of arguments for 'getset' command

# 命令入队
set k2 22

# 执行事务，报错
exec

(error) EXECABORT Transaction discarded because of previous errors.

# set命令未执行
get k1

# set命令未执行
get k2
```

> 事务中存在语法性错误

若在事务队列中存在语法性错误（类似于 Java 的的运行时异常），则执行 `exec` 命令时，其他正确命令会被执行，错误命令抛出异常。

```bash
# 开启事务
multi

# 命令入队
set k4 v4

# 命令入队（对“v4”进行 +1 ，会报语法错误）
incr k4

# 命令入队
set k5 v5

# 执行事务
# 执行错误的命令会报错，其余命令正常执行
exec

1) OK
2) (error) ERR value is not an integer or out of range # 
3) OK

# set命令执行成功
get k4

# set命令执行成功
get k5
```

## Jedis

Jedis 是 Redis 官方推荐的 Java 连接开发工具。

Jedis 客户端同时支持**单机模式**、**分片模式**、**集群模式**的访问模式：

- 通过构建 **Jedis** 类对象实现**单机模式**下的数据访问。
- 通过构建 **ShardedJedis** 类对象实现**分片模式**的数据访问。
- 通过构建 **JedisCluster** 类对象实现**集群模式**下的数据访问。

Jedis 客户端支持单命令和 Pipeline 方式访问 Redis 集群，通过 Pipeline 的方式能够提高集群访问的效率。

### 简单使用

- 创建Maven工程，导入依赖

```xml
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>4.3.1</version>
</dependency>
```

- 编码测试

```java
Jedis jedis = new Jedis("localhost", 6379);
System.out.println(jedis.ping());
```

### 常用API

> 连接

```java
//验证密码
jedis.auth("");

//连接
jedis.connect();

//断开连接
jedis.disconnect();
```

> 操作Key

```java
Jedis jedis = new Jedis("47.100.222.85", 6379);
System.out.println("清空数据：" + jedis.flushDB());
System.out.println("判断某个键是否存在：" + jedis.exists("username"));
System.out.println("新增<'username','kuangshen'>的键值对：" + jedis.set("username", "kuangshen"));
System.out.println("新增<'password','password'>的键值对：" + jedis.set("password", "password"));
System.out.print("系统中所有的键如下：");
Set<String> keys = jedis.keys("*");
System.out.println(keys);
System.out.println("删除键password:" + jedis.del("password"));
System.out.println("判断键password是否存在：" + jedis.exists("password"));
System.out.println("查看键username所存储的值的类型：" + jedis.type("username"));
System.out.println("随机返回key空间的一个：" + jedis.randomKey());
System.out.println("重命名key：" + jedis.rename("username", "name"));
System.out.println("取出改后的name：" + jedis.get("name"));
System.out.println("按索引查询：" + jedis.select(0));
System.out.println("删除当前选择数据库中的所有key：" + jedis.flushDB());
System.out.println("返回当前数据库中key的数目：" + jedis.dbSize());
System.out.println("删除所有数据库中的所有key：" + jedis.flushAll());
```

> 操作String

```java
Jedis jedis = new Jedis("47.100.222.85", 6379);
jedis.flushDB();
System.out.println("===========增加数据===========");
System.out.println(jedis.set("key1", "value1"));
System.out.println(jedis.set("key2", "value2"));
System.out.println(jedis.set("key3", "value3"));
System.out.println("删除键key2:" + jedis.del("key2"));
System.out.println("获取键key2:" + jedis.get("key2"));
System.out.println("修改key1:" + jedis.set("key1", "value1Changed"));
System.out.println("获取key1的值：" + jedis.get("key1"));
System.out.println("在key3后面加入值：" + jedis.append("key3", "End"));
System.out.println("key3的值：" + jedis.get("key3"));
System.out.println("增加多个键值对：" + jedis.mset("key01", "value01", "key02", "value02", "key03", "value03"));
System.out.println("获取多个键值对：" + jedis.mget("key01", "key02", "key03"));
System.out.println("获取多个键值对：" + jedis.mget("key01", "key02", "key03", "key04"));
System.out.println("删除多个键值对：" + jedis.del("key01", "key02"));
System.out.println("获取多个键值对：" + jedis.mget("key01", "key02", "key03"));
jedis.flushDB();
System.out.println("===========新增键值对防止覆盖原先值==============");
System.out.println(jedis.setnx("key1", "value1"));
System.out.println(jedis.setnx("key2", "value2"));
System.out.println(jedis.setnx("key2", "value2-new"));
System.out.println(jedis.get("key1"));
System.out.println(jedis.get("key2"));
System.out.println("===========新增键值对并设置有效时间=============");
System.out.println(jedis.setex("key3", 2, "value3"));
System.out.println(jedis.get("key3"));
try {
    TimeUnit.SECONDS.sleep(3);
} catch (InterruptedException e) {
    e.printStackTrace();
}
System.out.println(jedis.get("key3"));
System.out.println("===========获取原值，更新为新值==========");
System.out.println(jedis.getSet("key2", "key2GetSet"));
System.out.println(jedis.get("key2"));
System.out.println("获得key2的值的字串：" + jedis.getrange("key2", 2, 4));
```

> List

```java
Jedis jedis = new Jedis("127.0.0.1", 6379);
jedis.flushDB();
System.out.println("===========添加一个list===========");
jedis.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");
jedis.lpush("collections", "HashSet");
jedis.lpush("collections", "TreeSet");
jedis.lpush("collections", "TreeMap");
System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));//-1代表倒数第一个元素，-2代表倒数第二个元素,end为-1表示查询全部
System.out.println("collections区间0-3的元素：" + jedis.lrange("collections", 0, 3));
System.out.println("===============================");
// 删除列表指定的值 ，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
System.out.println("删除指定元素个数：" + jedis.lrem("collections", 2, "HashMap"));
System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
System.out.println("删除下表0-3区间之外的元素：" + jedis.ltrim("collections", 0, 3));
System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
System.out.println("collections列表出栈（左端）：" + jedis.lpop("collections"));
System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
System.out.println("collections添加元素，从列表右端，与lpush相对应：" + jedis.rpush("collections", "EnumMap"));
System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
System.out.println("collections列表出栈（右端）：" + jedis.rpop("collections"));
System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
System.out.println("修改collections指定下标1的内容：" + jedis.lset("collections", 1, "LinkedArrayList"));
System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
System.out.println("===============================");
System.out.println("collections的长度：" + jedis.llen("collections"));
System.out.println("获取collections下标为2的元素：" + jedis.lindex("collections", 2));
System.out.println("===============================");
jedis.lpush("sortedList", "3", "6", "2", "0", "7", "4");
System.out.println("sortedList排序前：" + jedis.lrange("sortedList", 0, -1));
System.out.println(jedis.sort("sortedList"));
System.out.println("sortedList排序后：" + jedis.lrange("sortedList", 0, -1));
```

> 操作Set

```java
Jedis jedis = new Jedis("127.0.0.1", 6379);
jedis.flushDB();
System.out.println("============向集合中添加元素（不重复）============");
System.out.println(jedis.sadd("eleSet", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
System.out.println(jedis.sadd("eleSet", "e6"));
System.out.println(jedis.sadd("eleSet", "e6"));
System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
System.out.println("删除一个元素e0：" + jedis.srem("eleSet", "e0"));
System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
System.out.println("删除两个元素e7和e6：" + jedis.srem("eleSet", "e7", "e6"));
System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
System.out.println("随机的移除集合中的一个元素：" + jedis.spop("eleSet"));
System.out.println("随机的移除集合中的一个元素：" + jedis.spop("eleSet"));
System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
System.out.println("eleSet中包含元素的个数：" + jedis.scard("eleSet"));
System.out.println("e3是否在eleSet中：" + jedis.sismember("eleSet", "e3"));
System.out.println("e1是否在eleSet中：" + jedis.sismember("eleSet", "e1"));
System.out.println("e1是否在eleSet中：" + jedis.sismember("eleSet", "e5"));
System.out.println("=================================");
System.out.println(jedis.sadd("eleSet1", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
System.out.println(jedis.sadd("eleSet2", "e1", "e2", "e4", "e3", "e0", "e8"));
//移到集合元素
System.out.println("将eleSet1中删除e1并存入eleSet3中：" + jedis.smove("eleSet1", "eleSet3", "e1"));
System.out.println("将eleSet1中删除e2并存入eleSet3中：" + jedis.smove("eleSet1", "eleSet3", "e2"));
System.out.println("eleSet1中的元素：" + jedis.smembers("eleSet1"));
System.out.println("eleSet3中的元素：" + jedis.smembers("eleSet3"));
System.out.println("============集合运算=================");
System.out.println("eleSet1中的元素：" + jedis.smembers("eleSet1"));
System.out.println("eleSet2中的元素：" + jedis.smembers("eleSet2"));
System.out.println("eleSet1和eleSet2的交集:" + jedis.sinter("eleSet1", "eleSet2"));
System.out.println("eleSet1和eleSet2的并集:" + jedis.sunion("eleSet1", "eleSet2"));
//eleSet1中有，eleSet2中没有
System.out.println("eleSet1和eleSet2的差集:" + jedis.sdiff("eleSet1", "eleSet2"));
//求交集并将交集保存到dstkey的集合
jedis.sinterstore("eleSet4", "eleSet1", "eleSet2");
System.out.println("eleSet4中的元素：" + jedis.smembers("eleSet4"));
```

> 操作Hash

```java
Jedis jedis = new Jedis("127.0.0.1", 6379);
jedis.flushDB();
Map<String, String> map = new HashMap<>();
map.put("key1", "value1");
map.put("key2", "value2");
map.put("key3", "value3");
map.put("key4", "value4");
// 添加名称为 hash（key）的 hash 元素
jedis.hmset("hash", map);
// 向名称为 hash 的 hash 中添加 key 为 key5，value 为 value5 元素
jedis.hset("hash", "key5", "value5");
// return Map<String,String>
System.out.println("散列hash的所有键值对为：" + jedis.hgetAll(" hash"));
// return Set<String>
System.out.println("散列hash的所有键为：" + jedis.hkeys("hash"));
// return List<String>
System.out.println("散列hash的所有值为：" + jedis.hvals("hash"));
System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6：" + jedis.hincrBy(" hash", " key6", 6));
System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6：" + jedis.hincrBy(" hash", " key6", 3));
System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
System.out.println("删除一个或者多个键值对：" + jedis.hdel("hash", "key2"));
System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
System.out.println("散列hash中键值对的个数：" + jedis.hlen("hash"));
System.out.println("判断hash中是否存在key2：" + jedis.hexists(" hash", " key2"));
System.out.println("判断hash中是否存在key3：" + jedis.hexists(" hash", " key3"));
System.out.println("获取hash中的值：" + jedis.hmget("hash", "key3"));
System.out.println("获取hash中的值：" + jedis.hmget(" hash", " key3", " key4"));
```

> 事务

```java
//创建客户端连接服务端，redis服务端需要被开启
Jedis jedis = new Jedis("127.0.0.1", 6379);

//清空数据库，为后面测试做准备
jedis.flushDB();

//构建JSON字符串
JSONObject jsonObject = new JSONObject();
jsonObject.put("hello", "world");
jsonObject.put("name", "java");

//开启事务
Transaction multi = jedis.multi();
String result = jsonObject.toJSONString();
try {
    //向redis存入一条数据
    multi.set("json", result);
    //再存入一条数据
    multi.set("json2", result);
    //这里引发了异常，用0作为被除数
    int i = 100 / 0;
    //如果没有引发异常，执行事务
    multi.exec();
} catch (Exception e) {
    e.printStackTrace();
    //如果出现异常，取消事务
    multi.discard();
} finally {
    System.out.println(jedis.get("json"));
    System.out.println(jedis.get("json2"));
    //最终关闭客户端
    jedis.close();
}
```

## SpringBoot整合Redis

说明：从springboot2.x开始，start底层使用的jedis被替换成了lettuce

jedis：采用的是直连，多个线程操作是不安全的，如果想要避免，使用jedis pool连接池！BIO

lettuce：采用netty，实例可以在多个线程中共享，不存在线程不安全的情况！可以减少线程数据了，更像NIO模式

### 简单使用

- 首先开启redis服务端

- 导入依赖

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>65	
   <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

```

- 编写配置

```yml
# 配置redis
spring.redis.host=localhost
spring.redis.port=6379
```

- 测试

SpringBoot中使用一个RedisTemplate模板类来直接操作Redis

```java
@SpringBootTest
class ProjectApplicationTests {
    //这里使用Autowire注入会报错，所以使用Resource进行注入
    //Resource是根据先根据bean的名字进行自动装配，如果找不到再根据类型进行装配
    @Resource
    private RedisTemplate redisTemplate;

    //StringRedisTemplate是专门用于存储 <String,String> 类型数据的模板
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name","zhangsan");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    void test1(){
        stringRedisTemplate.opsForValue().set("demo","lisi");
        System.out.println(redisTemplate.opsForValue().get("demo"));
    }
}
```

使用RedisTemplate和StringRedisTemplate来操作Redis，从代码层面不会发现问题

但是，我们查看Redis数据库，发现RedisTemplate存储的键值对出现了乱码

==分析：RedisTemplate会使用自身默认的方式将存储的键值对对象进行序列化，而StringRedisTemplate则是默认将键值作为String形式进行存储，不做序列化操作==

### 源码分析

查看Redis的自动装配类

通过源码可以看出，SpringBoot 自动帮我们在容器中生成了一个 RedisTemplate 和一个 StringRedisTemplate。

但是，这个 RedisTemplate 的泛型是 <Object, Object>，写代码不方便，需要写好多类型转换的代码。

我们需要一个泛型为 <String, Object> 形式的 RedisTemplate。

并且，这个 RedisTemplate 没有设置数据存在 Redis 时，key 及 value 的序列化方式。

由`@ConditionalOnMissingBean`可以看出，如果 Spring 容器中有了自定义的 RedisTemplate 对象，自动配置的 RedisTemplate 不会实例化。

因此我们可以直接自己写个配置类，配置 RedisTemplate。

```java
@AutoConfiguration
@ConditionalOnClass({RedisOperations.class})
@EnableConfigurationProperties({RedisProperties.class})
@Import({LettuceConnectionConfiguration.class, JedisConnectionConfiguration.class})
public class RedisAutoConfiguration {
    public RedisAutoConfiguration() {
    }

    @Bean
    @ConditionalOnMissingBean(
        name = {"redisTemplate"}
    )
    @ConditionalOnSingleCandidate(RedisConnectionFactory.class)
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnSingleCandidate(RedisConnectionFactory.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }
}
```

### 自定义RedisTemplate

```java
@Configuration
public class RedisConfig {
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // 定义泛型为 <String, Object> 的 RedisTemplate
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        // 设置连接工厂
        template.setConnectionFactory(factory);
        // 定义 Json 序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        // Json 转换工具
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        // 定义 String 序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
```

### RedisUtil工具类

```java
@Component
public class RedisUtil {
    private StringRedisTemplate redisTemplate;

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public StringRedisTemplate getRedisTemplate() {
        return this.redisTemplate;
    }

    /** -------------------key相关操作--------------------- */

    /**
     * 删除key
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     *
     * @param keys
     */
    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 序列化key
     *
     * @param key
     * @return
     */
    public byte[] dump(String key) {
        return redisTemplate.dump(key);
    }

    /**
     * 是否存在key
     *
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public Boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param date
     * @return
     */
    public Boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }

    /**
     * 查找匹配的key
     *
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 将当前数据库的 key 移动到给定的数据库 db 当中
     *
     * @param key
     * @param dbIndex
     * @return
     */
    public Boolean move(String key, int dbIndex) {
        return redisTemplate.move(key, dbIndex);
    }

    /**
     * 移除 key 的过期时间，key 将持久保持
     *
     * @param key
     * @return
     */
    public Boolean persist(String key) {
        return redisTemplate.persist(key);
    }

    /**
     * 返回 key 的剩余的过期时间
     *
     * @param key
     * @param unit
     * @return
     */
    public Long getExpire(String key, TimeUnit unit) {
        return redisTemplate.getExpire(key, unit);
    }

    /**
     * 返回 key 的剩余的过期时间
     *
     * @param key
     * @return
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 从当前数据库中随机返回一个 key
     *
     * @return
     */
    public String randomKey() {
        return redisTemplate.randomKey();
    }

    /**
     * 修改 key 的名称
     *
     * @param oldKey
     * @param newKey
     */
    public void rename(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    /**
     * 仅当 newkey 不存在时，将 oldKey 改名为 newkey
     *
     * @param oldKey
     * @param newKey
     * @return
     */
    public Boolean renameIfAbsent(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    /**
     * 返回 key 所储存的值的类型
     *
     * @param key
     * @return
     */
    public DataType type(String key) {
        return redisTemplate.type(key);
    }

    /** -------------------string相关操作--------------------- */

    /**
     * 设置指定 key 的值
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取指定 key 的值
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 返回 key 中字符串值的子字符
     * @param key
     * @param start
     * @param end
     * @return
     */
    public String getRange(String key, long start, long end) {
        return redisTemplate.opsForValue().get(key, start, end);
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)
     *
     * @param key
     * @param value
     * @return
     */
    public String getAndSet(String key, String value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)
     *
     * @param key
     * @param offset
     * @return
     */
    public Boolean getBit(String key, long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }

    /**
     * 批量获取
     *
     * @param keys
     * @return
     */
    public List<String> multiGet(Collection<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * 设置ASCII码, 字符串'a'的ASCII码是97, 转为二进制是'01100001', 此方法是将二进制第offset位值变为value
     *
     * @param key
     * @param postion
     *            位置
     * @param value
     *            值,true为1, false为0
     * @return
     */
    public boolean setBit(String key, long offset, boolean value) {
        return redisTemplate.opsForValue().setBit(key, offset, value);
    }

    /**
     * 将值 value 关联到 key ，并将 key 的过期时间设为 timeout
     *
     * @param key
     * @param value
     * @param timeout
     *            过期时间
     * @param unit
     *            时间单位, 天:TimeUnit.DAYS 小时:TimeUnit.HOURS 分钟:TimeUnit.MINUTES
     *            秒:TimeUnit.SECONDS 毫秒:TimeUnit.MILLISECONDS
     */
    public void setEx(String key, String value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 只有在 key 不存在时设置 key 的值
     *
     * @param key
     * @param value
     * @return 之前已经存在返回false,不存在返回true
     */
    public boolean setIfAbsent(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始
     *
     * @param key
     * @param value
     * @param offset
     *            从指定位置开始覆写
     */
    public void setRange(String key, String value, long offset) {
        redisTemplate.opsForValue().set(key, value, offset);
    }

    /**
     * 获取字符串的长度
     *
     * @param key
     * @return
     */
    public Long size(String key) {
        return redisTemplate.opsForValue().size(key);
    }

    /**
     * 批量添加
     *
     * @param maps
     */
    public void multiSet(Map<String, String> maps) {
        redisTemplate.opsForValue().multiSet(maps);
    }

    /**
     * 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在
     *
     * @param maps
     * @return 之前已经存在返回false,不存在返回true
     */
    public boolean multiSetIfAbsent(Map<String, String> maps) {
        return redisTemplate.opsForValue().multiSetIfAbsent(maps);
    }

    /**
     * 增加(自增长), 负数则为自减
     *
     * @param key
     * @param value
     * @return
     */
    public Long incrBy(String key, long increment) {
        return redisTemplate.opsForValue().increment(key, increment);
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public Double incrByFloat(String key, double increment) {
        return redisTemplate.opsForValue().increment(key, increment);
    }

    /**
     * 追加到末尾
     *
     * @param key
     * @param value
     * @return
     */
    public Integer append(String key, String value) {
        return redisTemplate.opsForValue().append(key, value);
    }

    /** -------------------hash相关操作------------------------- */

    /**
     * 获取存储在哈希表中指定字段的值
     *
     * @param key
     * @param field
     * @return
     */
    public Object hGet(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 获取所有给定字段的值
     *
     * @param key
     * @return
     */
    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取所有给定字段的值
     *
     * @param key
     * @param fields
     * @return
     */
    public List<Object> hMultiGet(String key, Collection<Object> fields) {
        return redisTemplate.opsForHash().multiGet(key, fields);
    }

    public void hPut(String key, String hashKey, String value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public void hPutAll(String key, Map<String, String> maps) {
        redisTemplate.opsForHash().putAll(key, maps);
    }

    /**
     * 仅当hashKey不存在时才设置
     *
     * @param key
     * @param hashKey
     * @param value
     * @return
     */
    public Boolean hPutIfAbsent(String key, String hashKey, String value) {
        return redisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
    }

    /**
     * 删除一个或多个哈希表字段
     *
     * @param key
     * @param fields
     * @return
     */
    public Long hDelete(String key, Object... fields) {
        return redisTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 查看哈希表 key 中，指定的字段是否存在
     *
     * @param key
     * @param field
     * @return
     */
    public boolean hExists(String key, String field) {
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     *
     * @param key
     * @param field
     * @param increment
     * @return
     */
    public Long hIncrBy(String key, Object field, long increment) {
        return redisTemplate.opsForHash().increment(key, field, increment);
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     *
     * @param key
     * @param field
     * @param delta
     * @return
     */
    public Double hIncrByFloat(String key, Object field, double delta) {
        return redisTemplate.opsForHash().increment(key, field, delta);
    }

    /**
     * 获取所有哈希表中的字段
     *
     * @param key
     * @return
     */
    public Set<Object> hKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * 获取哈希表中字段的数量
     *
     * @param key
     * @return
     */
    public Long hSize(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * 获取哈希表中所有值
     *
     * @param key
     * @return
     */
    public List<Object> hValues(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    /**
     * 迭代哈希表中的键值对
     *
     * @param key
     * @param options
     * @return
     */
    public Cursor<Entry<Object, Object>> hScan(String key, ScanOptions options) {
        return redisTemplate.opsForHash().scan(key, options);
    }

    /** ------------------------list相关操作---------------------------- */

    /**
     * 通过索引获取列表中的元素
     *
     * @param key
     * @param index
     * @return
     */
    public String lIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 获取列表指定范围内的元素
     *
     * @param key
     * @param start
     *            开始位置, 0是开始位置
     * @param end
     *            结束位置, -1返回所有
     * @return
     */
    public List<String> lRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 存储在list头部
     *
     * @param key
     * @param value
     * @return
     */
    public Long lLeftPush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public Long lLeftPushAll(String key, String... value) {
        return redisTemplate.opsForList().leftPushAll(key, value);
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public Long lLeftPushAll(String key, Collection<String> value) {
        return redisTemplate.opsForList().leftPushAll(key, value);
    }

    /**
     * 当list存在的时候才加入
     *
     * @param key
     * @param value
     * @return
     */
    public Long lLeftPushIfPresent(String key, String value) {
        return redisTemplate.opsForList().leftPushIfPresent(key, value);
    }

    /**
     * 如果pivot存在,再pivot前面添加
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public Long lLeftPush(String key, String pivot, String value) {
        return redisTemplate.opsForList().leftPush(key, pivot, value);
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public Long lRightPush(String key, String value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public Long lRightPushAll(String key, String... value) {
        return redisTemplate.opsForList().rightPushAll(key, value);
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public Long lRightPushAll(String key, Collection<String> value) {
        return redisTemplate.opsForList().rightPushAll(key, value);
    }

    /**
     * 为已存在的列表添加值
     *
     * @param key
     * @param value
     * @return
     */
    public Long lRightPushIfPresent(String key, String value) {
        return redisTemplate.opsForList().rightPushIfPresent(key, value);
    }

    /**
     * 在pivot元素的右边添加值
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public Long lRightPush(String key, String pivot, String value) {
        return redisTemplate.opsForList().rightPush(key, pivot, value);
    }

    /**
     * 通过索引设置列表元素的值
     *
     * @param key
     * @param index
     *            位置
     * @param value
     */
    public void lSet(String key, long index, String value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * 移出并获取列表的第一个元素
     *
     * @param key
     * @return 删除的元素
     */
    public String lLeftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
     *
     * @param key
     * @param timeout
     *            等待时间
     * @param unit
     *            时间单位
     * @return
     */
    public String lBLeftPop(String key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().leftPop(key, timeout, unit);
    }

    /**
     * 移除并获取列表最后一个元素
     *
     * @param key
     * @return 删除的元素
     */
    public String lRightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     * 移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
     *
     * @param key
     * @param timeout
     *            等待时间
     * @param unit
     *            时间单位
     * @return
     */
    public String lBRightPop(String key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPop(key, timeout, unit);
    }

    /**
     * 移除列表的最后一个元素，并将该元素添加到另一个列表并返回
     *
     * @param sourceKey
     * @param destinationKey
     * @return
     */
    public String lRightPopAndLeftPush(String sourceKey, String destinationKey) {
        return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey,
                destinationKey);
    }

    /**
     * 从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
     *
     * @param sourceKey
     * @param destinationKey
     * @param timeout
     * @param unit
     * @return
     */
    public String lBRightPopAndLeftPush(String sourceKey, String destinationKey,
                                        long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey,
                destinationKey, timeout, unit);
    }

    /**
     * 删除集合中值等于value得元素
     *
     * @param key
     * @param index
     *            index=0, 删除所有值等于value的元素; index>0, 从头部开始删除第一个值等于value的元素;
     *            index<0, 从尾部开始删除第一个值等于value的元素;
     * @param value
     * @return
     */
    public Long lRemove(String key, long index, String value) {
        return redisTemplate.opsForList().remove(key, index, value);
    }

    /**
     * 裁剪list
     *
     * @param key
     * @param start
     * @param end
     */
    public void lTrim(String key, long start, long end) {
        redisTemplate.opsForList().trim(key, start, end);
    }

    /**
     * 获取列表长度
     *
     * @param key
     * @return
     */
    public Long lLen(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /** --------------------set相关操作-------------------------- */

    /**
     * set添加元素
     *
     * @param key
     * @param values
     * @return
     */
    public Long sAdd(String key, String... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    /**
     * set移除元素
     *
     * @param key
     * @param values
     * @return
     */
    public Long sRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * 移除并返回集合的一个随机元素
     *
     * @param key
     * @return
     */
    public String sPop(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * 将元素value从一个集合移到另一个集合
     *
     * @param key
     * @param value
     * @param destKey
     * @return
     */
    public Boolean sMove(String key, String value, String destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    /**
     * 获取集合的大小
     *
     * @param key
     * @return
     */
    public Long sSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 判断集合是否包含value
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean sIsMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 获取两个集合的交集
     *
     * @param key
     * @param otherKey
     * @return
     */
    public Set<String> sIntersect(String key, String otherKey) {
        return redisTemplate.opsForSet().intersect(key, otherKey);
    }

    /**
     * 获取key集合与多个集合的交集
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public Set<String> sIntersect(String key, Collection<String> otherKeys) {
        return redisTemplate.opsForSet().intersect(key, otherKeys);
    }

    /**
     * key集合与otherKey集合的交集存储到destKey集合中
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long sIntersectAndStore(String key, String otherKey, String destKey) {
        return redisTemplate.opsForSet().intersectAndStore(key, otherKey,
                destKey);
    }

    /**
     * key集合与多个集合的交集存储到destKey集合中
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long sIntersectAndStore(String key, Collection<String> otherKeys,
                                   String destKey) {
        return redisTemplate.opsForSet().intersectAndStore(key, otherKeys,
                destKey);
    }

    /**
     * 获取两个集合的并集
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public Set<String> sUnion(String key, String otherKeys) {
        return redisTemplate.opsForSet().union(key, otherKeys);
    }

    /**
     * 获取key集合与多个集合的并集
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public Set<String> sUnion(String key, Collection<String> otherKeys) {
        return redisTemplate.opsForSet().union(key, otherKeys);
    }

    /**
     * key集合与otherKey集合的并集存储到destKey中
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long sUnionAndStore(String key, String otherKey, String destKey) {
        return redisTemplate.opsForSet().unionAndStore(key, otherKey, destKey);
    }

    /**
     * key集合与多个集合的并集存储到destKey中
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long sUnionAndStore(String key, Collection<String> otherKeys,
                               String destKey) {
        return redisTemplate.opsForSet().unionAndStore(key, otherKeys, destKey);
    }

    /**
     * 获取两个集合的差集
     *
     * @param key
     * @param otherKey
     * @return
     */
    public Set<String> sDifference(String key, String otherKey) {
        return redisTemplate.opsForSet().difference(key, otherKey);
    }

    /**
     * 获取key集合与多个集合的差集
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public Set<String> sDifference(String key, Collection<String> otherKeys) {
        return redisTemplate.opsForSet().difference(key, otherKeys);
    }

    /**
     * key集合与otherKey集合的差集存储到destKey中
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long sDifference(String key, String otherKey, String destKey) {
        return redisTemplate.opsForSet().differenceAndStore(key, otherKey,
                destKey);
    }

    /**
     * key集合与多个集合的差集存储到destKey中
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long sDifference(String key, Collection<String> otherKeys,
                            String destKey) {
        return redisTemplate.opsForSet().differenceAndStore(key, otherKeys,
                destKey);
    }

    /**
     * 获取集合所有元素
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Set<String> setMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 随机获取集合中的一个元素
     *
     * @param key
     * @return
     */
    public String sRandomMember(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    /**
     * 随机获取集合中count个元素
     *
     * @param key
     * @param count
     * @return
     */
    public List<String> sRandomMembers(String key, long count) {
        return redisTemplate.opsForSet().randomMembers(key, count);
    }

    /**
     * 随机获取集合中count个元素并且去除重复的
     *
     * @param key
     * @param count
     * @return
     */
    public Set<String> sDistinctRandomMembers(String key, long count) {
        return redisTemplate.opsForSet().distinctRandomMembers(key, count);
    }

    /**
     *
     * @param key
     * @param options
     * @return
     */
    public Cursor<String> sScan(String key, ScanOptions options) {
        return redisTemplate.opsForSet().scan(key, options);
    }

    /**------------------zSet相关操作--------------------------------*/

    /**
     * 添加元素,有序集合是按照元素的score值由小到大排列
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    public Boolean zAdd(String key, String value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     *
     * @param key
     * @param values
     * @return
     */
    public Long zAdd(String key, Set<TypedTuple<String>> values) {
        return redisTemplate.opsForZSet().add(key, values);
    }

    /**
     *
     * @param key
     * @param values
     * @return
     */
    public Long zRemove(String key, Object... values) {
        return redisTemplate.opsForZSet().remove(key, values);
    }

    /**
     * 增加元素的score值，并返回增加后的值
     *
     * @param key
     * @param value
     * @param delta
     * @return
     */
    public Double zIncrementScore(String key, String value, double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    /**
     * 返回元素在集合的排名,有序集合是按照元素的score值由小到大排列
     *
     * @param key
     * @param value
     * @return 0表示第一位
     */
    public Long zRank(String key, Object value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

    /**
     * 返回元素在集合的排名,按元素的score值由大到小排列
     *
     * @param key
     * @param value
     * @return
     */
    public Long zReverseRank(String key, Object value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    /**
     * 获取集合的元素, 从小到大排序
     *
     * @param key
     * @param start
     *            开始位置
     * @param end
     *            结束位置, -1查询所有
     * @return
     */
    public Set<String> zRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * 获取集合元素, 并且把score值也获取
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<TypedTuple<String>> zRangeWithScores(String key, long start,
                                                    long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    /**
     * 根据Score值查询集合元素
     *
     * @param key
     * @param min
     *            最小值
     * @param max
     *            最大值
     * @return
     */
    public Set<String> zRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 根据Score值查询集合元素, 从小到大排序
     *
     * @param key
     * @param min
     *            最小值
     * @param max
     *            最大值
     * @return
     */
    public Set<TypedTuple<String>> zRangeByScoreWithScores(String key,
                                                           double min, double max) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }

    /**
     *
     * @param key
     * @param min
     * @param max
     * @param start
     * @param end
     * @return
     */
    public Set<TypedTuple<String>> zRangeByScoreWithScores(String key,
                                                           double min, double max, long start, long end) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max,
                start, end);
    }

    /**
     * 获取集合的元素, 从大到小排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zReverseRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 获取集合的元素, 从大到小排序, 并返回score值
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<TypedTuple<String>> zReverseRangeWithScores(String key,
                                                           long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, start,
                end);
    }

    /**
     * 根据Score值查询集合元素, 从大到小排序
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> zReverseRangeByScore(String key, double min,
                                            double max) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max);
    }

    /**
     * 根据Score值查询集合元素, 从大到小排序
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<TypedTuple<String>> zReverseRangeByScoreWithScores(
            String key, double min, double max) {
        return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key,
                min, max);
    }

    /**
     *
     * @param key
     * @param min
     * @param max
     * @param start
     * @param end
     * @return
     */
    public Set<String> zReverseRangeByScore(String key, double min,
                                            double max, long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max,
                start, end);
    }

    /**
     * 根据score值获取集合元素数量
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zCount(String key, double min, double max) {
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    /**
     * 获取集合大小
     *
     * @param key
     * @return
     */
    public Long zSize(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    /**
     * 获取集合大小
     *
     * @param key
     * @return
     */
    public Long zZCard(String key) {
        return redisTemplate.opsForZSet().zCard(key);
    }

    /**
     * 获取集合中value元素的score值
     *
     * @param key
     * @param value
     * @return
     */
    public Double zScore(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * 移除指定索引位置的成员
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Long zRemoveRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().removeRange(key, start, end);
    }

    /**
     * 根据指定的score值的范围来移除成员
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zRemoveRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }

    /**
     * 获取key和otherKey的并集并存储在destKey中
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long zUnionAndStore(String key, String otherKey, String destKey) {
        return redisTemplate.opsForZSet().unionAndStore(key, otherKey, destKey);
    }

    /**
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long zUnionAndStore(String key, Collection<String> otherKeys,
                               String destKey) {
        return redisTemplate.opsForZSet()
                .unionAndStore(key, otherKeys, destKey);
    }

    /**
     * 交集
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long zIntersectAndStore(String key, String otherKey,
                                   String destKey) {
        return redisTemplate.opsForZSet().intersectAndStore(key, otherKey,
                destKey);
    }

    /**
     * 交集
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long zIntersectAndStore(String key, Collection<String> otherKeys,
                                   String destKey) {
        return redisTemplate.opsForZSet().intersectAndStore(key, otherKeys,
                destKey);
    }

    /**
     *
     * @param key
     * @param options
     * @return
     */
    public Cursor<TypedTuple<String>> zScan(String key, ScanOptions options) {
        return redisTemplate.opsForZSet().scan(key, options);
    }
}
```

## Redis配置文件

### 查看配置

Redis 的配置文件位于 Redis 安装目录下，文件名为 `redis.conf`

在 Linux 中，可以使用 `whereis redis` 查找 Redis 的安装目录

```bash
whereis redis
#redis: /usr/local/redis

cd /usr/local/redis

ls

00-RELEASENOTES  BUGS     CONTRIBUTING  deps      INSTALL   MANIFESTO  redis.conf  runtest-cluster    runtest-sentinel  src    TLS.md
bin              CONDUCT  COPYING       dump.rdb  Makefile  README.md  runtest     runtest-moduleapi  sentinel.conf     tests  utils
```

### 单位

开头定义了一些基本的度量单位，只支持 **bytes**，不支持 **bit**。

这些单位对大小写是**不敏感**的。

```bash
# Redis configuration file example.
#
# Note that in order to read the configuration file, Redis must be
# started with the file path as first argument:
#
# ./redis-server /path/to/redis.conf
# Note on units: when memory size is needed, it is possible to specify
# it in the usual form of 1k 5GB 4M and so forth:
#
# 1k => 1000 bytes
# 1kb => 1024 bytes
# 1m => 1000000 bytes
# 1mb => 1024*1024 bytes
# 1g => 1000000000 bytes
# 1gb => 1024*1024*1024 bytes
#
# units are case insensitive so 1GB 1Gb 1gB are all the same.
```

### 包含

和 Spring 配置文件类似，可以通过 `include` 包含，redis.conf 可以作为总文件，可以包含其他文件。

```bash
################################## INCLUDES ###################################
# Include one or more other config files here.  This is useful if you
# have a standard template that goes to all Redis servers but also need
# to customize a few per-server settings.  Include files can include
# other files, so use this wisely.
#
# Note that option "include" won't be rewritten by command "CONFIG REWRITE"
# from admin or Redis Sentinel. Since Redis always uses the last processed
# line as value of a configuration directive, you'd better put includes
# at the beginning of this file to avoid overwriting config change at runtime.
#
# If instead you are interested in using includes to override configuration
# options, it is better to use include as the last line.
#
# include /path/to/local.conf
# include /path/to/other.conf
```

### 网络配置

```bash
# 绑定的 IP
bind 127.0.0.1 
# 保护模式
protected-mode yes 
# 默认端口
port 6379
```

### 通用

```bash
# 默认情况下，Redis 不作为守护进程运行。需要开启的话，改为 yes
daemonize yes 
# 可通过 upstart 和 systemd 管理 Redis 守护进程
supervised no 
# 以后台进程方式运行 redis，则需要指定 pid 文件
pidfile /var/run/redis_6379.pid 
# 日志级别。可选项有：
# debug（记录大量日志信息，适用于开发、测试阶段）；
# verbose（较多日志信息）；
# notice（适量日志信息，使用于生产环境）；
# warning（仅有部分重要、关键信息才会被记录）。
loglevel notice 
# 日志文件的位置，当指定为空字符串时，为标准输出
logfile "" 
# 设置数据库的数目。默认的数据库是 0
databases 16 
# 是否总是显示 logo
always-show-logo yes
```

### 快照

```bash
# 900秒（15分钟）内至少 1 个 key 值改变（则进行数据库保存--持久化）
save 900 1
# 300秒（5分钟）内至少 10 个 key 值改变（则进行数据库保存--持久化）
save 300 10
# 60秒（1分钟）内至少 10000 个 key 值改变（则进行数据库保存--持久化）
save 60 10000
# 持久化出现错误后，是否依然进行继续进行工作
stop-writes-on-bgsave-error yes 
# 使用压缩 rdb 文件 yes：压缩，但是需要一些 cpu 的消耗；no：不压缩，需要更多的磁盘空间
rdbcompression yes 
# 是否校验 rdb 文件，更有利于文件的容错性，但是在保存 rdb 文件的时候，会有大概 10% 的性能损耗
rdbchecksum yes 
# dbfilenamerdb 文件名称
dbfilename dump.rdb 
# dir 数据目录，数据库的写入会在这个目录。rdb、aof 文件也会写在这个目录
dir ./
```

### 安全

```bash
# 获取密码
127.0.0.1:6379> config get requirepass
1) "requirepass"
2) ""
# 设置密码
127.0.0.1:6379> config set requirepass "123456"
OK
# 重新连接
[root@sail redis]# redis-cli
# 发现使用不了了
127.0.0.1:6379> ping
(error) NOAUTH Authentication required.
# 验证
127.0.0.1:6379> auth 123456
OK
# 验证后可以正常使用了
127.0.0.1:6379> ping
PONG
```

### 限制

```bash
# 设置能连上 redis 的最大客户端连接数量
maxclients 10000 
# redis 配置的最大内存容量
maxmemory <bytes> 
# maxmemory-policy 内存达到上限的处理策略：
#     volatile-lru：利用 LRU 算法移除设置过过期时间的 key。
#     volatile-random：随机移除设置过过期时间的 key。
#     volatile-ttl：移除即将过期的 key，根据最近过期时间来删除（辅以 TTL）
#     allkeys-lru：利用 LRU 算法移除任何 key。
#     allkeys-random：随机移除任何 key。
#     noeviction：不移除任何 key，只是返回一个写错误。
maxmemory-policy noeviction
```

### 常用配置

> daemonize no

Redis 默认不是以守护进程的方式运行，可以通过该配置项修改，使用 yes 启用守护进程。

> pidfile /var/run/redis.pid

当 Redis 以守护进程方式运行时，Redis 默认会把 pid 写入 /var/run/redis.pid 文件，可以通过 pidfile 指定。

> port 6379

指定 Redis 监听端口，默认端口为 6379。

作者在自己的一篇博文中解释了为什么选用 6379 作为默认端口，因为 6379 在手机按键上 MERZ 对应的号码，而 MERZ 取自意大利歌女 Alessia Merz 的名字。

> bind 127.0.0.1

绑定的主机地址。

> timeout 300

当客户端闲置多长时间后关闭连接，如果指定为 0，表示关闭该功能。

> loglevel verbose

指定日志记录级别，Redis总共支持四个级别：debug、verbose、notice、warning，默认为 verbose。

- debug：记录大量日志信息，适用于开发、测试阶段
- verbose：较多日志信息
- notice：适量日志信息，使用于生产环境
- warning：仅有部分重要、关键信息才会被记录

> logfile stdout

日志记录方式，默认为标准输出，如果配置 Redis 为守护进程方式运行，而这里又配置为日志记录方式为标准输出，则日志将会发送给 /dev/null。

> databases 16

设置数据库的数量，默认数据库为 0，可以使用 SELECT 命令在连接上指定数据库 id。

> save 900 1
> save 300 10
> save 60 10000

指定在多长时间内，有多少次更新操作，就将数据同步到数据文件，可以多个条件配合。

Redis 默认配置文件中提供了三个条件：

- 900 秒（15 分钟）内有 1 个更改
- 300 秒（5 分钟）内有 10 个更改
- 60 秒（1 分钟）内有 10000 个更改

> rdbcompression yes

指定存储至本地数据库时是否压缩数据，默认为 yes，Redis 采用 LZF 压缩，如果为了节省 CPU 时间，可以关闭该选项，但会导致数据库文件变的巨大。

> dbfilename dump.rdb

指定本地数据库文件名，默认值为 dump.rdb。

> dir ./

指定本地数据库存放目录。

> slaveof

设置当本机为 slav 服务时，设置 master 服务的 IP 地址及端口，在 Redis 启动时，它会自动从 master 进行数据同步。

> masterauth

当 master 服务设置了密码保护时，slav 服务连接 master 的密码。

> requirepass foobared

设置Redis连接密码，如果配置了连接密码，客户端在连接 Redis 时需要通过 `auth` 命令提供密码，默认关闭。

> maxclients 128

设置同一时间最大客户端连接数，默认无限制。

Redis 可以同时打开的客户端连接数为 Redis 进程可以打开的最大文件描述符数。

如果设置 maxclients 0，表示不作限制。

当客户端连接数到达限制时，Redis 会关闭新的连接并向客户端返回 max number of clients reached 错误信息。

> maxmemory

指定 Redis 最大内存限制，Redis 在启动时会把数据加载到内存中。

达到最大内存后，Redis 会先尝试清除已到期或即将到期的 Key。

当此方法处理后，仍然到达最大内存设置，将无法再进行写入操作，但仍然可以进行读取操作。

Redis 新的 vm 机制，会把 Key 存放内存，Value 会存放在 swap 区。

> appendonly no

指定是否在每次更新操作后进行日志记录，Redis 在默认情况下是异步的把数据写入磁盘。

如果不开启，可能会在断电时导致一段时间内的数据丢失。

因为 redis 本身同步数据文件是按上面 save 条件来同步的，所以有的数据会在一段时间内只存在于内存中。

默认为 no。

> appendfilename appendonly.aof

指定更新日志文件名，默认为 appendonly.aof。

> appendfsync everysec

指定更新日志条件，共有 3 个可选值：

- no：表示等操作系统进行数据缓存同步到磁盘（快）
- always：表示每次更新操作后手动调用 fsync() 将数据写到磁盘（慢，安全）
- everysec：表示每秒同步一次（折衷，默认值）

> vm-enabled no

指定是否启用虚拟内存机制，默认值为 no。

VM 机制将数据分页存放，由 Redis 将访问量较少的页即冷数据 swap 到磁盘上，访问多的页面由磁盘自动换出到内存中。

> vm-swap-file /tmp/redis.swap

虚拟内存文件路径，默认值为 /tmp/redis.swap，不可多个 Redis 实例共享。

> vm-max-memory 0

将所有大于 vm-max-memory 的数据存入虚拟内存。

无论 vm-max-memory 设置多小，所有索引数据都是内存存储的（Redis 的索引数据 就是 keys）。

也就是说，当 vm-max-memory 设置为 0 的时候,其实是所有 value 都存在于磁盘。

默认值为 0。

> vm-page-size 32

Redis swap 文件分成了很多的 page，一个对象可以保存在多个 page 上面，但一个 page 上不能被多个对象共享。

vm-page-size 是要根据存储的数据大小来设定的，作者建议如果存储很多小对象。

page 大小最好设置为 32 bytes 或者 64 bytes。

如果存储很大大对象，则可以使用更大的 page，如果不确定，就使用默认值。

> vm-pages 134217728

设置 swap 文件中的 page 数量。

由于页表（一种表示页面空闲或使用的 bitmap）是在放在内存中的。

在磁盘上每 8 个 pages 将消耗 1 byte 的内存。

> vm-max-threads 4

设置访问 swap 文件的线程数，最好不要超过机器的核数。

如果设置为 0，那么所有对 swap 文件的操作都是串行的，可能会造成比较长时间的延迟。

默认值为 4。

> glueoutputbuf yes

设置在向客户端应答时，是否把较小的包合并为一个包发送，默认为开启。

> hash-max-zipmap-entries 64
> hash-max-zipmap-value 512

指定在超过一定的数量或者最大的元素超过某一临界值时，采用一种特殊的哈希算法。

> activerehashing yes

指定是否激活重置哈希，默认为开启。

> include /path/to/local.conf

指定包含其它的配置文件，可以在同一主机上多个 Redis 实例之间使用同一份配置文件，而同时各个实例又拥有自己的特定配置文件。

## 持久化

Redis 是内存数据库，即数据存储在内存。

如果不将内存中的数据保存到磁盘，一旦服务器进程退出，服务器中的数据也会消失。

这样会造成巨大的损失，所以 Redis 提供了持久化功能。

### RDB

![RDB](D:\Study\Learning-record\Redis\RDB.jpg)

在指定的时间间隔内将内存中的数据集快照写入磁盘。

也就是 Snapshot 快照，恢复时是将快照文件直接读到内存里。

Redis会单独创建（fork）一个子进程来进行持久化。

会先将数据写入到一个临时文件中，待持久化过程都结束了，再用这个临时文件替换上次持久化好的文件。

整个过程中，主进程是不进行任何IO操作的，这就确保了极高的性能。

如果需要进行大规模数据的恢复，且对于数据恢复的完整性不是非常敏感，那 RDB 方式要比 AOF 方式更加的高效。

RDB 的缺点是最后一次持久化后的数据可能丢失。

RDB 保存的是`dump.rdb`文件

#### 配置

> RDB 是整合内存的压缩过的 Snapshot，RDB 的数据结构，可以配置复合的快照触发条件。

不设置任何 save 指令或者给 save 传入一个空串，可以禁用RDB策略

```bash
# 1小时内1次修改
save 3600 1
# 5分钟内100次修改
save 300 100
# 1分钟内1万次修改
save 60 10000
```

> stop-writes-on-bgsave-error

如果配置为 no，表示你不在乎数据不一致或者有其他的手段发现和控制，默认为 yes。

> rbdcompression

对于存储到磁盘中的快照，可以设置是否进行压缩存储。

如果是的话，redis 会采用 LZF 算法进行压缩，如果你不想消耗 CPU 来进行压缩的话，可以设置为关闭此功能。

> rdbchecksum

在存储快照后，还可以让 redis 使用 CRC64 算法来进行数据校验。

但是这样做会增加大约 10% 的性能消耗，如果希望获取到最大的性能提升，可以关闭此功能。

默认为 yes。

#### 触发条件

1. 配置文件中默认的快照配置触发，建议多用一台机子作为备份，复制一份 `dump.rdb`。
2. 执行 flushall 命令，也会产生 `dump.rdb` 文件，但里面是空的，无意义 。
3. 退出的时候也会产生 `dump.rdb` 文件。

#### 恢复

将备份文件 dump.rdb 移动到 redis 安装目录并启动服务即可。

```bash
127.0.0.1:6379> config get dir
```

#### 优缺点

> 优点

- 适合大规模的数据恢复。
- 对数据完整性和一致性要求不高时适用。

> 缺点

- 在一定间隔时间做一次备份，所以如果 redis 意外 down 掉的话，就会丢失最后一次快照后的所有修改。
- Fork 的时候，内存中的数据被克隆了一份，大致 2 倍的膨胀性需要考虑。

### AOF

![AOF](D:\Study\Learning-record\Redis\AOF.jpg)

以日志的形式来记录每个写操作，将 Redis 执行过的所有指令记录下来（读操作不记录）。

只许追加文件，但不可以改写文件，Redis 启动之初会读取该文件重新构建数据。

换言之，Redis 重启的话就根据日志文件的内容将写指令从前到后执行一次以完成数据的恢复工作。

AOF 保存的是 `appendonly.aof` 文件

#### 配置

```bash
# 是否以append only模式作为持久化方式，默认使用的是rdb方式持久化，这种方式在许多应用中已经足够用了
appendonly no 
# appendfilename AOF 文件名称
appendfilename "appendonly.aof" 
# appendfsync aof持久化策略的配置：
#     no：不执行fsync，由操作系统保证数据同步到磁盘，速度最快。
#     always：每次写入都执行fsync，以保证数据同步到磁盘。
#     everysec：每秒执行一次fsync，可能会导致丢失这1s数据。
appendfsync everysec 
# 重写时是否可以运用Appendfsync，用默认no即可，保证数据安全性
No-appendfsync-on-rewrite 
# 设置重写的基准值
Auto-aof-rewrite-min-size 
# 设置重写的基准值
Auto-aof-rewrite-percentage
```

#### 恢复

> 正常恢复

1. 启动：修改配置。修改默认的 appendonly no，改为 yes。
2. 复制：将有数据的 aof 文件复制一份保存到对应目录（config get dir）。
3. 恢复：重启 redis 然后重新加载。

> 异常恢复

1. 启动：修改配置。修改默认的 appendonly no，改为 yes。
2. 破坏：故意破坏 appendonly.aof 文件（写一些非 Redis 命令）。
3. 修复：`redis-check-aof --fix appendonly.aof` 进行修复。
4. 恢复：重启 redis 然后重新加载。

#### 触发机制

AOF 采用文件追加方式，文件会越来越大，为避免出现此种情况，新增了重写机制。

当AOF文件的大小超过所设定的阈值时，Redis 就会启动 AOF 文件的内容压缩。

只保留可以恢复数据的最小指令集，可以使用命令 `bgrewriteaof`。

> 重写原理

AOF 文件持续增长而过大时，会 Fork 出一条新进程来将文件重写（也是先写临时文件最后再 rename）。

遍历新进程的内存中数据，每条记录有一条的 set 语句。

重写 aof 文件的操作，并没有读取旧的 aof 文件，这点和快照有点类似。

> 触发机制

Redis 会记录上次重写时的 AOF 大小，默认配置是当 AOF 文件大小是上次 rewrite 后大小的 **1 倍**且文件大于 **64M** 时触发。

#### 优缺点

> 优点

- appendfsync always：每次修改同步。同步持久化，每次发生数据变更会被立即记录到磁盘。性能较差，但数据完整性比较好。
- appendfsync everysec：每秒同步。异步操作，每秒记录 ，如果一秒内宕机，有数据丢失。
- appendfsync no：不同步。从不同步。

> 缺点

- 相同数据集的数据而言，AOF 文件要远大于 RDB 文件，恢复速度慢于 RDB。
- AOF 运行效率要慢于 RDB，每秒同步策略效率较好，不同步效率和 RDB 相同。

## 发布订阅

![发布订阅](D:\Study\Learning-record\Redis\发布订阅.jpg)

### 命令

|                    命令                     | 描述                               |
| :-----------------------------------------: | :--------------------------------- |
|      PSUBSCRIBE pattern [pattern ...]       | 订阅一个或多个符合给定模式的频道。 |
| PUBSUB subcommand [argument [argument ...]] | 查看订阅与发布系统状态。           |
|           PUBLISH channel message           | 将信息发送到指定的频道。           |
|    PUNSUBSCRIBE [pattern [pattern ...]]     | 退订所有给定模式的频道。           |
|       SUBSCRIBE channel [channel ...]       | 订阅给定的一个或多个频道的信息。   |
|     UNSUBSCRIBE [channel [channel ...]]     | 指退订给定的频道。                 |

### 简单使用

- 窗口 1，订阅频道

```bash
127.0.0.1:6379> subscribe redisChat
Reading messages... (press Ctrl-C to quit)
1) "subscribe"
2) "redisChat"
3) (integer) 1
```

- 窗口 2，订阅频道

```bash
127.0.0.1:6379> subscribe redisChat
Reading messages... (press Ctrl-C to quit)
1) "subscribe"
2) "redisChat"
3) (integer) 1
```

- 窗口 3，频道发布消息

```bash
127.0.0.1:6379> publish redisChat "Hello,Redis"
(integer) 2
127.0.0.1:6379> publish redisChat "Hello,World"
(integer) 2
```

- 窗口 1 和窗口 2 都会收到发布的消息：

```bash
1) "message"
2) "redisChat"
3) "Hello,Redis"
1) "message"
2) "redisChat"
3) "Hello,World"
```

### 原理

- Redis 是使用 **C** 实现的，通过分析 Redis 源码里的 **pubsub.c** 文件，可以了解发布和订阅机制的底层实现。
- Redis 通过 publish 、subscribe 和 psubscribe 等命令实现发布和订阅功能。
- 通过 subscribe 命令订阅某频道后，redis-server 里维护了一个字典，字典的键就是一个个 channel。
- 而字典的值则是一个链表，链表中保存了所有订阅这个 channel 的客户端。
- subscribe 命令的关键，就是将客户端添加到给定 channel 的订阅链表中。
- 通过 publish 命令向订阅者发送消息，redis-server 会使用给定的频道作为键，在它所维护的 channel 字典中查找记录了订阅这个频道的所有客户端的链表，遍历这个链表，将消息发布给所有订阅者。
- pub / sub 从字面上理解就是发布（Publish）与订阅（Subscribe），在 Redis 中，你可以设定对某一个 key 值进行消息发布及消息订阅，当一个 key 值上进行了消息发布后，所有订阅它的客户端都会收到相应的消息。
- 这一功能最明显的用法就是用作实时消息系统，比如普通的即时聊天，群聊等功能。

## 主从复制

### 概述

> 主从复制，是指将一台 Redis 服务器的数据，复制到其他的 Redis 服务器

前者称为主节点（master / leader），后者称为从节点（slave / follower）。

数据的复制是单向的，只能由主节点到从节点。

Master 以写为主，Slave 以读为主。

一个主节点可以有多个从节点（或没有从节点），但一个从节点只能有一个主节点。

默认情况下，每台 Redis 服务器都是主节点。

### 作用

> 数据冗余

主从复制实现了数据的热备份，是持久化之外的一种数据冗余方式。

> 故障恢复

当主节点出现问题时，可以由从节点提供服务，实现快速的故障恢复。这也是一种服务的冗余。

> 负载均衡

在主从复制的基础上，配合读写分离，可以由主节点提供写服务，由从节点提供读服务，分担服务器负载。

尤其是在写少读多的场景下，通过多个从节点分担读负载，可以大大提高 Redis 服务器的并发量。

> 高可用

主从复制是哨兵和集群能够实施的基础，因此说主从复制是 Redis 高可用的基础。

一般来说，要将 Redis 运用于工程项目中，只使用一台 Redis 是万万不能的，原因如下：

- 结构上：单个 Redis 服务器会发生单点故障，并且一台服务器需要处理所有的请求负载，压力较大。
- 容量上：单个 Redis 服务器内存容量有限，一般来说，单台 Redis 最大使用内存不应该超过 20G。

> 应用

电商网站上的商品，一般都是一次上传，无数次浏览的，说专业点也就是**多读少写**。

对于这种场景，我们可以使用如下这种架构：

![主从复制](D:\Study\Learning-record\Redis\主从复制.jpg)

### 简单实现

#### 环境准备

标准配置为一主三从，这里以一主二从为例

- 拷贝多个`redis.conf`文件

```bash
cp redis.conf redis6379.conf
cp redis.conf redis6380.conf
cp redis.conf redis6381.conf
```

- 修改 redis6379.conf

```
daemonize yes
pidfile /var/run/redis_6379.pid
logfile "6379.log"
dbfilename dump6379.rdb
port 6379
```

- 修改 redis6380.conf

```
daemonize yes
pidfile /var/run/redis_6380.pid
logfile "6380.log"
dbfilename dump6380.rdb
port 6380
```

- 修改 redis6381.conf

```
daemonize yes
pidfile /var/run/redis_6381.pid
logfile "6381.log"
dbfilename dump6381.rdb
port 6381
```

#### 简单实现

- 启动服务

```bash
redis-server conf/redis6379.conf
redis-server conf/redis6380.conf
redis-server conf/redis6381.conf
```

- 查看启动的进程

```bash
ps -ef | grep redis
```

![主从复制-后台进程](D:\Study\Learning-record\Redis\主从复制-后台进程.jpg)

- 连接客户端到6379

```bash
redis-cli -p 6379
```

- 查看主从信息

可以看到，默认为master，有0个从机

```bash
info replication
```

![主从复制-默认主从信息](D:\Study\Learning-record\Redis\主从复制-默认主从信息.jpg)

- 在从机端使用命令指定主机，这样配置是临时的，在配置文件进行配置是永久的

可以看到，进行配置之后，查询到当前为从机，并且记录了主机的IP和端口信息

```bash
slaveof 主机地址 主机端口号
```

![主从复制-配置从机信息](D:\Study\Learning-record\Redis\主从复制-配置从机信息.jpg)

- 可以在配置文件里进行永久主从配置

![主从复制-配置文件实现](D:\Study\Learning-record\Redis\主从复制-配置文件实现.png)

#### 主从操作

主机赋值，从机取值

从机是不能赋值的，这样就实现了**读写分离**。

主机断开以后从机依然是从机，且正常工作。

主机恢复以后赋的值从机依然能够读取到，这样可以保证高可用。

从机断开后，主机赋了新值，从机启动后无法获取到新值，原因是从机启动后又默认为主机了。

如果想启动即为从机，可以按照前面说的配置 **replicaof** 进行设置。

在主机断连之后，从机可以使用`slaveof no one`命令来任命自己为主机，这样做，主机再连接上来的时候，将不会再有之前的主从关系

#### 层层链路

![主从复制-层层链路](D:\Study\Learning-record\Redis\主从复制-层层链路.png)

6381 指定 6380 作为主机，6380 依然是从机，只是有了从机节点。

这样 6379 赋的值只需要复制到 6380，6380 再复制到 6381，这样就有效的减轻主机的写压力。

### 哨兵模式（常用）

主从切换技术的操作是：当主机宕机后，需要手动把一台从机切换为主机。

这就需要人工干预，费事费力，还会造成一段时间内服务不可用。

这不是一种推荐的方式，更多时候，我们优先考虑**哨兵模式**。

Redis 从 **2.8** 开始正式提供了 **Sentinel（哨兵）** 架构来解决这个问题。

它能够后台监控主机是否故障，如果故障了根据投票数自动将从机转换为主机。

哨兵模式是一种特殊的模式，首先 Redis 提供了哨兵的命令，哨兵是一个独立的进程，它会独立运行。

其原理是哨兵通过发送命令，等待 Redis 服务器响应，从而监控运行的多个 Redis 实例。

![单哨兵](D:\Study\Learning-record\Redis\单哨兵.png)

这里的哨兵有两个作用：

- 通过发送命令，让 Redis 服务器返回监控其运行状态，包括主机和从机。
- 当哨兵监测到 master 宕机，会自动将 slave 切换成 master，然后通过**发布订阅模式**通知其他的从机，修改配置文件，让它们切换主机。

然而一个哨兵进程对 Redis 服务器进行监控，可能会出现问题，为此，我们可以使用多个哨兵进行监控。

各个哨兵之间还会进行监控，这样就形成了**多哨兵模式**：

![哨兵集群](D:\Study\Learning-record\Redis\哨兵集群.png)

假设主机宕机，哨兵 1 先检测到这个结果，系统并不会马上进行 failover（故障转移） 过程，仅仅是哨兵 1 主观的认为主机不可用，这个现象称为**主观下线**。

当后面的哨兵也检测到主机不可用，并且数量达到一定值时，哨兵之间就会进行一次投票，投票的结果由一个哨兵发起，进行 failover 操作。

切换成功后，就会通过发布订阅模式，让各个哨兵把自己监控的从机实现切换主机，这个过程称为**客观下线**。

#### 简单使用

- 创建一个哨兵的配置文件，文件名固定`sentinel.conf`

- 编写配置

```bash
#sentinel monitor 被监控的名称 host port 1
#末尾1代表主机挂了，slave投票看让谁接替成为主机，票数最多就会成为主机
sentinel monitor myredis 127.0.0.1 6379 1
```

- 启动哨兵

```
redis-sentinel conf/sentinel.conf
```

#### 哨兵机制

主机断开后，哨兵进程会监测到，然后发起选举，调用选举算法，选举一个从机成为新主机。

之前断开的主机恢复后，哨兵进程也会检测到，但此时并不会将其再设为主机，而是设为新主机的从机。

#### 完整配置文件

```bash
# 哨兵 sentinel 实例运行的端口 默认 26379
port 26379
# 哨兵 sentinel 的工作目录
dir /tmp
# 哨兵 sentinel 监控的 redis 主节点的 ip port
# master-name 可以自己命名的主节点名字：只能由字母 A-z、数字 0-9、".-_"这三个字符组成。
# quorum 配置多少个 sentinel 哨兵统一认为 master 主节点失联那么这时客观上认为主节点失联了
# sentinel monitor <master-name> <ip> <redis-port> <quorum>
sentinel monitor mymaster 127.0.0.1 6379 2
# 当在 Redis 实例中开启了 requirepass foobared 授权密码 这样所有连接 Redis 实例的客户端都要提供密码
# 设置哨兵 sentinel 连接主从的密码，注意必须为主从设置一样的验证密码
# sentinel auth-pass <master-name> <password>
sentinel auth-pass mymaster MySUPER--secret-0123passw0rd
# 指定多少毫秒之后，主节点没有应答哨兵 sentinel，此时，哨兵主观上认为主节点下线，默认 30 秒
# sentinel down-after-milliseconds <master-name> <milliseconds>
sentinel down-after-milliseconds mymaster 30000
# 这个配置项指定了在发生 failover 主备切换时最多可以有多少个 slave 同时对新的 master 进行同步
# 这个数字越小，完成 failover 所需的时间就越长
# 但是如果这个数字越大，就意味着越多的 slave 因为 replication 而不可用
# 可以通过将这个值设为 1 来保证每次只有一个 slave 处于不能处理命令请求的状态
# sentinel parallel-syncs <master-name> <numslaves>
sentinel parallel-syncs mymaster 1
# 故障转移的超时时间 failover-timeout 可以用在以下这些方面：
# 1. 同一个 sentinel 对同一个 master 两次 failover 之间的间隔时间
# 2. 当一个 slave 从一个错误的 master 那里同步数据开始计算时间。直到 slave 被纠正为向正确的 master 那里同步数据时。
# 3. 当想要取消一个正在进行的 failover 所需要的时间。
# 4. 当进行 failover 时，配置所有 slaves 指向新的 master 所需的最大时间。
#    不过，即使过了这个超时，slaves 依然会被正确配置为指向 master，但是就不按 parallel-syncs 所配置的规则来了
# 默认三分钟
# sentinel failover-timeout <master-name> <milliseconds>
sentinel failover-timeout mymaster 180000
# SCRIPTS EXECUTION
# 配置当某一事件发生时所需要执行的脚本，可以通过脚本来通知管理员，例如当系统运行不正常时发邮件通知相关人员。
# 对于脚本的运行结果有以下规则：
# 若脚本执行后返回 1，那么该脚本稍后将会被再次执行，重复次数目前默认为 10
# 若脚本执行后返回 2，或者比 2 更高的一个返回值，脚本将不会重复执行。
# 如果脚本在执行过程中由于收到系统中断信号被终止了，则同返回值为 1 时的行为相同。
# 一个脚本的最大执行时间为 60s，如果超过这个时间，脚本将会被一个 SIGKILL 信号终止，之后重新执行。
# 通知型脚本:当 sentinel 有任何警告级别的事件发生时（比如说 redis 实例的主观失效和客观失效等），将会去调用这个脚本
# 这时这个脚本应该通过邮件，SMS 等方式去通知系统管理员关于系统不正常运行的信息。
# 调用该脚本时，将传给脚本两个参数，一个是事件的类型，一个是事件的描述。
# 如果 sentinel.conf 配置文件中配置了这个脚本路径，那么必须保证这个脚本存在于这个路径，并且是可执行的，否则 sentinel 无法正常启动成功。
# 通知脚本
# sentinel notification-script <master-name> <script-path>
sentinel notification-script mymaster /var/redis/notify.sh
# 客户端重新配置主节点参数脚本
# 当一个 master 由于 failover 而发生改变时，这个脚本将会被调用，通知相关的客户端关于 master 地址已经发生改变的信息。
# 以下参数将会在调用脚本时传给脚本:
# <master-name> <role> <state> <from-ip> <from-port> <to-ip> <to-port>
# 目前 <state> 总是 “failover”，<role> 是 “leader” 或者 “observer” 中的一个。
# 参数 from-ip，from-port，to-ip，to-port是用来和旧的 master 和新的 master (即旧的 slave)通信的
# 这个脚本应该是通用的，能被多次调用，不是针对性的。
# sentinel client-reconfig-script <master-name> <script-path>
sentinel client-reconfig-script mymaster /var/redis/reconfig.sh
```

#### 优缺点

> 优点

哨兵集群模式是基于主从模式的，所有主从的优点，哨兵模式同样具有。

主从可以切换，故障可以转移，系统可用性更好。

哨兵模式是主从模式的升级，系统更健壮，可用性更高。

> 缺点

Redis较难支持在线扩容，在集群容量达到上限时在线扩容会变得很复杂。

实现哨兵模式的配置也不简单，甚至可以说有些繁琐。

## 缓存问题

Redis 缓存的使用，极大的提升了应用程序的性能和效率，特别是数据查询方面。

但同时，它也带来了一些问题。其中，最要害的问题，就是数据的一致性问题，从严格意义上讲，这个问题无解。

如果对数据的一致性要求很高，那么就不能使用缓存。

另外的一些典型问题就是，**缓存穿透**、**缓存雪崩**和**缓存击穿**。目前，业界也都有比较流行的解决方案。

![缓存-正常请求](D:\Study\Learning-record\Redis\缓存-正常请求.jpg)

### 缓存穿透

> 缓存的日常使用情况

查询一个数据，先到缓存中查询。如果缓存中存在，则返回。

如果缓存中不存在，则到数据库查询。

如果数据库中存在，则返回数据，且存到缓存。

如果数据库中不存在，则返回空值。

> 缓存穿透现象

**缓存穿透**出现的情况就是数据库和缓存中都没有。

这样缓存就不能拦截，数据库中查不到值也就不能存到缓存。

这样每次这样查询都会到数据库，相当于直达了，即**穿透**。

这样会给数据库造成很大的压力。

![缓存穿透](D:\Study\Learning-record\Redis\缓存穿透.jpg)

> 解决方案

1. 布隆过滤器

**布隆过滤器**是一种数据结构，对所有可能查询的参数以 hash 形式存储，在控制层先进行校验，不符合则丢弃，从而避免了对底层存储系统的查询压力。

![布隆过滤器](D:\Study\Learning-record\Redis\布隆过滤器.png)

2. 缓存空对象

当存储层不命中后，即使返回的空对象也将其缓存起来，同时会设置一个过期时间，之后再访问这个数据将会从缓存中获取，保护了后端数据源。

![缓存空对象](D:\Neat Download Manager下载目录\缓存空对象.png)

但是这种方法会存在两个问题：

- 如果空值能够被缓存起来，这就意味着缓存需要更多的空间存储更多的键，因为这当中可能会有很多的空值的键。
- 即使对空值设置了过期时间，还是会存在缓存层和存储层的数据会有一段时间窗口的不一致，这对于需要保持一致性的业务会有影响。

### 缓存击穿

**缓存击穿**，是指一个 key 非常热点，在不停的扛着大并发，大并发集中对这一个点进行访问。

当这个 key 在失效的瞬间，持续的大并发就穿破缓存，直接请求数据库，就像在一个屏障上凿开了一个洞。

当某个 key 在过期的瞬间，有大量的请求并发访问，这类数据一般是热点数据。

由于缓存过期，会同时访问数据库来查询最新数据，并且回写缓存，会导使数据库瞬间压力过大。

![缓存击穿](D:\Study\Learning-record\Redis\缓存击穿.jpg)

> 解决方案

1. 设置热点数据永不过期

从缓存层面来看，没有设置过期时间，所以不会出现热点 key 过期后产生的问题。

2. 加互斥锁

分布式锁：使用分布式锁，保证对于每个 key 同时只有一个线程去查询后端服务，其他线程没有获得分布式锁的权限，因此只能等待。

这种方式将高并发的压力转移到了分布式锁，因此对分布式锁的考验很大。

### 缓存雪崩

**缓存雪崩**，是指在某一个时间段，缓存集中过期失效。

产生雪崩的原因之一，比如马上就要到双十一零点，很快就会迎来一波抢购。

这波商品时间比较集中的放入了缓存，假设缓存一个小时。

那么到了凌晨一点钟的时候，这批商品的缓存就都过期了。

而对这批商品的访问查询，都落到了数据库上，对于数据库而言，就会产生周期性的压力波峰。

于是所有的请求都会达到存储层，存储层的调用量会暴增，造成存储层也会挂掉的情况。

其实集中过期，倒不是非常致命。

比较致命的缓存雪崩，是缓存服务器某个节点宕机或断网。

因为自然形成的缓存雪崩，一定是在某个时间段集中创建缓存。

这个时候，数据库也是可以顶住压力的，无非就是对数据库产生周期性的压力而已。

而缓存服务节点的宕机，对数据库服务器造成的压力是不可预知的，很有可能瞬间就把数据库压垮。

![缓存雪崩](D:\Study\Learning-record\Redis\缓存雪崩.jpg)

> 解决方案

1. 搭建集群

实现 Redis 的高可用，既然一台服务有可能挂掉，那就多增设几台服务。

这样一台挂掉之后其他的还可以继续工作，其实就是搭建的集群。

2. 限流降级

在缓存失效后，通过加锁或者队列来控制读数据库写缓存的线程数量。

比如对某个 key 只允许一个线程查询数据和写缓存，其他线程等待。

3. 数据预热

数据加热的含义就是在正式部署之前，先把可能的数据先预先访问一遍，这样部分可能大量访问的数据就会加载到缓存中。

在即将发生大并发访问前手动触发加载缓存不同的 key，设置不同的过期时间，让缓存失效的时间点尽量均匀。
