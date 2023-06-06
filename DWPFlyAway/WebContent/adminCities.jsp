<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminCities.jsp</title>
</head>
<body>
	<%@include file="commonHeaderAdmin.html"%>
	<h2>Add City Detail: </h2>
	<form action="flyawayadmincitiesservlet" method="post">
		Name 	<input type="text" name="cityName" /><br>
		Country	<input type="text" name="cityCountry" /><br>
		Continent	<input type="text" name="cityContinent" /><br><br> 
	 			<input type="submit" value="Add" name="citiesFormSubmit">
	</form>
	<br>
	<h2>Get City by ID: </h2>
	<form action="flyawayadmincitiesservlet" method="post">
		ID <input type="number" name="cityId" /><br><br>
	 		<input type="submit" value="Get" name="citiesFormSubmit" disabled>
	</form>
	<br>
	<h2>List Cities: </h2>
	<form action="flyawayadmincitiesservlet" method="post">
	 	<input type="submit" value="List" name="citiesFormSubmit" disabled>
	</form>
	
</body>
</html>