<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<style type="text/css">

body
{
width: 100%;
}

.body{
width:100%;
}

.container{
width:100%;
height:800px;
}

.header
{
width:100%;
height:10%;
background-color: #1BBCE0;
}



.content{
width:100%;
height:90%;
float:right;
background-color: #ccffff;
text-align: left;
}
</style>

</head>
<body>

<div class="body" align="center">
<div class="container">
<div class="header">
<tiles:insertAttribute name="header" />
</div>
<div class="content">
<tiles:insertAttribute name="body" />
</div>

</div>
</div>
</body>
</html>