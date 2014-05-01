<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){

	$("#role").change(function () {
		$.getJSON("getEnterpriseType", { enttype: $('#role').val()}, function (data) 
		{
			$("#listenterprise").html('');
			$("#listenterprise").append('<option value="Select One">SelectOne</option>');
		$.each(data, function (key, value) {
			$("#listenterprise").append('<option value="'+value+'">"' + key + '"</option>');
		});
	
		});
		});

	$("#listenterprise").change(function () {
		$.getJSON("getEmployeeByEnterprise", { ent: $('#listenterprise').val()}, function (data) 
		{
			$("#listemployee").html('');
			$("#listemployee").append('<option value="Select One">SelectOne</option>');
		$.each(data, function (key, value) {
			$("#listemployee").append('<option value="'+value+'">"' + key + '"</option>');
		});
		
		});
		});
	
	
});
</script>
</head>
<body>
<form action="admin_cr_user" method="post">
<table>
<tr><td>Username:</td><td> <input type="text" name="username"></td></tr>
<tr><td>Password:</td><td> <input type="password" name="password"></td></tr>

<tr><td>Role:</td><td>
<select id="role" >
<option value="Select One">Select One</option>
  <option value="manufacturer">Manufacturer Admin</option>
  <option value="distributor">Distributor Admin</option>
  <option value="hospital">Hospital Admin</option>
</select></td></tr>

<tr><td>Enterprise</td><td>
<select id="listenterprise" name="listenterprise">
     <option value="Select One">Select One</option>
</select></td></tr>

<tr><td>Employees</td><td>
<select id="listemployee" name="listemployee">
     <option value="Select One">Select One</option>
</select></td></tr>
</table>

<input type="submit" name="Submit">

</form>
</body>
</html>