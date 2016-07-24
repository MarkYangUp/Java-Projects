<!DOCTYPE html>
<%@page import="com.medibidz.entity.CategoryTypes"%>
<html>
<head>

<title>Seller</title>
  <link rel="stylesheet" href="jquery-dt/jquery-ui.css" />
  <script src="jquery-dt/jquery-1.9.1.js"></script>
  <script src="jquery-dt/jquery-ui.js"></script>
  
 <!--  <link rel="stylesheet" href="jquery-dt/style.css" /> -->
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({
    	changeMonth: true,
		changeYear: true,
		dateFormat: 'dd-M-yy'    	
    });
  });
  </script>
  
</head>
<body>
<h1>SELLER FORM</h1>
<hr>
<p>Fill the required form with appropriate details.</p>
<form  action="addItem" method="post" enctype="multipart/form-data">
<table>
		<tr><td>Category*: </td><td>
		<select name="categoryName">
		<option><%=CategoryTypes.ELECTRONICGADGETS %></option>
		<option><%=CategoryTypes.BOOKS %></option>
		<option><%=CategoryTypes.BAGS%></option>
		<option><%=CategoryTypes.CLOTHES%></option>
		<option><%=CategoryTypes.NOTES%></option>
		<option><%=CategoryTypes.STATIONERY%></option>
		<option><%=CategoryTypes.VEHICLES%></option>
		<option><%=CategoryTypes.TOOLS %></option>
		<option><%=CategoryTypes.TOLET%></option>
		<option><%=CategoryTypes.SOUVENIRS%></option>
		<option><%=CategoryTypes.OTHERS%></option>
		</select></td></tr>
		<tr><td>Name of item*: </td><td><input type="text" name="itemName" ></td></tr>			
		<tr><td>Description*: </td><td><textarea rows="" cols="" name="description"></textarea></td></tr>
		<tr><td>Last Date*: </td><td><input type="text"  placeholder="DD-MMM-YYYY" name="lastDateStr" id="datepicker"></td></tr>
		<tr><td>Start Bid Price*: </td><td><input type="text" name="startBidPrice" ></td></tr>
		<tr><td>Kindly upload 3 best pictures</td></tr>
		<tr><td>Image 1:</td><td><input type="file" name="img1" id="flUpload" /></td></tr>
		<tr><td>Image 2:</td><td><input type="file" name="img2" /></td></tr>
		<tr><td>Image 3:</td><td><input type="file" name="img3"/></td>
		</tr>		 	
	 	<tr><td> </td><td><input type="submit" value="submit" ></td></tr>	 	
		</table>			
	</form>
	</body>
</html>