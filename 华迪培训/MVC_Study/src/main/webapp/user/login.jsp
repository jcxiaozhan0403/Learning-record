<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/9/9
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../resource/css/bootstrap.css">
</head>
<body>
    <div align="center">
        <h3>用户登录</h3>
        <form class="form-group" action="<%=request.getContextPath()%>/user/doLogin2" method="get">
            <table class="table-bordered">
                <tr>
                    <td>用 户 名</td>
                    <td><input class="form-control" type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密 码</td>
                    <td><input class="form-control" type="password" name="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input class="btn-primary" type="submit" value="登录">
                        <input class="btn-primary" type="button" value="注册">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
