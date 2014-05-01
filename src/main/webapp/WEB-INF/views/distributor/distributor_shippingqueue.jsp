<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>    
.tables{ 
    overflow: auto; 
    height: 200px; 
    width: 100%;
    } 
</style>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#wrtable').on('click', '.processWR', function () {
		

		var wrid=this.id;

		
		$.getJSON("processDistSHR", {wid:wrid }, function (data){


		
			
		  if(data=="Processed"){
			  alert(data);
			  $('.st'+wrid).html('Processed');		  
			  }else{
			  	alert("Already Processed");
				  }
	});	
	});
	});
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  class="myTable" id="wrtable">
<tr><th>WorkRequest ID</th><th>Ordered By</th><th>Status </th><th>Sent on</th><th>Process</th></tr>
<c:forEach var="item" items="${queue}">
<tr><td>${item.id}</td><td >${item.sender}</td><td class="st${item.id}">${item.status}</td><td>${item.dateRequested}</td><td><input type="button" class="processWR" value="Process" id="${item.id}"></td></tr>
</c:forEach>
</table>
</body>
</html>