<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Jsp </title>
</head>
	<%@include file="commonHeader.html" %>
	<body>
	<h2>Passengers information</h2>
	<form name="bookings" action="flyawaybookingconfirmservlet" method="post">
		Enter the traveller's details : <br><br>
		Passenger One Name  
		<input type="text" name="passengerOneName"/><br>
		Passenger Two Name  
		<input type="text" name="passengerTwoName"/><br>
		Passenger Three Name  
		<input type="text" name="passengerThreeName"/><br>
		Passenger Four Name  
		<input type="text" name="passengerFourName"/><br><br>		
		<input type="submit" value="Confirm"> 
	</form>
	</body>
</html>