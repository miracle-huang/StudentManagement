<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统</title>
</head>
<center><h3>用户登录</h3></center>
<body style="text-align: center;">
	<form action="${pageContext.request.contextPath }/LoginServlet" method = "post">
	<table border="1" width="600px" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td height="30" align="center">用户名： </td>
			<td>
				<input type="text" name="username" />${errerMsg }</td>
		</tr>
		<tr>
			<td height="30" align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码： </td>
			<td>
				<input type="password" name="password" /></td>
		</tr>
		<tr>
			<td height="30" align="center">验证码：</td>
			<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" name="check_code"/>
			<img src="/StudentManage/CheckServlet"/><br/>
			</td>
		</tr>
		<tr>
			<td height="35" align="center">身份：</td>
			<td><input type="radio" name="identity"
					value="admin"/>管理员（老师 ）
				<input type="radio" name="identity"
					value="student"/>学生
			</td>
		</tr>
		<tr>
			<td height="30" colspan="2" align="center">
				<input type="submit" value="登陆">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>