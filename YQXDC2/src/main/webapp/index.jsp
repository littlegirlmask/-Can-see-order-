<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>看得见点餐系统</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
<script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
	type="text/javascript"></script>
<style type="text/css">
*{
margin:0;
padding:0;
}
.container{
width:100%;
height:960px;
}
.header{
height:80px;
background-color:red;
}
.left{
float:left;
width:30%;
background-color:red;
height:720px;
}
.right{
float:right;
width:70%;
background-color:blue;
height:720px;
}
#iframe0{
width:100%;
height:720px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header"></div>
		<div class="main">
			<div class="left">
				<a href="${pageContext.request.contextPath}/sys/role/toadd" target="iframe0">角色</a><br>
				<a href="http://www.sina.com.cn" target="iframe">新浪</a>
			</div>
			<div class="right">
				<iframe id="iframe0"></iframe>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>