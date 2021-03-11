<%--
  Created by IntelliJ IDEA.
  User: 爽
  Date: 2021/3/10
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<c:url value="/EditServlet" />" method="post">
        <label>内容：</label>
        <input type="text" name="content">
        <button type="submit">提交</button>
    </form>
</body>
</html>
