<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function(){
	$('#drugTable').on('click', '.selectDR', function () {

		

		var drugid=this.id;
		

		$("#packageTable").html('');
		$.getJSON("inventoryPackageByDrug", {pid:drugid}, function (data){
	$("#packageTable").append('<tr><th>Package ID</th><th>Drug Name</th><th>Manufacturer </th><th>Status</th><th>Report</th></tr>');
	for(var i in data) {
		
		
		  if(!isNaN(i)) {
 			$("#packageTable").append('<tr><td>'+data[i].id+'</td><td >'+data[i].drug.name+'</td><td>'+data[i].drug.manufacturer.enterpriseName+'</td><td>'+data[i].status+'</td><td><input type="button" class="reportPackage" id="'+data[i].id+'" value="Report"></td></tr>');
		  }}
});	
	
});

$('#packageTable').on('click', '.reportPackage', function () {
	var pid=this.id;
	$("#packageTable").html('');
	$.getJSON("reportPackage", {id:pid }, function (data)
			{
		$("#packageTable").append('<tr><th>Package ID</th><th>Drug Name</th><th>Manufacturer </th><th>Status</th><th>Report</th></tr>');
		for(var i in data) {
			
			
			  if(!isNaN(i)) {
				  $("#packageTable").append('<tr><td>'+data[i].id+'</td><td >'+data[i].drug.name+'</td><td>'+data[i].drug.manufacturer.enterpriseName+'</td><td>'+data[i].status+'</td><td><input type="button" class="reportPackage" id="'+data[i].id+'" value="Report"></td></tr>');
			  }}
	});	
});

});
</script>
</head>
<body>
<div class="tableDiv">
<table  class="myTable" id="drugTable">
<tr><th>Drug ID</th><th>Name</th><th>Compound </th><th>Quantity</th><th>View</th></tr>
<c:forEach var="item" items="${map}">
<tr><td>${item.key.id}</td><td >${item.key.name}</td><td >${item.key.compound}</td><td>${item.value}</td><td><input type="button" class="selectDR" value="View" id="${item.key.id}"></td></tr>
</c:forEach>
</table>
</div>
<div class="tableDiv">
<table  class="myTable" id="packageTable">
<tr><th>Package ID</th><th>Drug Name</th><th>Manufacturer </th><th>Report</th></tr>

</table>
</div>
</body>
</html>