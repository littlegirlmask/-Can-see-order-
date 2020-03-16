<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
<style type="text/css">
.info{
	line-height:30px;
}

</style>
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
	<ul class="breadcrumb" style="line-height:60px">
		<li><a href="#">订单管理</a> <span class="divider">/</span></li>
		<li class="active">订单列表</li>
	</ul>

	<div class="row-fluid">
		<form class="form-search" style="padding: 5px" action="${pageContext.request.contextPath}/sys/order/list" method="post">
			
		</form>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>订单号码</th>
					<th>用户名</th>
					<th>总价</th>
					<th>订单创建时间</th>
					<th>订单状态</th>
					<th>操作</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cusorderlist }" var="item">
					<tr class="info">
						<td>${item.orderid }</td>
						<td>${item.nickname }</td>
						<td>${item.ordertotleprice }元</td>
						<td><fmt:formatDate value="${item.ordertime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<c:choose>
								<c:when test="${item.orderstate==1 }">
									等待制作，再等一哈儿
								</c:when>
								<c:otherwise>
									正在制作，就快要好了
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${item.orderstate==1 }">
									<a href="${pageContext.request.contextPath}/sys/order/stating?id=${item.orderid }" class="btn btn-info">处理</a>
								</c:when>
								<c:otherwise>
									<button class="btn btn-info">处理中</button>
									<a href="${pageContext.request.contextPath}/sys/order/stated?id=${item.orderid }" class="btn btn-warning">完成</a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>菜品</th>
						<th>份数</th>
						<th>预计时间</th>
					</tr>
					<c:forEach items="${orderdetaillist }" var="dlist">
						<c:if test="${item.orderid==dlist.orderid}">
							<tr>	
								<td>${dlist.gname }</td>
								<td>${dlist.odcount }</td>
								<td>${dlist.gtime }分钟  x  ${dlist.odcount }份</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach> 
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
function getXhr(){
	var xhr = null;
    if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器
    } else if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();//非IE浏览器
    }
    return xhr;
}
</script>
</html>