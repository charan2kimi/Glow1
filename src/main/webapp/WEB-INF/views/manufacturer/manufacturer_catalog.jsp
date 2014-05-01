<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1 align="center">
Drug Catalog</h1>

<table id="myTable" class="myTable">
<tr>
  <th>Drug ID</th>
  <th>Name</th>
  <th>Compound</th>
  <th>Life</th>
  <th>Dosage</th>
  <th>Weight</th>
  <c:forEach var="item" items="${list}">
          <tr>
          <td>${item.id}</td><td>${item.name}</td><td>${item.compound}</td>
          <td>${item.life}</td><td>${item.dosage}</td><td>${item.weight}</td>
          </tr>
  
  </c:forEach>
</tr>
<tr>
</table>

</body>
</html>