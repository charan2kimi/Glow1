<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="admin_cr_enterprise" method="post">
<table>
<tr><td>Enterprise Name:</td><td><input type="text" name="enterpriseName"></td></tr>

<tr><td>Status:</td><td><select name="status">
  <option value="Licensed">Licensed</option>
  <option value="Expired">Expired</option>
</select></td></tr>
<tr><td>Type: </td><td>
<select name="enterpriseType">
<option value="Select One">Select One</option>
  <option value="Manufacturer">Manufacturer</option>
  <option value="Distributor">Distributor</option>
  <option value="Hospital">Hospital</option>
</select></td></tr>
<tr><td>Address</td></tr>
<tr><td>Line1:</td><td> <input type="text" name="line1"></td></tr>
<tr><td>Line2: </td><td><input type="text" name="line2"></td></tr>
<tr><td>City: </td><td><input type="text" name="city"></td></tr>
<tr><td>State: </td><td><input type="text" name="state"></td></tr>
<tr><td>Zip: </td><td><input type="text" name="zip"></td></tr>

</table>

<input type="submit" value="Next"><br>


</form>

</body>
</html>