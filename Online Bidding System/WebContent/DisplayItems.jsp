<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int c=0; %>
<c:if test="${not empty item }">
<c:forEach var="i" items="${item}">
<table>
<% c++; %>
<tr><th>Item&nbsp;<%=c%></th></tr>
<tr><td><hr></td></tr>
<tr><th>Item Id:</th><th></th><th>Item Name</th><th></th><th>Description</th><th></th><th>Last Date</th><th></th><th>Insertion Date</th><th></th><th>Start Bid Price</th></tr>
<tr><td>${i.itemId}</td><td></td><td>${i.itemName }</td><td></td><td>${i.description}</td><td></td><td>${i.lastDate}</td><td></td><td>${i.insertionDate}</td><td></td><td>${i.startBidPrice}</td>
</table>

<c:if test="${not empty i.image1}">
<img src="getImage?id=${i.image1.imageId }" width="100" height="100"/>
</c:if>
<c:if test="${not empty i.image2}">
<img src="getImage?id=${i.image2.imageId}" width="100" height="100"/>
</c:if>
<c:if test="${not empty i.image3}">
<img src="getImage?id=${i.image3.imageId}" width="100" height="100"/>
</c:if>&nbsp;&nbsp;&nbsp;&nbsp;<h2><a href="BidServlet?bidItemId=${i.itemId}">Bid on Item</a></h2>
<hr><br><br>
</c:forEach>
</c:if>
</body>
</html>