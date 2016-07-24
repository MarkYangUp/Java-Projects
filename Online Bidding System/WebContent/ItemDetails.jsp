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

<table border="1">
<tr><th align="center" colspan="2">Item Details</th></tr>

<c:if test="${not empty itm }">

<tr><th align="left">Item Id:</th><td>${itm.itemId}</td></tr>
<tr><th align="left">Category Name:</th><td>${itm.categoryName}</td></tr>
<tr><th align="left">Item Name:</th><td>${itm.itemName}</td></tr>
<tr><th align="left">Description:</th><td>${itm.description}</td></tr>
<tr><th align="left">Insertion Date:</th><td>${itm.insertionDate}</td></tr>
<tr><th align="left">Start Bid Price:</th><td>${itm.startBidPrice}</td></tr>
<tr><td align="left"><form action="VerifyItemServlet">
<input type="hidden" name="itm_id" value="${itm.itemId }">
<input type="submit" value="VERIFY"></form></td><td><form action="DeleteItemServlet">
<input type="hidden" name="itm_id" value="${itm.itemId }">
<input type="submit" value="DELETE"></form></td></tr>
</c:if>

</table>
<c:if test="${not empty itm.image1}">
<img src="getImage?id=${itm.image1.imageId }" width="200" height="200"/>
</c:if>
<c:if test="${not empty itm.image2}">
<img src="getImage?id=${itm.image2.imageId}" width="200" height="200"/>
</c:if>
<c:if test="${not empty itm.image3}">
<img src="getImage?id=${itm.image3.imageId}" width="200" height="200"/>
</c:if>
</body>
</html>