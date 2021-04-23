<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>今日校园-登录页</title>
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
</style>
<script type="text/javascript" src="<c:url value="/webjars/jquery/3.5.1/dist/jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.min.js" />"></script>
<script>
    window.onload = init;
    function init() {
        const flag ='<%=request.getParameter("error")%>';
        if(flag == 'yes'){
            alert("用户名或密码错误，请重新登录！");
        }
    }
</script>
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
<form class="form-signin needs-validation" method="post" action="<c:url value="/manager/checkLogin" />" novalidate>
    <div class="text-center mb-4">
        <img class="mb-4" src="<c:url value="/static/images/logo.jpg" />" style="border-radius: 15px" width="72" height="72">
        <p>健康填报</p>
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
        <div class="invalid-feedback">
            用户名或密码错误
        </div>
        <div class="valid-feedback">
            密码验证通过
        </div>
    </div>
    <button class="btn btn-lg btn-primary btn-block" style="background-color: #00dfdb; border-color: #00dfdb" type="submit">登录</button>
    <p class="mt-5 mb-3 text-muted text-center">© 2021-2021</p>
</form>
</body>
</html>