# P7 P12补

## 配置文件
语法
- properties文件
```
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

在yml文件中配置值
```yml
student:
  name: 张三
  age: 18
  like: null
```
```java
package cn.com.scitc.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 使用ConfigurationProperties注解获取yml中的值来给当前类赋值
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private String age;
    private String like;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", like='" + like + '\'' +
                '}';
    }
}
```
## JSR303校验
```java
@Validated //用来注释类
```
以下用来注释属性，用以校验
<img src="./JSR303校验.jpg">

常见参数
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
```

## SpringBoot配置文件拆分
多文件拆分
```yml
# 1. 将添加application-dev.yml和application-prod.yml两套配置文件，分别对应开发环境和生成环境
# 2. 将公共配置添加到application-dev.yml文件中
# 3. 在application-dev.yml文件中添加如下配置，激活拆分后的配置文件

spring:
  profiles:
    active: dev #激活配置
```
单文件拆分(不推荐使用)
```yml
server:
  port: 8081
spring:
  profiles:
    active: dev #激活配置

---
server:
  port: 8082
spring:
  profiles: dev #配置名

---
server:
  port: 8083
spring:
  profiles: test #配置名
```