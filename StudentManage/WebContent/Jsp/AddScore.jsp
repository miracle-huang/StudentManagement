<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统-录入成绩</title>
</head>
<body style="text-align: center;">
	<c:choose>
		<c:when test="${sessionScope.user.identity == 'admin'}">
			<div>输入下列信息进行分数录入</div>
			<br/>
			<form action="${pageContext.request.contextPath }/AddScoreServlet" method="post">
				<table align="center" cellpadding="0" cellspacing="0" border="1" width="600px">
					<tr>
						<td height="30" align="center">学生编号</td>
						<td><input type="text" name="stuId">${errerMsg}</td>
					</tr>
					<tr>
						<td height="30" align="center">学生姓名</td>
						<td><input type="text" name="stuName"></td>
					</tr>
					<tr>
						<td height="30" align="center">课程编号</td>
						<td><input type="text" name="courseId"></td>
					</tr>
					<tr>
						<td height="30" align="center">教师编号</td>
						<td><input type="text" name="tcId"></td>
					</tr>
					<tr>
						<td height="30" align="center">课程分数</td>
						<td><input type="text" name="courseGrade"></td>
					</tr>
					<tr>
						<td height="30" align="center">班级编号</td>
						<td><input type="text" name="classId"></td>
					</tr>
					<tr>
						<td height="30" colspan="2" align="center">
							<input type="submit" value="添加"/>
							&nbsp;&nbsp;
							<input type="reset" value="重置"/>
						</td>
					</tr>
				</table>
			</form>
			<br/>
			<%@ include file="Foot.jsp" %>
		</c:when>
		<c:otherwise>
			<c:if test="${sessionScope.user != null}">
					<div>你无权访问！！！</div><br/>
			</c:if>
			<a href="${pageContext.request.contextPath }/Jsp/Login.jsp">用户登录</a>	
		</c:otherwise>
	</c:choose>
</body>
</html>