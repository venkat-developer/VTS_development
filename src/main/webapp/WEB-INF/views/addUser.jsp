<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
</head>
<div align="center">
	<table>
		<tr>
			<td><a href="home">Trip Sheet</a></td>
			<td><a href="tripSheet">Trip Sheet</a></td>
			<td><a href="controlPanel">Control Panel</a></td>
			<td><a href="reports">Reports</a></td>
		</tr>
	</table>
	<form action="addUser">
		<table>
			<tr>
				<td>First name :</td>
				<td><input Type="text" value="firstName" /></td>
			</tr>
			<tr>
				<td>Last name :</td>
				<td><input Type="text" value="lastName" /></td>
			</tr>
			<tr>
				<td>Mobile number :</td>
				<td><input Type="text" value="mobile" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input Type="text" value="email"></td>
			</tr>
			<tr>
				<td><input Type="submit" value="Add"> <input
					Type="submit" value="Reset"></td>
			</tr>
		</table>
	</form>
</div>
<body>
</body>
</html>