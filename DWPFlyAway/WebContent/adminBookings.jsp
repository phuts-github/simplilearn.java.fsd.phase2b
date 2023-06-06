<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminBookings.jsp</title>
</head>
<body>
	<%@include file="commonHeaderAdmin.html"%>
	<h2>Add Booking Detail: </h2>
	<form action="flyawayadminbookingsservlet" method="post">
		User Id 	<input type=number name="bookingUserId" /><br>
		Flight Schedule Id	<input type="number" name="bookingFlightScheduleId" /><br>
		Flight Date	<input type="text" name="bookingFlightDate" /><br>
		Passenger One	<input type="text" name="bookingPassengerOne" /><br> 
		Passenger Two 	<input type="text" name="bookingPassengerTwo" /><br>
		Passenger Three	<input type="text" name="bookingPassengerThree" /><br>
		Passenger Four	<input type="text" name="bookingPassengerFour" /><br>
		Passenger Count	<input type="number" name="bookingPassengerCount" /><br>
		Transaction Id 	<input type="number" name="bookingTransactionId" /><br><br>
	 			<input type="submit" value="Add" name="bookingsFormSubmit">
	</form>
	<br>
	<h2>Get Booking by ID: </h2>
	<form action="flyawayadminbookingsservlet" method="post">
		ID <input type="number" name="bookingId" /><br><br>
	 		<input type="submit" value="Get" name="bookingsFormSubmit" disabled>
	</form>
	<br>
	<h2>List Bookings: </h2>
	<form action="flyawayadminbookingsservlet" method="post">
	 	<input type="submit" value="List" name="bookingsFormSubmit" disabled>
	</form>
	
</body>
</html>