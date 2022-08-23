<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2021/3/28
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>
    首页
</h1>

<span>${username}</span>
<p>
    <a href="${pageContext.request.contextPath}/user/goOut">注销 </a>
</p>
</body>
</html>
