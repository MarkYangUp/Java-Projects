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

<c:if test="${not empty newReg }">
<table border="1">
<tr><th>Profile Pic:</th><th>Registeration Id:</th><th>User Name</th><th>User Type</th></tr>
<c:forEach var="nr" items="${newReg}">
<tr><td>
<c:if test="${not empty nr.picId}">
<img src="getImage?id=${nr.picId.imageId }" width="100" height="100"/>
</c:if></td><td>${nr.registerationId}</td><td>${nr.firstName}</td><td>${nr.userType}</td><td><a href="DetailsRegisterationServlet?rid=${nr.registerationId}" >Details</a></td>

</c:forEach>
</table>
</c:if>
</body>
</html>