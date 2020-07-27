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
<body style="text-align: center;">
	<c:choose>
		<c:when test="${sessionScope.user==null }">
			<a href="${pageContext.request.contextPath }/Jsp/Login.jsp">用户登录</a>			
		</c:when>
		<c:otherwise>
			<c:if test="${sessionScope.user.identity == 'admin'}">
				<h3>管理员操作界面</h3>
				欢迎 ${sessionScope.user.username }!
					<div>
						<a href="${pageContext.request.contextPath }/Jsp/FindScore.jsp">查询  &nbsp; 成绩</a>
					</div>
					<div>
						<a href="${pageContext.request.contextPath }/Jsp/AddScore.jsp">录入  &nbsp; 成绩</a>
					</div>
					<div>
						<a href="${pageContext.request.contextPath }/Jsp/UpdDelScore.jsp">修改删除成绩</a>
					</div>
					<br/>
					<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>					
			</c:if>
			<c:if test="${sessionScope.user.identity == 'student'}">
				<div>你无权访问！！！</div>
				<a href="${pageContext.request.contextPath }/Jsp/Login.jsp">用户登录</a>	
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>