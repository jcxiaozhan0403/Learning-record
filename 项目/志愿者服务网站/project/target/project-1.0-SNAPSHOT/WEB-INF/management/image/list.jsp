<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2021/6/25
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>
    body {
        font-family: 楷体;
    }

    img {
        width: 500px;
        height: 300px;
    }

    .list .list-item {
        float: left;
        width: 500px;
        margin: 10px 32px 10px 0;
    }

    .list .list-item:nth-child(6n) {
        margin-right: 0;
    }

    .list .list-item .poster img {
        width: 500px;
        height: 220px;
    }

    .clearfix::after {
        content: "";
        display: block;
        clear: both;
    }

    div.title {
        text-align: center;
        color: #fff;
    }
</style>
<body>
<jsp:include page="/WEB-INF/management/include/nav.jsp" />
<div class="container">
    <h3 style="color: white;margin-bottom: 25px;">图片管理</h3>
    <c:if test="${msg != null}">
        <div class="alert alert-primary" role="alert">
            <c:out value="${msg}" />
        </div>
        <c:remove var="msg" scope="session" />
    </c:if>
    <div class="list clearfix">
        <div class="list-item">
            <img src="${images.page1}">
            <div class="title">文明川信</div>
            <button class="btn btn-primary" data-toggle="modal" data-target="#modal1">修改</button>
            <a href="${images.page1}" target="_blank"><button class="btn btn-primary">下载</button></a>
        </div>
        <div class="list-item">
            <img src="${images.page2}">
            <div class="title">川信志愿者</div>
            <button class="btn btn-primary" data-toggle="modal" data-target="#modal2">修改</button>
            <a href="${images.page2}" target="_blank"><button class="btn btn-primary">下载</button></a>
        </div>
        <div class="list-item">
            <img src="${images.page3}">
            <div class="title">雷锋热线</div>
            <button class="btn btn-primary" data-toggle="modal" data-target="#modal3">修改</button>
            <a href="${images.page3}" target="_blank"><button class="btn btn-primary">下载</button></a>
        </div>
        <div class="list-item">
            <img src="${images.login}">
            <div class="title">登录页</div>
            <button class="btn btn-primary" data-toggle="modal" data-target="#modalLogin">修改</button>
            <a href="${images.login}" target="_blank"><button class="btn btn-primary">下载</button></a>
        </div>
    </div>
    <%-- 修改图片对话框 --%>
    <div class="modal" id="modal1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">修改图片<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span></button></div>
                <form method="post" action="<c:url value="/management/image/update" />">
                    <div class="modal-body">
                        <span>当前图片地址：${images.page1}</span>
                        <input hidden name="name" value="page1">
                        <input class="form-control mt-3" type="text" placeholder="请输入新的图片地址" name="url">
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn" type="button">取消</button>
                        <button class="btn btn-primary" type="submit">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
     <div class="modal" id="modal2">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">修改图片<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span></button></div>
                <form method="post" action="<c:url value="/management/image/update" />">
                    <div class="modal-body">
                        <span>当前图片地址：${images.page2}</span>
                        <input hidden name="name" value="page2">
                        <input class="form-control mt-3" type="text" placeholder="请输入新的图片地址" name="url">
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn" type="button">取消</button>
                        <button class="btn btn-primary" type="submit">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
     <div class="modal" id="modal3">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">修改图片<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span></button></div>
                <form method="post" action="<c:url value="/management/image/update" />">
                    <div class="modal-body">
                        <span>当前图片地址：${images.page3}</span>
                        <input hidden name="name" value="page3">
                        <input class="form-control mt-3" type="text" placeholder="请输入新的图片地址" name="url">
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn" type="button">取消</button>
                        <button class="btn btn-primary" type="submit">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
     <div class="modal" id="modalLogin">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">修改图片<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span></button></div>
                <form method="post" action="<c:url value="/management/image/update" />">
                    <div class="modal-body">
                        <span>当前图片地址：${images.login}</span>
                        <input hidden name="name" value="login">
                        <input class="form-control mt-3" type="text" placeholder="请输入新的图片地址" name="url">
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn" type="button">取消</button>
                        <button class="btn btn-primary" type="submit">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
