<%@page import="priv.lihaogn.Bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//获取提示信息
		String info=(String)request.getAttribute("info");
		//如果提示信息不为空，则输出提示信息
		if(info!=null){
			out.println(info);
		}
		//获取登陆的用户信息
		User user=(User)session.getAttribute("user");
		//判断用户是否登陆
		if(user!=null){
	%>
		<P><%=user.getUsername() %>登陆成功</P>
		<p>sex:<%=user.getSex() %></p>
	<% 		
		}else{
			out.println("sorry,you haven't login in!");
		}
	%>
</body>
</html>