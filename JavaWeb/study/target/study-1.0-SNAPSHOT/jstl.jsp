<%--
  Created by IntelliJ IDEA.
  User: 爽
  Date: 2021/3/5
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL核心标签</title>
</head>
<body>
    <%-- <c:out> --%>
    <c:out value="&lt这句换不使用转义字符&gt" escapeXml="true" default="默认值"></c:out>
    <br>
    <c:out value="&lt这句换使用转义字符&gt" escapeXml="false" default="默认值"></c:out>
    <br>
    <c:out value="${null}" escapeXml="false" default="默认值"></c:out>

    <%--  <c:set>  --%>
    <c:set var="salary" scope="session" value="${2000*2}"/>
    <c:out value="${salary}"/>
</body>
</html>
