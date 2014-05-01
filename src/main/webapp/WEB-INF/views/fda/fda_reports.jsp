<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.tableDiv{
height:500px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$('#packageTable').on('click', '.testPack', function () {

		

		var drugid=this.id;
		

		
		$.getJSON("testPackage", {pid:drugid}, function (data){

			alert(data);
			if(data=="Safe"){
			 $('.statusDP'+drugid).html('Safe');
			}else{
				 $('.statusDP'+drugid).html('Counterfeit');
				}
			
			$('.row'+drugid).remove();
});	
	
});

$('#packageTable').on('click', '.confisticatePack', function () {
	var pid=this.id;
	
	$.getJSON("confisticatePackage", {pid:pid }, function (data)
			{
		
		$('.row'+pid).remove();
	});	
});

});
</script>
</head>
<body>

<div class="tableDiv">
<table  class="myTable" id="packageTable">
<thead>
<tr><th>Package ID</th><th>Drug Name</th><th>Reported by </th><th>Compound </th>
<th>Manufacturer </th><th>Status</th><th>Test</th><th>Dispose</th></tr></thead>
<tbody>
<c:forEach var="item" items="${list}">
<tr class="row${item.id}"><td>${item.id}</td><td >${item.drug.name}</td><td >${item.owner}</td>
<td>${item.drug.compound}</td><td>${item.drug.manufacturer.enterpriseName}</td><td class="statusDP${item.id}">${item.status}</td>
<td><input type="button" class="testPack" value="Test" id="${item.id}"></td>
<td><input type="button" class="confisticatePack" value="Confisticate" id="${item.id}"></td></tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>