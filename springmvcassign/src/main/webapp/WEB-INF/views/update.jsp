<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>


<div style="centre">
	<a href="home">home</a>
	
		<a href="./logout" style="float: right">Logout</a>
	</div>
		<form action="updateEmployee" method="post">
			<table>

			<tr>

				<td><label>Employee Id:</label></td>
				<td><input type="number" id="empId" name="id" required><br>
				</td>
			</tr>
			<tr>
				<td><label>Employee Name:</label></td>
				<td><input type="text" id="name" name="name"
					required><br></td>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><input type="email" id="email" name="email"
					required><br></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="password" id="password"
					name="password" required><br></td>
			</tr>
			<tr>
				<td><label>Designation:</label></td>
				<td><input type="text" id="designation"
					name="designation" required><br></td>
			</tr>
			<td><input type="submit" value ="submit"></td>
			</tr>

		</table>
		</form>

</body>
</html>