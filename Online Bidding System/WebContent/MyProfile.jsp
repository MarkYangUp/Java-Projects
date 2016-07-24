<%@page import="com.medibidz.entity.UserType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/expstickybar.css" />
<link rel="stylesheet" href="styles/featured_slide.css" type="text/css" />
<script src="scripts/expstickybar.js"></script>
<script type="text/javascript" src="scripts/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="scripts/jquery.jcarousel.pack.js"></script>
<script type="text/javascript" src="scripts/jquery.jcarousel.setup.js"></script>

<script type="text/javascript"
	src="scripts/jquery.waterwheelCarousel.js"></script>
<script type="text/javascript"
	src="scripts/jquery.waterwheelCarousel.setup.js"></script>
<script>
        window.onload = function(){ 
	//Get submit button
	var submitbutton = document.getElementById("tfq");
	//Add listener to submit button
	if(submitbutton.addEventListener){
		submitbutton.addEventListener("click", function() {
			if (submitbutton.value == 'Search our website'){//Customize this text string to whatever you want
				submitbutton.value = '';
			}
		});
	  }
        }
</script>
<style>
.tftextinput2 {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: grey;
	border: 1px solid grey;
	border-right: 0px;
	border-top-left-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
}

.tfbutton2 {
	margin: 0;
	padding: 5px 7px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-weight: bold;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	color: white;
	border: solid 1px grey;
	background: -webkit-radial-gradient(grey, white);
	/* Safari 5.1 to 6.0 */
	background: -o-radial-gradient(grey, white);
	/* For Opera 11.6 to 12.0 */
	background: -moz-radial-gradient(grey, white);
	/* For Firefox 3.6 to 15 */
	background: radial-gradient(grey, white);
	/* Standard syntax (must be last) */
	border-top-right-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
}

.tfbutton2:hover {
	text-decoration: none;
	background: -webkit-radial-gradient(white, grey);
	/* Safari 5.1 to 6.0 */
	background: -o-radial-gradient(white, grey);
	/* For Opera 11.6 to 12.0 */
	background: -moz-radial-gradient(white, grey);
	/* For Firefox 3.6 to 15 */
	background: radial-gradient(white, grey);
	/* Standard syntax (must be last) */
}
/* Fixes submit button height problem in Firefox */
.tfbutton2::-moz-focus-inner {
	border: 0;
}

.tfclear {
	clear: both;
}

#grad1 {
	height: 700px;
	background: -webkit-linear-gradient(#55aba8, #fce45c, white);
	/* For Safari 5.1 to 6.0 */
	background: -o-linear-gradient(#55aba8, #fce45c, white);
	/* For Opera 11.1 to 12.0 */
	background: -moz-linear-gradient(#55aba8, #fce45c, white);
	/* For Firefox 3.6 to 15 */
	background: linear-gradient(#55aba8, #fce45c, white));
	/* Standard syntax (must be last) */
}

#grad2 {
	height: 150px;
	width: 200px;
	background: -webkit-radial-gradient(white, #55aba8);
	/* Safari 5.1 to 6.0 */
	background: -o-radial-gradient(white, #55aba8);
	/* For Opera 11.6 to 12.0 */
	background: -moz-radial-gradient(white, #55aba8);
	/* For Firefox 3.6 to 15 */
	background: radial-gradient(white, #55aba8);
	/* Standard syntax (must be last) */
}

.a_link {
	color: grey;
}

.a_link2 {
	color: black;
}

.a_link3 {
	color: #2E2E2E;
}

.div_hover:hover {
	background-color: white;
}

.div_hover2:hover {
	border: solid 2px yellow;
}

div.transbox:hover {
	border: solid 2px yellow;
	background-color: black;
	opacity: 0.3;
	filter: alpha(opacity = 60); /* For IE8 and earlier */
}

#wrapper .text {
	position: relative;
	bottom: 200px;
	left: 20px;
	visibility: hidden;
}

#wrapper:hover .text {
	visibility: visible;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
	<div id="grad1">

		<center>
			<div style="width: 90%; height: 3000px; background:;">




				<div
					style="width: 85%; height: 150px; background:; border-radius: 20px; padding: 10px;">
					<div
						style="width: 65%; height: 120px; background:; border-radius: 20px; float: left;">
						<font color="white" size=6><h1 align="left">
								<i>Medibidzs</i>
							</h1></font>
					</div>



					<div a class="a_link"
						style="width: 30%; height: 50px; text-align: right; border-radius: 20px; float: left;">
						<a href="HomePage.jsp">Home</a> <a href="LogoutServlet">Logout</a>
						<br>
					</div>
				</div>




				<center>
					<div
						style="width: 85%; height: 1900px; background:; border-radius: 20px; padding: 10px;">





						<div id="grad2"
							style="width: 100%; height: 50px; background:; border-radius: 10px; box-shadow: 5px 5px 5px grey;">


							<div class="div_hover"
								style="width: 12%; height: 50px; background:; float: left;">
								<div style="width: 100%; height: 10px; background:;"></div>

								<div
									style="width: 100%; height: 30px; background:; border-right: thin solid white;">
									<font size=5><a class="a_link" href="HomePage.jsp"
										style="text-decoration: none">Home </a></font>
								</div>
							</div>
							<div class="div_hover"
								style="width: 12%; height: 50px; background:; float: left;">
								<div style="width: 100%; height: 10px; background:;"></div>

								<div
									style="width: 100%; height: 30px; background:; border-right: thin solid white;">
									<font size=5><a class="a_link" href="AboutUs.jsp"
										style="text-decoration: none">About us </a></font>
								</div>
							</div>
							<div class="div_hover"
								style="width: 16%; height: 50px; background:; float: left;">
								<div style="width: 100%; height: 10px; background:;"></div>

								<div
									style="width: 100%; height: 30px; background:; border-right: thin solid white;">
									<font size=5><a class="a_link" href="Categories.jsp"
										style="text-decoration: none">Categories </a></font>
								</div>
							</div>
							<div class="div_hover"
								style="width: 16%; height: 50px; background:; float: left;">
								<div style="width: 100%; height: 10px; background:;"></div>

								<div
									style="width: 100%; height: 30px; background:; border-right: thinB solid white;">
									<font size=5><a class="a_link" href="GetFreeItemServlet"
										style="text-decoration: none">Free Items</a></font>
								</div>
							</div>
							<div class="div_hover"
								style="width: 15%; height: 50px; background:; float: left;">
								<div style="width: 100%; height: 10px; background:;"></div>

								<div
									style="width: 100%; height: 30px; background:; border-right: thin solid white;">
									<font size=5><a class="a_link" href="GetItemByPrice"
										style="text-decoration: none">View by price</a></font>
								</div>
							</div>

							<div
								style="width: 21%; height: 30px; background:; float: left; padding: 10px;">
								<div id="tfheader">
									<form id="tfnewsearch">
										<input type="text" id="tfq" class="tftextinput2" name="q"
											size="21" maxlength="120" value="Search our website"><input
											type="submit" value=">" class="tfbutton2">
									</form>
									<div class="tfclear"></div>
								</div>

							</div>
						</div>

						<br>

						<div id="grad2"
							style="width: 100%; height: 300px; border-radius: 10px; box-shadow: 5px 5px 5px grey;">


							<div a class="a_link"
								style="width: 100%; height: 10%; text-align: center; float: right; background:;">
								<font size=5>PROFILE</font>

							</div>
							<div
								style="width: 2%; height: 90%; text-align: center; float: left; background:;">
							</div>

							<div
								style="width: 20%; height: 75%; float: left; padding:; background:; border-style: solid; border-width: 1px;">
							</div>


							<div
								style="width: 20%; height: 65%; float: left; padding: 3%; background:;">
								<div
									style="width: 98%; height: 98%; border-style:; border-width: 1px; border-color: grey; background:;">

									
									<c:if test="${not empty user}">

										<c:if test="${not empty user.picId}">
											<img src="getImage?id=${user.picId.imageId }" width="100"
												height="100" />
										</c:if>
										<div
											style="width: 100%; height: 15%; text-align: left; float: left; background:;">

											<div a class="a_link"
												style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">
												<font size=5><align="left">Name:
													&nbsp;${user.firstName}</align></font>
											</div>
										</div>

										<c:if test="${user.faculty}">
											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">
													<font size=5><align="left">Faculty
														Id:&nbsp;${user.facultyId }</align></font>
												</div>
											</div>

											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">

													<font size=5><align="left">Department:&nbsp;${user.department.departmentName }</align></font>
												</div>
											</div>
										</c:if>

										<c:if test="${user.student}">
											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">
													<font size=5><align="left">Enrollment:
														&nbsp;${user.enrollment}</align></font>
												</div>
											</div>

											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">

													<font size=5>Branch&nbsp;${user.branch.branchName }</font>
												</div>
												</a>
											</div>

											<div
												style="width: 100%; height: 15%; text-align: left; float: left; background:;">

												<div a class="a_link"
													style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">

													<font size=5>Semester&nbsp;${user.semester}</font>
												</div>
											
											</div>
										</c:if>


										<div
											style="width: 100%; height: 15%; text-align: left; float: left; background:;">

											<div a class="a_link"
												style="width: 100%; height: 100%; border-style:; border-width: 1px; border-color:; background:;">

												<font size=5>Contact No.&nbsp;${user.contactNo}</font>
											</div>
											
										</div>
								</div>
	</c:if>
							</div>
									</div>
			<br>

			<div id="grad2"
				style="width: 90.5%; height: 700px; background:; border-radius: 10px; padding: 5%; box-shadow: 5px 5px 5px grey;">



				<div
					style="width: 23%; height: 70%; text-align: center; float: left; background: #F08080;">
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br> <font size=4 color="white"> <i
						class="fa fa-male fa-5x"></i>
					</font> <br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<div
						style="width: 100%; height: 10%; text-align: center; float: left; background:;">
						<font size=5 color="white">M Y &nbsp;&nbsp; P O S T </font>
					</div>
				</div>
				<div
					style="width: 2%; height: 70%; text-align: left; float: left; background:;">

				</div>
				<div
					style="width: 40%; height: 70%; text-align: left; float: left; background:;">

					<div
						style="width: 100%; height: 30%; text-align: center; float: left; background: #00BFFF;">
						<font size=4 color="white"> <i class="fa fa-male fa-5x"></i>
						</font> <br>
						<br> <a href="History.jsp">
							<div
								style="width: 100%; height: 12%; text-align: center; float: left; background:;">
								<font size=5 color="white">C U R R E N T &nbsp;&nbsp; S T A T U S</font>
							</div>
						</a>
					</div>

					<div
						style="width: 100%; height: 3%; text-align: left; float: left; background:;">

					</div>
					<div
						style="width: 48.5%; height: 67%; text-align: center; float: left; background: #9370DB;">
						<br>
						<br>
						<br>
						<br>
						<br> <font size=4 color="white"><i
							class="fa fa-shopping-cart fa-5x"></i> </font> <br>
						<br>
						<br>
						<br>
						<br> <a href="Buyer.jsp">
							<div
								style="width: 100%; height: 12%; text-align: center; float: left; background:;">
								<font size=5 color="white">B U Y </font>
							</div>
						</a>
					</div>

					<div
						style="width: 3%; height: 70%; text-align: left; float: left; background:;">

					</div>

					<div
						style="width: 48.5%; height: 67%; text-align: center; float: left; background: #FF7F50;">
						<br>
						<br>
						<br>
						<br>
						<br> <font size=4 color="white"> <i
							class="fa fa-money fa-5x"></i>
						</font> <br>
						<br>
						<br>
						<br>
						<br> <a href="ItemSell.jsp">
							<div
								style="width: 100%; height: 12%; text-align: center; float: left; background:;">
								<font size=5 color="white">S E L L</font>
							</div>
						</a>

					</div>

				</div>

				<div
					style="width: 2%; height: 70%; text-align: left; float: left; background:;">

				</div>
				
				<a href="GetUserDetailsServlet" method="post">
				<div
					style="width: 32%; height: 34%; text-align: center; float: left; background: #9ACD32;">
					<br>
					<br>
					<br> <font size=4 color="white"> <i
						class="fa fa-edit fa-5x"></i>
					</font> <br>
					<br>
					<br>
					<div
						style="width: 100%; height: 12%; text-align: center; float: left; background:;">
						<font size=5 color="white">E D I T &nbsp;&nbsp; P R O F I L E</font>
					</div>

				</div>
			</a>
				<div
					style="width: 32%; height: 2%; text-align: left; float: left; background:;">

				</div>

				<div
					style="width: 32%; height: 34%; text-align: center; float: left; background: #5F9EA0;">
					<br>
					<br>
					<br> <font size=4 color="white"> <i
						class="fa fa-gift fa-5x"></i>
					</font> <br>
					<br>
					<br>
					<div
						style="width: 100%; height: 12%; text-align: center; float: left; background:;">
						<font size=5 color="white">W I S H &nbsp;&nbsp; L I S T</font>
					</div>

				</div>





			</div>
		</center>
	</div>
	<h1>
		Welcome &nbsp;&nbsp;<font color="red"></font>
	</h1>
	Sell Item
	</a>&nbsp;&nbsp; Buy Item
	</a>&nbsp;&nbsp;
	<a href="History.jsp">View History</a>

</body>
</html>