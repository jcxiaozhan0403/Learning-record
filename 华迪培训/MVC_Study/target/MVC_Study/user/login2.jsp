<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ceshi</title>

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
	<div class="form-group" align="center">
		<h3>用户登录</h3>
	<form action="<%=request.getContextPath()%>/user/login" method="post">
		<table class="table-bordered" style="width: 400px;height: 200px">

			<tr>
				<td >用户名</td>
				<td><input class="form-control" type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input class="form-control" type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="form-control btn-primary" type="submit" value="登陆"></td>
			</tr>
		</table>
	</form>
	</div>
</div>

</body>
</html>