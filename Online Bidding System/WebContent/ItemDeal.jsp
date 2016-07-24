<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ApprovDealServlet">


<table cellspacing="4" border="0">
<tr>
	<c:if test="${not empty item}">
<input type="hidden" name="bidId" value="${bidId}">


<table>
<tr><th>Item&nbsp;${item.itemId}</th></tr>
<tr><td><hr></td></tr>
<tr><th>Item Id:</th><th></th><th>Item Name</th><th></th><th>Description</th><th></th><th>Last Date</th><th></th><th>Insertion Date</th><th></th><th>Start Bid Price</th></tr>
<tr><td>${item.itemId}</td><td></td><td>${item.itemName }</td><td></td><td>${item.description}</td><td></td><td>${item.lastDate}</td><td></td><td>${item.insertionDate}</td><td></td><td>${item.startBidPrice}</td>
<%
Boolean status=(Boolean)request.getAttribute("status");
if(status==false){
%>
<td><input type="submit" name="submit" value="Confirm Deal"></td>
<%}else{ %>
<hr>
YOUR DEAL IS ACCEPTED PLEASE CALL RESPECTIVE BUYER!!!!
DELETE YOUR ITEM IF DEAL IS DONE!!!!!!!!!
<hr>
<%} %>
</tr>
</table>
Item Selling Price : ${itemp}
<hr>
<c:if test="${not empty item.image1}">
<img src="getImage?id=${item.image1.imageId }" width="100" height="100"/>
</c:if>
<c:if test="${not empty item.image2}">
<img src="getImage?id=${item.image2.imageId}" width="100" height="100"/>
</c:if>
<c:if test="${not empty item.image3}">
<img src="getImage?id=${item.image3.imageId}" width="100" height="100"/>
</c:if>
	
	</c:if>
</tr>


<hr>
<tr><hr>
	<h1><font color="red">Buyer Information</font></h1>	
<c:if test="${not empty buyer}">

										<c:if test="${not empty buyer.picId}">
											<img src="getImage?id=${buyer.picId.imageId }" width="100"
												height="100" />
										</c:if>
										<div
											style="width: 100%; height: 15%; text-align: left; float: left; background:;">

											<div a class="a_link"
												style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">
												<font size=5><align="left">Name:
													&nbsp;${buyer.firstName}</align></font>
											</div>
										</div>

										<c:if test="${buyer.faculty}">
											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">
													<font size=5><align="left">Faculty
														Id:&nbsp;${buyer.facultyId }</align></font>
												</div>
											</div>

											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">

													<font size=5><align="left">Department:&nbsp;${buyer.department.departmentName }</align></font>
												</div>
											</div>
										</c:if>

										<c:if test="${buyer.student}">
											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">
													<font size=5><align="left">Enrollment:
														&nbsp;${buyer.enrollment}</align></font>
												</div>
											</div>

											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">

													<font size=5>Branch&nbsp;${buyer.branch.branchName }</font>
												</div>
											
											</div>

											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">

													<font size=5>Semester&nbsp;${buyer.semester}</font>
												</div>
											
											</div>
										</c:if>


										<div
											style="width: 100%; height: 15%; text-align: left; float: left; background:;">

											<div a class="a_link"
												style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">

												<font size=5>Contact No.&nbsp;${buyer.contactNo}</font>
											</div>
											
										</div>
	</c:if>

</tr>

</table>
</form>

</body>
</html>