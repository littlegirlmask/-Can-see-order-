<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>'看得见餐厅'登录界面</title>
	<style type="text/css">
	h2 {
		color: black;
		font-family: 隶书;
	}
	
	.am {
		background: red;
		color: white;
	}
	</style>
</head>
<body  background="${pageContext.request.contextPath}/image/1.jpg"
		style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">
		<div style="height: 20px"></div>
		<div style="height: 20px"></div>
		<div style="height: 20px"></div>
		<div style="height: 20px"></div>
		<div style="height: 20px"></div>
		<div style="height: 20px"></div>
		<div style="height: 20px"></div>
		<div style="height: 20px"></div>
		<div style="height: 20px"></div>
		<h2 align="center">
			看得见餐厅
		</h2>
		<form method="post" action="${pageContext.request.contextPath}/login/login">
			<table align="center" border="1px" width="500" height="200">

				<tr>
					<td colspan="2">
						<font color=> 用户名:</font>
					</td>
					<td>
						<input type="text" name="username" value="${param.username}" size="60"
							style="background-color: transparent" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<font color=> 密码:</font>
					</td>
					<td>
						<input type="password" name="password" value="${param.password}" size="60"
							style="background-color: transparent" />
					</td>
				</tr>
				<tr>
					<td colspan="2"></td>
					<td>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<input type="submit" name="submit" value="登录"
							style="background-color: transparent"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
