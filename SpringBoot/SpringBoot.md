## 原理初探
pom.xml
- spring-boot-dependencies 核心依赖在父工程中
我们在引入一些SpringBoot依赖的时候，不需要指定版本，是因为有这些版本仓库

启动器：就是SpringBoot内置的一些启动场景，可以理解为是多个依赖包的一个封装，引入一个启动器就相当于一次引入了多个依赖包

## 自动配置原理
- SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值
- 将这些值作为自动配置类导入容器，自动配置类就生效，帮我们进行自动配置工作；
- 整个J2EE的整体解决方案和自动配置都在springboot-autoconfigure的jar包中；
- 它会给容器中导入非常多的自动配置类（xxxAutoConfiguration），就是给容器中导入这个场景需要的所有组件，并配置好这些组件；
- 有了自动配置类，免去了我们手动编写配置注入功能组件等的工作；

### 精髓
1. SpringBoot启动会加载大量的自动配置类
2. 我们看我们需要的功能有没有在SpringBoot默认写好的自动配置类当中；
3. 我们再来看这个自动配置类中到底配置了哪些组件；（只要我们要用的组件存在在其中，我们就不需要再手动配置了）
4. 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们只需要在配置文件中指定这些属性的值即可；

xxxxAutoConfigurartion：自动配置类；给容器中添加组件
xxxxProperties:封装配置文件中相关属性；

### 配置类生效
自动配置类必须在一定的条件下才能生效；依靠@Conditional派生注解来控制，必须是@Conditional指定的条件成立，才给容器中添加组件，配置配里面的所有内容才生效

<img src="./Conditional注解.jpg">

我们可以通过启用 debug=true属性；来让控制台打印自动配置报告，这样我们就可以很方便的知道哪些自动配置类生效
```properties
#开启springboot的调试类
debug=true
```

## 配置文件语法
- properties文件
```properties
key=value
```
- yml文件
```yml
key: value

# 对象
student01:
  name: 李爽
  age: 20

# 行内写法
student02: {name: 张三,age: 22}

# 数组
list01:
  - dog
  - cat
  - dark

# 行内写法
list02: [dog,pig,cat]
```

## 通过配置文件注入值
- User.java
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private String name;
    private int age;
    private Date birthday;
    private String[] likes;
    private Map<String,Object> maps;
    private List<Object> lists;
}
```
- application.yml
```yml
user1:
  name: 李爽
  age: 18
  birthday: 2001/4/3
  likes:
    - 乒乓
    - 唱歌
    - 编程
  maps: {k1: v1,k2: v2}
  lists:
    - list1
    - list2
    - list3
```

## 从指定配置文件拿值
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
// 加载指定配置文件
@PropertySource(value = "classpath:demo.properties")
public class User {
    // EL表达式取值
    @Value("${name}")
    private String name;
}
```
- demo.properties
```properties
name = 李爽
```

## 松散绑定
yml中写的last-name和lastName是一样的，`-`后面跟着的字母默认是大写的，这就是松散绑定。

## JSR303校验

<img src="./JSR303校验.jpg">

常用注解
```java
@NotNull(message="名字不能为空")
private String userName;
@Max(value=120,message="年龄最大不能查过120")
private int age;
@Email(message="邮箱格式错误")
private String email;

空检查
@Null       验证对象是否为null
@NotNull    验证对象是否不为null, 无法查检长度为0的字符串
@NotBlank   检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
@NotEmpty   检查约束元素是否为NULL或者是EMPTY.
    
Booelan检查
@AssertTrue     验证 Boolean 对象是否为 true  
@AssertFalse    验证 Boolean 对象是否为 false  
    
长度检查
@Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内  
@Length(min=, max=) string is between min and max included.

日期检查
@Past       验证 Date 和 Calendar 对象是否在当前时间之前  
@Future     验证 Date 和 Calendar 对象是否在当前时间之后  
@Pattern    验证 String 对象是否符合正则表达式的规则

.......等等
除此以外，我们还可以自定义一些数据校验规则
```

## 配置文件加载路径
官方定义了4个配置文件可以被加载的路径，自动加载名为application的配置文件
1. file:./config/
2. file:./
3. classpath:/config/
4. classpath:/

加载优先级
```
优先级1：项目路径下的config文件夹配置文件
优先级2：项目路径下配置文件
优先级3：资源路径下的config文件夹配置文件
优先级4：资源路径下配置文件
```

## 多环境切换
编写多套配置文件，用于多个环境
- application-test.properties 代表测试环境配置
- application-dev.properties 代表开发环境配置

在主配置文件里面激活
- application.properties
```properties
spring.profiles.active=dev
```

和properties配置文件中一样，但是使用yml去实现不需要创建多个配置文件，更加方便了!
```yml

server:
  port: 8081
#选择要激活那个环境块
spring:
  profiles:
    active: prod

---
server:
  port: 8083
spring:
  profiles: dev #配置环境的名称


---

server:
  port: 8084
spring:
  profiles: prod  #配置环境的名称
```

注意：如果yml和properties同时都配置了端口，并且没有激活其他环境 ， 默认会使用properties配置文件的！

## 静态资源处理
1. 通过源码分析可知，通过webjar导入的静态资源会自动放行
2. `classpath:/META-INF/resources/`、`classpath:/resources/`、`classpath:/static/`、`classpath:/public/`这四个路径下的静态资源会被放行，优先级：`resources>static>public`
3. 可以通过配置文件手动设置静态资源路径，不过设置过后，默认的几个路径都会失效
```yml
spring.resources.static-locations=classpath:/mystatic/,classpath:/mystatic2/
```