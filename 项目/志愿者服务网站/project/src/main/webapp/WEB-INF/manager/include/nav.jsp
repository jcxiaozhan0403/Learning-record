<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2021/5/17
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="<c:url value="/webjars/jquery/3.5.1/dist/jquery.min.js" />"></script>
<script src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.bundle.min.js" />"></script>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="<c:url value="/manager/home" />">
        <img src="<c:url value="/static/images/logo.jpg" />" style="width: 38px;height: 38px;border-radius: 10px">
        <span style="font-size: 18px">志愿云管理中心</span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/manager/home" />">首页 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">用户管理</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="<c:url value="/manager/user/list" />">用户列表</a>
                    <a class="dropdown-item" href="<c:url value="/manager/user/new" />">新增用户</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/manager/image/list" />">图片管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/manager/log" />">操作日志</a>
            </li>

            <li class="nav-item active" id="userName">
                <a class="nav-link">你好，<c:out value="${ sessionScope.currentUser.realname}" />！</a>
            </li>
            <li class="nav-item" id="logout">
                <a class="nav-link" href="<c:url value="/manager/logout" />">注销</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
