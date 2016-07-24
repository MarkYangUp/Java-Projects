<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sanil Jain(sanil.jain15@gmail.com)">
	
	<title>Contact Librarian</title>

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


<header id="head" class="secondary"></header>

<!-- container -->
	<div class="container">

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-sm-9 maincontent">
				<header class="page-header">
					<h1 class="page-title">Contact us</h1>
				</header>
				
				<p>
					We would love to hear from you. Fill out the form below with you suggestions,queries  and We will get back to you as soon as possible. Please allow a couple days for us to respond.
				</p>
				<br>
					<form>
						<div class="row">
							<div class="col-sm-4">
								<input class="form-control" type="text" placeholder="Name">
							</div>
							<div class="col-sm-4">
								<input class="form-control" type="text" placeholder="Email">
							</div>
							<div class="col-sm-4">
								<input class="form-control" type="text" placeholder="Phone">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-12">
								<textarea placeholder="Type your message here..." class="form-control" rows="9"></textarea>
							</div>
						</div>
						<br>
						<div class="row">
							
							<div class="col-sm-12 text-right">
								<input class="btn btn-action" type="submit" value="Send message">
							</div>
						</div>
					</form>

			</article>
			<!-- /Article -->
			
			
			<!-- Sidebar -->
			<aside class="col-sm-3 sidebar sidebar-right">

								
					
			

				<div class="widget">
					<h3>Quick Search</h3>
					<form action="QuickSearchServlet">
					<input type="text" class="form-control" class="search-query" placeholder="Search & Enter" name="quickSearch">  
					</form>  					
										
					<br>
					
					<h4>Address</h4>
					<address>
						MEDI-CAPS GROUP OF INSTITUTES
						CENTRAL LIBRARY
					</address>
					<h4>Phone:</h4>
					<address>
						+0000000000
					</address>
				</div>

			</aside>
			<!-- /Sidebar -->

		</div>
	</div>	<!-- /container -->
<br>
<br>
<br>
<br>

<%@ include file="Footer.jsp" %>
</body>
</html>