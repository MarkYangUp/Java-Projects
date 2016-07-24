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

<c:if test="${not empty itm }">

<table>
<tr><th>Item&nbsp;${itm.itemName}</th></tr>
<tr><td><hr></td></tr>
<tr><th>Item Id:</th><th></th><th>Item Name</th><th></th><th>Description</th><th></th><th>Last Date</th><th></th><th>Insertion Date</th><th></th><th>Start Bid Price</th></tr>
<tr><td>${itm.itemId}</td><td></td><td>${itm.itemName }</td><td></td><td>${itm.description}</td><td></td><td>${itm.lastDate}</td><td></td><td>${itm.insertionDate}</td><td></td><td>${itm.startBidPrice}</td>
</table>

<c:if test="${not empty itm.image1}">
<img src="getImage?id=${itm.image1.imageId }" width="100" height="100"/>
</c:if>
<c:if test="${not empty itm.image2}">
<img src="getImage?id=${itm.image2.imageId}" width="100" height="100"/>
</c:if>
<c:if test="${not empty itm.image3}">
<img src="getImage?id=${itm.image3.imageId}" width="100" height="100"/>
</c:if>&nbsp;&nbsp;&nbsp;&nbsp;
<form action="BidEnterServlet">
Enter Your Bid:RS.<input type="text" name="bidPrice">&nbsp;&nbsp;&nbsp;<input type="submit" value="SUBMIT">
</form>
<hr><br><br>

</c:if>
</body>
</html>