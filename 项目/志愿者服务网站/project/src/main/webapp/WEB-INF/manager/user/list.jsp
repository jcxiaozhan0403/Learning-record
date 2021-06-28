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
    <title>志愿云 - 用户列表</title>
    <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/static/css/manager.css" />">
</head>
<body>
    <jsp:include page="/WEB-INF/manager/include/nav.jsp" />
    <div class="container">
        <h3 style="color: white;margin-bottom: 25px;">用户管理</h3>
        <c:if test="${msg != null}">
            <div class="alert alert-primary" role="alert">
                <c:out value="${msg}" />
            </div>
            <c:remove var="msg" scope="session" />
        </c:if>
        <table class="table" id="userList">
            <tr>
                <th>编号</th>
                <th>登录名</th>
                <th>真实姓名</th>
                <th>密码</th>
                <th>登陆次数</th>
                <th>最后登录时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${managers}" var="model">
                <tr>
                    <td>${model.id}</td>
                    <td>${model.loginid}</td>
                    <td>${model.realname}</td>
                    <td>******</td>
                    <td>${model.logincount}</td>
                    <td><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${model.lastlogindt}"/></td>
                    <td>
                        <a href="<c:url value="/manager/user/edit?id=${model.id}" />">修改</a>
                        <a href="<c:url value="/manager/user/delete?id=${model.id}" />" onclick="return confirm('确认删除？');">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
