<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2021/1/16
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
  <title>首页</title>
  <style type="text/css">
    a {
      text-decoration: none;
      color: black;
      font-size: 18px;
    }
    h3 {
      width: 180px;
      height: 38px;
      margin: 100px auto;
      text-align: center;
      line-height: 38px;
      background: deepskyblue;
      border-radius: 4px;
    }
  </style>
</head>
<body>

<h3>
  <h1> <a href="${pageContext.request.contextPath}/user/main">点击进入列表页</a></h1>

  <h1> <a href="${pageContext.request.contextPath}/user/gologintext">登录页面</a></h1>
</h3>
</body>
</html>