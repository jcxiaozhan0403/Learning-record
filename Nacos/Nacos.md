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

通常，作为服务消费者，还需要监听服务实例化的变化，我们可以使⽤如下api来监听变化

```java
NamingService naming = NamingFactory.createNamingService("localhost:8848");
naming.subscribe("app1", event -> {
    if (event instanceof NamingEvent) {
        System.out.println(((NamingEvent) event).getServiceName());
        System.out.println(((NamingEvent) event).getInstances());
    }
});
```

### SpringCloud服务注册与发现

> 导入依赖

```xml
<!--2021.0.5.0 对应 springboot 2.6.7 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    <version>2021.0.5.0</version>
</dependency>
```

> 服务提供者

```properties
server.port=8070
spring.application.name=service-provider
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```

```java
@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {
    public static void main(String[] args) throws IOException {
    	SpringApplication.run(UserApplication.class, args);
    }
}
```

> 服务消费者

```properties
server.port=8080
spring.application.name=service-consumer
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```

```java
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
    
    //注入一个restTemplate用于服务调用
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }

    public static void main(String[] args) {
    	SpringApplication.run(ConsumerApplication.class, args);
    }
}
```

```java
@RestController
public class ConsumerController {
     @Autowired
     private RestTemplate restTemplate;
     @GetMapping(value = "/test")
     public String echo() {
         return restTemplate.getForObject("http://service-provider/test", String.class);
     }
}
```

## 高级配置

### 临时实例与持久实例

默认情况下，注册给nacos的实例都是临时实例，临时实例表示会通过客户端与服务端之间的⼼跳来保活，默认情况下，客户端会每隔5s发送⼀次心跳。

在服务端测，如果超过`15s`没有收到客户端的⼼跳，那么就会`把实例标记为不健康状态`

在服务端测，如果超过`30s`没有收到客户端的⼼跳，那么就会`删除实例`

默认情况下，生成的实例为临时实例，我们可以通过以下配置来配置为**持久实例**

```properties
spring.cloud.nacos.discovery.ephemeral=false
```

对于持久实例，就算服务实例下线了，那么也不会被删除，我们依然可以在nacos中查看到一些它的相关信息

### 保护阈值

在使用过程中，我们可以设置一个0-1的一个比例，表示如果服务的所有实例中，健康实例的比重低于这个比重就会触发保护，一旦触发保护，在服务消费端侧就会把所有实例拉取下来，不管是否健康，这样 就起到了保护的作用，因为正常来说消费端只会拿到健康实例，但是如果健康实例占总实例比例比较小了，那么就会导致所有流量都会压到健康实例上，这样仅剩的几个健康实例也会被压垮，所以只要触发 了保护，消费端就会拉取到所有实例，这样部分消费端仍然会访问到不健康的实例从而请求失败，但是也有⼀部分请求能访问到健康实例，达到保护的作用。

保护阈值的设置范围为`0-1`，表示比例，比如设置为0.4，就表示如果仅剩余40%的实例存活，就开启保护

###  权重

权重就是增加实例被访问到的概率，默认情况下，权重不会生效，我们需要重新负载均衡策略，使用Nacos提供的策略来覆盖掉默认策略即可

```java
@Bean
public IRule ribbonRule() {
	return new NacosRule();
}
```

### 就近访问

消费者在访问服务提供者的时候指定集群，可以完成就近访问，如果消费端没有配置cluster-name，那么则会使⽤所有集群

```properties
spring.cloud.nacos.discovery.cluster-name=bj
```

## 集群

在部署集群的时候，每一个nacos文件夹就代表了一个集群节点，我们需要修改`conf/cluster.conf`文件，配置所有节点的地址和端口

```conf
192.168.65.46:8848
192.168.65.46:8858
192.168.65.46:8868
```

分别修改每个节点的配置文件，配置正确的端口号

```properties
server.port=8848
```

```properties
server.port=8858
```

```properties
server.port=8868
```

服务同时向三个节点进行注册

这里官方推荐使用Nginx反向代理，配置统一地址，参考：https://www.bilibili.com/video/BV1q3411Z79z?p=23&vd_source=d6cbedbb3e249eafa593fdc79241d0c5

```properties
spring.cloud.nacos.discovery.server-addr=192.168.65.46:8848, 192.168.65.46:8858, 192.168.65.46:8858
```

启动

```cmd
startup.cmd -p embedded
```

