<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
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
		<li><a href="#">角色管理</a> <span class="divider">/</span></li>
		<li class="active">角色列表</li>
	</ul>

	<div class="row-fluid">
		<form class="form-search" style="padding: 5px" action="${pageContext.request.contextPath}/sys/role/list" method="post">
			<label>角色名：</label> <input class="input-medium search-query"
				type="text" name="rolename" value="${param.rolename}" />
			<button type="submit" class="btn">查找</button>
			<button class="btn btn-success" type="button" 
			onclick="window.location.href='${pageContext.request.contextPath}/sys/role/toadd';">增加</button>
		</form>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>角色名称</th>
					<th>角色状态</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.rolename}</td>
						<td>
							<c:choose>
								<c:when test="${item.rolestate==0}">
									不可用
								</c:when>
								<c:otherwise>
									可用
								</c:otherwise>
							</c:choose>
						</td>
						<td>
						<a href="${pageContext.request.contextPath}/sys/role/toedit?id=${item.roleid}">编辑</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>