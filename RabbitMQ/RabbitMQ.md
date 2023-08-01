## MQ概述

MQ全称 Message Queue（消息队列），是在消息的传输过程中保存消息的容器。多用于分布式系统之间进行通信。

![系统调用](D:\Study\Learning-record\RabbitMQ\系统调用.jpg)

## MQ的优劣势

> 优势

- 应用解耦：提高系统容错性和可维护性
- 异步提速：提升用户体验和系统吞吐量
- 削峰填谷：提高系统稳定性

> 劣势

- 系统可用性降低：系统引入外部依赖越多，系统稳定性越差，一旦MQ宕机，就会对业务造成影响
- 系统复杂度提高：MQ 的加入大大增加了系统的复杂度，以前系统间是同步的远程调用，现在是通过 MQ 进行异步调用。
- 一致性问题：A 系统处理完业务，通过 MQ 给B、C、D三个系统发消息数据，如果 B 系统、C 系统处理成功，D 系统处理失败。如何保证消息数据处理的一致性？

## MQ的使用场景

1. 生产者不需要从消费者处获得反馈。引入消息队列之前的直接调用，其接口的返回值应该为空，这才让明 明下层的动作还没做，上层却当成动作做完了继续往后走，即所谓异步成为了可能。
2. 容许短暂的不一致性。
3. 确实是用了有效果。即解耦、提速、削峰这些方面的收益，超过加入MQ，管理MQ这些成本。

## 常见MQ产品

![常见MQ产品](D:\Study\Learning-record\RabbitMQ\常见MQ产品.jpg)

## RabbitMQ概述

### AMQP

AMQP，即 Advanced Message Queuing Protocol（高级消息队列议），是一个网络协议，是应用层协议 的一个开放标准，为面向消息的中间件设计。基于此协议的客户端与消息中间件可传递消息，并不受客户端/中间件不同产品，不同的开发语言等条件的限制。2006年，AMQP 规范发布。类比HTTP。

![AMQP](D:\Study\Learning-record\RabbitMQ\AMQP.jpg)

### 基础架构

2007年，Rabbit 技术公司基于 AMQP 标准开发的 RabbitMQ 1.0 发布。RabbitMQ 采用 Erlang 语言开发。 Erlang 语言由 Ericson 设计，专门为开发高并发和分布式系统的一种语言，在电信领域使用广泛。基础架构如下

![RabbitMQ基础架构](D:\Study\Learning-record\RabbitMQ\RabbitMQ基础架构.jpg)

### 相关名词概念

- `Broker`：接收和分发消息的应用，RabbitMQ Server就是 Message Broker
- `Virtual host`：出于多租户和安全因素设计的，把 AMQP 的基本组件划分到一个虚拟的分组中，类似于网 络中的 namespace 概念。当多个不同的用户使用同一个 RabbitMQ server 提供的服务时，可以划分出多 个vhost，每个用户在自己的 vhost 创建 exchange／queue 等
- `Connection`：publisher／consumer 和 broker 之间的 TCP 连接
- `Channel`：如果每一次访问 RabbitMQ 都建立一个 Connection，在消息量大的时候建立 TC Connection 的开销将是巨大的，效率也较低。Channel 是在 connection 内部建立的逻辑连接，如果应用程序支持多线 程，通常每个thread创建单独的 channel 进行通讯，AMQP method 包含了channel id 帮助客户端和 message broker 识别 channel，所以 channel 之间是完全隔离的。Channel 作为轻量级的 Connection  极大减少了操作系统建立 TCP connection 的开销
- `Exchange`：message 到达 broker 的第一站，根据分发规则，匹配查询表中的 routing key，分发消息到 queue 中去。常用的类型有：direct (point-to-point), topic (publish-subscribe) and fanout (multicast)
- `Queue`：消息最终被送到这里等待 consumer 取走
- `Binding`：exchange 和 queue 之间的虚拟连接，binding 中可以包含 routing key。Binding 信息被保存 到 exchange 中的查询表中，用于 message 的分发依据

### 6种工作模式

RabbitMQ 提供了 6 种工作模式：简单模式、work queues、Publish/Subscribe 发布与订阅模式、Routing 路由模式、Topics 主题模式、RPC 远程调用模式（远程调用，不太算 MQ；暂不作介绍）。 官网对应模式介绍：https://www.rabbitmq.com/getstarted.html

![6种工作模式](D:\Study\Learning-record\RabbitMQ\6种工作模式.jpg)

### JMS

- JMS 即 Java 消息服务（JavaMessage Service）应用程序接口，是一个 Java 平台中关于面向消息中间件 的API
- JMS 是 JavaEE 规范中的一种，类比JDBC
- 很多消息中间件都实现了JMS规范，例如：ActiveMQ。RabbitMQ 官方没有提供 JMS 的实现包，但是开 源社区有