<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
</head>
    <body>
    <c:forEach begin="0" end="10">
        <h1>我是一个中国人</h1>
    </c:forEach>

    <c:out value="${name}"></c:out>
    <% out.print(request.getAttribute("name")); %>
    <%=request.getAttribute("name")%>
    </body>
</html>