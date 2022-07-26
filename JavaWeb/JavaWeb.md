## 基本概念

> web：web（World Wide Web）即全球广域网，也称为万维网，它是一种基于超文本和HTTP的、全球性的、动态交互的、跨平台的分布式图形信息系统。是建立在Internet上的一种网络服务，为浏览者在Internet上查找和浏览信息提供了图形化的、易于访问的直观界面，其中的文档及超级链接将Internet上的信息节点组织成一个互为关联的网状结构。
>
> web实质上就是网页

- 静态web：
  - html、css
  - 提供给用户的页面始终不会发生改变

- 动态web：
  - Servlet/JSP、ASP、PHP
  - 提供给用户的页面数据会发生改变，每个人在不同时间、不同地点看到的信息各不相同

在Java中，动态web资源开发的技术统称为JavaWeb

## TomCat

### 目录结构

bin：存放一些可执行的脚本文件，启动关闭之类的

conf：配置文件

lib：依赖的jar包

logs：日志文件

temp：临时文件

webapps：发布网站的文件夹

### 访问TomCat

bin目录下的可执行文件

`startup.bat`：启动服务器

`shutdown.bat`：关闭服务器

默认访问地址：https://localhost:8080

## 网站的访问流程

1. 输入网址，按下回车
2. 检索主机的hosts配置文件下有无域名映射
   - 有：直接返回对应的IP地址
   - 无：检索DNS服务器，找到对应的IP地址就返回，没有的话返回404

## Http

> Http（超文本传输协议）是一个简单的请求响应协议，它运行在TCP上面

### 两个时代

第一个时代(Http/1.0)：客户端与web服务器连接后，只能获取一个web资源，断开连接

第二个时代(Http/1.1)：客户端与web服务器连接后，可以获取多个web资源

### Http请求

#### 请求行

请求方式：GET, POST, OPTIONS, PUT, DELETE, TRACE, CONNECT...

- GET：请求能够携带的参数较少，大小有限制，会在浏览器的URL地址栏显示数据内容，不安全但高效
- POST：请求能够携带的参数没有限制，大小没有限制，不会在浏览器的URL地址栏显示数据内容，安全但不高效

#### 消息头

```
Accept: 支持的数据类型
Accept-Encoding: 支持的编码格式
Accept-Language: 语言环境
Cache-Control: 缓存控制
Connection: 请求完毕后的连接状态
Host: 主机
...
```

### 状态码

200：请求成功

404：找不到资源

3xx：请求重定向

5xx：服务器错误

## Maven

概念：在JavaWeb开发中，需要使用大量的jar包，手动导入太过繁琐，所以我们使用Maven来自动导入

==核心思想：约定大于配置，非不要不配置，使用默认值有时会达到最好的效果==

### Maven安装配置

1. 下载解压
2. 配置环境变量
   - `M2_HOME`：maven根目录下的bin目录
   - `MAVEN_HOME`：maven的根目录
   - 添加path变量：`%MAVEN_HOME%\bin`

3. 测试环境配置

```
mvn -version
```

4. 修改配置文件`conf/settings.xml`，添加阿里云镜像，提升下载速度

```xml
<mirror>
    <id>aliyunmaven</id>
    <mirrorOf>*</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```

5. 手动指定本地仓库，在maven根目录新建仓库文件夹`maven-repo`，添加如下配置

```
<localRepository>D:\environment\Maven\apache-maven-3.8.3\maven-repo</localRepository>
```

### Maven资源导出问题

我们在开发过程中可能会遇到导出失败的问题，在`pom.xml`文件添加如下配置

```xml
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>
</build>
```

## Servlet

### HelloServlet

1. 创建javaweb Maven项目
2. 修改`web.xml`文件到tomcat标准版本

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
  version="3.1"
  metadata-complete="true">

</web-app>
```

3. `pom.xml`中导入servlrt依赖

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
</dependency>
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>javax.servlet.jsp-api</artifactId>
    <version>2.3.3</version>
</dependency>
```

4. 创建java类，继承HttpServlet类，重写方法

```java
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
```

5. 在`web.xml`中配置servlet映射

```xml
<!-- 配置servlet类 -->
<servlet>
    <!-- 别名，任意取 -->
    <servlet-name>helloServlet</servlet-name>
    <!-- 类路径 -->
    <servlet-class>com.test.servlet.HelloServlet</servlet-class>
    <!-- 启动优先级，一般不用 -->
    <load-on-startup>0</load-on-startup>
</servlet>

<!-- 配置servlet映射 -->
<servlet-mapping>
    <servlet-name>helloServlet</servlet-name>
    <!-- 访问路径 -->
    <url-pattern>/HelloServlet</url-pattern>
</servlet-mapping>
```

```java
//servlet3.0可以通过注解来配置映射
@WebServlet(value = { "/HelloServlet" , "/demo" },loadOnStartup = 0)
public class Servlet01 extends HttpServlet {}
```

6. 访问

```
http://localhost:8080/HelloServlet
```

### Mapping映射问题

一个Servlet可以指定一个映射路径

```xml
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

一个Servlet可以指定多个映射路径

```xml
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello2</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello3</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello4</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello5</url-pattern>
</servlet-mapping>
```

一个Servlet可以指定通用映射路径

```xml
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello/*</url-pattern>
</servlet-mapping>
```

默认请求路径

```xml
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/*</url-pattern>
</servlet-mapping>
```

指定一些后缀或者前缀等等…

```xml
<!-- 注意，*前面不能加项目映射的路径-->
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>*.demo</url-pattern>
</servlet-mapping>
```

优先级问题：指定了固有的映射路径优先级最高，如果找不到就会走默认的处理请求

```xml
<!--404-->
<servlet>
    <servlet-name>error</servlet-name>
    <servlet-class>com.kuang.servlet.ErrorServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>error</servlet-name>
    <url-pattern>/*</url-pattern>
</servlet-mapping>
```

### ServletContext

> ServletContext是一个全局对象，项目启动时自动创建，项目关闭时才销毁，全局唯一，可以通过它来实现**数据共享**，但是不建议使用，因为获取多个ServletContext对象会占用服务器资源，我们一般使用session来传递数据

获取ServletContext对象的三种方式

```java
// 通过HttpServlet获取
ServletContext servletContext = this.getServletContext();
// 通过request对象获取
ServletContext servletContext = request.getServletContext();
// 通过session对象获取
ServletContext servletContext = session.getServletContext();
```

#### 数据共享

这个Servlet中保存的数据，可以在另外一个servlet中拿到

```java
public class DemoServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.getInitParameter() 初始化参数
        //this.getServletConfig() Servlet配置
        //this.getServletContext() Servlet上下文
        ServletContext context = this.getServletContext();
        String username = "小明"; //数据
        
        //将一个数据保存在了ServletContext
        context.setAttribute("username",username);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

```java
public class DemoServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //从ServletContext获取username值的对象出来
        String username = (String) context.getAttribute("username");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("名字:"+username);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

#### 获取初始化参数

```xml
<!--配置一些web应用初始化参数-->
<context-param>
    <param-name>application-name</param-name>
    <param-value>学习Servlet</param-value>
</context-param>
```

```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
    ServletContext context = this.getServletContext();
    //获取初始化参数
    String url = context.getInitParameter("application-name");
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");
    resp.getWriter().print(url);
}
```

#### 请求转发

```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext context = this.getServletContext();

    //调用forward实现请求转发
    //requestDispatcher.forward(req,resp); 
    context.getRequestDispatcher("/demo3").forward(req,resp);
}
```

#### 读取资源文件

```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //使用相对路径来引入资源文件
    InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/db.properties");
    Properties prop = new Properties();
    prop.load(is);
    String user = prop.getProperty("username");
    String pwd = prop.getProperty("password");
    resp.getWriter().print(user+":"+pwd);
}
```

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

## 文件下载
```java
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得请求文件名
        String filename = request.getParameter("filename");
        System.out.println(filename);

        //设置文件MIME类型
        response.setContentType(getServletContext().getMimeType(filename));
        //设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename="+filename);
        //读取目标文件，通过response将目标文件写到客户端
        //获取目标文件的绝对路径
        String fullFileName = getServletContext().getRealPath("/download/" + filename);
        //System.out.println(fullFileName);
        //读取文件
        InputStream in = new FileInputStream(fullFileName);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        //循环取出流中的数据
        while((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }

        in.close();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

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
// SessionID值是打开客户端时就自动创建的，会存放在Cookie里面，会话关闭后自动销毁
System.out.println(session.getId());
```

### 操作session
```java
// 在同一次会话的任意位置，使用到的session是同一个
HttpSession session = request.getSession();
// 设置session
session.setAttribute("键","值")
// 获取session值
session.getAttribute("键")
// 移除session
session.removeAttribute("键")
```

### session生命周期
1. 浏览器关闭时自动销毁
2. session超出时效，自动销毁
```java
// 设置session时效，单位秒，设置为负数永不失效
session.setMaxInactiveInterval(10)
```
```xml
<!--xml方式设置Session默认的失效时间-->
<session-config>
  <!--15分钟后Session自动失效，以分钟为单位-->
  <session-timeout>15</session-timeout>
</session-config>
```
3. 手动销毁
```java
session.invalidate();
```

## Session应用场景
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

过滤器完成权限验证
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
- JSP是服务端页面，简化了servlet回传页面的功能
- JSP本质上就是一个Servlet，在Tomcat服务器的工作区我们可以看到，jsp页面在运行时都被转换为了java文件，进行执行，查看此文件我们可以发现，它将我们所写的所有页面元素转换为了Java中的写法

### jsp基础语法
注解
```jsp
<!-- 这是html注解，会解析到DOM树中 -->

<%
  //这是java注释，会被解析到编译出的java源文件中
%>

<%--  这是jsp隐藏注释，只能在jsp中看见，编译时不会被解析 --%>
```
jsp表达式
```jsp
<%-- jsp表达式
    作用：用来将程雪输出，写到客户端
    <%= 变量名/表达式%>
--%>
<%= new java.util.Date()%>
```
jsp脚本片段
```jsp
<%-- jsp脚本片段 --%>
<%
    int sum=0;
    for (int i = 0; i < 10; i++) {
        sum+=i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
%>
<%-- 嵌入正常的标签 --%>
<%
    int x=10;
    out.print(x);
%>
<p>这是一个jsp文档</p>
<%
    int y=20;
    out.print(20);
%>
<%-- ------------------------------------ --%>
<%-- 在代码中嵌入html元素 --%>
<%
    for (int i = 0; i < 5; i++) {
%>
<h1>HelloWorld,<%= new java.util.Date()%></h1>
<%
    }
%>
```
```jsp
<%-- 在代码中嵌入html元素 --%>
<%
    for (int i = 0; i < 5; i++) {
%>
<h1>HelloWorld,<%= new java.util.Date()%></h1>
<%
    }
%>
```

### jsp指令
JSP指令元素的分类
- page指令：指示JSP的页面设置属性和行为
- include指令：指示JSP包含哪些其他页面
- taglib指令：指示JSP页面包含哪些标签库

xml配置错误页
```xml
<error-page>
    <error-code>404</error-code>
    <location>/error/404.jsp</location>
</error-page>
<error-page>
    <error-code>500</error-code>
    <location>/error/500.jsp</location>
</error-page>
```

指令语法
```jsp
<%@ 指令名 属性名=属性值 属性名=属性值 %>
```
page指令的常用属性
```
import属性：用于导入包或类
contentType属性：标明JSP被浏览器解析和打开的时候采用的默认字符集
pageEncoding属性：JSP文件及编译后的Servlet保存到硬盘上采用的字符集
```
```jsp
<!-- 导入jar包 -->
<%@ page import="java.util.Date" %>
<!-- 指定错误页面 -->
<%@ page errorPage="error/500.jsp" %>
<!-- 显示的声明这是一个错误页面 -->
<%@ page isErrorPage="true" %>
<!-- 页面编码格式 -->
<%@ page pageEncoding="utf-8" %>
```

include指令(静态联编)
用于包含页面，实质是将第二个页面完整复制了一份到第一个页面，编译时两个页面编入同一个java文件中，所以是先复制，在编译的顺序，如果两个文件中都使用了java代码，可能会存在变量冲突的问题
```jsp
<!-- page1 -->
befor
<%@ include file="/page2.jsp" %>
after
```

静态联编和动态联编的区别
- 静态联编编译出一个Java文件
- 动态联编编译出多个Java文件

静态联编和动态联编的应用场景
- 在静态联编和动态联编都可用时，一般用动态联编
- 需要共享变量时，使用静态联编
- 存在同名变量需要区分时，用动态联编

### 9大内置对象
- PageContext
- Request
- Response
- Session
- Application
- config
- out
- page
- exception

四种作用域
```jsp
<%
  pageContext.setAttribute("name1","val1"); // 仅在页面生效
  request.setAttribute("name2","val2"); // 在一次请求中生效
  session.setAttribute("name3","val3"); // 在一次会话中生效(打开浏览器到关闭浏览器)
  application.setAttribute("name4","val4"); //在服务器中生效，从服务器打开到关闭
%>
```

## JSP标签、JSTL标签、EL表达式
### JSP标签
```jsp
<!-- forward是转发 -->
<jsp:forward page="/page2.jsp" />
<!-- include是包含，是动态联编 -->
<jsp:include page="/page2.jsp"/>
```

### JSTL标签
引入标签核心库
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```
```jsp
<!-- 用于在JSP中显示数据，就像<%= ... > -->
<c:out>
<!-- 用于保存数据 -->
<c:set>
<!-- 用于删除数据 -->
<c:remove>
<!-- 与我们在一般程序中用的if一样 -->
<c:if>
<!-- 本身只当做<c:when>和<c:otherwise>的父标签 -->
<c:choose>
<!-- <c:choose>的子标签，用来判断条件是否成立 -->
<c:when>
<!-- <c:choose>的子标签，接在<c:when>标签后，当<c:when>标签判断为false时被执行 -->
<c:otherwise>
<!-- 基础迭代标签，接受多种集合类型 -->
<c:forEach>    
<!-- 使用可选的查询参数来创造一个URL -->
<c:url>
```
c:if
```jsp
<%@ page contenttype="text/html;charset=utf-8" language="java" %>
<%--引入jstl核心标签库，我们才能使用核心标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>title</title>
</head>
<body>
<h4>if测试</h4>
<hr>
<form action="jstlcore1.jsp" method="get">
<%--
    el表达式获取表单中的数据：
    ${param.参数名}
--%>
<input type="text" name="username" value="${param.username}">
<input type="submit" value="登录">
</form>
<%--判断如果是管理员就登陆成功--%>
<c:if test="${param.username=='admin'}" scope="page" var="isadmin">
<c:out value="<h3>登录成功<h3>"/>
</c:if>
<c:out value="${isadmin}"/>
</body>
</html>
```
c:choose
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Title</title>
</head>
<body>
<c:set var="score" value="50"/>
<c:choose>
<c:when test="${score>=60}">
    <c:out value="成绩合格"/>
</c:when>
<c:otherwise>
    <c:out value="需要补考"/>
</c:otherwise>
</c:choose>
</body>
</html>
```
c:forEach
```jsp
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> array=new ArrayList<>();
    array.add("h1");
    array.add("h2");
    array.add("h3");
    array.add("h4");
    request.setAttribute("list",array);
%>
<%--
    hs 储存便遍历的数据
    items 被遍历的的对象
--%>
<c:forEach var="hs" items="${list}">
    <c:out value="${hs}"/><br>
</c:forEach>
<hr>
<c:forEach var="hs" items="${list}" varStatus="">  
</c:forEach>
</body>
</html>
```

## 过滤器
在客户端与服务端中间加上一层，拦截请求，做出一些特殊处理，比如解决乱码问题
```java
public class CharecterFilter  implements Filter {
    /**
     * web服务器启动执行该方法
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化了...");
    }
    /**
     * 1. 过滤中的所有代码，在过滤特定请求的时候都会执行
     * 2. 必须要让过滤器继续同行
     * @param req
     * @param resp
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("filter执行前...");
        chain.doFilter(req,resp); //放行，如果不写，程序会被拦截
        System.out.println("filter执行后...");
    }
    //web服务器关闭，执行方法
    @Override
    public void destroy() {
        System.out.println("filter销毁了...");
    }
}
```
在web.xml中配置
```xml
<filter>
  <filter-name>CharecterFilter</filter-name>
  <filter-class>com.bug.filter.CharecterFilter</filter-class>
</filter>
<filter-mapping>
  <filter-name>CharecterFilter</filter-name>
  <url-pattern>/servlet/*</url-pattern>
</filter-mapping>
```

## 监听器
监测网站在线人数（基于session）
```java
public class OnlineListen implements HttpSessionListener {
    /**
     * 监听session新创建时执行的方法
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        System.out.println("sessionId:" + se.getSession().getId());
        Integer onlineCount = (Integer) sc.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = 1;
        } else {
            onlineCount++;
        }
        sc.setAttribute("onlineCount",onlineCount);
    }
    /**
     * 监听session销毁时执行方法
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        Integer onlineCount = (Integer) sc.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = 0;
        } else {
            getSession().invalidate();
            onlineCount--;
        }
        System.out.println("销毁session了--监听到");
        sc.setAttribute("onlineCount",onlineCount);
    }
}
```
web.xml中配置
```xml
<!--监听器-->
<listener>
  <listener-class>com.bug.listener.OnlineListen</listener-class>
</listener>
```

## 文件上传
### 前端
```jsp
<!-- 文件上传必须为post请求-->
<!-- 表单必须加上一个enctype="multipart/form-data"属性 -->
<!-- 用type="file"的input进行文件上传 -->
<form action="${pageContext.request.contextPath}/upload.do" method="post" enctype="multipart/form-data">
    上传用户: <input type="text" name="username"><br/>
    上传文件：<input type="file" name="file"><br/>
    <input type="submit" value="提交">
</form>
```
### 后端
1. 引入依赖
```xml
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.4</version>
</dependency>
```
2. 文件处理servlet
```java
public class FileUpload extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //判断用户上传的文件是普通表单还是带文件的表单，如果是普通文件直接返回
      if (!ServletFileUpload.isMultipartContent(request)) {
          return;
      }
      //创建文件上传保存的路径，在WEB-INF路径下是安全的，用户无法直接访问上传文件
      //小：上传文件
      String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
      System.out.println(uploadPath);
      File uploadFile = new File(uploadPath);
      if (!uploadFile.exists()){
          uploadFile.mkdir();
      }
      //临时路径,如果文件好过了预期大小，就把他放到一个临时文件中，过几天自动删除，或者提醒用户转存为永久
      //大：临时上传文件---qq
      String tmpPath = this.getServletContext().getRealPath("WEB-INF/tmp");
      File file = new File(tmpPath);
      if (!file.exists()){
          file.mkdir();
      }
      //处理上传的文件，一般通过流来获取，可以使用request.getInputStream(),原生态的文件上传流获取，十分麻烦
      //建议使用 Apache的文件上传组件来实现，common-fileupload，它需要依赖于 commons-io组件；
      //1、创建DiskFileItemFactory对象，处理文件上传路径或大小的限制
      DiskFileItemFactory factory = getDiskFileItemFactory(uploadFile);
      //2、获取ServletFileUpload
      ServletFileUpload upload = getServletFileUpload(factory);
      //3、处理上传的文件
      try {
          String msg = uploadParseRequest(upload,request,uploadPath);
          //将数据发给前端
          request.setAttribute("msg",msg);
          request.getRequestDispatcher("msg.jsp").forward(request,response);
      } catch (FileUploadException e) {
          e.printStackTrace();
      }
  }
  public static DiskFileItemFactory getDiskFileItemFactory(File file){
      DiskFileItemFactory factory = new DiskFileItemFactory();
      //通过这个工厂设置一个缓冲区，当上传的文件大于这个缓冲区的时候，将他放到临时文件中
      factory.setSizeThreshold(1024*1024); //缓冲区大小为1M
      factory.setRepository(file);//临时文件保存的目录，需要一个File
      return factory;
  }
  public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory){
      ServletFileUpload upload = new ServletFileUpload(factory);
      //监听文件上传进度
      upload.setProgressListener(new ProgressListener() {
          @Override
          //pBytesRead:已经读取到的文件大小
          //pContentLength ： 文件大小
          public void update(long pBytesRead, long pContentLength, int pItems) {
              System.out.println("总大小："+pContentLength+"已上传"+pBytesRead);
          }
      });
      //处理乱码问题
      upload.setHeaderEncoding("utf-8");
      //设置单个文件的最大值
      upload.setFileSizeMax(1024*1024*10);
      //设置总共能够上传文件的大小
      upload.setSizeMax(1024 * 1024 * 10);
      return upload;
  }
  public static String uploadParseRequest(ServletFileUpload upload, HttpServletRequest request, String uploadPath) throws FileUploadException, IOException {
      String msg = "";
      //把前端请求解析，封装成一个FileItem对象（表单中的输入项）
      List<FileItem> fileItems = upload.parseRequest(request);
      for (FileItem fileItem : fileItems) {
          if (fileItem.isFormField()){
              String name = fileItem.getFieldName();
              String value = fileItem.getString("UTF-8");
              System.out.println(name+":"+value);
          }else {
              //****************************处理文件****************************
              //拿到文件名字
              String uploadFileName = fileItem.getName();
              System.out.println("上传的文件名："+uploadFileName);
              if (uploadFileName.trim().equals("") || uploadFileName==null){
                  continue;
              }
              //获得上传的文件名
              String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/")+1);
              //获得文件的后缀名
              String fileExName = uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
              /*
              * 如果文件后缀名fileExName不是所需的直接return，不进行处理，告诉用户文件类型不对
              * */
              System.out.println("文件信息 [文件名："+fileName+"---文件类型"+fileExName+"]");
              //可以使用UUID（唯一识别通用码）保证文件名唯一
              String uuidPath = UUID.randomUUID().toString();
              //****************************处理文件完毕****************************
              //真实存在的路径
              String realPath = uploadPath+"/"+uuidPath;
              //给每个文件创建一个对应的文件夹
              File realPathFile = new File(realPath);
              if (!realPathFile.exists()){
                  realPathFile.mkdir();
              }
              //****************************存放地址完毕*****************************
              //获得文件上传的流
              InputStream inputStream = fileItem.getInputStream();
              //创建一个文件输出流
              //realPath是真实的文件夹
              FileOutputStream fos = new FileOutputStream(realPath + "/"+fileName);
              //创建一个缓冲区
              byte[] buffer = new byte[1024 * 1024];
              //判断是否读取完毕
              int len = 0;
              while ((len=inputStream.read(buffer))>0){
                  fos.write(buffer,0,len);
              }
              //关闭流
              fos.close();
              inputStream.close();
              msg = "文件上传成功";
              fileItem.delete();//上传成功，清除临时文件
              //*************************文件传输完毕**************************
          }
      }
      return msg;
  }
}
```

## 邮件发送

### 基本原理
要在网络上实现邮件功能，必须要有专门的邮件服务器。这些邮件服务器类似于现实生活中的邮局，它主要负责接收用户投递过来的邮件，并把邮件投递到邮件接收者的电子邮箱中。
邮件的收发遵循两种协议：
- SMTP协议：通常把处理用户smtp请求(邮件发送请求)的服务器称之为SMTP服务器(邮件发送服务器)。
- POP3协议：通常把处理用户pop3请求(邮件接收请求)的服务器称之为POP3服务器(邮件接收服务器)。

SMTP服务器地址：一般是 smtp.xxx.com，比如163邮箱是smtp.163.com，qq邮箱是smtp.qq.com。

### Java邮件发送流程

<img src="./邮件发送.png">

### 发送简单邮件
1. 导入依赖
```xml
<!-- https://mvnrepository.com/artifact/mail.jar/mail.jar -->
<dependency>
    <groupId>mail.jar</groupId>
    <artifactId>mail.jar</artifactId>
    <version>1.4</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.activation/activation -->
<dependency>
    <groupId>javax.activation</groupId>
    <artifactId>activation</artifactId>
    <version>1.1.1</version>
</dependency>
```
2. 编写发送类
```java
public class SendEamil {
    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
        //创建一个配置文件并保存
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.qq.com");
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");
        //QQ存在一个特性设置SSL加密，其他邮箱不用编写
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("619046217@qq.com","16位授权码");
            }
        });
        //开启debug模式，控制台打印发送过程
        session.setDebug(true);
        //获取连接对象
        Transport transport = session.getTransport();
        //连接服务器
        transport.connect("smtp.qq.com","619046217@qq.com","16位授权码");
        //创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);
        //邮件发送人
        mimeMessage.setFrom(new InternetAddress("619046217@qq.com"));
        //邮件接收人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("875203654@qq.com"));
        //邮件标题
        mimeMessage.setSubject("Hello Mail");
        //邮件内容
        mimeMessage.setContent("我的想法是把代码放进一个循环里","text/html;charset=UTF-8");
        //发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        //关闭连接
        transport.close();
    }
}
```

### 复杂文件发送
发送多媒体带附件的邮件
```java
public class SendComplexEmail {
    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");  设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码
        // QQ邮箱设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        //1、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //传入发件人的姓名和授权码
                return new PasswordAuthentication("619046217@qq.com","16位授权码");
            }
        });
        //2、通过session获取transport对象
        Transport transport = session.getTransport();
        //3、通过transport对象邮箱用户名和授权码连接邮箱服务器
        transport.connect("smtp.qq.com","619046217@qq.com","16位授权码");
        //4、创建邮件,传入session对象
        MimeMessage mimeMessage = complexEmail(session);
        //5、发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        //6、关闭连接
        transport.close();
    }
    public static MimeMessage complexEmail(Session session) throws MessagingException {
        //消息的固定信息
        MimeMessage mimeMessage = new MimeMessage(session);
        //发件人
        mimeMessage.setFrom(new InternetAddress("619046217@qq.com"));
        //收件人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("619046217@qq.com"));
        //邮件标题
        mimeMessage.setSubject("带图片和附件的邮件");
        //邮件内容
        //准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler handler = new DataHandler(new FileDataSource("E:\\IdeaProjects\\WebEmail\\resources\\测试图片.png"));
        image.setDataHandler(handler);
        image.setContentID("test.png"); //设置图片id
        //准备文本
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一段文本<img src='cid:test.png'>","text/html;charset=utf-8");
        //附件
        MimeBodyPart appendix = new MimeBodyPart();
        appendix.setDataHandler(new DataHandler(new FileDataSource("E:\\IdeaProjects\\WebEmail\\resources\\测试文件.txt")));
        appendix.setFileName("test.txt");
        //拼装邮件正文
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(image);
        mimeMultipart.addBodyPart(text);
        mimeMultipart.setSubType("related");//文本和图片内嵌成功
        //将拼装好的正文内容设置为主体
        MimeBodyPart contentText = new MimeBodyPart();
        contentText.setContent(mimeMultipart);
        //拼接附件
        MimeMultipart allFile = new MimeMultipart();
        allFile.addBodyPart(appendix);//附件
        allFile.addBodyPart(contentText);//正文
        allFile.setSubType("mixed"); //正文和附件都存在邮件中，所有类型设置为mixed
        //放到Message消息中
        mimeMessage.setContent(allFile);
        mimeMessage.saveChanges();//保存修改
        return mimeMessage;
    }
}
```