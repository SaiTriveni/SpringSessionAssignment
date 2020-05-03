<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String errMsg =(String) request.getAttribute("errMsg"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Employee Login</legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td>Employee Id:</td>
						<td><input type="number" name="id"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Login"></td>
					</tr>
				</table>
			</form>
		
	</fieldset>
	<%if (errMsg != null && !errMsg.isEmpty()) { %>
	<h3 style="color : red;"><%=errMsg %></h3>
	<%} %>
</body>
</html>