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

## Eureka服务注册与发现

### CAP原则

CAP原则又称CAP定理，指的是在一个分布式系统中

- 一致性（Consistency）
- 可用性（Availability）
- 分区容错性（Partition tolerance）

三者不可兼得

==Eureka遵循AP原则，Zookeeper遵循CP原则==

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
