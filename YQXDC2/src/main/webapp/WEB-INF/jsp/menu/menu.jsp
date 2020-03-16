<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>menu page</title></head>
  <frameset rows="20%,*">
	  <frame src="${pageContext.request.contextPath}/top.jsp">
	 <frameset cols="20%,*">
	    <frame src="${pageContext.request.contextPath}/menu_left.jsp">
	    <frame name="main">
	 </frameset>
  </frameset>

</html>
