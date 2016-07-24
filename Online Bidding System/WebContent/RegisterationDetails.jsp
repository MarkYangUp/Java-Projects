<%@page import="com.medibidz.entity.UserType"%>
<%@page import="com.medibidz.entity.Registeration"%>
<%@page import="com.medibidz.dao.UserDao"%>
<%@page import="com.medibidz.dao.DaoFactory"%>
<%@page import="com.medibidz.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table border="1">
	
		<c:if test="${not empty reg }">
		<tr>
			<th>Registeration Details</th>
			<th></th>
		</tr>

			<tr>
				<th>Profile Pic:</th>
				<td><c:if test="${not empty reg.picId}"><img src="getImage?id=${reg.picId.imageId}" width="100" height="100" />
					</c:if></td>
			</tr>
			<tr>
				<th>Registeration Id:</th>
				<td>${reg.registerationId}</td>
			</tr>
			<tr>
				<th>First Name:</th>
				<td>${reg.firstName}</td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td>${reg.lastName}</td>
			</tr>
			<tr>
				<th>E-Mail Id:</th>
				<td>${reg.emailId}</td>
			</tr>
			<tr>
				<th>Registeration Date:</th>
				<td>${reg.registerationDate}</td>
			</tr>
			<tr>
				<th>Contact Number:</th>
				<td>${reg.contactNumber}</td>
			</tr>
			<tr>
				<th>User Type</th>
				<td>${reg.userType}</td>
			</tr>

			<c:if test="${reg.student}">
				<tr>
					<th>Enrollment:</th>
					<td>${reg.enrollment}</td>
				</tr>
				<tr>
					<th>Branch:</th>
					<td>${reg.branch.branchName}</td>
				</tr>
				<tr>
					<th>Semester:</th>
					<td>${reg.semester}</td>
				</tr>
			</c:if>

			<c:if test="${reg.faculty}">
				<tr>
					<th>Faculty Id:</th>
					<td>${reg.facultyId}</td>
				</tr>
				<tr>
					<th>Department:</th>
					<td>${reg.department.departmentName}</td>
				</tr>

			</c:if>

			<tr>
				<td><form action="VerifyUserServlet">
						<input type="hidden" name="rid" value="${reg.registerationId }">

						<input type="submit" value="VERIFY">
					</form></td>
				<td><form action="DeleteUserServlet">
						<input type="hidden" name="rid" value="${reg.registerationId }"><input type="submit" value="DELETE">
					</form></td>
			</tr>
			
			</c:if>

</table>

</body>
</html>