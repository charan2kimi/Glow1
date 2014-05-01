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
	$('#packageTable').on('click', '.revoke', function () {

		

		var drugid=this.id;
		

	
		$.getJSON("revoke", {pid:drugid}, function (data){
			
			alert(data);
			document.location.reload(true);
				
});	
	
});

});
</script>
</head>
<body>
<form action="disposeDrugs" method="post">
<div class="tableDiv">
<table  class="myTable" id="packageTable">
<thead>
<tr><th>Package ID</th><th>Drug Name</th><th>Reported by </th><th>Compound </th>
<th>Manufacturer </th><th>Status</th><th>Remove From Production</th></tr></thead>
<tbody>
<c:forEach var="item" items="${list}">
<tr><td>${item.id}</td><td >${item.drug.name}</td><td >${item.owner}</td>
<td>${item.drug.compound}</td><td>${item.drug.manufacturer.enterpriseName}</td><td class="statusDP${item.id}">${item.status}</td>
<td><input type="button" class="revoke" value="Remove" id="${item.id}"></td></tr>

</c:forEach>
</tbody>
</table>
</div>

<input type="submit" value="Dispose drugs">
</form>
</body>
</html>