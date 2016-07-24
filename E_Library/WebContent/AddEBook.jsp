<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sanil Jain (sanil.jain15@gmail.com)">
	
	<title>E-book</title>

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

	<% 

String userType=(String)session.getAttribute("userType");

if(userType.equals("STUDENT")||userType.equals("NONFACULTY")){
		response.sendRedirect("NonValid.html");
		}

%>
	
	
	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">
		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Add E-Book</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form id="formID" method="post" action="AddEBookServlet"  enctype="multipart/form-data" >		
						<div class="panel panel-default">
						<div class="panel-body rowspan=120">
				
								<hr/>

						
						<%@ include file="EMaterialCommon.jsp"%>
						
						
								<div class="top-margin">	 
										<label>ISBN-10</label>
										  <input class="validate[required] text-input form-control" type="text" name="isbnTen">
										</div>
								
								<div class="top-margin">
								<label>ISBN-13</label>
										  <input  class="validate[required] text-input form-control"  type="text" name="isbnThirteen">
										</div>
										
								
								
										
								<div class="top-margin">
								
								<label>File</label>
								<input class="validate[required]" type="file" name="fn"/>
										
										</div>
								
								<hr>
								
								<div class="col-lg-12 text-right">
										<button class="btn btn-action" type="submit" value="Validate &amp; Send the form!">Add</button>
									</div>
								<br/>
							</div>		
							
						</div>
						
						</form>
					</div>

				
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->
	

	<%@ include file="Footer.jsp" %>		




	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
</body>
</html>