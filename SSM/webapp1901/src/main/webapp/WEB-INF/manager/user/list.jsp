<%--
  Created by IntelliJ IDEA.
  User: 爽
  Date: 2021/4/21
  Time: 18:32
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
    <title>今日校园 - 用户列表</title>
    <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/static/css/manager.css" />">
    <link rel="stylesheet" href="<c:url value="/webjars/font-awesome/4.7.0/css/font-awesome.min.css" />">
</head>
<body>
    <jsp:include page="/WEB-INF/manager/include/nav.jsp" />
    <table class="table" id="userList">
        <tr>
            <th>编号</th>
            <th>登录名</th>
            <th>真实姓名</th>
            <th>密码</th>
            <th>登陆次数</th>
            <th>最后登录时间</th>
        </tr>
        <c:forEach items="${managers}" var="model">
            <tr>
                <td>${model.id}</td>
                <td>${model.loginid}</td>
                <td>${model.realname}</td>
                <td>******</td>
                <td>${model.logincount}</td>
                <td><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${model.lastlogindt}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
