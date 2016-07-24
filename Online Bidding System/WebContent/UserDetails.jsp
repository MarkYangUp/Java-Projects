<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	
		<c:if test="${not empty user }">
		<tr>
			<th>User Details</th>
			<th></th>
		</tr>

			<tr>
				<th>Profile Pic:</th>
				<td><c:if test="${not empty user.picId}"><img src="getImage?id=${user.picId.imageId}" width="100" height="100" />
					</c:if></td>
			</tr>
			<tr>
				<th>User Id:</th>
				<td>${user.Id}</td>
			</tr>
			<tr>
				<th>Name:</th>
				<td>${user.firstName}&nbsp;&nbsp;${user.lastName}</td>
			</tr>
			
			<tr>
				<th>E-Mail Id:</th>
				<td>${user.email}</td>
			</tr>
			<tr>
				<th>Contact Number:</th>
				<td>${user.contactNumber}</td>
			</tr>
			<tr>
				<th>User Type</th>
				<td>${user.userType}</td>
			</tr>

			<c:if test="${user.student}">
				<tr>
					<th>Enrollment:</th>
					<td>${user.enrollment}</td>
				</tr>
				<tr>
					<th>Branch:</th>
					<td>${user.branch.branchName}</td>
				</tr>
				<tr>
					<th>Semester:</th>
					<td>${user.semester}</td>
				</tr>
			</c:if>

			<c:if test="${user.faculty}">
				<tr>
					<th>Faculty Id:</th>
					<td>${user.facultyId}</td>
				</tr>
				<tr>
					<th>Department:</th>
					<td>${user.department.departmentName}</td>
				</tr>

			</c:if>

			<tr>
				<td></td>
				<td><form action="DeleteUserServlet">
						<input type="hidden" name="uid" value="${user.id}"><input type="submit" value="DELETE">
					</form></td>
			</tr>
			
			</c:if>

</table>

</body>
</html>