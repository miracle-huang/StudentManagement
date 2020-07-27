<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="Model.Grade"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统-修改删除成绩</title>
</head>
<body  style="text-align: center;">
	<c:choose>
			<c:when test="${sessionScope.user.identity == 'admin'}">
			<div >
				<form action="${pageContext.request.contextPath }/FindScoreServlet" method = "post">
				    <input name="func" type="hidden" value="update">成绩查询方式：学号查询<br/>
				    <input name="id" type="text">${errerMsg}
				    <input type="submit" value="查询">
				</form>
			</div>
			<br/>
		     <table align="center" cellpadding="5" cellspacing="5" border="1">
		    <%
		    ArrayList<Grade> list=(ArrayList<Grade>) session.getAttribute("grade"); 
		    if(list!=null&&list.size()!=0){%>
		        <tr>
		     	<td colspan="8" align="center">学号为<%=list.get(0).getStuId() %>的学生成绩如下</td>
		     	</tr>
		    <tr>
		         <td>学生学号</td>
		         <td>学生姓名</td>
		         <td>课程编号</td>
		         <td>教师编号</td>
		         <td>班级编号</td>
		         <td>课程分数</td>
		         <td>修改</td>
		         <td>是否删除</td>
		     </tr>
		    <%
		            for(int j=0;j<list.size();j++){%>
		            <tr>
		            <td><%=list.get(j).getStuId()%></td>
		            <td><%=list.get(j).getStuName()%></td>
		            <td><%=list.get(j).getCourseId()%></td>
		            <td><%=list.get(j).getTcId()%></td>
		            <td><%=list.get(j).getClassId()%></td>
		            <form action="${pageContext.request.contextPath }/UpdScoreServlet" method="post">
		            <input type="hidden" name="stuId" value="<%=list.get(j).getStuId() %>">
		            <input type="hidden" name="stuName" value="<%=list.get(j).getStuName() %>">
		            <input type="hidden" name="courseId" value="<%=list.get(j).getCourseId() %>">
		            <input type="hidden" name="tcId" value="<%=list.get(j).getTcId() %>">
		            <input type="hidden" name="classId" value="<%=list.get(j).getClassId() %>">
		            <td><input name="grade" type="text" value="<%=list.get(j).getCourseGrade()%>"></td>
		            <td><input type="submit" value="修改"></td>
		            </form>
		            <form action="${pageContext.request.contextPath }/DelScoreServlet" method="post">
		            <input type="hidden" name="stuId" value="<%=list.get(j).getStuId() %>">
		            <input type="hidden" name="stuName" value="<%=list.get(j).getStuName() %>">
		            <input type="hidden" name="courseId" value="<%=list.get(j).getCourseId() %>">
		            <input type="hidden" name="tcId" value="<%=list.get(j).getTcId() %>">
		            <input type="hidden" name="classId" value="<%=list.get(j).getClassId() %>">
		            <input type="hidden" name="grade" value="<%=list.get(j).getCourseGrade()%>">
		            <td><input type="submit" value="删除"></td>
		            </form>
		            </tr>
					 <% }}%>
		   </table>
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