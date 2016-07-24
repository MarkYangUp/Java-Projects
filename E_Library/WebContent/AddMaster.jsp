<!DOCTYPE html>
<html lang="en">
<%@page import="com.mgielib.dao.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.mgielib.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>E-Library Main Page</title>
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.js" type="text/javascript"></script> -->

<script src="jq/jquery.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function(){
        $('input[type="radio"]').click(function(){
            if($(this).attr("value")=="Genre"){
                $(".box").hide();
                $(".Genre").show();
            }
            if($(this).attr("value")=="Category"){
                $(".box").hide();
                $(".Category").show();
            }
            if($(this).attr("value")=="Subject"){
                $(".box").hide();
                $(".Subject").show();
            }
            if($(this).attr("value")=="Publisher"){
                $(".box").hide();
                $(".Publisher").show();
            }
        });
    });
</script>

<style type="text/css">
    .box{
        
     padding: 20px;
        display: none;
        margin-top: 20px;
        
    }
    
    .BOOK{ background: #ffffff; }
    .PROJECTS{ background: #ffffff; }
    .PUBLISH{ background: #ffffff; }
    .FACULTY_RESOURCES{ background: #ffffff; }
</style>



	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Add Master</title>
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
			jQuery("#formID1").validationEngine({scroll: false});
			jQuery("#formID2").validationEngine({scroll: false});
			jQuery("#formID3").validationEngine({scroll: false});
			jQuery("#formID4").validationEngine({scroll: false});
		});
	</script>


	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">

	

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
	<div class="container" style="height: auto;">

		<ol class="breadcrumb">
			<li><a href="index.html">Home</a></li>
			<li class="active">Login</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent" style="height:auto;">
				<header class="page-header">
					<h1 class="page-title">Add Master</h1>
				</header>
			
				
	<!-- Highlights - jumbotron -->
	<div class="jumbotron top-space">
		<div class="container">
			
			<h3 class="text-center thin">Add Master Details </h3>
							
			<div class="row">
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><i class="fa fa-list-alt fa-5"></i><h4><input type="radio" name="AddType" value="Genre">Genre</h4></div>
					<div class="h-body text-center">
						<p>Add's Genre</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><i class="fa fa-sort-alpha-asc fa-5"></i>
					<h4><input type="radio" name="AddType" value="Category">Category</h4></div>
					<div class="h-body text-center">
						<p>Add's Category</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><i class="fa fa-columns fa-5"></i>
					<h4><input type="radio" name="AddType" value="Subject">Subject</h4></div>
					<div class="h-body text-center">
						<p>Add's Subject</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><i class="fa fa-smile-o fa-5"></i>
					<h4><input type="radio" name="AddType" value="Publisher">Publisher</h4></div>
					<div class="h-body text-center">
						<p>Add's Publisher</p>
					</div>
				</div>
			</div> <!-- /row  -->
		
		</div>
	</div>
	<!-- /Highlights -->
	
	<br>			
	<br>			
			
		
				
									
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					
					<div class="panel panel-default">
				
						<div class="panel-body rowspan=40">
								
								<center><h1>	
									${error}
									${success}
									</h1>
								</center>			
								<div class="row top-margin">	 
									
								<div class="Genre box">
								<form id="formID1" action="GenreServlet" method="post" >
													
									
									Enter Genre:<input  class="form-control text-input validate[required]" type="text" name="genreName"/>
									<div class="row">
									<div class="col-lg-8"></div>
									<br>
									<div class="col-lg-12 text-right">
										<button class="btn btn-action"  type="submit">Add</button>
									</div></div>
									<hr>
									
									<c:if test="${not empty gen}">
									<center>
									<table cellpadding="10" cellspacing="20" border="2">
									<tr>
									<th>GenreName
									</th>
									</tr>
									
									<c:forEach var="c" items="${gen}">
									<tr>
									<td>
									${c.genreName}
									</td>
									</tr>
									</c:forEach>
									
									</table>
									</center>
									</c:if>
								</form>
								

								
								
								</div>
								
								
								
								<div class="Category box">
								
								<form action="CategoryServlet" id="formID2">
								
									
									Enter Category:<input class="form-control validate[required] text-input" type="text"  name="catName"/>
									<div class="row">
									<div class="col-lg-8"></div>
									<br>
									<div class="col-lg-12 text-right">
										<button class="btn btn-action" type="submit">Add</button>
									</div></div>
									<hr>
									
									<c:if test="${not empty cat}">
									<center>
									<table cellpadding="10" cellspacing="20" border="2">
									<tr>
									<th>Category Name
									</th>
									</tr>
									
									<c:forEach var="c" items="${cat}">
									
									<tr>
									<td>
									${c.catName}
									</td>
									</tr>
									</c:forEach>
									
									</table>
									</center>
									</c:if>
								</form>
								

								</div>
									
								
									
							<div class="Subject box">
							<form action="SubjectServlet"  id="formID3">
							
							Subject Name:<input class="form-control validate[required] text-input" type="text"  name="subName"/><br/>
							Subject Category:<input  class="form-control validate[required] text-input" type="text" name="category"/><br/>
							<div class="row">
									<div class="col-lg-8"></div>
									<br>
									<div class="col-lg-12 text-right">
										<button class="btn btn-action" type="submit">Add</button>
									</div></div>
							<hr>
							
							<c:if test="${not empty sub}">
							<center>		
							<table cellspacing="20" cellpadding="10" border="2">
							<tr><th>Subject Name</th><th>Subject Category</th></tr>
							<c:forEach var="c" items="${sub}">
							<tr>
							<td>
							${c.subName}
							</td>
							<td>
							${c.category}
							</td>
							</tr>
							</c:forEach>
							
							</table>
							</center>
							</c:if>
							</form>
							
								</div>
								
								
								
													
									
								<div class="Publisher box">
								<form action="PublisherServlet" id="formID4">
							
							Publisher Name<input class="form-control validate[required] text-input"  type="text" name="pubName"/><br/>
							Publisher URL<input  value="http://" class="validate[required,custom[url]] text-input form-control" type="text" name="url"/><br/>
							Description<input  class="form-control validate[required] text-input " type="text" name="description"/><br/>
							<div class="row">
									<div class="col-lg-8"></div>
									<br>
									<div class="col-lg-12 text-right">
										<button class="btn btn-action" type="submit" >Add</button>
									</div></div>
							
							<hr>
							${error}
							${success}
							<center>
							<c:if test="${not empty pub}">
							<table cellspacing="20" border="2" cellpadding="10">
							<tr><th>Publisher Name</th><th>Publisher URL</th><th>Description</th></tr>
							<c:forEach var="c" items="${pub }">
							<tr>
							<td>
							${c.pubName}
							</td>
							<td>
							${c.url}
							</td>
							<td>
							${c.description}
							</td>
							</tr>
							</c:forEach>
							
							</table>
							</c:if>
						
							</form>
							</center>	
																
						</div>
								<br/>
								</div>
								</div>

								
					</div>

				</div>
				
							</article>
			<!-- /Article -->

		</div>
	</div>	
	
	
			
	
	
	
	
	
	
	
	
	
	<!-- /container -->
	<%@ include file="Footer.jsp" %>

	



	
</body>
</html>