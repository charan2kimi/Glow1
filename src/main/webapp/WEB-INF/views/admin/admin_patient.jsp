<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="cr_patient" method="post">
<table>
<tr><td>Username:</td><td><input type="text" name="uName"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
<tr></tr>
<tr></tr>
<tr><td>First Name:</td><td><input type="text" name="fName"></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lName"></td></tr>
<tr><td>Date of Birth:</td><td><input type="text" name="dob"></td></tr>
<tr><td>Address</td></tr>
<tr><td>Line1:</td><td><input type="text" name="line1"></td></tr>
<tr><td>Line2:</td><td><input type="text" name="line2"></td></tr>
<tr><td>City:</td><td><input type="text" name="city"></td></tr>
<tr><td>State:</td><td><input type="text" name="state"></td></tr>
<tr><td>Zip:</td><td> <input type="text" name="zip"></td></tr>
</table>
<div>
<input type="submit" value="Submit">
</div>
</form>
</body>
</html>