<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2021/6/28
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>志愿云 - 操作日志</title>
    <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/static/css/manager.css" />">
</head>
<style>
    body {
        font-family: 楷体;
    }
</style>
<body>
<jsp:include page="/WEB-INF/manager/include/nav.jsp" />
<div class="container">
    <h3 style="color: white;margin-bottom: 25px;">操作日志</h3>
    <table class="table" style="text-align: center; color: #fff; margin: 0 auto; width: 90%">
        <tr>
            <th>编号</th>
            <th>时间</th>
            <th>管理员ID</th>
            <th>事件</th>
        </tr>
        <c:forEach items="${logs}" var="model">
            <tr>
                <td>${model.id}</td>
                <td><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${model.time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td>${model.loginid}</td>
                <td>${model.event}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
