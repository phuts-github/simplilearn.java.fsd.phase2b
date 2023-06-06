<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminAirlines.jsp</title>
</head>
<body>
	<%@include file="commonHeaderAdmin.html"%>
	<h2>Add Airlines Detail: </h2>
	<form action="flyawayadminairlinesservlet" method="post">
		Name 	<input type="text" name="airlineName" /><br>
		City	<input type="text" name="airlineCity" /><br>
		Country	<input type="text" name="airlineCountry" /><br>
		Route	<input type="text" name="airlineRoute" /><br><br> 
		
	 			<input type="submit" value="Add" name="airlinesFormSubmit">
	</form>
	<br>
	<h2>Get Airline by ID: </h2>
	<form action="flyawayadminairlinesservlet" method="post">
		ID <input type="number" name="airId" /><br><br>
	 		<input type="submit" value="Get" name="airlinesFormSubmit" disabled>
	</form>
	<br>
	<h2>List Airlines: </h2>
	<form action="flyawayadminairlinesservlet" method="post">
	 	<input type="submit" value="List" name="airlinesFormSubmit" disabled>
	</form>
	
</body>
</html>