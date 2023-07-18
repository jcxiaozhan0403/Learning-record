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



