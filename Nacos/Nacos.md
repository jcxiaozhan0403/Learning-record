## 启动

单机模式启动

```
startup.cmd -m standalone
```

访问地址

```
http://localhost:8848/nacos
```

## 配置管理

### 原生SDK

maven项目导入依赖

```xml
<dependency>
    <groupId>com.alibaba.nacos</groupId>
    <artifactId>nacos-client</artifactId>
    <version>2.2.4</version>
</dependency>
```

> 拉取配置

在服务端创建配置之后，可以在程序中使用代码拉取配置

```java
try {
	String serverAddr = "localhost:8848";
	String dataId = "test";
	String group = "DEFAULT_GROUP";
	Properties properties = new Properties();
	properties.put("serverAddr", serverAddr);
	ConfigService configService = NacosFactory.createConfigService(properties);
	String content = configService.getConfig(dataId, group, 5000);
	System.out.println(content);
} catch (NacosException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

> 监听配置

```java
//监听配置
configService.addListener(dataId, group, new Listener() {
    @Override
    public void receiveConfigInfo(String configInfo) {
        System.out.println("recieve1:" + configInfo);
    }
    @Override
    public Executor getExecutor() {
        return null;
    }
});

//程序阻塞
System.in.read();
```

### Spring

> 导入依赖

```xml
<dependency>
    <groupId>com.alibaba.nacos</groupId>
    <artifactId>nacos-spring-context</artifactId>
    <version>1.1.1</version>
</dependency>
```

> 编写配置类

```java
@ComponentScan("com.*")
@Configuration
//开启Nacos
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
@NacosPropertySource(dataId = "test",autoRefreshed = true)
public class AppConfig {

    @Bean
    public User myBean() {
        return new User();
    }
}
```

> 测试

```java
@Component
public class User {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    public void test(){
        System.out.println(this.name + " " + this.age);
    }
}
```

```java
public class ApplicationContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 可以在这里使用从容器中获取的Bean
        User user = (User) context.getBean("myBean");
        user.test();
        context.close();
    }
}
```

### SpringBoot

> 引入依赖

```xml
<dependency>
    <groupId>com.alibaba.boot</groupId>
    <artifactId>nacos-config-spring-boot-starter</artifactId>
    <version>0.2.2</version>
</dependency>
```

> 开启配置

- 方式一：注解开启

```java
@NacosProperties(serverAddr = "127.0.0.1:8848"))
@NacosPropertySource(dataId = "test",autoRefreshed = true)
```

- 方式二：配置文件开启

```properties
nacos.config.server-addr=127.0.0.1:8848
nacos.config.data-id=test
nacos.config.auto-refresh=true
nacos.config.bootstrap.enable=true
spring.main.allow-bean-definition-overriding=true
```

> 测试

```java
@RestController
public class HelloController {
    @NacosValue(value = "${name}",autoRefreshed = true)
    private String name;


    @RequestMapping("/test")
    public String test(){
        return name;
    }
}
```

### SpringCloud

> 引入依赖

```xml
<!--2021.0.5.0 对应 springboot 2.6.7 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
    <version>2021.0.5.0</version>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
    <version>3.0.3</version>
</dependency>
```

> 配置文件

- bootstrap.properties

```properties
spring.application.name=test
spring.cloud.nacos.server-addr=127.0.0.1:8848
```

> 测试

```java
@RestController
@RefreshScope //注解开启自动刷新
public class HelloController {
    @Value("${name}")
    private String name;


    @RequestMapping("/test")
    public String test(){
        return name;
    }
}
```

> 实际开发中的通用解决思路

将配置项单独提取出来，写入一个统一配置类进行管理，提供get方法来获取这些值

```java
@Component
@RefreshScope
public class CommonConfig {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int nage;

    public String getName() {
        return name;
    }

    public int getNage() {
        return nage;
    }
}
```

### profile

在使⽤spring-cloud-starter-alibaba-nacos-config时，我们除开可以配置 spring.cloud.nacos.config.server-addr外，还可以配置：

1. spring.cloud.nacos.config.group：默认为"DEFAULT_GROUP"
2. spring.cloud.nacos.config.file-extension：默认为"properties"
3. spring.cloud.nacos.config.prefix：默认为${spring.application.name}

在拉取配置的时候，优先级如下：依次升高

1. 拉取dataid为user的配置
2. 拉取dataid为user.properties的配置
3. 拉取dataid为user-${spring.profiles.active}.properties的配置

spring.profiles.active值可以直接写在本地配置文件中，更多的时候是写在启动命令中`-Dspring.profiles.active=dev`

### 多配置拉取

在一个项目中可以从Nacos拉取多个配置文件

```properties
spring.cloud.nacos.config.extension-configs[0].data-id=datasource.properties
spring.cloud.nacos.config.shared-configs[0].data-id=common.properties
```

区别：

- extension-configs表示本应用特有的
- shared-configs表示多个应用共享的

优先级：

- extension-configs[2] > extension-configs[1] > extension-configs[0]
- shared-configs[2] > shared-configs[1] > shared-configs[0]
- 主配置 > extension-configs > shared-configs

### 配置自动刷新

默认情况下，主配置会自动刷新**，extension-configs**和**shared-configs**不会自动刷新，可以通过`spring.cloud.nacos.config.refresh-enabled=true`来开启主配置的自动刷新。 自动配置的意思是，一旦应用中引入的配置发生了变化，应用端也能及时获取到最新值。 值得注意的是，尽管默认情况下会自动刷新，但是对于通过@Value的使用方式，还需要在该Bean上加上`@RefreshScope`注解，这样才能动态的修改`@Value`属性，达到动态更新的最终效果。

## 服务管理

### 服务注册

> 原生SDK

```java
//服务名：app1
//访问该服务的地址：11.11.11.11:8888
NamingService naming = NamingFactory.createNamingService("localhost:8848");
naming.registerInstance("app1", "11.11.11.11", 8888);
```

- 一个服务有三个实例，分别属于两个虚拟集群

```java
NamingService naming = NamingFactory.createNamingService("localhost:8848")
;
naming.registerInstance("app1", "11.11.11.11", 8888, "cluster1");
NamingService naming1 = NamingFactory.createNamingService("localhost:8848"
);
naming1.registerInstance("app1", "11.11.11.12", 8888, "cluster1");
NamingService naming2 = NamingFactory.createNamingService("localhost:8848"
);
naming2.registerInstance("app1", "11.11.11.13", 8888, "cluster2");
System.in.read();
```

### 服务发现

服务注册之后，服务消费者就可以来使⽤了，我们可以使⽤如下api来获取某个服务的所有实例信息

```java
NamingService naming = NamingFactory.createNamingService("localhost:8848");
System.out.println(naming.getAllInstances("app1"));
```

也可以获取所有健康的实例

```java
naming.selectInstances("app1", true)
```

直接获取某一个健康的实例（权重随机算法）

```java
naming.selectOneHealthyInstance("app1")
```

