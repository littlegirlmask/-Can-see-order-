<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品种类管理</title>
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
		<li class="active">菜品种类列表</li>
	</ul>

	<div class="row-fluid">
		<form class="form-search" style="padding: 5px" action="${pageContext.request.contextPath}/goods/goodstype/list" method="post">
			<label>菜品种类名称：</label> <input class="input-medium search-query"
				type="text" name="gtname" value="${param.gtname}" />
			<button type="submit" class="btn">查找</button>
			<button class="btn btn-success" type="button" 
			onclick="window.location.href='${pageContext.request.contextPath}/goods/goodstype/toadd';">增加</button>
		</form>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>菜品种类名称</th>
					<th>菜品种类状态</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.gtname}</td>
						<td>
							<c:choose>
								<c:when test="${item.gtstate==0}">
									不可用
								</c:when>
								<c:otherwise>
									可用
								</c:otherwise>
							</c:choose>
						</td>
						<td>
						<a href="${pageContext.request.contextPath}/goods/goodstype/toedit?id=${item.gtid}">编辑</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>