<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PIZZA Shop System</title>
</head>
<body>
	<div align="center">
		<h1>PIZZA Shop System</h1>
		<h3>Summary of the Order</h3>
		
		<hr><br>
		
		<form action="FrontController" method="Post">
			<table bgcolor="lightBlue" align="center" border="0">
				<tr>
					<td align="left"><b>Name</b></td>
					<td align="left">${customer.getName()}</td>
				</tr>
				<tr>
					<td align="left"><b>Email</b></td>
					<td align="left">${customer.getEmail()}</td>
				</tr>
				<tr>
					<td align="left"><b>Size</b></td>
					<td align="left">${customer.getOrder().getSize()}</td>
				</tr>

				<tr>
					<td align="left"><b>Pizza Type</b></td>
					<td align="left">${customer.getOrder().getPizza()}</td>
				</tr>
				<tr>
					<td align="left"><b>Total Before Tax</b></td>
					<td align="left">${receipt.getPizzaPrice()}</td>
				</tr>
				<tr>
					<td align="left"><b>Total After Tax</b></td>
					<td align="left">${receipt.getPriceAfterTax()}</td>
				</tr>
			</table>
			<input type="submit"  name="run" value="Report" align="middle">
		</form>
	</div>
</body>
</html>