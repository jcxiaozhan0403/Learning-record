## 什么是mybatis
- MyBatis 是一款优秀的`持久层框架`
- 它支持自定义 SQL、存储过程以及高级映射
- MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作
- MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

## mybatis的简单使用
1. pom文件引入jar包
```xml
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.38</version>
</dependency>
```

2. 创建实体类
```java
package cn.com.scitc.model;

public class User {
    private Integer id;
    private String name;
    private String mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
```

3. 配置文件
- mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!-- JDBC配置 -->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/webapp1901"/>
                <property name="username" value="root"/>
                <property name="password" value="lishuang001219"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!-- Mapper路径 -->
        <mapper resource="UserMapper.xml"/>
    </mappers>
</configuration>
```
- UserMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.com.scitc.mapper.UserMapper">
    <!-- sql语句 -->
    <select id="selectUser" resultType="cn.com.scitc.model.User">
        select * from user where id = #{id}
    </select>
</mapper>
```

4. 测试类
```java
package cn.com.scitc.test;

import cn.com.scitc.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {

    //注解添加测试方法
    @Test
    public void test() {
        InputStream inputStream = null;
        try {
            //用输入流来读取xml文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建会话
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //调用sql语句，结果保存在实体类中
            User user = (User) session.selectOne("cn.com.scitc.mapper.UserMapper.selectUser",1);
            //获取实体类中的信息
            System.out.println("姓名：" + user.getName());
        }
    }
}
```
5. 目录结构
<img src="D:/Study/Learning-record/SSM/mybatis简单使用目录结构.jpg" style="height:300px;width:300px;text-align:center;">

## 持久化
数据持久化
- 持久化就是将程序的数据在持久状态和瞬时状态转化的过程
- 内存：断电即失
- 数据库(JDBC)，io文件持久化

## 持久层
完成持久化工作的代码块

## Spring简介
- Spring是一个开源的免费的框架(容器)
- Spring是一个轻量级的、非入侵的框架
- 控制反转(IOC)、面向切面编程(AOP)
- 支持事务处理，对框架整合的支持

## Spring的简单使用
1. pom文件引入
```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.9.RELEASE</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.9.RELEASE</version>
</dependency>
```
2. 创建配置文件`applicationContext.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 每一个bean代表new一个对象 -->
    <bean id="hello" class="cn.com.scitc.spring.pojo.Hello">
        <property name="str" value="李爽" />
    </bean>
    <bean id="hello" class="cn.com.scitc.spring.pojo.Hello"></bean>
</beans>
```
3. 获取配置文件中的对象
```java
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello);
    }
}
```

## IOC创建对象的方式
1. 使用无参构造，默认
2. 假设我们要使用有参构造创建对象
    - 下标赋值
    ```xml
    <bean id="exampleBean" class="examples.ExampleBean">
        <constructor-arg index="0" value="7500000"/>
        <constructor-arg index="1" value="42"/>
    </bean>
    ```
    - 参数类型赋值
    ```xml
    <bean id="exampleBean" class="examples.ExampleBean">
        <constructor-arg type="int" value="7500000"/>
        <constructor-arg type="java.lang.String" value="42"/>
    </bean>
    ```
    - 参数名赋值
    ```xml
    <bean id="exampleBean" class="examples.ExampleBean">
        <constructor-arg name="name" value="李爽"/>
    </bean>
    ```

    # P7