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
    <title>志愿云 - 新增用户</title>
    <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/static/css/manager.css" />">
    <link rel="stylesheet" href="<c:url value="/webjars/font-awesome/4.7.0/css/font-awesome.min.css" />">
</head>
<body>
    <jsp:include page="/WEB-INF/manager/include/nav.jsp" />
    <div class="container">
        <form id="userNew" method="post" action="<c:url value="/manager/user/create" />" class="needs-validation" novalidate>
            <h3 style="color: white;margin-bottom: 25px;">新增用户</h3>
            <c:if test="${msg != null}">
                <div class="alert alert-primary" role="alert">
                    <c:out value="${msg}" />
                </div>
                <c:remove var="msg" scope="session" />
            </c:if>
            <div class="form-group">
                <label for="loginId">登录名</label>
                <input type="text" class="form-control" id="loginId" name="loginId" placeholder="登录名" required minlength="4" maxlength="10" pattern="\w{4,10}">
                <small class="form-text text-muted">登录名是唯一的</small>
            </div>
            <div class="form-group">
                <label for="realName">真实姓名</label>
                <input type="text" class="form-control" id="realName" name="realName" placeholder="真实姓名" required pattern="[\u4e00-\u9fa5]{2,5}">
                <small class="form-text text-muted">务必填写真实姓名</small>
            </div>
            <div class="form-group">
                <label for="pwd1">密码</label>
                <input type="password" class="form-control" id="pwd1" name="pwd1" placeholder="密码" required minlength="6" maxlength="20">
                <small class="form-text text-muted">密码</small>
            </div>
            <div class="form-group">
                <label for="pwd2">确认密码</label>
                <input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="确认密码" required minlength="6" maxlength="20">
                <small class="form-text text-muted">请与第一次密码保持一致</small>
            </div>
            <button type="submit" class="btn btn-primary">提交</button>
        </form>
    </div>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</body>
</html>
