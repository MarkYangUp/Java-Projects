<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller</title>
</head>
<body>
<h1>SELLER FORM</h1>
<hr>
<p>Fill the required form with appropriate details.</p>
<form  action="SellerServlet" method="post">
<table>
		<tr><td>Category*: </td><td><input type="text" name="category" ></td></tr>
		
		<tr><td>Name of item*: </td><td><input type="text" name="itemname" ></td></tr>
			
		<tr><td>Description*: </td><td><input type="textarea" rows="9" name="desc" ></td></tr>
		<tr><td>Kindly upload 3 best pictures</td></tr>
		<tr><td>Image 1:</td><td><input type="text" name="name1" value="1." placeholder="Name of file" ></td><td><input type="file" name="img1" /></td></tr>
		<tr><td>Image 2:</td><td><input type="text" name="name2"  value="2."></td><td><input type="file" name="img2" /></td></tr>
		<tr>
		<td>Image 3:</td>
		<td><input type="text" name="name3" value="3."placeholder="Name of file" ></td>
		<td><input type="file" name="img3"/></td>
		</tr>
		<tr><td>Last Date*: </td><td><input type="text"  placeholder="DD/MM/YY" name="lastdate" ></td></tr>
		
		<tr><td>Start Bid*: </td><td><input type="text" name="startbid" ></td></tr>
	
	 	<tr><td>email*: </td><td><input type="text" name="email" ></td></tr>
	 	
	 	<tr><td>Contact No*: </td><td><input type="text" name="contactNo" ></td></tr>
	 	
	 	<tr><td> </td><td><input type="submit" value="submit" ></td></tr>
	 	
		</table>
	
			
	</form>


</body>
</html>