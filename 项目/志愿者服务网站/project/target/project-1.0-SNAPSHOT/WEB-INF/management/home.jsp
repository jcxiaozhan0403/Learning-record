<%--
  Created by IntelliJ IDEA.
  User: 爽
  Date: 2021/4/21
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>志愿云管理中心</title>
    <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/static/css/manager.css" />">
    <link rel="stylesheet" href="<c:url value="/webjars/font-awesome/4.7.0/css/font-awesome.min.css" />">
</head>
<style>
    body {
        font-family: 楷体;
    }
</style>
<body>
    <jsp:include page="/WEB-INF/management/include/nav.jsp" />
    <div style="width: 400px;height: 200px;margin: 310px auto;line-height: 200px;text-align: center;color: #fff;font-size: 40px;">
        <p>志愿云管理中心</p>
    </div>
</body>
</html>
