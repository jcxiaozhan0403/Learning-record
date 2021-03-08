<%--
  Created by IntelliJ IDEA.
  User: 爽
  Date: 2021/3/8
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr><td>f1</td><td>f2</td><td>f3</td></tr>
        <c:forEach var="i" begin="1" end="4">
            <tr><td>${i}</td><td></td><td></td></tr>
        </c:forEach>
    </table>

    <c:set var="gender" value="1"></c:set>
    <span>性别：</span>
    <label for="sex1"><input type="radio" id="sex1" name="sex" value="0" <c:if test="${gender == 1}">checked</c:if>>男</label>
    <label for="sex2"><input type="radio" id="sex2" name="sex" value="1" <c:if test="${gender == 0}">checked</c:if>>女</label>

</body>
</html>
