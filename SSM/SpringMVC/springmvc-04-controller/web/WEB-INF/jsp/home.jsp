
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/e/t1" method="post">
        <input type="text" name="name">
        <input type="submit" value="提交">
    </form>
    ${msg}
</body>
</html>
