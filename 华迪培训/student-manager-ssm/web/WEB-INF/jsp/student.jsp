<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.usebootstrap.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    body {
        background-image: linear-gradient(to top, #a8edea 0%, #fed6e3 100%);
    }
</style>
<body>

<div class="container">

    <div class="row clearfix mt-5">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>学生列表</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-1 offset-md-11 mb-3">
            <a class="btn btn-primary" href="<c:url value="/student/add" />">新增</a>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" style='vertical-align: middle;text-align: center;'>
                <thead>
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>班级</th>
                    <th>学号</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
<%--                <c:forEach var="student" items="${list}">--%>
<%--                    <tr>--%>
<%--                        <td>${student.id}</td>--%>
<%--                        <td>${student.name}</td>--%>
<%--                        <td>${student.age}</td>--%>
<%--                        <td>${student.sex}</td>--%>
<%--                        <td>${student.cls}</td>--%>
<%--                        <td>${student.num}</td>--%>
<%--                        <td>--%>
<%--                            <a class="btn btn-primary" href="<c:url value="/student/edit/${student.id}" />" style="margin-right: 10px">修改</a>--%>
<%--                            <a class="btn btn-danger" href="<c:url value="/student/delete/${student.id}" />">删除</a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <nav aria-label="...">
            <ul class="pagination">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">上一页</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item active">
                    <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                </li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">下一页</a>
                </li>
            </ul>
        </nav>
    </div>
</div>