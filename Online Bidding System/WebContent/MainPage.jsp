<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td width="100%"><h1>Welcome&nbsp&nbsp<font color="red"><%=(String)session.getAttribute("userName") %></font></h1></td><td width="100%"><a href="Seller.jsp"><h3>Seller</h3></a></td>&nbsp&nbsp<td width="100%"><a href="Buyer.jsp"><h3>Buyer</h3></a></td></tr>
</table>
</body>
</html> 