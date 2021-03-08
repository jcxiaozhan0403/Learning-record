<%--
  Created by IntelliJ IDEA.
  User: 爽
  Date: 2021/3/8
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    span{
        color:red;
    }
</style>
<body>
<%--    <p>--%>
<%--        <c:set var="name" value="李爽"/>--%>
<%--        我的名字是：<span><c:out value="${name}"></c:out></span>--%>
<%--    </p>--%>

<%--    <c:set var="score" value="75" />--%>
<%--    <c:if test="${score >= 90}">--%>
<%--        优秀--%>
<%--    </c:if>--%>

<%--    <c:choose>--%>
<%--        <c:when test="${score >= 90}">优秀</c:when>--%>
<%--        <c:when test="${score >= 70}">良好</c:when>--%>
<%--        <c:when test="${score >= 60}">及格</c:when>--%>
<%--        <c:otherwise>不及格</c:otherwise>--%>
<%--    </c:choose>--%>

<%--    <c:set var="gender" value="1" />--%>
<%--    <c:choose>--%>
<%--        <c:when test="${gender == 0}">女性</c:when>--%>
<%--        <c:when test="${gender == 1}">男性</c:when>--%>
<%--        <c:otherwise>你是个嘛玩意儿</c:otherwise>--%>
<%--    </c:choose>--%>

    <c:set var="gender" value="1"></c:set>
    <span>性别：</span>
    <label for="sex1"><input type="radio" id="sex1" name="sex" value="0" <c:if test="${gender == 1}">checked</c:if>>男</label>
    <label for="sex2"><input type="radio" id="sex2" name="sex" value="1" <c:if test="${gender == 0}">checked</c:if>>女</label>

</body>
</html>
