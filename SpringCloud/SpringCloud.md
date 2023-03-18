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

## 项目构建

### 创建父工程

- pom

```xml
<!--使用pom方式进行打包-->
<packaging>pom</packaging>
<!--统一管理版本依赖-->
<properties>
    <java.version>1.8</java.version>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <junit.version>4.12</junit.version>
    <lombok.version>1.16.18</lombok.version>
    <log4j.version>1.2.17</log4j.version>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
</properties>
<!--依赖管理器可以使子模块依赖按需引入-->
<dependencyManagement>
    <dependencies>
        <!--springboot-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--springcloud-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>2021.0.1</version>
        </dependency>
        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!--druid数据库连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.16</version>
        </dependency>
        <!--mybatis-plus-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.4.1</version>
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

- pom

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

- pom

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

- pom

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

