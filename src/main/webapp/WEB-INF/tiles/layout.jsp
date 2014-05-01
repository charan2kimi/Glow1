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
background-image:url('background.jpg');

}

.header
{
width:100%;
height:10%;
background-color: #1BBCE0;
}



.sidebar{
width:20%;
height:90%;
float:left;
background-color: yellow;
border-right: 2px;
border-right-style: solid;
}

.content{
width:79.8%;
height:90%;
float:right;

text-align: left;
}


.tableDiv{
 overflow: auto; 
    height: 200px; 
    width: 100%;
}
.myTable
{
font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
width:100%;
border-collapse:collapse;
 }
.myTable td, .myTable th 
{
font-size:1em;
border:1px solid #98bf21;
padding:3px 7px 2px 7px;
}
.myTable th 
{
font-size:1.1em;
text-align:left;
padding-top:5px;
padding-bottom:4px;
background-color:#A7C942;
color:#ffffff;
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</head>
<body>

<div class="body" align="center">
<div class="container">
<div class="header">
<tiles:insertAttribute name="header" />
</div>
<div class="sidebar" align="left">
<tiles:insertAttribute name="menu" />
</div>
<div class="content">
<tiles:insertAttribute name="body" />
</div>

</div>
</div>
</body>
</html>