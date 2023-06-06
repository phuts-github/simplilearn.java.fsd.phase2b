<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminHome.jsp</title>
</head>
<body>
	<%@include file="commonHeaderAdmin.html"%>
	<h2>Administration Options: </h2>
	
	<a href='/FlyAway/adminAirlines.jsp'>Airlines</a> <br><br>
	<a href='/FlyAway/adminBookings.jsp'>Bookings</a> <br><br>
	<a href='/FlyAway/adminCities.jsp'>Cities</a> <br><br>
	<a href='/FlyAway/adminFlightsSchedules.jsp'>Flight Schedules</a> <br><br>
	<a href='/FlyAway/adminTransactions.jsp?code='>Transactions</a> <br><br>
	<a href='/FlyAway/adminUsers.jsp?code='>Users</a>
	
</body>
</html>