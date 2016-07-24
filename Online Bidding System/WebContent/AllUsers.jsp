<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AllUsers.jsp</title>
</head>
<body>
<c:if test="${not empty allUser}">
<table border="1">
<tr><th>Profile Pic:</th><th>Email Id:</th><th>User Name</th><th>User Type</th><th></th></tr>
<c:forEach var="au" items="${allUser}">
<tr><td>
<c:if test="${not empty au.picId}">
<img src="getImage?id=${au.picId.imageId }" width="100" height="100"/>
</c:if></td><td>${au.email}</td><td>${au.firstName}&nbsp;&nbsp;${au.lastName}</td><td>${au.userType}</td><td><a href="DetailsUserServlet?uid=${au.id}" >Details</a></td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>