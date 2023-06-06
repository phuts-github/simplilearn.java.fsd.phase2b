<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Jsp</title>
</head>
<body>
	<%@include file="commonHeader.html"%>
	<h2>Login</h2>
	<form name="Register" action="flyawayloginservlet" method="post">
		Enter the following to login: <br><br> 
		Email <input type="text" name="email" /><br> 
		Password <input type="password" name="pass" /><br><br>
		 <input type="submit" value="Login now">
	</form>
	<br>
	<a href='/FlyAway/register.jsp?code='>Register</a>
</body>
</html>