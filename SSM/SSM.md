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
此方式注意：

1. 接口和他的Mapper配置文件必须同名
2. 接口和他的Mapper配置文件必须在同一个包下
```xml
<mappers>
    <mapper class="cn.com.scitc.webapp1901.dao"/>
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

## Mybatis多表查询之多对一
多对一环境准备
实体类

- Student.java
```java
public class Student {
    private int id;
    private String name;
    // 多个学生关联一个老师
    private Teacher teacher;
}
```
- Teacher.java
```java
public class Teacher {
    private int id;
    private String name;
}
```

方法一：按查询嵌套处理
```xml
<select id="getStydent" resultMap="studentTeacher">
    select  * from student
</select>

<resultMap id="studentTeacher" type="Student">
    <result property="id" column="id" />
    <result property="name" column="name" />
<!-- 复杂属性，单独处理 对象：association 集合：collection 指定属性的类型：javaType -->
<association property="teacher" column="tid" javaType="Teacher" select="getTeacher" />
</resultMap>

<select id="getTeacher" resultMap="Teacher">
    select * from teacher where id = #{tid}
</select>
```
方法二：按结果嵌套查询
```xml
<select id="getStudent" resultMap="StudentTeacher">
    select s.id sid,s.name sname,t.name tname from student s,teacher t where s.tid = t.id;
</select>

<resultMap id="StudentTeacher" type="Student">
    <result property="id" column="sid" />
    <result property="name" column="sname" />
    <association property="teacher" javaType="Teacher">
        <result property="name" column="tname" />
    </association>
</resultMap>
```

## Mybatis多表查询之一对多
多对一环境准备
实体类

- Student.java
```java
public class Student {
    private int id;
    private String name;
    private int tid;
}
```
- Teacher.java
```java
public class Teacher {
    private int id;
    private String name;
    // 一个老师拥有多个学生
    private List<Student> student;
}
```

方法一：按查询嵌套处理
```xml
<select id="getTeacher" resultMap="TeacherStudent">
    select * from teacher where id = #{tid}
</select>

<resultMap id="TeacherStudent" type="Teacher">
    <collection property="student" javaType="ArrayList" ofType="Studentt" select="getStudentByTeacherId" column="id" />
</resultMap>

<select id="getStudentByTeacherId" resultType="Studnet">
    select * from student where tid = #{tid}
</select>
```
方法二：按结果嵌套查询
```xml
<select id="getTeacher" resultMap="TeacherStudent">
    select s.id sid,s.name sname,t.name tname,t.id tid from student student s,teacher t where s.tid = t.id and t.id = #{tid}
</select>

<reslutMap id="TeacherStudent" type="Teacher">
    <result property="id" column="tid" />
    <result property="name" column="tname" />
    <!-- javaType="" 指定属性的类型 ofType="" 集合中的泛型 -->
    <collection property="student" ofType="Student">
        <result property="id" column="sid" />
        <result property="name" column="sname" />
        <result property="tid" column="tid" />
    </collection>
</reslutMap>
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

## 动态SQL
- 使用动态 SQL 最常见情景是根据条件包含 where 子句的一部分
- 动态 SQL 的另一个常见使用场景是对集合进行遍历（尤其是在构建 IN 条件语句的时候）
if标签
```xml
<select id="queryBlogIf" parameterType="map" resultType="blog">
    select * from blog where 1=1
    <if test="title != null">
        and title = #{title}
    </if>
    <if test="author != null">
        and author = #{author}
    </if>
</select>
```
```java
public void queryBlogIf() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

    HashMap map = new HashMap();
    map.put("title","Java从入门到放弃");
    map.put("author","John.Cena");

    List<Blog> blogs = mapper.queryBlogIf(map);

    for(Blog blog : blogs) {
        System.out.println(blog);
    }

    sqlSession.close();
}
```
where标签
> where 元素只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。而且，若子句的开头为 “AND” 或 “OR”，where 元素也会将它们去除。
```xml
<select id="queryBlogIf" parameterType="map" resultType="blog">
    select * from blog
    <where>
        <if test="title != null">
            and title = #{title}
        </if>
        <if test="author != null">
            and author = #{author}
        </if>
    </where>
</select>
```
choose、when、otherwise
> 有时候，我们不想使用所有的条件，而只是想从多个条件中选择一个使用。针对这种情况，MyBatis 提供了 choose 元素，它有点像 Java 中的 switch 语句。
```xml
<select id="findActiveBlogLike"
     resultType="Blog">
  SELECT * FROM BLOG WHERE state = ‘ACTIVE’
  <choose>
    <when test="title != null">
      AND title like #{title}
    </when>
    <when test="author != null and author.name != null">
      AND author_name like #{author.name}
    </when>
    <otherwise>
      AND featured = 1
    </otherwise>
  </choose>
</select>
```
set标签
> set 元素会动态地在行首插入 SET 关键字，并会删掉额外的逗号（这些逗号是在使用条件语句给列赋值时引入的）。
```xml
<update id="updateAuthorIfNecessary">
  update Author
    <set>
      <if test="username != null">username=#{username},</if>
      <if test="password != null">password=#{password},</if>
      <if test="email != null">email=#{email},</if>
      <if test="bio != null">bio=#{bio}</if>
    </set>
  where id=#{id}
</update>
```
trim自定义标签

foreach标签
[foreach详解](https://www.cnblogs.com/fnlingnzb-learner/p/10566452.html)
foreach元素的属性主要有item，index，collection，open，separator，close
- item：集合中元素迭代时的别名，该参数为必选。
- index：在list和数组中,index是元素的序号，在map中，index是元素的key，该参数可选
- open：foreach代码的开始符号，一般是(和close=")"合用。常用在in(),values()时。该参数可选
- 元素之间的分隔符，例如在in()的时候，separator=","会自动在元素中间用“,“隔开，避免手动输入逗号导致sql错误，如in(1,2,)这样。该参数可选。
- close: foreach代码的关闭符号，一般是)和open="("合用。常用在in(),values()时。该参数可选。
- collection: 要做foreach的对象，作为入参时，List对象默认用"list"代替作为键，数组对象有"array"代替作为键，Map对象没有默认的键。当然在作为入参时可以使用@Param("keyName")来设置键，设置keyName后，list,array将会失效。 除了入参这种情况外，还有一种作为参数对象的某个字段的时候。举个例子：如果User有属性List ids。入参是User对象，那么这个collection = "ids".如果User有属性Ids ids;其中Ids是个对象，Ids有个属性List id;入参是User对象，那么collection = "ids.id"
collection属性值的三种情况
- 如果传入的是单参数且参数类型是一个List的时候，collection属性值为list
- 如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array
- 如果传入的参数是多个的时候，我们就需要把它们封装成一个Map了，当然单参数也可以封装成map，实际上如果你在传入参数的时候，在MyBatis里面也是会把它封装成一个Map的，map的key就是参数名，所以这个时候collection属性值就是传入的List或array对象在自己封装的map里面的key

## 分页
Limit实现
```sql
-- 从索引0开始，查询20条记录
select * from `student` limit 0,20
```
分页插件
[MybatisPageHelper](https://pagehelper.github.io/)

## 日志
标准日志工厂的实现
在mybais设置文件中添加日志设置
```xml
<settings>
    <setting name="logImpl" value="STDOUT_LOGGING"/>
<settings>
```

log4j的使用
1. 在pom中导入依赖
```xml
<!-- https://mvnrepository.com/artifact/log4j/log4j -->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```
2. 创建log4j配置文件
- log4j.properties
```
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
log4j.appender.file.File=./log/kuang.log
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
3. 修改mybais设置文件中的日志设置
```xml
<settings>
    <setting name="logImpl" value="LOG4J"/>
<settings>
```

在类中手动添加日志输出
- UserDao.java
```java
static Logger logger = Logger.getLogger(UserDao.class);
logger.info("xxxxxx");
logger.debug("xxxxxx");
logger.error("xxxxxx");
```

## 缓存
1. 什么是缓存
   - 存在内存中的临时数据。
   - 将用户经常查询的数据放在缓存（内存）中，用户去查询数据就不用从磁盘上(关系型数据库数据文件)查询，从缓存中查询，从而提高查询效率，解决了高并发系统的性能问题。
2. 为什么使用缓存
   - 减少和数据库的交互次数，减少系统开销，提高系统效率。
3. 什么样的数据能使用缓存
   - 经常查询并且不经常改变的数据。

MyBatis系统中默认定义了两级缓存
- 一级缓存(由Mybatis默认开启，无法关闭)
一级缓存也叫本地缓存，与数据库同一次会话期间(一次Session创建到关闭之间的代码块)查询到的数据会放在本地缓存中，以后如果需要获取相同的数据，直接从缓存中拿，没必须再去查询数据库，当两次相同查询之间，存在增删改查操作，则缓存会被清除
可以通过代码，手动清除一级缓存
```java
session.clearCache();
```

- 

## 使用注解开发
1. 在工具类中设置事务自动提交
```java
public static SqlSession getSqlSession(){
    return sqlSessionFactory.openSession(true);
}
```
2. 在mybatis配置文件中绑定接口类
- mybatis-config.xml
```xml
<mappers>
    <mapper class="cn.com.scitc.webapp1901.mapper.UserMapper" />
</mappers>
```
3. 编写Mapper接口文件
- UserMapper.java
```java
@Select("select * from user")
List<User> getUsers();


//根据id查询用户
@Select("select * from user where id = #{id}")
User selectUserById(@Param("id") int id);


//添加一个用户
@Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
int addUser(User user);


//修改一个用户
@Update("update user set name=#{name},pwd=#{pwd} where id = #{id}")
int updateUser(User user);

//根据id删除用
@Delete("delete from user where id = #{id}")
int deleteUser(@Param("id")int id);
```

关于@Param
- 在方法只接受一个参数的情况下，可以不使用@Param。
- 在方法接受多个参数的情况下，建议一定要使用@Param注解给参数命名。
- 如果参数是 JavaBean ， 则不能使用@Param。
- 不使用@Param注解时，参数只能有一个，并且是Javabean。


## Thymeleaf模板引擎
html文件根标签属性引入Thymeleaf
```html
<html lang="en" xmlns:th="http://www.thymeleaf.org">
```
语法
```html
<h1 th:text="'姓名：'+${name}"></h1>
<h1 th:text="|姓名：${name}|"></h1>
<h1 th:utext="'姓名：'+${name}"></h1>
<h1 th:each="user:${users}" th:text="${user}"></h1>
```
fragment标签与insert、replace、include属性
```html
<!-- 用fragment标签定义 -->
<footer th:fragment="copy">
  &copy; 2011 The Good Thymes Virtual Grocery
</footer>

<!-- 用insert属性在元素下引用定义好的片段 -->
<!-- 效果如下 
<div>
    <footer>
        &copy; 2011 The Good Thymes Virtual Grocery
    </footer>
</div> 
-->
<div th:insert="footer :: copy"></div>

<!-- 用replace属性在元素下引用定义好的片段 -->
<!-- 效果如下 
<footer>
    &copy; 2011 The Good Thymes Virtual Grocery
</footer>
-->
<div th:replace="footer :: copy"></div>

<!-- 用include属性在元素下引用定义好的片段 -->
<!-- 效果如下 
<div>
    &copy; 2011 The Good Thymes Virtual Grocery
</div>
-->
<div th:include="footer :: copy"></div>

<!-- 注：当定义标签与使用标签不存在与同一个目录中时，引用时要带上路径 -->
<div th:insert="main/footer :: copy"></div>
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

