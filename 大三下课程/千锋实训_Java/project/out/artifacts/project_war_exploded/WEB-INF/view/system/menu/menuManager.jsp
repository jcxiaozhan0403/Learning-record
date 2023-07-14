<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/15
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
</head>
 <frameset cols="200,*" border="1">
     <frame src="${pageContext.request.contextPath}/sys/toMenuLeft.action" name="left">
     <frame src="${pageContext.request.contextPath}/sys/toMenuRight.action" name="right">
 </frameset>
</html>
