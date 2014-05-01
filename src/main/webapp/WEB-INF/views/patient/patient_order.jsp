<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<style>    
.tables{ 
    overflow: auto; 
    height: 200px; 
    width: 100%;
    } 
</style>  
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
<form action="patient_onorder" method="post">





<h3>Drugs</h3>
<div class="tables">
<table class="myTable" id="drugTable">
<tr><th>Drug ID</th><th>Name</th><th>Compound</th><th>Life</th><th>Manufacturer</th><th>Order</th></tr>
<c:forEach var="item" items="${list1}">
<tr ><td >${item.id}</td><td class="name">${item.name}</td><td>${item.compound}</td><td>${item.life}</td><td>${item.manufacturer.enterpriseName}</td><td><input type="button" class="addToCart" id="${item.id}" value="Add To Cart"></td></tr>
</c:forEach>
</table>
</div>
<br>

<br>
<h3>Cart</h3>
<div class="tables">
<table class="myTable" id="cart">
</table>
</div>
<label for="selecthospital">Select Distributor:</label>
<select id="selecthospital" name="selecthospital">
<option value="Select One">Select One</option>
<c:forEach var="item" items="${list}">
<option value="${ item.id}">${item.enterpriseName}</option>
</c:forEach>

</select>
<input type="submit" onclick="checkout" value="order">
</form>
</body>
</html>