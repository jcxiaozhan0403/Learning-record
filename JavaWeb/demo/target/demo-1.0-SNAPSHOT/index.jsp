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
    hs 储存便遍历的数据
    items 被遍历的的对象
--%>
<c:forEach var="hs" items="${list}">
    <c:out value="${hs}"/><br>
</c:forEach>
<hr>
<c:forEach var="hs" items="${list}" varStatus="">
</c:forEach>
</body>
</html>