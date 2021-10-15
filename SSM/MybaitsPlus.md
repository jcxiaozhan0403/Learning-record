## 快速入门
1. 测试数据
```sql
drop table if exists user;

create table user
(
	id bigint(20) not null comment '主键id',
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
2. 创建SpringBoot项目，导入pom依赖
```xml
<!-- 数据库连接依赖 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<!-- lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
<!-- MybatisPlus -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.4.0</version>
</dependency>
```
4. 编写数据库连接配置
```properties
spring.datasource.username=root
spring.datasource.password=lishuang001219
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis_plus?useSSL=false&userUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8
```
5. 实体类
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```
6. Mapper
```java
@Mapper
// 用Mpper注解标记
public interface UserMapper extends BaseMapper<User> {
    // 继承BaseMapper完成大部分CRUD操作
}
```
7. 启动类
```java
// 添加注解扫描项目中的Mapper
@MapperScan("cn.com.mybatisplus.mapper")
@SpringBootApplication
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
```
8. 测试
```java
@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;
    
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
```

## 配置日志
```properties
# 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

## 主键生成策略
在插入数据时如果不设置主键。默认会使用雪花算法生成一个唯一id

雪花算法：
snowflake是Twitter开源的分布式ID生成算法，结果是一个long型的ID。其核心思想是：使用41bit作为毫秒数，10bit作为机器的ID（5个bit是数据中心（北京、香港···），5个bit的机器ID），12bit作为毫秒内的流水号（意味着每个节点在每毫秒可以产生 4096 个 ID），最后还有一个符号位，永远是0。

选择主键的生成策略
```java
// 实体类添加注解
@TableId(type = IdType.AUTO)
private Long id;
```
```java
public enum IdType {
    AUTO, //数据库id自增，如果选择此方式，数据库主键也必须添加自增属性
    INPUT, //手动输入，选择此方式，如果插入时没有id字段，会默认用null填充
    ID_WORKER, //默认的全局唯一id 雪花算法
    UUID, //全球唯一id  uuid
    NONE;//未设置主键
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
@Component//丢到springboot里   一定不要忘记把处理器加到Ioc容器中!
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

## 乐观锁&悲观锁
乐观锁：顾名思义十分乐观,他总是认为不会出现问题,无论干什么都不上锁!如果出现了问题,再次更新值测试
悲观锁：顾名思义十分悲观,他总是认为出现问题,无论干什么都会上锁!再去操作!

### 乐观锁机制
1. 取出记录时，获取当前version
2. 更新时，带上这个version
3. 执行更新时，set version = newVersion where version = oldVersion，如果version不对,就更新失败

```sql
--乐观锁：先查询，获得版本号
-- A
update user set name = "wsk",version = version+1 
where id = 1 and version = 1
-- B  （B线程抢先完成，此时version=2，会导致A线程修改失败！）
update user set name = "wsk",version = version+1 
where id = 1 and version = 1
```

### MybatisPlus中乐观锁的使用
1. 表中添加version字段
2. 实体类中添加属性
```java
@Version//乐观锁version注解
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
- 成功
```java
@Test//测试乐观锁成功
public void testOptimisticLocker1(){
    //1、查询用户信息
    User user = userMapper.selectById(1L);
    //2、修改用户信息
    user.setAge(18);
    user.setEmail("2803708553@qq.com");
    //3、执行更新操作
    userMapper.updateById(user);
}
```
- 失败
```java
@Test//测试乐观锁失败  多线程下
public void testOptimisticLocker2(){
    //线程1
    User user1 = userMapper.selectById(1L);
    user1.setAge(1);
    user1.setEmail("2803708553@qq.com");
    //模拟另外一个线程执行了插队操作
    User user2 = userMapper.selectById(1L);
    user2.setAge(2);
    user2.setEmail("2803708553@qq.com");
    userMapper.updateById(user2);
    //自旋锁来多次尝试提交！
    userMapper.updateById(user1);//如果没有乐观锁就会覆盖插队线程的值
}
```

## 分页查询
1. 注册分页插件
```java
 //分页插件
// 最新版
@Bean
public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
    return interceptor;
}
```
2. 测试
```java
@Test//测试分页查询
public void testPage(){
    //参数一current：当前页   参数二size：页面大小
    //使用了分页插件之后，所有的分页操作都变得简单了
    Page<User> page = new Page<>(2,5);
    userMapper.selectPage(page,null);
    page.getRecords().forEach(System.out::println);
    System.out.println("总页数==>"+page.getTotal());
}
```

## CRUD
### 查询
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

### 删除
```java
@Test
public void testDeleteById(){
    userMapper.deleteById(1359507762519068681L);
}
@Test
public void testDeleteBatchIds(){
  userMapper.deleteBatchIds(Arrays.asList(1359507762519068675L,1359507762519068676L));
}
@Test
public void testD(){
    HashMap<String, Object> map = new HashMap<>();
    map.put("age","18");
    map.put("name","lol");
    userMapper.deleteByMap(map);
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