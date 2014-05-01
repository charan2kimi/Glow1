<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="cr_drug" method="post">


<table>
<tr><td>Name:</td><td><input type="text" id="name" name="name"></td></tr>
<tr><td>Compound:</td><td><input type="text" id="compound" name="compound"></td></tr>
<tr><td>Dosage:</td><td><input type="text" id="dosage" name="dosage"></td></tr>
<tr><td>Life:</td><td><input type="text" id="life" name="life"></td></tr>
<tr><td>Weight:</td><td><input type="text" id="weight" name="weight"></td></tr>
</table>
<input type="submit" value="Submit">
</form>
</body>
</html>