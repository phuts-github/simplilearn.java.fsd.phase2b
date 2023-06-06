<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Jsp</title>
</head>
<%@include file="commonHeader.html"%>
<body>
	<h2>Register</h2>
	<form name="Register" action="flyawayregisterservlet" method="post">
		Enter the following to register: <br><br> 
		Email <input type="text" name="email" /><br> 
		Name <input type="text" name="name" /><br> 
		Contact no <input type="text" name="contact" /><br>
		Password <input type="password" name="pass" /><br><br> 
		<input	type="submit" value="Register now">
	</form>
	<br>
	<a href='/FlyAway/login.jsp?code='>Login</a>
</body>
</html>