<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Adding New Product</title>
	</head>
	<body>
		<form action="productservlet">
			<h1>Product Details Portal</h1>
			<h2>Enter New Product Details below:</h2>
			<%
			
				String dName = " ";
				String dColour = " ";
				String dDesc = " ";
				String dQuantity = " ";
				String dCostPrice = " ";
				String dSalePrice = " ";
				
// 			    HttpSession session = request.getSession(false);
			    if (session != null) {
			  
					dName = (String) session.getAttribute("sName");
					dColour = (String) session.getAttribute("sColour");
					dDesc = (String) session.getAttribute("sDesc");
					dQuantity = (String) session.getAttribute("sQuantity");
					dCostPrice = (String) session.getAttribute("sCostPrice");
					dSalePrice = (String) session.getAttribute("sSalePrice");
					

			    }
			    else {
					if (dName.equals(null)) {dName = "";}
					if (dColour.equals(null)) {dColour = "";}
					if (dDesc.equals(null)) {dDesc = "";}
					if (dQuantity.equals(null)) {dQuantity = "";}
					if (dCostPrice.equals(null)) {dCostPrice = "";}
					if (dSalePrice.equals(null)) {dSalePrice = "";}			    	
			    }
			    
			 %>
			<table border="1">
				<tr> 
					<th>Field</th><th>Value</th>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="pName" value=<%=dName%>></td>
				</tr>
				<tr>
					<td>Colour </td>
					<td><input type="text" name="pColour" value=<%=dColour%>></td>
				</tr>					
				<tr>
					<td>Description </td>
					<td><input type="text" name="pDesc" value=<%=dDesc%>></td>
				</tr>
				<tr>
					<td>Quantity </td>
					<td><input type="text" name="pQuantity" value=<%=dQuantity%>></td>
				<tr>
					<td>Cost Price </td>
					<td><input type="text" name="pCostPrice" value=<%=dCostPrice%>></td>
				</tr>
				<tr>
					<td>Sale Price</td>
					<td><input type="text" name="pSalePrice" value=<%=dSalePrice%>></td>
				</tr>															
				
			</table>	
			<br>
	  	   <input type="submit" value="Add">
		</form>
	</body>
</html>