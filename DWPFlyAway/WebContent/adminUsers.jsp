<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminUsers.jsp</title>
</head>
<body>
	<%@include file="commonHeaderAdmin.html"%>
	<h2>Add User Detail: </h2>
	<form action="flyawayadminusersservlet" method="post">
		Email 	<input type="text" name="userEmail" /><br>
		Name    <input type="text" name="userName" /><br>
		Contact	<input type="text" name="userContact" /><br>
		Pass	<input type="text" name="userPass" /><br>
		Type	<input type="text" name="userTypeAdmin" /><br><br> 
	 			<input type="submit" value="Add" name="usersFormSubmit">
	</form>
	<br>
	<h2>Get User by ID: </h2>
	<form name="Airlines" action="flyawayadminusersservlet" method="post">
		ID <input type="number" name="userId" /><br><br>
	 		<input type="submit" value="Get" name="usersFormSubmit" disabled>
	</form>
	<br>
	<h2>List Users: </h2>
	<form action="flyawayadminusersservlet" method="post">
	 	<input type="submit" value="List" name="usersFormSubmit" disabled>
	</form>
	
</body>
</html>