## 微服务概述

### 什么是微服务架构

微服务架构是一种软件设计方法，其中应用程序被拆分成一组小型、自治的服务，每个服务都运行在独立的进程中，并使用轻量级的通信机制来相互协作。每个服务都专注于解决一个特定的业务问题，可以独立开发、测试、部署和扩展。微服务架构通常使用容器化技术（如Docker）来实现服务的部署和管理，并使用自动化工具和平台来协助开发和部署。

与传统的单体架构相比，微服务架构具有更好的可扩展性、可靠性和可维护性，因为每个服务都是独立的，可以针对具体问题进行优化和扩展。此外，微服务架构还使开发人员能够使用不同的编程语言和技术栈来实现不同的服务，从而提高了团队的灵活性和生产力。

### 微服务架构4个核心问题

1. 服务很多，用户该如何访问
2. 这么多服务，服务之间如何通信
3. 这么多服务，如何治理
4. 服务挂了怎么办

### 微服务问题的多种解决方案

- Spring Cloud NetFlix 一站式解决方案
- Apache Dubbo + Zookeeper 拼装解决

- Spring Cloud Alibaba 一站式解决方案

## SpringCloud入门

### SpringCloud是什么

- SpringCloud, 基于SpringBoot提供了一套微服务解决方案，包括**服务注册与发现，配置中心，全链路监
  控，服务网关，负载均衡，熔断器等组件**，除了基于NetFlix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件。
- SpringCloud利用SpringBoot的开发便利性，巧妙地简化了分布式系统基础设施的开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，**包括配置管理，服务发现，断路器，路由，微代理，事件总线，全局锁，决策竞选，分布式会话等等**，他们都可以用SpringBoot的开发风格做到一键启动和部署。
- SpringBoot并没有重复造轮子，它只是将目前各家公司开发的比较成熟，经得起实际考研的服务框架组合起来，通过SpringBoot风格进行再封装，屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套
  **简单易懂，易部署和易维护的分布式系统开发工具包**
- SpringCloud 是 分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务全桶。

![SpringCloud](D:\Study\Learning-record\SpringCloud\SpringCloud.png)

### SpringCloud和SpringBoot关系

SpringBoot专注于快速方便的开发**单个个体微服务**。

SpringCloud是关注**全局的微服务协调整理治理框架**，它将SpringBoot开发的一个个单体微服务整合并管理起来，为各个微服务之间提供：配置管理，服务发现，断路器，路由，微代理，事件总线，全局锁，决策竞选，分布式会话等等集成服务。

SpringBoot可以离开SpringClooud独立使用，开发项目，但是SpringCloud离不开SpringBoot，属于依赖关系

### Dubbo 和 SpringCloud 对比

|                          |     Dubbo     |         SpringCloud          |
| :----------------------: | :-----------: | :--------------------------: |
| 服务注册中心服务注册中心 |   Zookeeper   | Spring Cloud Netfilx Eureka  |
|       服务调用方式       |      RPC      |           REST API           |
|         服务监控         | Dubbo-monitor |      Spring Boot Admin       |
|          断路器          |    不完善     | Spring Cloud Netfilx Hystrix |
|         服务网关         |      无       |  Spring Cloud Netfilx Zuul   |
|        分布式配置        |      无       |     Spring Cloud Config      |
|         服务跟踪         |      无       |     Spring Cloud Sleuth      |
|         消息总栈         |      无       |       Spring Cloud Bus       |
|          数据流          |      无       |     Spring Cloud Stream      |
|         批量任务         |      无       |      Spring Cloud Task       |

> 最大区别：SpringCloud抛弃了Dubbo的RPC通信，采用的是基于HTTP的REST方式。

严格来说，这两种方式各有优劣。虽然从一定程度上来说，后者牺牲了服务调用的性能，但也避免了上面提到的原生RPC带来的问题。

而且REST相比RPC更为灵活，服务提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖，这在强调快速演化的微服务环境下，显得更加合适。

**Dubbo**的定位是一款RPC框架，**Spring Cloud**的目标是微服务架构下的一站式解决方案

### 官网

http://projects.spring.io/spring-cloud/

SpringCloud没有采用数字编号的方式命名版本号，而是采用了**伦敦地铁站**的名称，同时根据字母表的顺序来对应版本时间顺序，比如最早的Realse版本：Angel，第二个Realse版本：Brixton，然后是Camden、Dalston\Edgware，目前最新的是Hoxton SR4 CURRENT GA通用稳定版。

### 参考资料

- SpringCloud Netflix 中文文档：https://springcloud.cc/spring-cloud-netflix.html
- SpringCloud 中文API文档(官方文档翻译版)：https://springcloud.cc/spring-cloud-dalston.html
- SpringCloud中国社区：http://springcloud.cn/
- SpringCloud中文网：[https://springcloud.cc](https://springcloud.cc/)

## 模块通信

### 创建父工程

- pom.xml

```xml
<!--使用pom方式进行打包-->
<packaging>pom</packaging>
<!--统一管理版本依赖-->
<properties>
    <java.version>1.8</java.version>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>

    <junit.version>4.12</junit.version>
    <lombok.version>1.16.18</lombok.version>
    <log4j.version>1.2.17</log4j.version>
    <cloud.varsion>2021.0.6</cloud.varsion>
    <mp.version>3.4.1</mp.version>
    <druid.version>1.2.16</druid.version>
    <mysql.version>5.1.47</mysql.version>
    <springboot.version>2.6.7</springboot.version>
</properties>
<!--依赖管理器可以使子模块依赖按需引入-->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>${springboot.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <version>${springboot.version}</version>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <version>${springboot.version}</version>
            <scope>test</scope>
        </dependency>
        <!--springcloud-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${cloud.varsion}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>
        <!--druid数据库连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>
        <!--mybatis-plus-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>${mp.version}</version>
        </dependency>
        <!--测试、日志-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### 创建spingcloud-api子模块

> 用于存放实体类

- pom.xml

```xml
<!--因为有了依赖管理器，不需要再手动指定版本-->
<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

- 创建数据库表

```sql
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `dname` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `db_source` varchar(255) DEFAULT NULL COMMENT '所属数据库',
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
```

```sql
insert into dept (`dname`,`db_source`) values ('开发部',DATABASE());
insert into dept (`dname`,`db_source`) values ('人事部',DATABASE());
insert into dept (`dname`,`db_source`) values ('财务部',DATABASE());
insert into dept (`dname`,`db_source`) values ('市场部',DATABASE());
insert into dept (`dname`,`db_source`) values ('运营部',DATABASE());
```

- 实体类

```java
package com.jc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author John.Cena
 * @date 2023/3/18 16:26
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept {
    private Long id;
    private String dname;
    private String db_source;
}
```

### 创建springcloud-provider-dept-8001子模块

> 用于提供服务

- pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>springcloud-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    <!--mysql-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <!--druid数据库连接池-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
    </dependency>
    <!--mybatis-plus-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

- 配置文件

```yml
server:
  port: 8001

mybatis-plus:
  configuration:
    cache-enabled: true
    log-impl: org.apache.ibatis.logging.log4j.Log4jImpl
    map-underscore-to-camel-case: false

spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/springcloud-test?useSSL=false&userUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8
    username: root
    password: lishuang001219
```

- mapper

```java
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
```

- Service

```java
public interface DeptService extends IService<Dept> {
}
```

```java
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}
```

- RestController

```java
//提供Restful服务
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService service;
    @PostMapping("/add")
    public boolean addDept(Dept dept){
        boolean b = service.save(dept);
        return b;
    }
    @GetMapping("/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = service.getById(id);
        return dept;
    }
    @GetMapping("/list")
    public List<Dept> queryAll(){
        return service.list();
    }
}
```

### 创建springcloud-customer-dept-80子模块

- pom.xml

```xml
<!-- 客户端不需要处理业务，所以只需要实体类+Web依赖即可 -->
<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>springcloud-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

- 使用配置类注册restTemple模板的Bean对象

```java
@Configuration
public class ApplicationConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

- Controller

使用restTemplate模板发送http请求调用远程服务，完成模块通信

```java
@RestController
public class CustomerController {

    //提供服务的地址
    private static final String REST_URL_PREFIX="http://localhost:8001";

    //使用restTemplate模板发送http请求调用远程服务，完成模块通信
    //(url,实体：map,Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }
}
```

## CAP理论

CAP原则又称CAP定理，指的是在一个分布式系统中

- 一致性（Consistency）
- 可用性（Availability）
- 分区容错性（Partition tolerance）

三者不可兼得

一个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求

根据CAP原理，将NoSQL数据库分成了满足CA原则，满足CP原则和满足AP原则三大类：

- CA：单点集群，满足一致性，可用性的系统，通常可扩展性较差
- CP：满足一致性，分区容错性的系统，通常性能不是特别高
- AP：满足可用性，分区容错性的系统，通常可能对一致性要求低一些

![CAP理论图](D:\Study\Learning-record\SpringCloud\CAP理论图.jpg)

### Eureka与Zookerper

由于**分区容错性P**在分布式系统中是必须要保证的，因此我们只能在A和C之间进行权衡。==Eureka遵循AP原则，Zookeeper遵循CP原则==

> Zookeeper保证的是CP

当向注册中心查询服务列表时，我们可以容忍注册中心返回的是几分钟以前的注册信息，但不能接受服务直接down掉不可用。也就是说，**服务注册功能对可用性的要求要高于一致性**。但是zk会出现这样一种情况，当master节点因为网络故障与其他节点失去联系时，剩余节点会重新进行leader选举。问题在于，选举leader的时间太长，30~120s，且选举期间整个zk集群都是不可用的，这就导致在选举期间注册服务**瘫痪**。在云部署的环境下，因为网络问题使得zk集群失去master节点是较大概率会发生的事件，虽然服务最终能够恢复，但是漫长的选举时间导致的注册长期不可用是不能容忍的。

> Eureka保证的是AP

Eureka看明白了这一点，因此在设计时就优先保证可用性。**Eureka各个节点都是平等的**，几个节点挂掉不会影响正常节点的工作，剩余的节点依然可以提供注册和查询服务。而Eureka的客户端在向某个Eureka注册时，如果发现连接失败，则会自动切换至其他节点，只要有一台Eureka还在，就能保住注册服务的可用性，只不过查到的信息可能不是最新的，除此之外，Eureka还有一种自我保护机制，如果在15分钟内超过85%的节点都没有正常的心跳，那么Eureka就认为客户端与注册中心出现了网络故障，此时会出现以下几种情况：

- Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务
- Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其他节点上（即保证当前节点依然可用）
- 当网络稳定时，当前实例新的注册信息会被同步到其他节点中

**因此，Eureka可以很好的应对因网络故障导致部分节点失去联系的情况，而不会像zookeeper那样使整个注册服务瘫痪**

## Eureka服务注册与发现

### Eureka是什么

Eureka是Netflix的一个子模块，也是核心模块之一。Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移，服务注册与发现对于微服务来说是非常重要的，有了服务发现与注册，只需要使用服务的标识符，就可以访问到服务，而不需要修改服务调用的配置文件了，功能类似于Dubbo的注册中心，比如Zookeeper；

### 三大角色

- Eureka Server：提供服务的注册于发现。
- Service Provider：将自身服务注册到Eureka中，从而使消费方能够找到。
- Service Consumer：服务消费方从Eureka中获取注册服务列表，从而找到消费服务。

### Eureka的自我保护机制

==好死不如赖活着：某时刻某一个微服务不可以用了，eureka不会立刻清理，依旧会对该微服务的信息进行保存！==

不开启保护模式的情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例（默认90秒）。但是当网络分区故障发生时，微服务与Eureka之间无法正常通行，以上行为可能变得非常危险了—因为微服务本身其实是健康的，此时本不应该注销这个服务。Eureka通过 自我保护机制 来解决这个问题—当EurekaServer节点在短时间内丢失过多客户端时（可能发生了网络分区故障），那么这个节点就会进入自我保护模式。一旦进入该模式，EurekaServer就会保护服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）。当网络故障恢复后，该EurekaServer节点会自动退出自我保护模式。

在自我保护模式中（默认开启），EurekaServer会保护服务注册表中的信息，不再注销任何服务实例。当它收到的心跳数重新恢复到阈值以上时，该EurekaServer节点就会自动退出自我保护模式。它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务实例。一句话：好死不如赖活着。

综上，自我保护模式是一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留），也不盲目注销任何健康的微服务。使用自我保护模式，可以让Eureka集群更加的健壮和稳定。在SpringCloud中，可以使用 `eureka.server.enable-self-preservation = false` 禁用自我保护模式 【不推荐关闭自我保护机制】

### 简单使用

#### 创建springcloud-eureka-7001模块，作为注册中心

- pom.xml

```xml
<!--导包-->
<dependencies>
    <!--erueka-server服务端-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    <!--热部署工具-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

- application.yml

```yml
server:
  port: 7001
  
#Eureka配置
eureka:
  instance:
    hostname: localhost  #Eureka服务端的实例名称
  client:
    register-with-eureka: false  #表示是否向eureka注册中心注册自己，此模块就是作为注册中心的，所以不注册
    fetch-registry: false  #如果为false，则表示自己为注册中心，等别人过来连就好了
    service-url:  #监控页面
      #单机
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
      # 设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个defaultZone地址
      # http://localhost:7001/eureka/
```

- 启动类使用`@EnableEurekaServer`注解开启Eureka

```java
@SpringBootApplication
//开启注册中心
//注册中心监控地址：http://localhost:7001/
@EnableEurekaServer
public class App7001 {
    public static void main(String[] args) {
        SpringApplication.run(App7001.class,args);
    }
}
```

#### 改写springcloud-provider-dept-8001子模块，作为服务提供者

- 添加依赖

```xml
<!--eureka,注册到服务中心-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

- 添加配置

```yml
#Eureka的配置
eureka:
  client:
    service-url:
      #注册中心地址
      defaultZone: http://localhost:7001/eureka/
  instance:
    instance-id: springcloud-provider-dept-8001   #修改erueka上的默认描述信息
```

- 开启Eureka

```java
@SpringBootApplication
@MapperScan("com.jc.mapper")
@EnableEurekaClient
public class App8001 {
    public static void main(String[] args) {
        SpringApplication.run(App8001.class,args);
    }
}
```

- 再次访问注册中心`http://localhost:7001/`，可以看到8001提供的服务

#### 微服务配置

![Eureka监控页](D:\Study\Learning-record\SpringCloud\Eureka监控页.png)

```yml
# 服务名称也就是我们boot项目的名称
spring:
  application:
    name: server8001
```

> 在8001子模块配置status描述页

描述页面默认是没有的，我们可以通过此页面返回json信息，介绍服务作用

- 添加依赖

```xml
<!--完善监控信息-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

- 添加配置

```yml
# info配置
info:
  app.name: springcloud-provider-dept-8001
  company.name: www.jc.com
  build.artifactId: @project.artifactId@
  build.version: @project.version@
  
# 由于版本问题，info接口可能不能访问，手动暴露所有接口
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

- 若info信息为空，可能是打包时没有被包含进来，手动配置一下pom的build

```xml
<!--监控信息导出过滤-->
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>build-info</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

- 使用插件手动打包info，再手动放入以下路径

  `resources\META-INF\build-info.properties`

![Eureka-info](D:\Study\Learning-record\SpringCloud\Eureka-info.png)

- 再次访问status描述页，可以看到我们填写的服务信息

![Eureka服务信息](D:\Study\Learning-record\SpringCloud\Eureka服务信息.png)

### Discovery服务发现

status描述页能够简单地描述服务信息，但是描述的信息比较有限

对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息

在团队开发中比较常见

- 添加一个方法，返回服务信息

```java
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Autowired
DiscoveryClient client;

@GetMapping("/discovery")
public Object discovery(){
    //获得微服务列表清单
    List<String> list = client.getServices();
    System.out.println("client.getServices()==>"+list);
    //得到一个具体的微服务！
    List<ServiceInstance> serviceInstanceList =
        client.getInstances("springcloud-provider-dept");
    for (ServiceInstance serviceInstance : serviceInstanceList) {
        System.out.println(
            serviceInstance.getServiceId()+"\t"+
            serviceInstance.getHost()+"\t"+
            serviceInstance.getPort()+"\t"+
            serviceInstance.getUri()
        );
    }
    return this.client;
}
```

- 在启动类添加`@EnableDiscoveryClient`注解，开启服务发现
- 访问测试 http://localhost:8001/dept/discovery

### Eureka集群

> 添加windows域名映射

路径：`C:\Windows\System32\drivers\etc\host`

```
127.0.0.1       eureka7001.com
127.0.0.1       eureka7002.com
127.0.0.1       eureka7003.com
```

- 新建子模块`springcloud-eureka-7002`、`springcloud-eureka-7003`，pom文件与`springcloud-eureka-7001`一致，作为两个新的注册中心

> 在配置文件中做集群关联，每一个注册中心都要与另外的注册中心进行关联，以`springcloud-eureka-7001`的配置文件为例，7002和7003的配置文件也相似

- 7001

```yml
server:
  port: 7001

#Eureka配置
eureka:
  instance:
    hostname: eureka7001.com  #Eureka服务端的实例名称
  client:
    register-with-eureka: false  #表示是否向eureka注册中心注册自己，此模块就是作为注册中心的，所以不注册
    fetch-registry: false  #如果为false，则表示自己为注册中心，等别人过来连就好了
    service-url:  #监控页面
      #单机
      #defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
      #多个地址使用逗号分隔
      defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
      # 设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个defaultZone地址
      # http://localhost:7001/eureka/
```

> 服务提供者的配置文件里，需要罗列所有的注册中心地址

- 8001

```yml
#Eureka的配置
eureka:
  client:
    service-url:
      #注册中心地址
      #只需要填写一个注册中心的地址即可，当然如果是为了保险，可以填上多个注册中心地址，使用逗号进行分隔
      defaultZone: http://eureka7001.com:7001/eureka/
  instance:
    hostname: localhost
    instance-id: springcloud-provider-dept-8001   #修改erueka上的默认描述信息
```

访问：http://eureka7001.com:7001/，可以看到我们部署的Eureka集群

![Eureka集群](D:\Study\Learning-record\SpringCloud\Eureka集群.png)

## Ribbon负载均衡

### Ribbon是什么

Spring Cloud Ribbon是基于Netflix Ribbon实现的一套**客户端负载均衡**的工具。

简单的说，Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件**负载均衡算法**，将NetFlix的中间层服务连接在一起。Ribbon的客户端组件提供一系列完整的配置项如：连接超时、重试等等。简单的说，就是在配置文件中列出LoadBalancer（简称LB：负载均衡）后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随机连接等等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法！

### Ribbon能干嘛？

LB，即负载均衡（Load Balance），在微服务或分布式集群中经常用的一种应用。

负载均衡简单的说就是**将用户的请求平摊的分配到多个服务上**，从而达到系统的HA（**高可用**）。常见的负载均衡软件有 Nginx，Lvs 等等

Dubbo、SpringCloud中均给我们提供了负载均衡，SpringCloud的负载均衡算法可以自定义负载均衡简单分类：

- 集中式LB
  - 即在服务的消费方和提供方之间使用独立的LB设施
  - 如之前学习的Nginx，由该设施负责把访问请求通过某种策略转发至服务的提供方！
- 进程式LB
  - 将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选出一个合适的服务器。
  - **Ribbon就属于进程内LB**，它只是一个类库，集成于消费方进程，消费方通过它来获取到服务提供方的地址！

Ribbon的github地址 ： https://github.com/NetFlix/ribbon

### Ribbon简单使用

- 参考`springcloud-customer-dept-80`子模块创建`springcloud-customer-dept-ribbon-80`子模块

- pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>springcloud-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!--eureka-client默认集成Ribbon-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
</dependencies>
```

- 配置文件

```yml
server:
  port: 80

#Eureka的配置
eureka:
  client:
    register-with-eureka: false  #不向eureka注册自己
    service-url:
      #注册中心地址
      defaultZone: http://eureka7003.com:7003/eureka/,http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
```

- 使用`@LoadBalanced`注解开启负载均衡

```java
@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

- 对url地址前缀进行改写，使用服务名称来进行访问

```java
//提供服务的地址
//private static final String REST_URL_PREFIX="http://localhost:8001";
//使用服务名称来进行访问
private static final String REST_URL_PREFIX="http://server8001";
```

- 在启动类使用`@EnableEurekaClient`来开启Eureka

- 测试：http://localhost/consumer/dept/list

### 负载均衡的实现

![Ribbon负载均衡](D:\Study\Learning-record\SpringCloud\Ribbon负载均衡.jpg)

- 添加子模块`springcloud-provider-dept-8002`和`springcloud-provider-dept-8003`，模拟服务提供者


- 导入依赖：我们这里测试不连接数据库，所以仅用以下依赖即可

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    <!--eureka,注册到服务中心-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
</dependencies>
```

- 添加Eureka配置

```yml
#三个服务提供者对外暴露的应用名需要一致，因为Ribbon是根据应用名来查找调用服务的
spring:
  application:
    name: server-provide

#Eureka的配置
eureka:
  client:
    service-url:
      #注册中心地址
      defaultZone: http://eureka7001.com:7001/eureka/
  instance:
    hostname: localhost
    instance-id: springcloud-provider-dept-8001   #修改erueka上的默认描述信息
```

- 为三个提供者创建相同路径的Controller，提供服务，返回字符串，用于区分服务器

```java
@RestController
public class RibbonController {
    @RequestMapping("/ribbon/test")
    public String ribbonTest(){
        return "8001为你提供服务";
    }
}
```

- 修改`springcloud-customer-dept-ribbon-80`模块的Controller，修改访问地址为服务名，添加访问接口

```java
@RestController
public class CustomerController {
    //提供服务的地址
    //private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX="http://server-provide";

    @RequestMapping("/get/provide")
    public String getProvider(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/ribbon/test",String.class);
    }
}
```

- 添加主启动类，使用`@EnableEurekaClient`注解开启Eureka
- 测试
  1. 启动注册中心集群
  2. 启动三个微服务
  3. 启动客户端
  4. 访问：http://localhost/get/provide，==使用Ribbon之后，不用再关心端口号==

总结：通过访问同样的地址，我们得到了3个服务器返回的不同的字符串，而且是有规律的`8001-8002-8003-8001...`，这正是Ribbon负载均衡的默认访问机制，**轮询**，轮流访问每一台服务器。

### 修改负载均衡的机制

> Ribbon的负载均衡算法

- **RoundRobinRule**：轮询
- **RandomRule**：随机访问
- **AvailabilityFilterRule**：会先过滤掉由于多次访问故障而处于断路器跳闸的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
- **WeightedResponseTimeRule**：根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大，被选中的概率越高，刚启动时如果统计信息不足，则使用RoundRobinRule策略，等待统计信息足够，会切换到WeightedResponseTimeRule
- **RetryRule**：先按照RoundRobinRule的策略获取服务，如果获取服务失败，则在指定时间内会进行重试，获取可用的服务
- **BestAvailableRule**：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
- **ZoneAvoidanceRule**：默认规则，复合判断server所在区域的性能和server的可用性选择服务器

> 修改它的机制

只需要注册一个Bean来指定它的算法即可

==最新版SpringCloud将它弃用，改用spring-cloud-starter-loadbalancer，可以平滑过渡==

```java
@Configuration
public class RuleConfig {
    @Bean
    public IRule rule(){
        //改为随机访问
        return new RandomRule();
    }
}
```

## Feign负载均衡

### Feign是什么

feign是声明式的web service客户端，它让微服务之间的调用变得更简单了，类似controller调用service。

Spring Cloud集成了Ribbon和Eureka，可在使用Feign时提供负载均衡的http客户端。

**只需要创建一个接口，然后添加注解即可！**

feign ，主要是社区，大家都习惯面向接口编程。这个是很多开发人员的规范。调用微服务访问两种方法

- 微服务名字 【ribbon】
- 接口和注解 【feign 】

利用Ribbon维护了springcloud-Dept的服务列表信息，并且通过**轮询实现了客户端的负载均衡**，而与Ribbon不同的是，通过Feign**只需要定义服务绑定接口且以声明式的方法**，优雅而且简单的实现了服务调用。

### Feign能干什么

Feign旨在使编写Java Http客户端变得更容易

前面在使用Ribbon + RestTemplate时，利用RestTemplate对Http请求的封装处理，形成了一套模板化的调用方法。但是在实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。所以，Feign在此基础上做了进一步封装，由他来帮助我们定义和实现依赖服务接口的定义

在Feign的实现下，我们**只需要创建一个接口并使用注解的方式来配置它**（类似于以前Dao接口上标注Mapper注解，现在是一个微服务接口上面标注一个Feign注解即可。）即可完成对服务提供方的接口绑定，简化了使用Spring Cloud Ribbon时，自动封装服务调用客户端的开发量。

### Feign简单使用

- 参考`springcloud-customer-dept-ribbon-80`子模块创建`springcloud-customer-dept-feign-80`子模块

- 导入依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>springcloud-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!--eureka-client默认集成Ribbon-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
        <!--Feign相关-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-feign</artifactId>
      <version>1.4.7.RELEASE</version>
    </dependency>
</dependencies>
```

- 配置文件

```yml
server:
  port: 80

#Eureka的配置
eureka:
  client:
    register-with-eureka: false  #不向eureka注册自己
    service-url:
      #注册中心地址
      defaultZone: http://eureka7003.com:7003/eureka/,http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
```

- 创建服务层接口，用于绑定服务

```java
//value:指定微服务的名字,这样就可以使Feign客户端直接找到对应的微服务
@FeignClient(value = "SERVER-PROVIDE")
public interface DeptClineService {
    //填写服务提供的地址
    @GetMapping("/ribbon/test")
    String getProvider();
}
```

- Controller

```java
@RestController
public class CustomerController {
  
    @Autowired
    DeptClineService service;

    @RequestMapping("/get/provide")
    public String getProvider(){
        return service.getProvider();
    }
}
```

- 编写主启动类

```java
@SpringBootApplication
@EnableEurekaClient
//扫描服务接口的包
@EnableFeignClients(basePackages = {"com.jc.service"})
public class App80FE {
    public static void main(String[] args) {
        SpringApplication.run(App80FE.class,args);
    }
}
```

总结：通过Feign直接找到服务接口，由于在进行服务调用的时候融合了Ribbon技术，所以也支持负载均衡作用！
Feign其实不是做负载均衡的,负载均衡是Ribbon的功能，Feign只是集成了Ribbon而已，但是负载均衡的功能还是Feign内置的Ribbon再做,而不是Feign。

==Feign的作用的替代RestTemplate，性能比较低，但是可以使代码可读性很强。==

## Feign和Ribbon的区别

> Ribbon

Ribbon是一个基于HTTP和TCP客户端的负载均衡器它可以在客户端配置 RibbonServerList（服务端列表），然后轮询请求以实现均衡负载它在联合 Eureka使用时RibbonServerList会被DiscoveryEnabledNIWSServerList重写，扩展成从Eureka注册中心获取服务端列表同时它也会用NIWSDiscoveryPing来取代IPing，它将职责委托给Eureka来确定服务端是否已经启动。 使用HttpClient或RestTemplate模拟http请求，步骤相当繁琐。

> Feign

在Ribbon的基础上进行了一次改进，是一个使用起来更加方便的 HTTP 客户端。采用接口的方式， 只需要创建一个接口，面向接口；然后在上面添加注解即可 ，将需要调用的其他服务的方法定义成抽象方法即可， 不需要自己构建http请求。然后就像是调用自身工程的方法调用，而感觉不到是调用远程方法，使得编写 客户端变得非常容易。

## Hystrix断路器-服务熔断

### 服务雪崩

如下图，分布式的多个服务在部署时，存在调用关系。如果此时有大量请求传入，服务O承受不住，导致宕机无法提供服务，那么就会连锁引起服务J、服务D、服务A的阻塞现象，所有的请求都会堆积，这种现象就是**服务雪崩**。

而**服务熔断**和**服务降级**就是解决**服务雪崩**的手段之一。

![服务雪崩](D:\Study\Learning-record\SpringCloud\服务雪崩.jpg)

### 服务熔断

>  熔断机制是对应雪崩效应的一种微服务链路保护机制。

当扇出链路的某个微服务不可用或者响应时间太长时，**会进行服务的降级，进而熔断该节点微服务的调用**，快速返回 错误的响应信息。**当检测到该节点微服务调用响应正常后恢复调用链路**。在SpringCloud框架里熔断机制通过Hystrix实现。Hystrix会监控微服务间调用的状况，当失败的调用到一定阈值，缺省是**5秒内20次**调用失败就会启动熔断机制。

服务熔断可以解决的问题：

- 当所依赖的对象不稳定时，能够起到快速失败的目的；
- 快速失败后，能够根据一定的算法动态试探所依赖对象是否恢复。

#### 简单实现

- 参考`springcloud-provider-dept-8001`子模块创建`springcloud-provider-dept-hystrix-8001`子模块
- 添加依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>springcloud-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    <!--mysql-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <!--druid数据库连接池-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
    </dependency>
    <!--mybatis-plus-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <!--eureka,注册到服务中心-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <!--Hystrix-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        <version>2.2.10.RELEASE</version>
    </dependency>
</dependencies>
```

- 配置文件

```yml
#Eureka的配置
eureka:
  client:
    service-url:
      #注册中心地址
      defaultZone: http://eureka7001.com:7001/eureka/
  instance:
    hostname: localhost
    instance-id: springcloud-provide-dept-hystric-8001   #修改erueka上的默认描述信息
    prefer-ip-address: true  #改为true默认显示的是ip地址，而不是Localhost
```

![prefer-ip-address true](D:\Study\Learning-record\SpringCloud\prefer-ip-address true.png)

- 编写Controller

```java
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService service;
    /**
     * 根据id查询部门信息
     * HystrixCommand：一旦调用该方法发生异常后，就执行hystrixGet方法中的代码
     * @Param:id
     */
    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/get/{id}")//根据id查询
    public Dept queryById(@PathVariable("id") Long id){
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.eq("deptno",id);
        Dept dept = service.getOne(wrapper);
        if(dept==null){
            throw new RuntimeException("该id："+id+"没有对应的的信息");
        }
        return dept;
    }
    /**
     * 根据id查询备选方案（熔断）
     * @Param:id
     * @return
     * */
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("这个id=>"+id+",没有对应的信息,null---@Hystrix~").setDb_source("在Mysql中没有这个数据库");
    }
}
```

- 主启动类通过`@EnableHystrix`注解开启服务熔断

```java
@SpringBootApplication
@MapperScan("com.jc.mapper")
@EnableEurekaClient
//开启熔断
@EnableHystrix
public class App8001HY {
    public static void main(String[] args) {
        SpringApplication.run(App8001HY.class,args);
    }
}
```

- 测试
  1. 启动注册中心集群
  2. 启动`springcloud-provider-dept-hystrix-8001`微服务
  3. 访问：http://localhost:8001/dept/get/1，我们发现，如果调用发生异常，会执行`hystrixGet`函数，服务不会中断

### 服务降级

> 整体资源快不够了，忍痛先将某些服务关闭，等度过难关，再开启回来

服务降级是指当服务器压力剧增的情况下，根据实际业务情况及流量，对一些服务和页面有策略的不处理，或换种简单的方式处理，从而释放服务器资源以保证核心业务正常运作或高效运作。说白了，就是**尽可能的把系统资源让给优先级高的服务**。

资源有限，而请求是无限的。如果在并发高峰期，不做服务降级处理，一方面肯定会影响整体服务的性能，严重的话可能会导致宕机某些重要的服务不可用。所以，**一般在高峰期，为了保证核心功能服务的可用性，都要对某些服务降级处理**。比如当双11活动时，把交易无关的服务统统降级，如查看蚂蚁深林，查看历史订单等等。

服务降级主要用于什么场景呢？当整个微服务架构整体的负载超出了预设的上限阈值或即将到来的流量预计将会超过预设的阈值时，为了保证重要或基本的服务能正常运行，可以将一些 不重要或不紧急的服务或任务进行服务的延迟使用或暂停使用。

降级的方式可以根据业务来，可以延迟服务，比如延迟给用户增加积分，只是放到一个缓存中，等服务平稳之后再执行 ；或者在粒度范围内关闭服务，比如关闭相关文章的推荐。

#### 服务降级需要考虑的问题

- 哪些服务是核心服务，哪些服务是非核心服务
- 哪些服务可以支持降级，那些服务不能支持降级，降级策略是什么？
- 除服务降级之外是否存在更复杂的业务放通场景，策略是什么？

#### 自动降级分类

1. 超时降级：主要配置好超时时间和超时重试次数和机制，并使用异步机制探测回复情况

2. 失败次数降级：主要是一些不稳定的api，当失败调用次数达到一定阀值自动降级，同样要使用异步机制探测回复情况

3. 故障降级：比如要调用的远程服务挂掉了（网络故障、DNS故障、http服务返回错误的状态码、rpc服务抛出异常），则可以直接降级。降级后的处理方案有：默认值（比如库存服务挂了，返回默认现货）、兜底数据（比如广告挂了，返回提前准备好的一些静态页面）、缓存（之前暂存的一些缓存数据）

4. 限流降级：秒杀或者抢购一些限购商品时，此时可能会因为访问量太大而导致系统崩溃，此时会使用限流来进行限制访问量，当达到限流阀值，后续请求会被降级；降级后的处理方案可以是：排队页面（将用户导流到排队页面等一会重试）、无货（直接告知用户没货了）、错误页（如活动太火爆了，稍后重试）。

#### 简单实现

- 修改`springcloud-customer-dept-feign-80`模块，根据已经有的DeptClineService接口新建一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory

```java
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClineService> {
    @Override
    public DeptClineService create(Throwable cause) {
        return new DeptClineService() {
            @Override
            public String getProvider() {
                return "该服务已被关闭";
            }
        };
    }
}
```

- 给DeptClineService接口添加注解，指定降级后批量处理类

```java
@FeignClient(value = "SERVER-PROVIDE",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClineService {
    //填写服务提供的地址
    @GetMapping("/ribbon/test")
    String getProvider();
}
```

- 配置文件开启降级

```yml
feign:
  circuitbreaker:
    enabled: true
```

- 主启动类，使用`@EnableHystrix`开启熔断
- 测试
  - 访问：http://localhost/get/provide，看到正常的返回结果
  - 关闭服务端，再次访问，则返回预处理信息

###  小结

**服务熔断=>服务端**：一般是某个服务故障或者异常引起，类似现实世界中的 “保险丝” ， 当某个异常条件被触发，直接熔断整个服务，而不是一直等到此服务超时！
**服务降级=>客户端**：所谓降级，一般是从整体负荷考虑，就是当某个服务熔断之后，服务器将不再被调用，此时客户端可以自己准备一个本地的fallback回调，返回一个缺省值。这样做，虽然服务水平下降，但好歹可用，比直接挂掉要强。

> 触发原因不太一样

服务熔断一般是某个服务（下游服务）故障引起，而服务降级一般是从整体负荷考虑；管理目标的层次不太一样，熔断其实是一个框架级的处理，每个微服务都需要（无层级之分），而降级一般需要对业务有层级之分（比如降级一般是从最外围服务开始）

> 实现方式不太一样

服务降级具有代码侵入性(由控制器完成/或自动降级)，熔断一般称为自我熔断。

> 熔断，降级，限流

- 熔断：依赖的下游服务器故障触发熔断，避免引发本地系统崩溃，系统自动执行和恢复
- 降级：服务分优先级，牺牲非核心业务，保证核心服务稳定，从整体符合考虑
- 限流：限制并发的请求访问量，超过阈值则拒绝

### 服务监控

除了隔离依赖服务的调用以外，Hystrix还提供了准实时的调用监控（Hystrix Dashboard），Hystrix会持续地**记录所有通过Hystrix发起的请求的执行信息**，并以统计报表和图形的形式展示给用户，包括每秒执行多少请求，多少成功，多少失败等等。

Netflix通过hystrix-metrics-event-stream项目实现了对以上指标的监控SpringCloud也提供了HystrixDashboard的整合，对监控内容转化成可视化界面！

#### 简单使用

- 给客户端添加依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    <version>2.2.10.RELEASE</version>
</dependency>
```

- 给服务端添加依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

- 客户端主启动类，使用`@EnableHystrixDashboard`注解开启监控功能

- 将下面这个Bean注入到每一个服务端的Spring容器里

```java
//增加一个Servlet
@Bean
public ServletRegistrationBean hystrixMetricsStreamServlet() {
    ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
    //访问该页面就是监控页面
    registration.addUrlMappings("/actuator/hystrix.stream");
    return registration;
}
```

- 服务端配置

```yml
#暴露全部的监控信息
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

- 客户端配置

```yml
hystrix:
  dashboard:
    proxy-stream-allow-list: "*"
```

- 看到如下页面，配置成功

![HystrixDashboard](D:\Study\Learning-record\SpringCloud\HystrixDashboard.png)

- 填写需要监控的地址：http://localhost:8001/actuator/hystrix.stream

- 流量统计图

![Hystrix监控统计图](D:\Study\Learning-record\SpringCloud\Hystrix监控统计图.png)

## Zuul路由网关

### Zuul是什么

Zuul包含了**对请求的路由和过滤**两个最主要的功能：

其中**路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础，而过滤器功能则负责对请求的处理过程进行干预，是实现请求校验，服务聚合等功能的基础**。Zuul和Eureka进行整合，将Zuul自身注册为Eureka服务治理下的应用，同时从Eureka中获得其他微服务的消息，也即以后的访问微服务都是通过Zuul跳转后获得。

**注意**：Zuul服务最终还是会注册进Eureka

**提供**：代理 + 路由 + 过滤 三大功能！

### 简单使用

- 新建子模块
- 导入依赖

```xml
<dependencies>
    <!--Hystrix-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        <version>2.2.10.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        <version>2.2.10.RELEASE</version>
    </dependency>
    <!--实体类和web-->
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>springcloud-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    <!--集成Ribbon-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        <version>2.2.10.RELEASE</version>
    </dependency>
</dependencies>
```

- 配置文件

```yml
server:
  port: 9527

#spring相关配置
spring:
  application:
    name: springcloud-zuul

#erueka配置
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
```

- 添加域名映射

```
127.0.0.1       www.jc.com
```

- 主启动类使用`@EnableZuulProxy`开启Zuul
- 测试
  1. 启动注册中心
  2. 启动服务模块`springcloud-provider-dept-hystrix-8001`
  3. 启动zuul模块

==高版本已不支持Zuul，现在API网关使用gateway==getForObject
