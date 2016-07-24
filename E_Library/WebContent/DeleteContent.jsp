<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sanil Jain(sanil.jain15@gmail.com)">
	
	<title>Delete Content Admin Page</title>

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


<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			
			<li class="active">User access</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Search & Delete</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Search</h3>
							<p class="text-center text-muted">Search quickly the content ,type either name or author then click delete to delete the content </p>
						
							<hr>
							
							<form action="DeleteSearchServlet">
								<div class="top-margin">
	
									<aside class="col-sm-12 sidebar sidebar-right">

										<div class="widget">
										<input type="text" class="form-control" class="search-query" placeholder="Search & Enter" name="quickSearch">  
										</div>

			</aside>
															
												</div>
							</form>
						</div>
	${error}
	${success}


					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->

<br>
<br>
<br>
<%@ include file="Footer.jsp" %>

</body>
</html>