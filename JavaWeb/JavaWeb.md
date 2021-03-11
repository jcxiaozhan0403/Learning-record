## 数据库字段类型
```
Java   MySql
byte   tinyint
short  smallint
int    int
long   bigint
float  float
double double
char/String  char/varchar  
            char(8) 不够8位用空格补齐，超出8位报错 varchar(8) 存入几位就是几位，超出8位报错
Date  date/time/datetime/timestamp
        datetime如果未存值，会用null填充
        timestamp如果未存值，会用当前系统时间填充
File   BLOB/TEXT
```

## SQL语句
数据库操作
1. 创建数据库
```
create database 数据库名称 [character 字符集 collate 字符集校对规则]
```

2. 查看数据库
```
简单展示所有数据库
show databases

查看某一个数据库的定义信息
show create database 数据库名称
```

3. 修改数据库
```
alter database 数据库名称 character set 字符集 collate 校对规则
```

4. 删除数据库
```
drop database 数据库名
```

5. 查看当前所在数据库
```
select database()
```

表操作
1. 创建表
```
create table 表名(字段名 字段类型(长度) 约束,字段名 字段类型(长度) 约束)
```

2. 查看表
```
查看某个数据库下的所有表
show tables

查看某个表的结构信息
desc 表名
```

3. 删除表
```
drop table 表名
```

4. 修改表
```
添加列
alter table 表名 add 列名 类型(长度) 约束

修改列的类型、长度、约束
alter table 表名 modify 列名 类型(长度) 约束

删除列
alter table 表名 drop 列名

修改列名
alter table 表名 change 旧列名 新列名 类型(长度) 约束

修改表名
rename table 旧表名 to 新表名

修改表的字符集
alter table 表名 character set 字符集
```

表中数据操作
1. 添加表记录
```
向表中插入某些列
insert into 表名 (列名1,列名2...) values(值1,值2...)

向表中插入所有列
insert into 表名 values(值1,值2,值3...)

注:值的类型是字符串或者是日期类型，使用单引号引起来
```

2. 修改表记录
```
update 表名 set 列名=值,列名=值 [where 条件]
```

3. 删除表记录
```
删除表中某一行记录
delete from 表名 [where 条件]

删除表中所有记录
delete from 表名 //一条一条地删除，属于DML语句

truncate table user //删除整表，复制出有相同结构的表，属于DDL语句
```

4. 查询表记录
```
普通查询
distinct用于去掉重复值
select [distinct] * 列名 from 表名 [where 条件]

给查询列取别名显示
select [distinct] * 列名 别名 from 表名 [where 条件]

条件查询
where子句
>、<、>=、<=、<>、=
like 模糊查询
in 范围查询
条件关联and、or、not

排序查询
order by 字段名称 asc/desc //升序/降序  默认升序

多个排序条件
order by 字段1 asc/desc,字段2 asc/desc

聚合函数
括号里面放列名
sum() 求和
count() 计数
max() 最大值
min() 最小值
avg() 平均值

分组查询
group by 字段名
筛选分组后的结果用having
group by score having score>50
```

## 约束
添加外键
```
alter table 表名 add foreign key(字段) references 指向表名(字段)
```

## 多表设计
一对多:在多的一方创建外键指向一的一方的主键

多对多:需要创建第三张表(中间表),在中间表中至少有两个字段分别作为外键，指向多对多双方的主键

一对一:假设一对一是一个一对多关系，需要在多的一方创建外键指向一的一方的主键，将外键设置为唯一(unique)

## 多表查询
连接查询
1. 交叉查询 cross join
```
查询到两个表的笛卡尔积

select * from 表1 cross join 表2

selext * from 表1,表2
```

2. 内连接 inner join(inner可省略)
```
显式内连接
select * from 表1 inner join 表2 on 关联条件

隐式内连接
select * from 表1，,表2 where 关联条件
```

3. 外连接 outer join(outer可省略)
```
左外连接
select * from 表1 left outer join 表2 on 关联条件

右外连接
select * from 表1 right outer join 表2 on 关联条件
```

子查询
```
带in的子查询
select * from 表1 where 字段 in (子查询语句)

带exists的子查询
select * from 表1 where exists (子查询语句)  //子查询语句成立，显示查询结果

带any的子查询
select * from 表1 where 字段 > any (子查询语句)

带all的子查询
select * from 表1 where 字段 > all (子查询语句)
```

## 事务
事务指的是逻辑上的一组操作，组成这组操作的各个逻辑单元，要么全部成功，要么全部失败

事务流程
```
开启事务
start transaction

提交事务
commit

回滚事务
rollbak
```

JDBC中的事务管理
```
//开启事务(写于获取连接后)
conn.setAutoCommit(false);

//提交事务(写于SQL语句执行完毕后)
conn.commit();

//回滚事务(写于异常)
conn.rollback();
```

## 连接池

连接池是创建和管理一个连接的缓冲池的技术，这些连接准备好被任何需要它们的线程使用

连接池是装有连接的容器，使用连接的话，可以从连接池中获取，使用完成后将连接归还给连接池

Druid是阿里旗下的开源连接池，可以与Spring快速整合

## DBUtils

DBUtils是对JDBC的一个简单封装的工具类，简化了开发过程的同时，不会影响程序性能

## MVC开发模式
```
C: controller

M：model，业务模型层，完成业务处理
    dao层：直接操作数据库
    service层：调用dao层来完成业务实现，负责管理所调用的dao层

V：view 视图层，将处理结果响应到界面


Dao层角色：
  Dao接口层
  Dao实现层
Dao层命名规则：
  Dao接口层：com.xxx.dao [接口]：表名Dao
  Dao实现层：com.xxx.daoImpl [实现类]：表名DaoImpl

service层角色：
  service接口层
  service实现层
service层命名规则：
  service接口层：com.xxx.service [接口]:单表用表名Service，多表用业务名Service
  service实现层：com.xxx.service [接口]:单表用表名ServiceImpl，多表用业务名ServiceImpl
```

## Servlet
1. 创建javaweb项目
2. 在web/WEB-INF下创建lib目录，放入servlet-api.jar包
3. 创建类，调用Servlet接口，导入包和方法
4. 配置web.xml文件，添加如下配置
```xml
<servlet>
    <!-- 别名，任意取 -->
    <servlet-name>my</servlet-name>
    <!-- 类路径 -->
    <servlet-class>com.test.servlet.Servlet01</servlet-class>
    <!-- 启动优先级 -->
    <load-on-startup>0</load-on-startup>
</servlet>

<servlet-mapping>
    <servlet-name>my</servlet-name>
    <!-- 访问路径，任意取 -->
    <url-pattern>/myservlet</url-pattern>
</servlet-mapping>
```
5. Servlet3.0之后可以用注解方式来进行配置，如下
```java
@WebServlet(value = { "/ls" , "/demo" },loadOnStartup = 0)
public class Servlet01 extends HttpServlet {}
```

Servlet的三种使用方式
1. 调用Servlet接口，重写5个方法
2. 继承GenericServlet类，重写service方法
3. 继承HttpServlet类，重写doPost和doGet方法，分开处理两种类型的请求 (常用)

对传入的对象设置编码格式，用于解决表单提交时，post方法后台接收中文乱码问题
```java
req.setCharacterEncoding("utf-8");
```

设置响应内容的编码格式,用于响应内容回显时乱码问题
```java
response.setContentType("text/html;charset=UTF-8");
```

回显信息到页面
```java
PrintWriter printWriter = resp.getWriter();
printWriter.println("成功");
```

转发
多个资源共同处理同一个请求，地址栏不发生变化
```java
req.getRequestDispatcher("/xxx").forward(req,resp);
```

通过请求在服务器不同资源间传递数据
```java
req.setAttribute("键","值");
req.getAttribute("键");
```

重定向
重定向跳转相当于两次请求，所以无法通过请求进行数据传递
```java
resp.sendRedirect("/xxxx/demo");
```

Servlet的生命周期
1. 实例化
2. init 初始化
3. service 服务 多次
4. destory 销毁

## Cookie
1. 创建Cookie
```java
// 创建Cookie对象
Cookie cookie = new Cookie("键","值");
// 设置Cookie的访问路径
cookie.setPath("/demo"); //只对demo路径下的资源生效
// 设置Cookie的时效,>0 表示多少秒,=0 浏览器关闭,<0 浏览器关闭 ,默认-1
cookie.setMaxAge(-1);
// 将Cookie响应给客户端
resp.addCookie(cookie);
```
2. 获取Cookie
```java
Cookie[] cookies = req.getCookies();

for(Cookie cookie : cookies){
  system.out.println("name" + cookie.getName() + "value" + cookie.getValue());
}
```
3. 修改
当新设置的cookie与已存在的cookie的键值对和路径都相同时，会发生覆盖，时效会以新的cookie为准

设置和获取中文cookie
```java
// 设置
Cookie cookie = new Cookie(URLEncoder.encode("姓名","UTF-8"),URLEncoder.encode("张三","UTF-8"));
// 获取
Cookie[] cookies = req.getCookies();

for(Cookie cookie : cookies){
  system.out.println("name" + URLDecoder.decode(cookie.getName(),"UTF-8") + "value" + URLDecoder.decode(cookie.getValue(),"UTF-8"));
}
```

## Session
```java
// 通过request对象获取Session对象，Session对象是客户端第一次请求服务端自动创建的
HttpSession session = request.getSession();
// SessionID值会存放在Cookie里面，会话关闭后失效
System.out.println(session.getId());
```
session操作数据
```java
// 在同一次会话的任意位置，使用到的session是同一个
HttpSession session = request.getSession();
// 存放数据
session.setAttribute("键","值")
// 获取数据
session.getAttribute("键")
// 移除数据
session.removeAttribute("键")
```
session生命周期
1. 浏览器关闭自动销毁
2. session超出时效，自动销毁
```java
// 设置Session时效,单位秒
session.setMaxInactiveInterval(10)
```
3. 手动销毁
```java
session.invalidate();
```

## ServletContext
ServletContext是一个全局对象，项目启动时自动创建，项目关闭时才销毁
获取ServletContext对象的三种方式
```java
// 通过HttpServlet获取
ServletContext servletContext = this.getServletContext();
// 通过request对象获取
ServletContext servletContext = request.getServletContext();
// 通过session对象获取
ServletContext servletContext = session.getServletContext();
```

## 应用场景
1. 临时数据传递：HttpServletRequest
2. 登录状态管理：HttpSession
3. 访问次数统计：ServletContext

## 过滤器
过滤器是存在于客户端和服务端之间的一道程序，主要是为了解决多个Servlet共性代码冗余的问题

1. 创建过滤器
创建一个java类，继承Filter接口
```java
public class Demo implements Filter {

}
```
2. 让请求继续传递
```java
filterChain.doFilter(servletRequest,servletResponse);
```
3. web.xml配置Filter
```xml
<filter>
    <!-- 别名，任意取 -->
    <filter-name>my</filter-name>
    <!-- 类路径 -->
    <filter-class>com.test.filter.Filter</filter-class>
    <!-- 启动优先级 -->
    <load-on-startup>0</load-on-startup>
</filter>

<filter-mapping>
    <filter-name>my</filter-name>
    <!-- 拦截的资源路径，任意取 -->
    <url-pattern>/myservlet</url-pattern>
</filter-mapping>
```
4. 注解配置过滤器
```java
@WebFilter(value = "拦截的资源路径")
```
在一个Web应用中，可以开发编写多个Filter，这些Filter组合起来称为一个Filter链
Filter优先级
- 如果都为注解配置，按照类名的字符串顺序排列
- 如果都为xml配置，按照编写顺序，从上到下排列
- 如果xml优先级高于注解
- 如果既有注解，又有xml，会进行多次过滤

拦截器完成权限验证
```java
// 拆箱，完成类型转换
HttpServletRequest request = (HttpServletRequest)servletRequest;
HttpServletRequest response = (HttpServletResponse)servletResponse;
//获取session对象
HttpSession session = request.getSession();
//获取session内的信息
String str = (String)session.getAttribute("键");
//判断
if( str != null ){
  filterChain.doFilter(request,response);
}else{
  response.sendRedirect("/xxx/login.html");
}
```

## JSP
JSP是服务端页面，简化了servlet回传页面的功能

注解
```jsp
<!-- 这是html注解，会解析到DOM树中 -->

<%
  //这是java注释，会被解析到编译出的java源文件中
%>

<%--  这是jsp隐藏注释，只能在jsp中看见，不会被解析 --%>
```

插入成员变量
```jsp
<%
  int a = 10;
%>
```

插入成员变量和成员方法
```jsp
<%! 
  private int a = 10;
  public void demo(){

  }
%>
```

表达式块
```jsp
<%
  int count = 10;
%>
<!-- 结果会显示到前端页面上 -->
<%=count %>
```

指令语法
```jsp
<%@ 指令名 属性名=属性值 属性名=属性值 %>
```

JSP指令元素的分类
- page指令：指示JSP的页面设置属性和行为
- include指令：指示JSP包含哪些其他页面
- taglib指令：指示JSP页面包含哪些标签库

page指令的常用属性
```
import属性：用于导入包或类
contentType属性：标明JSP被浏览器解析和打开的时候采用的默认字符集
pageEncoding属性：JSP文件及编译后的Servlet保存到硬盘上采用的字符集
```

发生错误跳转至错误页面
```jsp
<%@ page errorPage="/error.jsp" %>
```

错误页面打印错误信息
```jsp
<%@ page isErrorPage="true" %>
<%=exception.getMessage() %>
```

include指令(静态联编)
用于包含页面，实质是将第二个页面完整复制了一份到第一个页面，编译时两个页面编入同一个java文件中，所以是先复制，在编译的顺序
```jsp
<!-- page1 -->
befor
<%@ include file="/page2.jsp" %>
after
```

两个jsp动作
这两个动作都是用于指向指定页面的，forward是转向，include是包含
- forward
- include(动态联编)

语法
```jsp
<jsp:动作名 属性名=属性值></jsp:动作名>
或
<jsp:动作名 属性名=属性值/>
```

静态联编和动态联编的区别
- 静态联编编译出一个Java文件
- 动态联编编译出多个Java文件

静态联编和动态联编的应用场景
- 在静态联编和动态联编都可用时，一般用静态联编
- 需要共享变量时，使用静态联编
- 存在同名变量需要区分时，用动态联编

## JSTL
JSTL是JSP标签库

## JSP与Servlet传参
设置
```java
String name = "李爽";
req.setAttribute("name",name);
```
获取
```jsp
<c:out value="${name}"></c:out>
<% out.print(request.getAttribute("name")); %>
<%=request.getAttribute("name")%>
```
