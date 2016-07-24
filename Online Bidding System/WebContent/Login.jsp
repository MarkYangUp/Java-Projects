<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<form  action="UserValidateServlet" method="post">
	
	<hr>
	${param.error}
	
		<table border="0" >
		<tr><td>
		 Id:</td><td><input type="text" name="loginId"></td></tr>
		<tr><td>Password: </td><td><input type="password" name="pwd"></td></tr>
		<tr><td></td><td align="right"><input type="submit" value="login"></td>
		</tr>
		<tr><td>New User Click</td><td><a href="Register">Here</a></td></tr>
		<tr><td><a href="ForgotPasswordServlet">Forgot Password??</a></td></tr>
		</table>
	</form> 
</body>
</html>