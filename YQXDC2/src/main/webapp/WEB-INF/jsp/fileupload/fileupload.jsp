<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<h1>文件上传</h1>
	<!-- 
		要上传文件，那么：
		method：必须是post
		enctype:必须是multipart/form-data
	 -->
	<form action="${pageContext.request.contextPath}/test/upload" 
		method="post" enctype="multipart/form-data">
		<div>文件名称：<input type="text" name="filename"></div>
		<div>选择文件：<input type="file" name="file"></div>
		<div>
			<input type="submit" value="上传文件">
		</div>
	</form>
</body>
</html>