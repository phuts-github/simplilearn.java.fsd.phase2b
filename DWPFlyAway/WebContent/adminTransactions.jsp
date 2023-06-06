<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminTransactions.jsp</title>
</head>
<body>
	<%@include file="commonHeaderAdmin.html"%>
	<h2>Add Transaction Detail: </h2>
	<form action="flyawayadmintransactionsservlet" method="post">
		Booking Id		<input type="text" name="transBookingId" /><br>
		FlightAmount	<input type="number" name="transFlightAmount" /><br>
		PassengerCount	<input type="number" name="transPassengerCount" /><br>
		TotalDue		<input type="number" name="transTotalDue" /><br> 
		TotalPaid		<input type="number" name="transTotalPaid" /><br>
		Date		<input type="number" name="transDate" /><br><br>
	 				<input type="submit" value="Add" name="transactionsFormSubmit">
	</form>
	<br>
	<h2>Get Transaction by ID: </h2>
	<form action="flyawayadmintransactionsservlet" method="post">
		ID <input type="number" name="transId" /><br><br>
	 		<input type="submit" value="Get" name="transactionsFormSubmit" disabled>
	</form>
	<br>
	<h2>List Transactions: </h2>
	<form action="flyawayadmintransactionsservlet" method="post">
	 	<input type="submit" value="List" name="transactionsFormSubmit" disabled>
	</form>
	
</body>
</html>