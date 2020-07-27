<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="Model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统</title>
</head>
<body>
	
	<br/>
	<c:choose>
		<c:when test="${sessionScope.user==null }">
		<a href="${pageContext.request.contextPath }/Jsp/Login.jsp">用户登录</a>
		</c:when>
		<c:otherwise>
			<form action="${pageContext.request.contextPath }/ExitServlet" method="post">
				<input type="submit" value="返回">
			</form>	
			欢迎你，${sessionScope.user.username }!
			<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
		</c:otherwise>
	</c:choose>
</body>
</html>