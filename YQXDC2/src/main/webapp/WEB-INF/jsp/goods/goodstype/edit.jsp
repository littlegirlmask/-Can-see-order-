<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑菜品种类</title>
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
		<li class="active">修改菜品种类</li>
	</ul>
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<h4>提示!</h4>
		<strong>${msg}</strong> 
	</div>
	<div class="row-fluid">
		<div class="span12">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/goods/goodstype/edit"
				method="post">
				<div class="control-group">
					<label class="control-label" for="gtname">菜品种类名称</label>
					<div class="controls">
						<input id="gtname" type="text" name="gtname" value="${goodstype.gtname}" />
						<input type="hidden" name="gtid" value="${goodstype.gtid}" >
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="gtstate">菜品种类状态</label>
					<div class="controls">
						<select id="gtstate" name="gtstate">
							<c:choose>
								<c:when test="${goodstype.gtstate==0}">
									<option value="1">可用</option>
									<option value="0" selected="selected">不可用</option>
								</c:when>
								<c:otherwise>
									<option value="1" selected="selected">可用</option>
									<option value="0">不可用</option>
								</c:otherwise>
							</c:choose>
							
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