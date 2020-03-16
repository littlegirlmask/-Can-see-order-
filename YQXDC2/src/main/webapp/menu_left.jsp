<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>menu_left page</title>
		<style type="text/css">
			a{
				text-decoration:none;
			}
		</style>
	</head>
	<body>
		<a href="sys/role/list" target="main">角色管理</a><br/>
		<div style="height:20px"></div>
		<a href="sys/user/list" target="main">用户管理</a><br/>
		<div style="height:20px"></div>
		<a href="goods/goodstype/list" target="main">菜品类别管理</a><br/>
		<div style="height:20px"></div>
		<a href="goods/list" target="main">菜品管理</a><br/>
		<div style="height:20px"></div>
		<a href="sys/order/list" target="main">订单管理</a><br/>
		<div style="height:20px"></div>
		<a href="sys/order/list" target="main">统计分析</a><br/>
		<div style="height:20px"></div>
		<a href="login/login" target="_top">退出登录</a><br/>
	 </body>
</html>
