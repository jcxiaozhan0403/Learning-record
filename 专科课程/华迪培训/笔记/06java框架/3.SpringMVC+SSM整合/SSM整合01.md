# 环境搭建

##环境要求

> IDEA
>
> MySQL 5.7
>
> Tomcat 8.5
>
> Maven 3.5

##数据库环境

创建一个存放用户数据的数据库表

```sql
create table user(   -- 创建表
		id int primary key auto_increment,
		username varchar(50),
		password varchar(50),
		name varchar(20) not null,
		gender varchar(5),
		age int,
		address varchar(32),
		qq	varchar(20),
		email varchar(50)
	);
INSERT INTO USER VALUES(1,'zhangsan','123','张三','男',18,'北京','111','111@qq.com');
INSERT INTO USER VALUES(2,'lisi','123','李四','女',19,'上海','222','222@qq.com');
INSERT INTO USER VALUES(3,'wangwu','123','王五','男',20,'广州','333','333@qq.com');
INSERT INTO USER VALUES(4,'zhaoliu','123','赵六','女',21,'深圳','444','444@qq.com');
INSERT INTO USER VALUES(5,'sunqi','123','孙七','男',22,'北京','555','555@qq.com');
INSERT INTO USER VALUES(6,'zhouba','123','周八','女',23,'上海','666','666@qq.com');
```

##基本环境搭建

###新建Maven项目

###导入相关的pom依赖！

```xml
<dependencies>
        <!--Junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
        <!--数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!-- 数据库连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.3</version>
        </dependency>

        <!--Servlet - JSP -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>

        <!--Mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.2</version>
        </dependency>

        <!--Spring-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.1.9.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.1.9.RELEASE</version>
        </dependency>

        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.18</version>
            <scope>provided</scope>
        </dependency>

        <!--jackson-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.12.1</version>
        </dependency>

        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>

    <!--导入插件，防止静态资源过滤-->
    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>

        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>utf-8</encoding>
                </configuration>
            </plugin>
        </plugins>

    </build>

```

###建立基本结构和配置框架！

- com.bao.pojo

- com.bao.mapper

- com.bao.service

- com.bao.controller

- mybatis-config.xml（mybatis的核心文件）

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE configuration
         PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
         "http://mybatis.org/dtd/mybatis-3-config.dtd">
  <configuration>
  
  </configuration>
  ```

- applicationContext.xml（spring的核心文件）

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd">
  
  </beans>
  ```



#Mybatis层

## 编写log4j.properties

```properties
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
log4j.rootLogger=DEBUG,console,file

#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender 
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%c]-%m%n

#文件输出的相关设置
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/bao.log
log4j.appender.file.MaxFileSize=10mb
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n

#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```

##编写druid.properties

```properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm?useSSL=true&useUnicode=true&characterEncoding=utf8
jdbc.username=root
jdbc.password=root
```

> 这里的每一个key的前面加了jdbc的原因是，如果不加有可能会与电脑的其他路径相冲突

##编写mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

    <!--设置-->
    <settings>
        <!--设置日志-->
        <setting name="logImpl" value="LOG4J"/>
    </settings>

    <!--起别名-->
    <typeAliases>
        <package name="com.bao.pojo"/>
    </typeAliases>

    <!--关联mapper.xml文件-->
    <mappers>
        <mapper resource="com/bao/dao/UserMapper.xml"/>
    </mappers>

</configuration>
```

##编写实体类

```java
package com.bao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String qq;
    private String email;
}

```

##编写Mapper层的接口

```java
package com.bao.dao;

import com.bao.pojo.User;
import java.util.List;

public interface UserMapper {
    // 增
    public int addUser(User user);
    // 删
    public int deleteUser(int id);
    // 改
    public int updataUser(User user);
    // 查所有
    public List<User> queryAllUser();
    // 根据id查一个
    public User queryUserById(int id);

    //条件查询
    public List<User> conditionQuery(User user);
}

```

##编写对应的Mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.bao.dao.UserMapper">

    <!--增-->
    <insert id="addUser" parameterType="user">
        insert into user(name,gender,age,address,qq,email)
        values(#{name},#{gender},#{age},#{address},#{qq},#{email})
    </insert>

    <!--删-->
    <delete id="deleteUser" parameterType="int">
        delete from user where id = #{id}
    </delete>

    <!--改-->
    <update id="updataUser" parameterType="user">
        update user set name=#{name},gender=#{gender},age=#{age},address=#{address},qq=#{qq},email=#{email} where id=#{id}
    </update>

    <!--查所有-->
    <select id="queryAllUser" resultType="user">
        select * from user
    </select>

    <!--根据id查一个-->
    <select id="queryUserById" resultType="user" parameterType="int">
        select * from user where id=#{id}
    </select>
    
    <!--根据条件查询-->
    <select id="conditionQuery" resultType="user" parameterType="user">
        select * from user
        <where>
            <if test="name != null and name != ''">
                name = #{name}
            </if>
            <if test="gender != null and gender != ''">
                and gender = #{gender}
            </if>
            <if test="address != null and address != ''">
                and address = #{address}
            </if>
        </where>
    </select>

</mapper>
```

##编写Service层的接口

```java
package com.bao.service;

import com.bao.pojo.User;

import java.util.List;

public interface UserService {
    // 增
    public int addUser(User user);
    // 删
    public int deleteUser(int id);
    // 改
    public int updataUser(User user);
    // 查所有
    public List<User> queryAllUser();
    // 根据id查一个
    public User queryUserById(int id);

    //条件查询
    public List<User> conditionQuery(User user);
}

```

##编写实现类

```java
package com.bao.service;

import com.bao.dao.UserMapper;
import com.bao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    public int updataUser(User user) {
        return userMapper.updataUser(user);
    }

    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public List<User> conditionQuery(User user) {
        return userMapper.conditionQuery(user);
    }
}

```



#Spring层

##编写spring-mybatis.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd">

    <!--导入druid.properties进行关联-->
    <context:property-placeholder location="classpath:druid.properties"/>

    <!--配置数据库连接池-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <!--注入连接属性-->
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!--配置SqlSessionFactory对象,该对象可以生成SqlSession对象-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--连接数据源-->
        <property name="dataSource" ref="dataSource"/>
        <!--绑定Mybatis的配置文件-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
    </bean>

    <!--配置MapperScannerConfigurer，将创建的接口的都自动注入到了SqlSessionFactory中，
        给每个接口创建了实例-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--确定哪个包下的接口需要创建实体类-->
        <property name="basePackage" value="com.bao.dao"/>
        <!--指定需要注入到哪一个SqlSessionFactory中-->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    </bean>
</beans>
```

##编写spring-service.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd">

    <!--扫描service相关的bean，同时让service包下的注解生效-->
    <context:component-scan base-package="com.bao.service"/>

    <!-- 配置事务管理器 -->
    <!--1.创建事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!--注入数据源-->
        <constructor-arg ref="dataSource" />
    </bean>

    <!--2.开启事务注解，需要导入tx命名空间-->
    <!--transaction-manager="transactionManager" : 绑定事务管理器-->
    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>

</beans>
```

##applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <import resource="classpath:spring-mvc.xml"/>
    <import resource="classpath:spring-mybatis.xml"/>
    <import resource="classpath:spring-service.xml"/>

</beans>
```





#Service层测试

```java
@Test
public void testQueryAllUser(){
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
    List<User> users = userService.queryAllUser();
    for (User user : users) {
        System.out.println(user);
    }
}
```

#添加web支持

#SpringMVC层

##web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!--配置DispatcherServlet，是SpringMVC的核心，又名前端控制器；用于拦截符合配置的 url 请求、分发请求-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--DispatcherServlet需要绑定Spring的配置文件-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext.xml</param-value>
        </init-param>
        <!--设置启动级别1：随着服务器的启动而启动-->
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <!--配置过滤器，防止乱码-->
    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>
```

##spring-mvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--开启注解支持，确定扫描的包-->
    <context:component-scan base-package="com.bao.controller"/>

    <!--开启mvc的注解支持-->
    <!--<mvc:annotation-driven/>-->
    <!--开启mvc的注解支持，同时解决json乱码问题，这是固定的，记住怎么使用就可以-->
    <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8"/>
            </bean>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="objectMapper">
                    <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                        <property name="failOnEmptyBeans" value="false"/>
                    </bean>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>

    <!-- 让Spring MVC不处理静态资源，比如.css .js .mp4 .jpg .html等 -->
    <mvc:default-servlet-handler/>

    <!--配置视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```



#Controller层测试

### 注意要保证依赖已经加载到了web项目中

![image-20210427061455657](SSM%E6%95%B4%E5%90%8801-image/image-20210427061455657.png)

```java
package com.bao.controller;

import com.bao.pojo.User;
import com.bao.service.UserService;
import com.bao.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/queryAllUser")
    @ResponseBody
    public List<User> queryAllUser(){
        List<User> users = userServiceImpl.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
}
```



#Controller层

```java
package com.bao.controller;

import com.bao.pojo.User;
import com.bao.service.UserService;
import com.bao.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/list")
    public String queryAllUser(Model model) {
        List<User> users = userServiceImpl.queryAllUser();
        model.addAttribute("users", users);
        return "list";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        int i = userServiceImpl.addUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/queryUserById/{id}")
    public String queryUserById(@PathVariable Integer id, Model model) {
        User user = userServiceImpl.queryUserById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @PostMapping("/update")
    public String queryUserById(User user) {
        int i = userServiceImpl.updataUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        int i = userServiceImpl.deleteUser(id);
        return "redirect:/user/list";
    }

    @GetMapping("/conditionQuery")
    public String deleteUser(User user,Model model) {
        List<User> users = userServiceImpl.conditionQuery(user);
        model.addAttribute("users",users);
        return "list";
    }

}

```

#页面

##index.jsp

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <title>首页</title>
</head>
<body>
    <div >${user.name}欢迎您</div>
    <div align="center">
        <a href="${pageContext.request.contextPath}/user/list"
                style="text-decoration:none;font-size:33px;color: bisque">查询所有用户信息
        </a>
    </div>
</body>
</html>
```

##list.jsp

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户展示</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>

<div style="width: 1200px;margin: auto" >
    <div>
        <h4 align="center">用户展示</h4>
    </div>
    <div>
        <form style="float: left;margin: 5px;" class="form-inline" action="${pageContext.request.contextPath}/user/conditionQuery" method="get">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" name="name" class="form-control" id="name" >
            </div>
            <div class="form-group">
                <label for="gender">性别</label>
                <input type="text" name="gender" class="form-control" id="gender"  >
            </div>
            <div class="form-group">
                <label for="address">城市</label>
                <input type="text" name="address" class="form-control" id="address" >
            </div>

            <button type="submit" class="btn btn-default">查询</button>
        </form>

        <a style="float: right;margin: 5px;" class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
    </div>

    <table class="table table-hover">
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>城市</th>
            <th>qq</th>
            <th>邮箱</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/delete/${user.id}">删除</a>
                    <a href="${pageContext.request.contextPath}/user/queryUserById/${user.id}">修改</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>

```

##add.jsp

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
    <div style="width: 1200px;margin: auto" >
        <div>
            <h4 align="center">添加用户</h4>
        </div>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/user/add" method="post">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" placeholder="姓名">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10" style="margin-top: 3px;">
                    男：<input type="radio" name="gender" value="男" checked="checked" >
                    女：<input type="radio" name="gender" value="女">
                </div>
            </div>
            <div class="form-group">
                <label for="age" class="col-sm-2 control-label">年龄</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="age" name="age" placeholder="年龄">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">城市</label>
                <div class="col-sm-1">
                    <select class="form-control input-sm" name="address">
                        <option value="成都">成都</option>
                        <option value="重庆">重庆</option>
                        <option value="北京">北京</option>
                        <option value="上海">上海</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="qq" class="col-sm-2 control-label">QQ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">添加</button>
                </div>
            </div>
        </form>
    </div>

</body>
</html>

```

##update.jsp

```html
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<div style="width: 1200px;margin: auto" >
    <div>
        <h4 align="center">修改用户</h4>
    </div>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/update" method="post">
        <input name="id" value="${user.id}" hidden>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" placeholder="姓名" value="${user.name}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10" style="margin-top: 3px;">
                <c:if test="${user.gender == '男'}">
                    男：<input type="radio" name="gender" value="男" checked="checked" >
                    女：<input type="radio" name="gender" value="女">
                </c:if>
                <c:if test="${user.gender == '女'}">
                    男：<input type="radio" name="gender" value="男" >
                    女：<input type="radio" name="gender" value="女" checked="checked">
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="age" name="age" placeholder="年龄" value="${user.age}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">城市</label>
            <div class="col-sm-1">
                <select class="form-control input-sm" name="address">
                    <c:if test="${user.address == '成都'}">
                        <option value="成都" selected>成都</option>
                        <option value="重庆">重庆</option>
                        <option value="北京">北京</option>
                        <option value="上海">上海</option>
                    </c:if>
                    <c:if test="${user.address == '重庆'}">
                        <option value="成都">成都</option>
                        <option value="重庆" selected>重庆</option>
                        <option value="北京">北京</option>
                        <option value="上海">上海</option>
                    </c:if>
                    <c:if test="${user.address == '北京'}">
                        <option value="成都">成都</option>
                        <option value="重庆">重庆</option>
                        <option value="北京" selected>北京</option>
                        <option value="上海">上海</option>
                    </c:if>
                    <c:if test="${user.address == '上海'}">
                        <option value="成都">成都</option>
                        <option value="重庆">重庆</option>
                        <option value="北京">北京</option>
                        <option value="上海" selected>上海</option>
                    </c:if>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="qq" class="col-sm-2 control-label">QQ</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ" value="${user.qq}">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="email" placeholder="邮箱" value="${user.email}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">修改</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
```
