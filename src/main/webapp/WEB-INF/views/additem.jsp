<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1>
		<%=msg%></h1>
	<%
		}
	%>
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red;">
		<%=errMsg%></h1>
	<%
		}
	%>
	<fieldset>
		<legend>Add Item</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Items ID</td>
					<td>:</td>
					<td><input type="number" name="id"
						placeholder="Enter the ID" required="required"></td>
				</tr>
				<tr>
					<td>Items Name</td>
					<td>:</td>
					<td><input type="text" name="name"
						placeholder="Enter the Items Name" required="required"></td>
				</tr>
				<tr>
					<td>Items Quantity</td>
					<td>:</td>
					<td><input type="text" name="quantity"
						placeholder="Enter the Quatity" required="required"></td>
				</tr>
				<tr>
					<td>Items Price</td>
					<td>:</td>
					<td><input type="number" name="price"
						placeholder="Enter the price" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Additems"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>