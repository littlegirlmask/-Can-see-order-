<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
<script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
	type="text/javascript"></script>
</head>
<body>
<ul class="breadcrumb">
		<li><a href="#">用户管理</a> <span class="divider">/</span></li>
		<li class="active">增加用户</li>
	</ul>
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<h4>提示!</h4>
		<strong>${msg}</strong> 
	</div>
	<div class="row-fluid">
		<div class="span12">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/sys/user/add"
				method="post">
				<div class="control-group">
					<label class="control-label" for="username">用户昵称:</label>
					<div class="controls">
						<input id="username" type="text" name="username" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="usertruename">真实姓名:</label>
					<div class="controls">
						<input id="usertruename" type="text" name="usertruename" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="rolename">用户角色:</label>
					<div class="controls">
						<select id="roleid" name="roleid">
							<c:forEach items="${list}" var="item">
								<option value="${item.roleid}">${item.rolename}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="userpwd">用户密码:</label>
					<div class="controls">
						<input id="userpwd" type="password" name="userpwd" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="usersex">用户性别:</label>
					<div class="controls">
						<select id="usersex" name="usersex">
							<option value="1">男</option>
							<option value="0">女</option>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="userstate">用户状态：</label>
					<div class="controls">
						<select id="userstate" name="userstate">
							<option value="1">可用</option>
							<option value="0">不可用</option>
						</select>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<input type="submit" class="btn" value="提交" />
						<button class="btn btn-primary" type="button">返回</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>