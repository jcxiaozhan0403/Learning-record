<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>志愿云-登录页</title>
    <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/static/css/login.css" />">
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

    body {
        background-image: url(${loginbk});
        background-size: cover;
    }
</style>
<script type="text/javascript" src="<c:url value="/webjars/jquery/3.5.1/dist/jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.min.js" />"></script>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            const forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            const validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
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
<body>
<form class="form-signin needs-validation" method="post" action="<c:url value="/management/checkLogin" />" style="background-color: rgba(169,169,169,0.4);border-radius: 15px;" novalidate>
    <div class="text-center mb-4">
        <img class="mb-4" src="<c:url value="/static/images/logo.jpg" />" style="border-radius: 15px" width="72" height="72">
        <p style="font-size: 22px">志愿云管理中心</p>
    </div>

    <div class="form-label-group">
        <input type="text" id="loginId" name="loginId" class="form-control" placeholder="用户名" pattern="(\w|\W|\d){6,10}" required autofocus>
        <label for="loginId">用户名</label>
        <div class="invalid-feedback">
            用户名由6-10个字符组成，不能加汉字，符号
        </div>
        <div class="valid-feedback">
            用户名验证通过
        </div>
    </div>

    <div class="form-label-group">
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" pattern=".{6,20}" required>
        <label for="password">密码</label>
        <div class="invalid-feedback" id="demo">
            用户名或密码错误
        </div>
        <div class="valid-feedback">
            密码验证通过
        </div>
    </div>
    <c:if test="${sessionScope.loginMsg != null}">
        <div class="alertMsg" style="position: fixed;top: 70px;width: 373px;">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>注意</strong>
                <c:out value="${sessionScope.loginMsg}" />
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </div>
    </c:if>
    <c:remove var="loginMsg" scope="session" />
    <button class="btn btn-lg btn-primary btn-block" style="background-color: #4082d8; border-color: #4082d8" type="submit">登录</button>
    <p class="mt-5 mb-3 text-muted text-center">© 2021-2021</p>
</form>
</body>
</html>