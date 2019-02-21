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
		<h3>Hello ${customer.getName()}</h3>
	</div>
	
	<hr><br>

	<form action="FrontController" method="Post">
		<table bgcolor="lightBlue" align="center" border="0">
			<tr>
				<td align="left"><b>SMALL OR LARGE?</b></td>
				<td align="left"><select name="size" size="1">
						<option value="SMALL" selected="selected">SMALL</option>
						<option value="LARGE">LARGE</option>
				</select></td>
			</tr>

			<tr>
				<td align="left"><b>Pizza Type</b></td>
				<td align="left"><input type="radio" name="pizzatype" value="CHEESE" checked="checked"> Cheese Pizza
					<input type="radio" name="pizzatype" value="PEPERONI"> Peperoni Pizza
					<input type="radio" name="pizzatype" value="VEG"> Veg Pizza</td>
			</tr>

			<tr>
				<td align="left"></td>
				<td align="left"><input type="submit"  name="run" value="Place My Order" align="middle"></td>
			</tr>
		</table>
	</form>
</body>
</html>