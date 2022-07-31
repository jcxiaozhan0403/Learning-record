<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> array=new ArrayList<>();
    array.add("h1");
    array.add("h2");
    array.add("h3");
    array.add("h4");
    request.setAttribute("list",array);
%>
<%--
    hs      每一次遍历出来的变量
    items   要遍历的的对象
    begin   从哪里开始
    end     到哪里结束
    step    步长
--%>
<c:forEach var="hs" items="${list}">
    <c:out value="${hs}"/><br>
</c:forEach>
</body>
</html>