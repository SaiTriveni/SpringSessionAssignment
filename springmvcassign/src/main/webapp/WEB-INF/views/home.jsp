<%@page import="com.capgemini.springmvcassign.bean.EmployeePrimary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%EmployeePrimary loggedEmployeeInfo =(EmployeePrimary)session.getAttribute("loggedEmployeeInfo"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<div style="width: 100%;" align="center">
<h1 style="color: navy;">Welcome  <%=loggedEmployeeInfo.getName() %>!!</h1>
</div>
<a href="addEmployeeForm">Add Employee </a>
	<br>
	<a href="updateEmployeeForm">Update Employee Details</a>
	<br>
	<a href="deleteEmployeeForm">Delete EmployeeDetails</a>
	<br>
	<a href="allEmployeeDetails"> All Employee Details</a>
	<br>
	<a href="getEmployeeForm"> Search Employee</a>
	<br>
	<br>
		<a href="./logout" style="float: right">Logout</a>
</body>
</html>


</body>
</html>