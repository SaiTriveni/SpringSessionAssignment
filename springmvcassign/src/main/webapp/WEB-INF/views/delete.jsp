<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>

<div style="center">
	<a href="home">home</a>
	
		<a href="./logout" style="float: right">Logout</a>
	</div>
	<fieldset>
		<legend>Delete Employee Form</legend>
		<form action="deleteEmployee" >
			<table>
				<tr>
					<td>Employee Id</td>
					<td><input type="number" id="id" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="submit">
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>