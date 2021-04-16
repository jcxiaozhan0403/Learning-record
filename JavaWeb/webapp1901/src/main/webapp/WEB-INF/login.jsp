<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/static/css/login.css" />">
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">--%>
</head>
<style>
    .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
    }

    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
            font-size: 3.5rem;
        }
    }
</style>
<%--<c:url value="webjars/jquery/3.5.1/"></c:url>--%>
<%--<script src=""></script>--%>
<body class="text-center">
<form class="form-signin">
    <img class="mb-4" src="https://img.jcxiaozhan.top/%E7%BD%91%E7%AB%99%E5%B0%8F%E5%9B%BE%E6%A0%87.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required="" autofocus="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="密码" required="">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> 记住我
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    <p class="mt-5 mb-3 text-muted">© 2019-2021</p>
</form>
</body>
</html>