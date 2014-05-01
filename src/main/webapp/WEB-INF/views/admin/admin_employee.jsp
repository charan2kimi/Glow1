<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){

	$("#enterprisetype").change(function () {
		$.getJSON("getEnterpriseType", { enttype: $('#enterprisetype').val() }, function (data) 
		{
			$("#listenterprise").html('');
			$("#listenterprise").append('<option value="Select One">SelectOne</option>');
		$.each(data, function (key, value) {
			$("#listenterprise").append('<option value="'+value+'">"' + key + ' "</option>');
		});
		
		});
		});
	
});
</script>

</head>
<body>
<form action="admin_cr_employee" method="post">
<table>
<tr><td>Enterprise Type
</td><td><select id="enterprisetype" >
<option value="SelectOne">Select One</option>
  <option value="Manufacturer">Manufacturer</option>
  <option value="Distributor">Distributor</option>
  <option value="Hospital">Hospital</option>
</select></td></tr>

<tr><td>Enterprise
</td><td><select id="listenterprise" name="selectedenterprise" >
     <option value="SelectOne">Select One</option>
</select></td></tr>


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

<input type="submit" value="Next"><br>

</form>
</body>
</html>