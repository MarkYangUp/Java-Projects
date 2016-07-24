<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registeration</title>
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.js" type="text/javascript"></script> -->

<script src="jq/jquery.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function(){
        $('input[type="radio"]').click(function(){
            if($(this).attr("value")=="FACULTY"){
                $(".box").hide();
                $(".FACULTY").show();
            }
            if($(this).attr("value")=="STUDENT"){
                $(".box").hide();
                $(".STUDENT").show();
            }
           
        });
    });
</script>

<style type="text/css">
    .box{
        padding: 20px;
        display: none;
        margin-top: 20px;
        border: 1px solid #ffffff;
    }
    
</style>
</head>
<body>
 
<h1> Registeration Form</h1><br><br>
	
	<form  action="Register" method="post" enctype="multipart/form-data">
	<table>
		<tr><td>Profile Picture:</td><td><input type="file" name="pic" id="flUpload" /></td></tr>
		
		<tr><td>emailId*: </td><td><input type="text" name="emailId" ></td></tr>
		
		<tr><td>Password*: </td><td><input type="password" name="password"></td></tr>
			
		<tr><td>First Name*: </td><td><input type="text" name="firstName" ></td></tr>
		
		<tr><td>Last Name*: </td><td><input type="text" name="lastName" ></td></tr>
	 	
	 	<tr><td>Contact No*: </td><td><input type="text" name="contactNumber" ></td></tr>
	 	
		<tr><td>Title*: </td><td><input type="radio" name="title" value="Mr">Mr.</td><td><input type="radio" name="title" value="Ms">Ms.</td></tr>
		</table>
	
		<div>
        <label><input type="radio" name="user" value="FACULTY">FACULTY</label>
        <label><input type="radio" name="user" value="STUDENT">STUDENT</label>
        
   		 </div>

    
    <div class="FACULTY box">
    	<table>
    
		<tr><td>FacultyId*: </td><td><input type="text" name="facultyId" ></td></tr>
	 	<tr><td>Department*:</td><td>
	 	<select name="deptId" >

<c:if test="${not empty dptLst }">
<c:forEach var="d" items="${dptLst }">
<option value="${d.departmentId}">${d.departmentName }</option>

</c:forEach>

</c:if>


</select>
</td></tr>
   </table>
    </div>
    <div class="STUDENT box">
   
		       <table>
    	<tr><td>Enrollment*: </td><td><input type="text" name="enrollment" ></td></tr>
	
	 	<tr><td>Branch*:</td><td>
<select name="branchId" >

<c:if test="${not empty brLst }">
<c:forEach var="b" items="${brLst }">
<option value="${b.branchId}">${b.branchName }</option>
</c:forEach>

</c:if>


</select>
</td></tr>
    	<tr><td>Semester*:</td><td><input type="text" name="semester" ></td></tr>
    	</table>
    	</div>          		
     		<table>
			<tr><td></td><td align="right"><input type="submit" value="Submit"></td></tr>
		</table>
	
	</form>

</body>
</html>