<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品种类管理-增加</title>
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
		<li><a href="#">菜品种类管理</a> <span class="divider">/</span></li>
		<li class="active">增加菜品种类</li>
	</ul>
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<h4>提示!</h4>
		<strong>${msg}</strong> 
	</div>
	<div class="row-fluid">
		<div class="span12">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/goods/goodstype/add"
				method="post">
				<div class="control-group">
					<label class="control-label" for="gtname">菜品种类名称</label>
					<div class="controls">
						<input id="gtname" type="text" name="gtname" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="gtstate">菜品种类状态</label>
					<div class="controls">
						<select id="gtstate" name="gtstate">
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