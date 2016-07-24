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

<c:if test="${not empty Item }">
<table border="1">
<tr><th>Item Id:</th><th>Item Name</th><th>Description</th><th></th></tr>
<c:forEach var="ni" items="${Item}">

<tr><td>${ni.itemId}</td><td>${ni.itemName }</td><td>${ni.description}</td><td><a href="ItemDetailsServlet?itmid=${ni.itemId}">Details</a></td>

</c:forEach>
</table>
</c:if>
</body>
</html>