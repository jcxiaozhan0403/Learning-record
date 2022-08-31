<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改信息</title>
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
          <small>修改信息</small>
        </h1>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-1 offset-md-11 mb-3">
      <a class="btn btn-primary" href="<c:url value="/student/toStudentPage" />">返回</a>
    </div>
  </div>

  <form action="<c:url value="/student/update" />" method="post">
    <input type="hidden" name="id" value="${student.id}"/>
    <div class="form-group">
      <input type="text" id="name" name="name" class="form-control" placeholder="姓名" value="${student.name}" required autofocus>
    </div>

    <div class="form-group">
      <input type="text" id="age" name="age" class="form-control" placeholder="年龄" value="${student.age}" required autofocus>
    </div>

    <div class="form-group">
      <input type="text" id="sex" name="sex" class="form-control" placeholder="性别" value="${student.sex}" required autofocus>
    </div>

    <div class="form-group">
      <input type="text" id="cls" name="cls" class="form-control" placeholder="班级" value="${student.cls}" required autofocus>
    </div>

    <div class="form-group">
      <input type="text" id="num" name="num" class="form-control" placeholder="学号" value="${student.num}" required autofocus>
    </div>
    <button class="btn btn-primary" type="submit">修改</button>
  </form>
</div>