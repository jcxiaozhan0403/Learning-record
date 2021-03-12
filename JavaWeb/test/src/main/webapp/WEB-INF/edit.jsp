<%--
  Created by IntelliJ IDEA.
  User: 爽
  Date: 2021/3/12
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

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
<body>
<div class="container">
    <form class="needs-validation" method="post" action="<c:url value="/sava" />" novalidate>
        <div class="form-group">
            <label>编号</label>
            <input type="text" class="form-control" name="on" placeholder="请输入编号" required>
            <small class="form-text text-muted">编号是唯一的，用于找回账号</small>
            <!-- <div class="valid-feedback">用户名可用</div> -->
            <div class="invalid-feedback">用户名由6~20个字符组成</div>
        </div>
        <div class="form-group">
            <label>姓名</label>
            <input type="text" class="form-control" name="name" placeholder="请输入姓名" required>
        </div>
        <div class="form-group">
            <label>出生日期</label>
            <input type="date" class="form-control" name="birth" required>
            <small class="form-text text-muted">范围1900-2020</small>
        </div>
        <div class="form-group">
            <label>地址</label>
            <input type="text" class="form-control" name="address" placeholder="请输入地址" required>
            <small class="form-text text-muted">用户名由6~20个字符组成</small>
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
    </form>
</div>
</body>
</html>
