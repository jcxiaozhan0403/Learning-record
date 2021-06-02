## 什么是mybatis
- MyBatis 是一款优秀的`持久层框架`
- 它支持自定义 SQL、存储过程以及高级映射
- MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作
- MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

## 持久化
- 因为内存有断电即失的特性，所以需要进行数据持久化
- 持久化就是将程序的数据在持久状态和瞬时状态转化的过程

## 持久层
完成持久化工作的代码块

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

2. 创建工具类
```java
package cn.com.scitc.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream inputStream = null;
        try {
            //用输入流来读取xml文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSession工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession(){
        //创建并返回SqlSession
        return sqlSessionFactory.openSession();
    }
}
```

3. 创建实体类
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

4. 创建mybatis配置文件
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
        <!-- 绑定Mapper配置文件 -->
        <mapper resource="UserMapper.xml"/>
        <!-- resource下的Mapper资源存在多层目录结构时的写法 -->
        <mapper resource="cn/com/scitc/webapp1901/mapper/UserMapper.xml"/>
    </mappers>
</configuration>
```

5. 创建Mapper接口文件
```java
package cn.com.scitc.test.mapper;

import cn.com.scitc.test.pojo.User;

public interface UserMapper {
    public User findById(Integer id);
}
```

6. 创建Mapper配置文件
- UserMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace命名空间：对应一个Mapper接口 -->
<mapper namespace="cn.com.scitc.mapper.UserMapper">
    <!-- sql语句 -->
    <!-- id对应接口中定义的方法 resultType表示结果集类型 -->
    <select id="selectUser" resultType="cn.com.scitc.model.User">
        select * from user where id = #{id}
    </select>
</mapper>
```

7. 创建Dao文件
```java
package cn.com.scitc.test.dao;

import cn.com.scitc.test.mapper.UserMapper;
import cn.com.scitc.test.pojo.User;
import cn.com.scitc.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserDao implements UserMapper{

    public User findById(Integer id) {
        //获取SqlSession
        try(SqlSession session = MybatisUtils.getSqlSession()){
            //获取Mapper，执行其中方法
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.findById(id);
        }
    }
}
```

7. 编写测试类
```java
package cn.com.scitc.test;

import cn.com.scitc.test.dao.UserDao;
import cn.com.scitc.test.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDaoTest {

    @Test
    void findById() {
        UserDao userDao = new UserDao();
        User user = userDao.findById(1);
        System.out.println(user.getName());
        Assertions.assertEquals("李爽",user.getName());
    }
}
```

8. 目录结构
<img src="D:/Study/Learning-record/SSM/mybatis简单使用目录结构.jpg" style="height:400px;width:300px;text-align:center;">

## mybatis-generator的简单使用
注：此插件主要用于自动生成实体类、Mapper接口和Mapper配置文件，mybatis配置文件和Dao层文件需要根据实际应用场景对照生成的文件自行编写
1. 编写pom文件
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

<!-- 添加插件(注意将此行注释删除，中文会引起idea报错) -->
<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.4.0</version>
    <executions>
        <execution>
            <id>Generate MyBatis Artifacts</id>
            <goals>
                <goal>generate</goal>
            </goals>
        </execution>
    </executions>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.5</version>
        </dependency>
    </dependencies>
    <configuration>
        <!-- 生成的文件覆盖源文件 -->
        <overwrite>true</overwrite>
    </configuration>
</plugin>
```

2. 编写mybatis-generator配置文件
- generatorConfig.xml
```xml
<!DOCTYPE generatorConfiguration PUBLIC
        "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <context id="simple" targetRuntime="MyBatis3Simple">
        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/webapp1901" userId="root" password="lishuang001219"/>
        <!--实体存放位置-->
        <javaModelGenerator targetPackage="cn.com.scitc.webapp1901.pojo" targetProject="src/main/java"/>
        <!--Mapper.xml存放位置-->
        <sqlMapGenerator targetPackage="cn.com.scitc.webapp1901.mapper" targetProject="src/main/resources"/>
        <!--Mapper接口存放位置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="cn.com.scitc.webapp1901.mapper" targetProject="src/main/java"/>
        <!--需要生成的表-->
        <table tableName="student" />
    </context>
</generatorConfiguration>
```

3. 双击一键生成代码
<img src="D:/Study/Learning-record/SSM/mybatis-generator.jpg" style="height:300px;width:500px;text-align:center;">

## 提取数据库配置文件
- db.properties
```properties
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/webapp1901
username=root
password=lishuang001219
```

- mybatis-config.xml
```xml
<!-- 引入外部配置文件 -->
<!-- 在引入外部文件后，还可以添加字段，如果存在相同字段，以配置文件中的为准 -->
<properties resource="db.properties">
    <property name="username" value="root" />
    <property name="pwd" value="123456" />
</properties>
```

## 类型别名

- 类型别名是为Java类型设置一个短的名字
- 存在的意义仅在于用来减少类完全限定名的冗余
```xml
<!-- 可以给实体类起别名 -->
<typeAliases>
    <typeAlias type="cn.com.scitc.webapp1901.pojo.User" alias="User">
</typeAliases>
```
也可以指定一个包名，Mybatis会在包名下面搜索需要的Java Bean，比如：扫描实体类的包，它的默认别名就是这个类的类名，首字母小写
```xml
<typeAliases>
    <package name="cn.com.scitc.webapp1901.pojo" />
</typeAliases>
```
实体类较少时，使用第一种
实体类较多时，使用第二种，第二种如果需要DIY别名，需要使用注解
```java
@Alias("UserPojo")
public class User {

}
```

## 注册绑定Mapper文件的多种方式
方式一：通过resource属性进行绑定(少量Mapper时推荐使用)
```xml
<mappers>
    <mapper resource="cn/com/scitc/webapp1901/mapper/UserMapper.xml"/>
</mappers>
```

方式二：通过扫描包进行绑定(少量Mapper时推荐使用)
方式二注意：
1. 接口和他的Mapper配置文件必须同名
2. 接口和他的Mapper配置文件必须在同一个包下
```xml
<mappers>
    <mapper name="cn.com.scitc.webapp1901.dao"/>
</mappers>
```

## 结果集映射(resultMap)
当数据库中的列名和实体类中的属性名不完全相同时，需要用到结果集映射
```xml
<resultMap id="BaseResultMap" type="cn.com.scitc.webapp1901.model.Signin">
    <!-- column数据库中的字段，property实体类中的属性 -->
    <result column="studentId" property="studentid" />
    <result column="signDatetime" property="signdatetime" />
    <result column="signDate" property="signdate" />
</resultMap>
```

## Map的使用

当实体类或者数据库表、字段、参数过多时，应当考虑使用map
- UserMapper.java
```java
int addUser(Map<String,Object> map);
```

- UserMapper.xml
```xml
<insert id="addUser" parameterType="map">
    insert into user (id,pwd) value (#{userId},#{passWord})
</insert>
```

- UserDao.java
```java
public int addUser(Map<String,Object> map) {
    //获取SqlSession
    try(SqlSession session = MybatisUtils.getSqlSession()){
        //获取Mapper，执行其中方法
        UserMapper mapper = session.getMapper(UserMapper.class);
        int result = mapper.addUser(map);
        session.commit();
        return result;
    }
}
```

测试代码
```java
@Test
void addUser() {
    UserDao userDao = new UserDao();
    Map<String,Object> map = new Map<String,Object>();
    map.put("userId",5);
    map.put("password",123456);
    User user = userDao.addUser(map);
}
```

## 模糊查询的简单实现
```xml
<select id="getUserLike" resultType="cn.com.scitc.model.User">
    select * from user where name like #{value}
</select>
```

```java
public void getUserLike() {
    SqlSession session = MybatisUtils.getSqlSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    List<User> userList = mapper.getUserLike("%李%");

    for(User user : userList) {
        System.out.println(user);
    }
    sqlSession.close();
}
```
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

## Spring配置
1. Bean配置
```xml
<!-- 
    id：唯一标识符
    class：全限定名 包名+类名
    name：别名，可以有多个，分隔符也比较人性化
 -->
<bean id="hello" class="cn.com.scitc.spring.pojo.Hello" name="xxx sss ddd">
    <property name="str" value="李爽" />
</bean>
```
2. 合并多个配置文件
```xml
<import resource="beans01.xml" />
<import resource="beans02.xml" />
<import resource="beans03.xml" />
```
3. 别名
```xml
<!-- 用别名也可以获取到对象，多去一个名字而已，并没有什么用 -->
<alias name="user" alias="userNew">
```

## 依赖注入(DI)
```xml
<bean id="hello" class="cn.com.scitc.spring.pojo.Hello" />
<bean id="student" class="cn.com.scitc.spring.pojo.Student">
    <!-- 普通类型注入 -->
    <property name="name" value="李爽" />
    <!-- 引用类型注入 -->
    <property name="hello" ref="hello" />
    <!-- 数组注入 -->
    <property name="books">
        <array>
            <value>水浒传</value>
            <value>红楼梦</value>
            <value>西游记</value>
        </array>
    </property>
    <!-- List -->
    <property name="hobbys">
        <list>
            <value>唱</value>
            <value>跳</value>
            <value>Rap</value>
        </list>
    </property>
    <!-- Map -->
    <property name="card">
        <map>
            <entry key="身份证" value="46515619841515"></entry>
            <entry key="银行卡" value="46545619841515"></entry>
        </map>
    </property>
    <!-- Set -->
    <property name="games">
        <set>
            <value>LOL</value>
            <value>CS</value>
            <value>CF</value>
        </set>
    </property>
    <!-- Properties -->
    <property name="info">
        <props>
            <prop key="driver">com.mysql.jdbc.Driver</prop>
            <prop key="url">jdbc:mysql://localhost:3306/webapp1901</prop>
            <prop key="username">root</prop>
            <prop key="password">lishuang001219</prop>
        </props>
    </property>
</bean>
```

## c命名空间和p命名空间
他们的使用实质上就是简化赋值操作，p对应变量赋值，c对应构造器参数赋值
```xml
<!-- 首先在头部引入约束文件 -->
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"
```
使用
```xml
<bean id="hello" class="cn.com.scitc.spring.pojo.Hello" p:str="你好世界"/>
<bean id="hello" class="cn.com.scitc.spring.pojo.Hello" c:name="李爽" c:age="18"/>
```

## Bean作用域
1. 单例模式(默认)
```xml
<bean id="hello" class="cn.com.scitc.spring.pojo.Hello" scope="singleton"/>
```
2. 原型模式(每次拿到的Bean都是一个新的)
```xml
<bean id="hello" class="cn.com.scitc.spring.pojo.Hello" scope="prototype"/>
```

## Bean的自动装配
1. byName
```xml
<!-- byName会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanid -->
<bean id="cat" class="cn.com.scitc.spring.pojo.Cat" />
<bean id="dog" class="cn.com.scitc.spring.pojo.Dog" />
<bean id="hello" class="cn.com.scitc.spring.pojo.Hello" autowire="byName"/>
```
2. byType
```xml
<!-- byType会自动在容器上下文中查找，和自己对象属性类型相同的bean -->
<bean class="cn.com.scitc.spring.pojo.Cat" />
<bean class="cn.com.scitc.spring.pojo.Dog" />
<bean id="hello" class="cn.com.scitc.spring.pojo.Hello" autowire="byType"/>
```
小结
- byName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致！
-  byType的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的类型一致！

## 注解实现自动装配
1. 导入约束
```xml
xmlns:context="http://www.springframework.org/schema/context"

xsi:schemaLocation="http://www.springframework.org/schema/context
https://www.springframework.org/schema/context/spring-context.xsd">
```
2. 添加注解支持
```xml
<context:annotation-config/>
```
3. 使用：直接在属性上添加注解即可，使用注解方式可以不用写set方法
```java
public class Hello {
    private String str;
    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
```
4. 多个bean对象时，@Autowired配合@Qualifier使用
```java
@Autowired
@Qualifier(value="dog01")
private Dog dog;
```
注：@Autowired自动装配是默认byType装配，查找不到的时候再使用byName

## Spring注解开发
1. 导入约束
```xml
xmlns:context="http://www.springframework.org/schema/context"

xsi:schemaLocation="http://www.springframework.org/schema/context
https://www.springframework.org/schema/context/spring-context.xsd">
```
3. 指定扫描包，包下所有类的注解才会生效
```xml
<context:component-scan base-package="cn.com.scitc.spring" />
```
4. 添加注解支持
```xml
<context:annotation-config/>
```
5. 常见注解
```java
// 等价于<bean id="" class="" />
@Component

// 赋值
// 1.属性赋值
@Value("李爽")
private String name;
// 2. 参数赋值
@Value("王麻子")
public void setName(String name) {
    this.name = name;
}

// @Component衍生的注解
四个注解功能是一样的，对应MVC三层架构分层
dao【@Repository】
service【@Service】
controller【@Controller】

// 作用域
// 单例模式
@Scope("singleton")
// 原型模式
@Scope("prototype")
```

小结
xml与注解：
 - xml更加万能，适用于任何场合！维护简单方便
  - 注解只应用于自己的类，维护复杂
最佳使用原则：xml用来管理bean，注解只负责完成属性的注入

## 使用Java类方式配置Spring
创建一个配置类来代替xml配置文件
```java
// 注解指定它为配置类
@Configuration
// 指定扫描包
@ComponentScan("cn.com.scitc.spring")
public class SpringConfig {

}
```

# P16