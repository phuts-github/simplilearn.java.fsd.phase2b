<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product Input Form</title>
	</head>
	<body>
		<form action="productservlet">
			<h1>Product Details Portal</h1>
			<h2>Enter Product Details below:</h2>
			<table border="1">
				<tr> 
					<th>Field</th><th>Value</th>
				</tr>
				
				<tr>
					<td>Name</td>
					<td><input type="text" name="pName"></td>
				</tr>
				
				<tr>
					<td>Colour </td>
					<td><input type="text" name="pColour"></td>
				</tr>
										
				<tr>
					<td>Description </td>
					<td><input type="text" name="pDesc"></td>
				</tr>
				<tr>
					<td>Quantity </td>
					<td><input type="text" name="pQuantity"></td>
				<tr>
					<td>Cost Price </td>
					<td><input type="text" name="pCostPrice"></td>
				</tr>
				<tr>
					<td>Sale Price</td>
					<td><input type="text" name="pSalePrice"></td>
				</tr>															
				
			</table>	
			<br>
	  	   <input type="submit" value="Display Product">
		</form>
	</body>
</html>