<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product Display Form</title>
	</head>
	<body>
		<h1>Product Details Portal</h1>
		<h2>Review Product Details below:</h2>
		<% 
			String dName = (String) session.getAttribute("sName");
			String dColour = (String) session.getAttribute("sColour");
			String dDesc = (String) session.getAttribute("sDesc");
			String dQuantity = (String) session.getAttribute("sQuantity");
			String dCostPrice = (String) session.getAttribute("sCostPrice");
			String dSalePrice = (String) session.getAttribute("sSalePrice");
			
			out.print("<table border='1'>");
			out.print("<tr><th>Field</th><th>Value</th></tr>");
			out.print("<tr><td>Name</td><td>" + dName + "</td></tr>");
			out.print("<tr><td>Colour</td><td>" + dColour + "</td></tr>");
			out.print("<tr><td>Description</td><td>" + dDesc + "</td></tr>");
			out.print("<tr><td>Quantity</td><td>" + dQuantity + "</td></tr>");
			out.print("<tr><td>Cost Price</td><td>" + dCostPrice + "</td></tr>");
			out.print("<tr><td>Sale Price</td><td>" + dSalePrice + "</td></tr>");
			out.print("</table>");
			
			out.print("<br>");
			out.print("<a href='ProductInput.jsp'>Enter Another Product</a>"); 
		%>
	</body>
</html>