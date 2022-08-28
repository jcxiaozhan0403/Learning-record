## 简介

> MyBatis-Plus(简称 MP)是一个MyBatis的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

官网：https://baomidou.com/

## 简单使用

1. 测试数据
```sql
drop table if exists user;

create table user
(
	id bigint(20) not null auto_increment comment '主键id',
	name varchar(30) null default null comment '姓名',
	age int(11) null default null comment '年龄',
	email varchar(50) null default null comment '邮箱',
	primary key (id)
);

delete from user;

insert into user (id, name, age, email) values
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
```
2. 导入pom依赖，mybatis-plus包会自动导入对应版本的mybatis
```xml
<!-- spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.9.RELEASE</version>
</dependency>
<!-- spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.9.RELEASE</version>
</dependency>
<!-- spring织入 -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
<!-- spring-test -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>5.2.9.RELEASE</version>
</dependency>
<!-- junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
<!-- mysql-jdbc -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
</dependency>
<!-- mybatis-plus -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>3.4.3</version>
</dependency>
<!-- lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
</dependency>
```
4. 创建数据库配置文件

`database.properties`

```properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis_plus?useSSL=false&userUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8
jdbc.username=root
jdbc.password=lishuang001219
```
5. 创建Mybatis核心配置文件

`mybatis-config.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--开启别名（包扫描）-->
    <typeAliases>
        <package name="entity"/>
    </typeAliases>

</configuration>
```

6. 创建spring-mybatis-plus配置文件

`spring-mybatis-plus.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <!--开启注解支持-->
    <context:annotation-config/>

    <!--关联数据库配置文件-->
    <context:property-placeholder location="classpath:database.properties"/>

    <!--配置数据源：数据源有非常多，可以使用第三方的，也可使使用Spring的-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!--这里使用MP提供的sqlSessionFactory，完成了Spring与MP的整合-->
    <bean id="sqlSessionFactory"
          class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
    </bean>

</beans>
```

7. 创建Spring核心配置文件

`applicationContext.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <import resource="spring-mybatis-plus.xml" />

</beans>
```

8. 创建实体类

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private String email;
}
```
9. 创建Mapper接口

```java
// 可以使用Mpper注解标记Mapper
@Mapper
// 继承BaseMapper完成大部分CRUD操作
public interface UserMapper extends BaseMapper<User> {
    
}
```
Mpper接口过多的时候，配置自动扫描

```xml
<!--扫描mapper接口，使用的依然是Mybatis原生的扫描器-->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="mapper"/>
</bean>
```

10. 测试

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")	//注解寻找配置文件
public class MyTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
```

## 注解

### 表名映射

在实体类的名字与表名不对应的时候，我们需要手动给实体类配置表名映射

```java
//注解的参数就是数据库表的名字
@TableName("tb_user")
public class User {
    private long id;
    private String name;
    private int age;
    private String email;
}
```

### 属性映射

在实体类字段与数据库表列名不一致的时候，可以手动配置，使其对应

```java
@TableField("age")
private int ageOne;
```

### 主键生成策略

在插入数据时如果不设置主键,MP默认会使用雪花算法生成一个唯一id

#### 雪花算法
snowflake是Twitter开源的分布式ID生成算法，结果是一个long型的ID。其核心思想是：使用41bit作为毫秒数，10bit作为机器的ID（5个bit是数据中心（北京、香港···），5个bit的机器ID），12bit作为毫秒内的流水号（意味着每个节点在每毫秒可以产生 4096 个 ID），最后还有一个符号位，永远是0。

```java
@TableId(type = IdType.AUTO)
private Long id;
```
```java
public enum IdType {
    AUTO, //数据库id自增，如果选择此方式，数据库主键也必须添加自增属性
    INPUT, //手动输入，选择此方式，如果插入时没有id字段，会默认用null进行填充
    ID_WORKER, //生成全局唯一id 雪花算法，默认
    UUID, //全球唯一id  uuid
    NONE;//未设置主键
}
```

## 全局配置

对于批量的设置，使用注解会比较繁琐，我们可以使用xml进行批量全局配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <!--开启包扫描，自动将注解注册为bean-->
    <context:component-scan base-package="mapper" />
    <context:component-scan base-package="service" />

    <!--关联数据库配置文件-->
    <context:property-placeholder location="classpath:database.properties"/>

    <!--配置数据源：数据源有非常多，可以使用第三方的，也可使使用Spring的-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!--这里使用MP提供的sqlSessionFactory，完成了Spring与MP的整合-->
    <bean id="sqlSessionFactory"
          class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!--将全局配置类注入到MybatisSqlSessionFactoryBean中-->
        <property name="globalConfig" ref="globalConfig"/>
        <!--将配置类注入到MybatisSqlSessionFactoryBean中-->
        <property name="configuration" ref="configuration" />
    </bean>

    <!--动态扫描mapper接口，使用的依然是Mybatis原生的扫描器-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="mapper"/>
    </bean>

    <bean id="dbConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig$DbConfig">
        <!--配置实体类表映射，统一前缀-->
        <property name="tablePrefix" value="tb_" />
        <!--配置主键生成策略-->
        <property name="idType" value="AUTO" />
    </bean>

    <bean id="globalConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig">
        <property name="dbConfig" ref="dbConfig" />
    </bean>
    
    <bean id="configuration" class="com.baomidou.mybatisplus.core.MybatisConfiguration" >
        <!--关闭驼峰自动映射-->
        <property name="mapUnderscoreToCamelCase" value="false" />
        <!--配置日志实现类-->
        <property name="logImpl" value="org.apache.ibatis.logging.stdout.StdOutImpl" />
    </bean>
</beans>
```

## Wrapper

> 我们在实际操作数据库的时候会涉及到很多的条件，所以MP为我们提供了一个功能强大的条件构造器 Wrapper，使用它可以让我们非常方便的构造条件。

Wrapper接口提供了一个抽象子类**AbstractWapper**

**AbstractWapper**抽象类有两个子类**QueryWrapper**和**UpdateWrapper**，我们使用这两个类来编写条件

### QueryWrapper

#### 常用方法

eq：equals，等于
gt：greater than ，大于 >
ge：greater than or equals，大于等于≥
lt：less than，小于<
le：less than or equals，小于等于≤
between：相当于SQL中的BETWEEN
like：模糊匹配。like("name","黄")，相当于SQL的name like '%黄%'
likeRight：模糊匹配右半边。likeRight("name","黄")，相当于SQL的name like '黄%'
likeLeft：模糊匹配左半边。likeLeft("name","黄")，相当于SQL的name like '%黄'
notLike：notLike("name","黄")，相当于SQL的name not like '%黄%'
isNull
isNotNull
and：SQL连接符AND
or：SQL连接符OR

in: in(“age",{1,2,3})相当于 age in(1,2,3)

groupBy: groupBy("id","name")相当于 group by id,name

orderByAsc :orderByAsc("id","name")相当于 order by id ASC,name ASC

orderByDesc :orderByDesc ("id","name")相当于 order by id DESC,name DESC

> select id,name,age,email from user where age>18 and email='349636607@qq.com'

```java
@Test
public void testWrapper01(){
    QueryWrapper wrapper = new QueryWrapper();
    wrapper.gt("age",18);
    wrapper.eq("email","349636607@qq.com");
    List<User> users = userMapper.selectList(wrapper);
    System.out.println(users);
}
```

> select id,name,age,email from user where id in(1,2,3) and age between 12 and 29 and name like '%李%'

```java
@Test
public void testWrapper02(){
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.in("id",1,2,3);
    wrapper.between("age",12,29);
    wrapper.like("name","李");
    List<User> users = userMapper.selectList(wrapper);
    System.out.println(users);
}
```

> select id,name,age,email from user where id in(1,2,3) and age > 10 order by age desc

```java
@Test
public void testWrapper03(){
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.in("id",1,2,3);
    queryWrapper.gt("age",10);
    queryWrapper.orderByDesc("age");
    List<User> users = userMapper.selectList(queryWrapper);
    System.out.println(users);
}
```

#### select方法

select用于指定查询哪些列

> select id,name from user

```java
@Test
public void testSelect01(){
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.select("id","name");
    List<User> users = userMapper.selectList(queryWrapper);
    System.out.println(users);
}
```

方法的第一个参数为实体类的class对象，第二个参数为Predicate类型，可以使用lambda的写法，过滤要查询的字段 (主键除外)。

重写test方法，return true表示此字段要查询，false表示忽略不查询

> select id,name from user

```java
@Test
public void testSelect02(){
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.select(User.class, new Predicate<TableFieldInfo>() {
        @Override
        public boolean test(TableFieldInfo tableFieldInfo) {
            return "name".equals(tableFieldInfo.getColumn());
        }
    });
    List<User> users = userMapper.selectList(queryWrapper);
    System.out.println(users);
}
```

方法第一个参数为Predicate类型，可以使用lambda的写法，过滤要查询的字段 (主键除外) 。(此方法存在问题)

忽略email这一列进行查询

> select id,name,age from user

```java
@Test
public void testSelect03(){
    QueryWrapper<User> queryWrapper = new QueryWrapper<>(new User());
    queryWrapper.select(new Predicate<TableFieldInfo>() {
        @Override
        public boolean test(TableFieldInfo tableFieldInfo) {
            return !"email".equals(tableFieldInfo.getColumn());
        }
    });
    List<User> users = userMapper.selectList(queryWrapper);
    System.out.println(users);
}
```

### UpdateWrapper

我们前面在使用update方法时需要创建一个实体类对象传入，用来指定要更新的列及对应的值。但是如果需要更新的列比较少时，创建这么一个对象显的有点麻烦和复杂。

我们可以使用UpdateWrapper的set方法来设置要更新的列及其值。同时这种方式也可以使用Wrapper去指定更复杂的更新条件。

> update user set age = 99 where id > 1

```java
@Test
public void testUpdateWrapper(){
    UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
    updateWrapper.gt("id",1);
    updateWrapper.set("age",99);
    userMapper.update(null,updateWrapper);
}
```

### Lambda条件构造器

我们前面在使用条件构造器时列名都是用字符串的形式去指定。这种方式无法在编译期确定列名的合法性。

所以MP提供了一个Lambda条件构造器可以让我们直接以实体类的方法引用的形式来指定列名。这样就可以弥补上述缺陷。

> select id,name,age,email from user where age > 18 and email = '349636607@qq.com'

如果使用之前的条件构造器写法如下

```java
@Test
public void testLambdaWrapper(){
    QueryWrapper<User> queryWrapper = new QueryWrapper();
    queryWrapper.gt("age",18);
    queryWrapper.eq("email","349636607@qq.com");
    List<User> users = userMapper.selectList(queryWrapper);
}
```

如果使用Lambda条件构造器写法如下

```java
@Test
public void testLambdaWrapper2(){
    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.gt(User::getAge,18);
    queryWrapper.eq(User::getEmail,"349636607@qq.com");
    List<User> users = userMapper.selectList(queryWrapper);
}
```

## 自定义SQL

虽然MP为我们提供了很多常用的方法，并且也提供了条件构造器。但是如果真的遇到了复杂的SQL时，我们还是需要自己去定义方法，自己去写对应的SQL，这样SQL也更有利于后期维护。

因为MP是对mybatis做了增强，所以还是支持之前Mybatis的方式去自定义方法。

同时也支持在使用Mybatis的自定义方法时使用MP的条件构造器帮助我们进行条件构造。

1. 在Mapper中定义方法

```java
public interface UserMapper extends BaseMapper<User> {

    User findMyUser(Long id);
}

```

2. 创建Mapper映射文件

`UserMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace命名空间：绑定一个对应的Mapper接口 -->
<mapper namespace="mapper.UserMapper">
    <select id="findMyUser" resultType="entity.User">
        select * from tb_user where id = #{id}
    </select>
</mapper>
```

3. 如果没有动态扫码mapper，就需要在在配置文件中手动注入mapper

```xml
<bean id="sqlSessionFactory"
      class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
    <property name="mapperLocations" value="classpath:/mapper/**/*.xml" />
</bean>
```

4. 测试

```java
@Test
public void test(){
    User myUser = userMapper.findMyUser(1l);
    System.out.println(myUser);
}
```

## 分页插件

1. 配置分页过滤器

`spring-mybatis-plus.xml`

```xml
<bean id="mybatisPlusInterceptor" class="com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor">
    <property name="interceptors">
        <list>
            <ref bean="paginationInnerInterceptor"/>
        </list>
    </property>
</bean>

<bean id="paginationInnerInterceptor" class="com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor">
    <!-- 对于单一数据库类型来说,都建议配置该值,避免每次分页都去抓取数据库类型 -->
    <constructor-arg name="dbType" value="H2"/>
</bean>

<bean id="sqlSessionFactory"
      class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"/>
    <property name="globalConfig" ref="globalConfig"/>
    <property name="configuration" ref="configuration" />
    <property name="plugins">
        <array>
            <ref bean="mybatisPlusInterceptor"/>
        </array>
    </property>
</bean>
```

2. 测试

```java
@Test
public void testPage(){
    /**
         * new Page<>(current,size);
         * current：页码
         * size：每一页容量
         */
    IPage<User> page = new Page<>(1,2);

    userMapper.selectPage(page, null);
    System.out.println("总页数" + page.getPages());
    System.out.println("当前页的数据:" + page.getRecords());
    System.out.println("总记录数:" + page.getTotal());
    System.out.println("当前页码:" + page.getCurrent());
    System.out.println("页面容量" + page.getSize());
}
```

**除了使用MP提供的分页插件外，PageHelper也是可以正常用于MP的**

## Service CRUD接口

相比于Mapper接口，Service层主要是支持了更多批量操作的方法。

1. Service接口继承IService

```java
public interface UserService extends IService<User> {

}
```

2. Service实现类继承ServiceImpl

```java
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
	
}
```

3. 测试

```java
@Autowired
private UserService userService;


@Test
public void testSeervice(){
    List<User> list = userService.list();
    System.out.println(list);
}
```

## 代码生成器

MP提供了一个代码生成器，可以让我们一键生成实体类，Mapper接口，Service，Controller等全套代码

1. 添加依赖

```xml
<!--mybatisplus代码生成器-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.4.1</version>
</dependency>
<!--模板引擎-->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
</dependency>
<!--slf4j日志-->
<!--springboot项目自带，spring项目需要手动导入-->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.7</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.7</version>
</dependency>
```

2. 创建生成类，并执行

`旧版`

```java
public class CodeGenerator {
    public static void main(String[] args) {
        // 1. 构建一个代码生成器对象
        AutoGenerator ag = new AutoGenerator();

        // 2. 配置策略
        // 2.1 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir"); //获取当前项目路径
        gc.setOutputDir(projectPath+"/src/main/java"); //将代码生成到项目路径下
        gc.setAuthor("John.Cena"); // 设置作者
        gc.setOpen(false); // 生成完是否打开文件夹
        gc.setFileOverride(true); // 是否覆盖文件
        gc.setServiceName("%sService"); // service文件名字格式
        gc.setIdType(IdType.AUTO); // 主键生成策略
        gc.setDateType(DateType.ONLY_DATE); // 日期格式
//        gc.setSwagger2(true); // 是否配置swagger
        ag.setGlobalConfig(gc);

        // 2.2 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL); // 数据库类型
        dsc.setDriverName("com.mysql.jdbc.Driver"); // 驱动名字
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8"); // url
        dsc.setUsername("root");
        dsc.setPassword("lishuang001219");
        ag.setDataSource(dsc);

        // 2.3 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.generator");
        ag.setPackageInfo(pc);

        // 2.4 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("tb_user"); // 设置要映射的表名
        sc.setNaming(NamingStrategy.underline_to_camel); // 设置类命名规则-下划线转驼峰
        sc.setColumnNaming(NamingStrategy.underline_to_camel); //设置字段命名规则
        sc.setEntityLombokModel(true); //是否使用Lombok
        sc.setRestControllerStyle(true); // controller采用restful风格
        //同时,也可以配置自动填充,逻辑删除,乐观锁等等...
        ag.setStrategy(sc);

        //使用Freemarker作为模板引擎
        ag.setTemplateEngine(new FreemarkerTemplateEngine());

        // 3. 执行代码生成器
        ag.execute();
    }
}
```

`新版`

```java
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8", "root", "lishuang001219")
                .globalConfig(builder -> {
                    builder.author("John.Cena") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式，这里开启的是对swagger2的支持
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(".\\src\\main\\java"); // 指定输出到项目路径下
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("generator"); // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tb_user") // 设置需要生成的表名
                            .addTablePrefix("tb_", "c_"); // 设置过滤表前缀
                })
                //使用freemark引擎要引入freemark的依赖
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
```

## 自动填充

创建时间、更改时间！ 这些操作一般都是自动化完成，我们不希望手动更新

阿里巴巴开发手册︰几乎所有的表都要配置`gmt_create`、`gmt_modified`这两个字段，而且需要自动化

### 方式一：数据库级别（工作中不允许修改数据库级别）
1. 在表中增加字段：create_time,update_time，并设置默认值为当前时间戳

<img src="https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2021/03/01/kuangstudy624d739f-d5b3-43c4-a9fd-c2b9fbca4530.png">

2. 更新实体类
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date createTime;//驼峰命名
    private Date updateTime;
}
```
3. 插入数据时，不用设置新增的两个字段，数据库会自动创建、更新

### 方式二：代码级别
1. 在表中增加字段：create_time,update_time，不用设置默认值

<img src="https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2021/03/01/kuangstudyc6de3b50-4e0d-4893-ad89-06efb2acf3b1.png">

2. 更新实体类，使用注解完成默认值操作
```java
//字段  字段添加填充内容
@TableField(fill = FieldFill.INSERT)//value = ("create_time"),
private Date createTime;

@TableField(fill = FieldFill.INSERT_UPDATE)
private Date updateTime;
```
3. 创建处理器
```java
@Slf4j//日志
@Component//注册组件
public class MyMetaObjectHandler extends MetaObjectHandler {//extends
    @Override//插入时的填充策略
    public void insertFill(MetaObject metaObject) {
        log.info("==start insert ······==");
        //setFieldValByName(java.lang.String fieldName, java.lang.Object fieldVal, org.apache.ibatis.reflection.MetaObject metaObject)
        this.setFieldValByName("createTIme",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
    @Override//更新时的填充策略
    public void updateFill(MetaObject metaObject) {
        log.info("==start update ······==");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
```
4. 插入数据时，不用设置新增的两个字段，数据库会自动创建、更新

## 逻辑删除

> 我们在删除的时候通常不会使用delete真正地对数据进行删除。而是使用一个标志字段，控制数据的展示

==注：如果3.3.0版本之前还需要在对应的逻辑字段上加上`@TableLogic`注解==

1. 在数据库表中加入一个标志字段，例如flag，用1表示删除，用0表示未删除
2. 在配置文件中配置逻辑删除

```xml
<bean id="dbConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig$DbConfig">
    <property name="tablePrefix" value="tb_" />
    <property name="idType" value="AUTO" />
    <!--全局逻辑删除字段名-->
    <property name="logicDeleteField" value="flag" />
    <!--用1表示逻辑已删除值-->
    <property name="logicDeleteValue" value="1" />
    <!--用0表示逻辑未删除值-->
    <property name="logicNotDeleteValue" value="0" />
</bean>

<bean id="globalConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig">
    <property name="dbConfig" ref="dbConfig" />
</bean>
```

3. 测试

```java
//查看控制台两条sql执行语句发现，逻辑删除已经实现
//UPDATE tb_user SET flag=1 WHERE id=? AND flag=0
//SELECT id,name,age,email,flag FROM tb_user WHERE id IN ( ? , ? , ? ) AND flag=0

@Test
public void testDeleteById(){
    //删除单个值
    userMapper.deleteById(1);
}

@Test//通过id查询多个用户
public void testSelectBatchIds(){
    List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
    users.forEach(System.out::println);
    //System.out.println(users);
}
```

## 乐观锁&悲观锁

乐观锁：顾名思义十分乐观，他总是认为不会出现问题，无论干什么都不上锁，如果出现了问题，再次更新值测试
悲观锁：顾名思义十分悲观，他总是认为出现问题，无论干什么都会上锁，再去操作!

### 乐观锁机制
1. 取出记录时，获取当前version
2. 更新时，带上这个version
3. 执行更新时，set version = newVersion where version = oldVersion，如果version不对，就更新失败

```sql
--乐观锁：先查询，获得版本号
-- A
update user set name = "wsk",version = version+1 
where id = 1 and version = 1
-- B  （B线程抢先完成，此时version=2，会导致A线程修改失败！）
update user set name = "wsk",version = version+1 
where id = 1 and version = 1
```

### MP中乐观锁的使用
1. 表中添加version字段
2. 实体类中添加属性
```java
//乐观锁version注解
@Version
private Integer version;
```
3. 注册组件，一般会把Mybatis的配置专门抽取出来，单独写一个配置类
```java
//扫描mapper文件夹
@MapperScan("com.wsk.mapper")//交给mybatis做的，可以让这个配置类做扫描
@EnableTransactionManagement//自动管理事务
@Configuration//配置类
public class MyBatisPlusConfig {
    //注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
```
4. 测试

`成功`

```java
@Test
public void test(){
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("id",3);
    User user = userMapper.selectOne(wrapper);

    user.setAge(25);
    int i = userMapper.updateById(user);
}
```

`失败`

```java
@Test
public void test(){
    User user1 = userMapper.selectById(1l);
    user1.setAge(1);
    user1.setName("线程一");

    //模拟线程插队
    User user2 = userMapper.selectById(1l);
    user2.setAge(100);
    user2.setName("线程二");

    userMapper.updateById(user2);
    userMapper.updateById(user1);
}
```

## CRUD
### 增

```java
@Test
public void testInsert(){
    User user = new User();
    user.setName("John.Cena");
    user.setAge(21);
    user.setEmail("349636607@qq.com");
    userMapper.insert(user);
}
```

### 删
```java
@Test
public void testDeleteById(){
    //删除单个值
    userMapper.deleteById(1);
}

@Test
public void testDeleteBatchIds(){
    ArrayList<Integer> integers = new ArrayList<Integer>();
    //删除多个值
    integers.add(2);
    integers.add(3);
    integers.add(4);
    userMapper.deleteBatchIds(integers);
}

@Test
public void testD(){
    HashMap<String, Object> map = new HashMap<String, Object>();
    //按条件删除，多个条件用and连接
    map.put("age","18");
    map.put("name","John.Cena");
    userMapper.deleteByMap(map);
}
```

### 改

```java
@Test
public void testUpdate(){
    User user = new User();
    user.setId(3);
    user.setName("John.Cena");
    user.setAge(22);
    user.setEmail("1111@qq.com");
    //修改对应Id的内容
    userMapper.updateById(user);
}
```

### 查

1. 通过id查询单个用户
```java
@Test//通过id查询单个用户
public void testSelectById(){
    User user = userMapper.selectById(1L);
    System.out.println(user);
}
```
2. 通过id查询多个用户
```java
@Test//通过id查询多个用户
public void testSelectBatchIds(){
    List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
    users.forEach(System.out::println);
    //System.out.println(users);
}
```
3. 条件查询，通过map封装
```java
@Test//通过条件查询之一  map
public void testMap(){
    HashMap<String, Object> map = new HashMap<>();
    //自定义要查询的
    map.put("name","www");
    map.put("age",18);
    List<User> users = userMapper.selectByMap(map);
    users.forEach(System.out::println);
}
```

### 逻辑删除
- 物理删除：从数据库中直接删除

- 逻辑删除：在数据库中没有被删除，而是通过一个变量来使他失效！ deleted=0 ==> deleted=1

实现：
1. 数据库添加delete字段
2. 实体类添加属性
```java
@TableLogic//逻辑删除注解
private Integer deleted;
```
3. 注册组件
```java
//逻辑删除组件
@Bean
public ISqlInjector sqlInjector(){
    return new LogicSqlInjector();
}
```
4. 添加配置
```properties
#配置逻辑删除  没删除的为0 删除的为1
mybatis-plus.global-config.db-config.logic-delete-value=1
mybatis-plus.global-config.db-config.logic-not-delete-value=0
```
5. 测试删除操作，会发现，数据库中的记录还在，只是deleted字段的值变变为了1，从日志中也可以看到，实际sql是写的更新操作

<img src="https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2021/03/01/kuangstudyc0ad8e44-da12-4a8f-9ad7-39229abcbdd0.png">