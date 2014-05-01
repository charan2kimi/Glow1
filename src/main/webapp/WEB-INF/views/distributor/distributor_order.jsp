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
function checkout()
{
	if(document.getElementById("cart").rows.length<=1)
		{
			alert("Cart is empty");
			return false;
		}
		return true;
}
$(document).ready(function(){

	$("#selectenterprise").change(function () {
		$("#drugTable").html('');
		$("#cart").html('');
		$.getJSON("getDrugsByEnterprise", { entid: $('#selectenterprise').val() }, function (data)
		{
			$("#drugTable").append('<tr><th>Drug ID</th><th>Name</th><th>Compound</th><th>Life</th><th>Order</th></tr>');
			for(var i in data) {
				
		
			  if(!isNaN(i)) {
				  $("#drugTable").append('<tr id="row'+data[i].id+'"><td >'+data[i].id+'</td><td class="name">'+data[i].name+'</td><td>'+data[i].compound+'</td><td>'+data[i].life+'</td><td><input type="button" class="addToCart" id="'+data[i].id+'" value="Add To Cart"></td></tr>');
			  }
			 
			}

			
		});
		});

	$('#drugTable').on('click', '.addToCart', function () {
		var dquantity=prompt("Please enter quantity","1");

		var drugid=this.id;

		$("#cart").html('');
		$.getJSON("addItemToCart", {pid:drugid ,quantity:dquantity }, function (data){
	$("#cart").append('<tr><th>Order Item ID</th><th>Name</th><th>Compound</th><th>Quantity</th><th>Delete</th></tr>');
	for(var i in data) {
		
		
		  if(!isNaN(i)) {
 			$("#cart").append('<tr><td>'+data[i].id+'</td><td >'+data[i].name+'</td><td>'+data[i].compund+'</td><td>'+data[i].quantity+'</td><td><input type="button" class="deleteFromCart" id="'+data[i].id+'" value="Delete"></td></tr>');
		  }}
});	
	
});

	$('#cart').on('click', '.deleteFromCart', function () {
		var did=this.id;
		$("#cart").html('');
		$.getJSON("deleteItemToCart", {id:did }, function (data)
				{
			$("#cart").append('<tr><th>Order Item ID</th><th>Name</th><th>Compound</th><th>Quantity</th><th>Delete</th></tr>');
			for(var i in data) {
				
				
				  if(!isNaN(i)) {
		 $("#cart").append('<tr><td>'+data[i].id+'</td><td >'+data[i].name+'</td><td>'+data[i].compound+'</td><td>'+data[i].quantity+'</td><td><input type="button" class="deleteFromCart" id="'+data[i].id+'" value="Delete"></td></tr>');
				  }}
		});	
	});
});
</script>

</head>
<body>
<form action="distributor_onorder" method="post">

<label for="selectenterprise">Select Manufacturer:</label>
<select id="selectenterprise" name="selectenterprise">
<option value="Select One">Select One</option>
<c:forEach var="item" items="${list}">
<option value="${ item.id}">${item.enterpriseName}</option>
</c:forEach>

</select>



<h3>Drugs</h3>
<div class="tableDiv">
<table class="myTable" id="drugTable">

</table>
</div>
<br>
<br>
<h3>Cart</h3>
<div class="tableDiv">
<table class="myTable" id="cart">
</table>
</div>
<input type="submit" onclick="checkout" value="order">
</form>
</body>
</html>