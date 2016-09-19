<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">mode2实现用户注册和登陆</h1>
	<form action="RegServlet" method="post" onsubmit="return reg(this);">
		<table style="border:1px solid blue;width=300px;" align="center">
			<tr>
				<td align="center" colspan="2">
					<h1>注册</h1>
				</td>
			</tr>
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td align="right">确认密码：</td>
				<td><input type="password" name="repassword"/></td>
			</tr>
			<tr>
				<td align="right">性别：</td>
				<td>
					<input type="radio" name="sex" value="man"/>man
					<input type="radio" name="sex" value="woman"/>woman
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40">
					<input type="submit" value="提交"/>
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>