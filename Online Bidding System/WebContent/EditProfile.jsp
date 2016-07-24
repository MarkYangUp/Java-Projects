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
<h1>Edit Profile</h1>
<form action=EditProfileServlet  enctype="multipart/form-data" method="post">
<table border="1">
<c:if test="${not empty user}">
<tr><th>Email Id:</th><td><input type="text" name="email" value="${user.email}"></td></tr>
<tr><th>Password</th><td><input type="text" name="password" value="${user.password}"></td></tr>
<tr><th>Profile Pic</th><td><input type="file" name="pic" id="flUpload" value="${user.picId}" /></td></tr>
<tr><th>Contact Number</th><td><input type="text" name="contactNo" value="${user.contactNo}"></td></tr>
<c:if test="${user.student}">
<tr><th>Semester</th><td><input type="text" name="semester" value="${user.semester}"></td></tr>
</c:if>
<tr><th></th><td><input type="submit" value="submit"></td></tr>
</c:if>
</table>
</form>
</body>
</html>