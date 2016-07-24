<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sanil Jain(sanil.jain15@gmail.com)">
	
	<title>Faculty page</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->

</head>

<body>

<%@ include file="HeaderNavBar.jsp" %>
<% 

String userType=(String)session.getAttribute("userType");

if(userType.equals("STUDENT")||userType.equals("NONFACULTY")){
		response.sendRedirect("NonValid.html");
		}

%>

<header id="head" class="secondary"></header>


			
<div class="container">
			
			<div class="row">

	<header class="page-header">
					<h1 class="page-title">Faculty Facilities</h1>
				</header>
					


	
	<div class="container"  style="background-color:#f7f5f4;align-self:stretch;">



	<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><h4><a href="entryServlet?uid=b"><i class="fa fa-female fa-5"></i> Faculty Resouces</a></h4></div>
				</div>
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><h4>	<a href="entryServlet?uid=e"><i class="fa fa-search-plus fa-5"></i>Search</a></h4></div>
				</div>
				
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><h4>	<a href="entryServlet?uid=g"><i class="fa fa-edit fa-5"></i>Modify</a></h4></div>
				</div>
				
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><h4>	<a href="entryServlet?uid=h"><i class="fa fa-trash-o fa-5"></i>Delete</a></h4></div>
				</div>








</div>
</div>
	<h2>${error}</h2>
				<h2>${success}</h2>

</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="Footer.jsp" %>



</body>
</html>