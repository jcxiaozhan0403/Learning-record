<%--
  Created by IntelliJ IDEA.
  User: 爽
  Date: 2021/3/10
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Servlet传参</title>
</head>
<body>
<h1>我叫<c:out value="${name}" />，我今年<c:out value="${age}岁" /></h1>
</body>
</html>
