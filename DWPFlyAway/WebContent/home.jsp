<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fly Away home</title>
</head>
<body>
	<%@include file="commonHeader.html"%>
	<form action="flyawaysearchservlet" name="formName" id="searchForm">
		<h2>Select schedule search parameters below:</h2>
		<table>
			<tr>
				<th>Code</th>
				<th>Fly From Source</th>
				<th>Fly To Destination</th>
				<th>Fly When</th>
			</tr>
			<tr>
				<td></td>
				<td><select name="flyFrom">
						<option></option>
						<option value="LAGOS">Lagos, Nigeria</option>
						<option value="TOKYO">Tokyo, Japan</option>
						<option value="SYDNEY">Sydney, Australia</option>
						<option value="ISTANBUL">Istanbul, Turkey</option>
						<option value="MEXICO CITY">Mexico City, Mexico</option>
						<option value="SAO PAULO">São Paulo, Brazil</option>

				</select></td>
				<td><select name="flyTo">
						<option></option>
						<option value="LAGOS">Lagos, Nigeria</option>
						<option value="TOKYO">Tokyo, Japan</option>
						<option value="SYDNEY">Sydney, Australia</option>
						<option value="ISTANBUL">Istanbul, Turkey</option>
						<option value="MEXICO CITY">Mexico City, Mexico</option>
						<option value="SAO PAULO">São Paulo, Brazil</option>
				</select></td>
				<td><select name="flyWhen">
						<option></option>
						<option value="JUN">Jun</option>
						<option value="JUL">Jul</option>
						<option value="AUG">Aug</option>
				</select></td>
			</tr>
		</table>
		<br> <input type="submit" value="Search">
	</form>

</body>
</html>