<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sanil Jain(sanil.jain15@gmail.com)">
	
	<title>Sign In Page</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="jqv/css/validationEngine.jquery.css" type="text/css"/>
<link rel="stylesheet" href="jqv/css/template.css" type="text/css"/>
<script src="jqv/js/jquery-1.8.2.min.js" type="text/javascript">
	</script>
	<script src="jqv/js/languages/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8">
	</script>
	<script src="jqv/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
	<script>
		jQuery(document).ready( function() {
			// binds form submission and fields to the validation engine
			jQuery("#formID").validationEngine();
		});
	</script>
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

		<ol class="breadcrumb">
			
			<li class="active">User access</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Sign in</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Sign in to your account</h3>
							<p class="text-center text-muted">Login to your respective account to traverse the E-Library for Medi-Caps Group Of Instituions.. </p>
						
							<hr>
							
							<form action="MainServlet" method="post" id="formID">
								<div class="top-margin">
									<label>Username/Email <span class="text-danger">*</span></label>
									<input  class="form-control validate[required] text-input" type="text" name="loginId">
								</div>
								<div class="top-margin">
									<label>Password <span class="text-danger">*</span></label>
									<input class="form-control validate[required] " type="password"  name="password">
								</div>

								<hr>

								<div class="row">
									
									<div class="col-lg-12 text-right">
										<button class="btn btn-action" type="submit">Sign in</button>
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->


<%@ include file="Footer.jsp" %>

</body>
</html>