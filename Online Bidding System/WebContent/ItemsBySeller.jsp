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
<c:if test="${not empty sellItem }">

<c:forEach var="si" items="${sellItem}">
<table>
<tr><th>Item&nbsp;${si.itemId}</th></tr>
<tr><td><hr></td></tr>
<tr><th>Item Id:</th><th></th><th>Item Name</th><th></th><th>Description</th><th></th><th>Last Date</th><th></th><th>Insertion Date</th><th></th><th>Start Bid Price</th></tr>
<tr><td>${si.itemId}</td><td></td><td>${si.itemName }</td><td></td><td>${si.description}</td><td></td><td>${si.lastDate}</td><td></td><td>${si.insertionDate}</td><td></td><td>${si.startBidPrice}</td>
</table>

<c:if test="${not empty si.image1}">
<img src="getImage?id=${si.image1.imageId }" width="100" height="100"/>
</c:if>
<c:if test="${not empty si.image2}">
<img src="getImage?id=${si.image2.imageId}" width="100" height="100"/>
</c:if>
<c:if test="${not empty si.image3}">
<img src="getImage?id=${si.image3.imageId}" width="100" height="100"/>
</c:if>&nbsp;&nbsp;&nbsp;&nbsp;<h2><a href="ViewAllBidServlet?ItemId=${si.itemId}">View Bid List</a></h2>
<h2><a href="DeleteItemServlet?itemId=${si.itemId}">Delete Item</a></h2>
<hr><br><br>
</c:forEach>
</c:if>
</body>
</html>