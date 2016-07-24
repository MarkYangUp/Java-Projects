<%@page import="com.medibidz.entity.CategoryTypes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Buy Your Product</h1>

<table border="1">

<tr><td>select Price</td></tr>

<tr><td><a href="GetItemByPrice?no=0">Rs.1-250</a></td></tr>

<tr><td><a href="GetItemByPrice?no=1">Rs.251-500</a></td></tr>

<tr><td><a href="GetItemByPrice?no=2">Rs.500-2000</a></td></tr>

<tr><td><a href="GetItemByPrice?no=3">Rs.2001-5000</a></td></tr>

<tr><td><a href="GetItemByPrice?no=4">Rs.5000-10000</a></td></tr>

<tr><td><a href="GetItemByPrice?no=5">Rs.10000-20000</a></td></tr>

<tr><td><a href="GetItemByPrice?no=6">Rs.20000-50000</a></td></tr>

<tr><td><a href="GetItemByPrice?no=7">Rs.50000-100000</a></td></tr>

<tr><td><a href="GetItemByPrice?no=8">Rs.100000+</a></td></tr>

<tr><td>Select Category</td></tr>

<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.ELECTRONICGADGETS%>">ELECTRONIC GADGETS</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.BOOKS%>">BOOKS</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.NOTES%>">NOTES</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.BAGS%>">BAGS</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.STATIONERY%>">STATIONERY</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.CLOTHES%>">CLOTHES</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.TOOLS%>">TOOLS</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.TOLET%>">TO-LET</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.VEHICLES%>">VEHICLES</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.SOUVENIRS%>">SOUVENIRS</a></td></tr>
<tr><td><a href="CategoryServlet?catName=<%=CategoryTypes.OTHERS%>">OTHERS</a></td></tr>
</table>

</body>

</html>