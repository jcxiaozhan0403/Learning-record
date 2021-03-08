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
    <p><c:out value="&lt这句换不使用转义字符&gt" escapeXml="true" default="默认值" /></p>
    <p><c:out value="&lt这句换使用转义字符&gt" escapeXml="false" default="默认值" /></p>
    <p><c:out value="${null}" escapeXml="false" default="默认值" /></p>

    <%--  <c:set>  --%>
    <p><c:set var="salary" scope="session" value="${2000*2}"/></p>

    <%--  <c:remove>  --%>
    <p>salary 变量值: <c:out value="${salary}"/></p>
    <c:remove var="salary"/>
    <p>删除 salary 变量后的值: <c:out value="${salary}"/></p>

    <%--  <c:catch>  --%>
    <c:catch var ="catchException">
        <% int x = 5/0;%>
    </c:catch>
    <p>${catchException}</p>

    <%--  <c:if>  --%>
    <c:if test="${salary > 2000}">
        <p>我的工资为大于2000<p>
    </c:if>

    <%--  <c:choose> <c:when> <c:otherwise> 类似于if-else --%>
    <c:choose>
        <c:when test="${salary <= 0}">
            太惨了。
        </c:when>
        <c:when test="${salary > 1000}">
            不错的薪水，还能生活。
        </c:when>
        <c:otherwise>
            什么都没有。
        </c:otherwise>
    </c:choose>

    <%--  <c:import>  --%>

    <%--   <c:forEach>   --%>
    <c:forEach var="i" begin="1" end="5">
        <p>我是一个中国人</p>
    </c:forEach>

    <%--  <c:forTokens>  --%>
    <c:forTokens items="google,runoob,taobao" delims="," var="name">
        <c:out value="${name}"/><p>
    </c:forTokens>

    <%--  <c:param>  --%>
    <h1>&lt;c:param&gt; 实例</h1>
    <c:url var="myURL" value="index.jsp">
        <c:param name="name" value="Runoob"/>
        <c:param name="url" value="www.runoob.com"/>
    </c:url>
    <a href="/<c:out value="${myURL}"/>">
        使用 &lt;c:param&gt; 为指定URL发送两个参数。</a>

    <%--  <c:redirect>  --%>
    <c:redirect url="http://www.runoob.com"/>

    <%--  <c:url>  --%>
    <a href="<c:url value="http://www.runoob.com"/>">
        这个链接通过 &lt;c:url&gt; 标签生成。
    </a>
</body>
</html>
