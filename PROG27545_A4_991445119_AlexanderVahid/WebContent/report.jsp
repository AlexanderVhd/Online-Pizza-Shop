<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List of Order Summary Items</h2>
	<c:choose>
		<c:when test="${fn:length(report) > 0}">
			<table border="1">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Total Before Tax</th>
					<th>Total After Tax</th>
				</tr>
				<c:forEach var="reportItem" items="${report}">
					<tr>
						<td>${reportItem.customerName}</td>
						<td>${reportItem.customerEmail}</td>
						<td>${reportItem.totalBeforeTax}</td>
						<td>${reportItem.totalAfterTax}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>There are no orders placed</h3>
		</c:otherwise>
	</c:choose>

</body>
</html>