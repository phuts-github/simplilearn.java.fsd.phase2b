<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminFlightsSchedules.jsp</title>
</head>
<body>
	<%@include file="commonHeaderAdmin.html"%>
	<h2>Add Flight Schedules Detail: </h2>
	<form action="flyawayadminflightsschedulesservlet" method="post">
		Source 		<input type="text" name="flightSource" /><br>
		Destination	<input type="text" name="flightDestination" /><br>
		Date	<input type="text" name="flightDate" /><br>
		Airline	<input type="text" name="flightAirline" /><br> 
		Price 	<input type="number" name="flightPrice" /><br>
		SeatsTotal	<input type="number" name="flightSeatsTotal" /><br>
		SeatsBooked	<input type="number" name="flightSeatsBooked" /><br>
		SeatsAvailable	<input type="number" name="flightSeatsAvailable" /><br><br> 		
	 			<input type="submit" value="Add" name="flightsschedulesFormSubmit">
	</form>
	<br>
	<h2>Get Flight Schedule by ID: </h2>
	<form action="flyawayadminflightsschedulesservlet" method="post">
		ID <input type="number" name="flightId" /><br><br>
	 		<input type="submit" value="Get" name="flightsschedulesFormSubmit" disabled>
	</form>
	<br>
	<h2>List Flight Schedules: </h2>
	<form action="flyawayadminflightsschedulesservlet" method="post">
	 	<input type="submit" value="List" name="flightsschedulesFormSubmit" disabled>
	</form>
	
</body>
</html>