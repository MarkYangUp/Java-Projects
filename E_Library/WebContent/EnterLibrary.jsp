<!DOCTYPE html>
<html lang="en">
<%@page import="com.mgielib.dao.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.mgielib.entity.*"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>E-Library Main Page</title>
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.js" type="text/javascript"></script> -->

<script src="jq/jquery.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function(){
        $('input[type="radio"]').click(function(){
            if($(this).attr("value")=="BOOK"){
                $(".box").hide();
                $(".BOOK").show();
            }
            if($(this).attr("value")=="PUBLISH"){
                $(".box").hide();
                $(".PUBLISH").show();
            }
            if($(this).attr("value")=="PROJECTS"){
                $(".box").hide();
                $(".PROJECTS").show();
            }
            if($(this).attr("value")=="FACULTY_RESOURCES"){
                $(".box").hide();
                $(".FACULTY_RESOURCES").show();
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
	<meta name="author"      content="Sanil Jain (sanil.jain15@gmail.com)">
	
	<title>Advanced Search</title>

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

String uid=(String)session.getAttribute("uid");

if(uid==null){
		response.sendRedirect("Invalid.jsp");
		
}

%>
	
	
	
	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container" style="height: auto;">


					<div class="row">
			
			<!-- Article main content -->
			
			<article class="col-xs-12 maincontent" style="height:auto;">
					
				
					<div class="pull-right">
			<%@ include file="Sidebar.jsp" %>		
		</div>		
		<br>
		<br>
		<header class="page-header">	
					<h1 class="page-title">Catelogue Search</h1>
					</header>
			
			<form action="SearchContentServlet" id="formID">
				
	<!-- Highlights - jumbotron -->
	<div class="jumbotron top-space">
		<div class="container">
			
			<h3 class="text-center thin">Search Through</h3>
							
			<div class="row">
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><i class="fa fa-book fa-5"></i><h4><input type="radio" name="eMaterialType" value="BOOK">E-Books</h4></div>
					<div class="h-body text-center">
						<p>Enabling it will search only through E-Books</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><i class="fa fa-clipboard fa-5"></i>
					<h4><input type="radio" name="eMaterialType" value="PUBLISH"> E-Jounals/Papers</h4></div>
					<div class="h-body text-center">
						<p>Enabling it will search only through E-Jornals/Papers</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><i class="fa fa-users fa-5"></i>
					<h4><input type="radio" name="eMaterialType" value="PROJECTS"> E-Projects</h4></div>
					<div class="h-body text-center">
						<p>Enabling it will search only through E-Projects</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 highlight">
					<div class="h-caption"><i class="fa fa-male fa-5"></i>
					<h4><input type="radio" name="eMaterialType" value="FACULTY_RESOURCES"> Faculty Resources</h4></div>
					<div class="h-body text-center">
						<p>Enabling it will search only through Faculty Resouces</p>
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
						<div class="panel-body rowspan=100">
							<h3 class="thin text-center">Advanced Searching Options</h3>
							<p class="text-center text-muted">This option will seach through all of the available E-Content in the Library.</p>
							
							
							<hr>
			
								<div class="top-margin">
								<label>Title</label>
								  <input type="text" class="form-control validate[required] text-input" name="title">
								</div>
								
								<div class="top-margin">
								<label>Author</label>
								  <input type="text" class="form-control" name="authors">
								</div>
								
								
								
								<div class="top-margin">
								<label>Language</label>
								  <input type="text" class="form-control" name="language">
								</div>
								<div class="top-margin">
								<label>Publication Year</label>
								  <input type="text" class="form-control" name="pubYear">
								</div>

								<div class="row top-margin">
									<div class="col-sm-6">
									<label>Edition</label>
									  <input type="text" class="form-control" name="edition">
									</div>
									<div class="col-sm-6">
									<label>Volume</label>
										<input type="text" class="form-control" name="volume">
									</div>
								</div>
								
								
								<div class="row top-margin">
								<div class="col-sm-6">
								<label>Category</label>
								<select name="category" class="form-control">
								 <%      
								    ArrayList<Category> al=(ArrayList<Category>)request.getAttribute("category");		
								     for(Category cat:al){   %>
								     <option><%=cat.getCatName()%></option>
								      <% }
								     %> 
								</select>
								</div>

								<div class="col-sm-6">
								<label>Subject</label>
								<select name="subjectId" class="form-control">
								
								<%      
								    ArrayList<Subject> al1=(ArrayList<Subject>)request.getAttribute("subject");		
								     for(Subject sub:al1){   %>
								     <option value="<%=sub.getSubId()%>"><%=sub.getSubName()%></option>
								      <%      
								      }
								     %> 
 
								</select>
								</div>
								</div>
								
								
							<div class="row top-margin">
								<div class="col-sm-6">
								<label>Genre</label>
								<select name="genre" class="form-control">
								<%      
								    ArrayList<Genre> al2=(ArrayList<Genre>)request.getAttribute("genre");		
								if(al2!=null){ 
								for(Genre gen:al2){   %>
								     <option><%=gen.getGenreName()%></option>
								      <%      
								      }
								}
								     %> 
								
								</select>
								</div>
								
								
								<div class="col-sm-6">
								<label>Publisher</label>
								<select name="publisherId" class="form-control">
								<%      
    							ArrayList<Publisher> al3=(ArrayList<Publisher>)request.getAttribute("publisher");		
     							for(Publisher pub:al3){   %>
   							 	<option value="<%=pub.getPubId()%>"><%=pub.getPubName()%></option>
      							<%      
      							}
     							%> 
								</select>
								</div>
								
							</div>
						<div class="row top-margin">	 
								
								<div class="BOOK box">
								
								E-Book Attributes
								<div class="top-margin">
								<label>ISBN-10</label>
								  <input type="text" class="form-control" name="isbnTen">
								</div>
								<div class="top-margin">
								<label>ISBN-13</label>
								  <input type="text" class="form-control" name="isbnThirteen">
								</div>
								
								</div>
								
								
								
								<div class="PUBLISH box">
								
								<label>E-Journals/Papers.</label>
								<div class="top-margin">
								
								<input type="radio"  name="publishType" value="PAPER"> E-Paper &nbsp&nbsp&nbsp
								<input type="radio"  name="publishType" value="JOURNAL"> E-Journal
								</div>
								<div class="top-margin">
								<label>Year</label>
								  <input type="text" class="form-control" name="year">
								</div>
								<div class="top-margin">
								<label>Month</label>
								  <input type="text" class="form-control" name="month">
								</div>
								
								<div class="top-margin">
								<br/>
								<label>Frequency</label>
								  <input type="text" class="form-control" name="frequency">
								</div>
								
								</div>
									
								
									
								<div class="PROJECTS box">
								
								<label>E-Projects</label> 
								<div class="top-margin">
								<label>Topic</label>
								  <input type="text" class="form-control" name="topic">
								</div>
								
								<div class="top-margin">
								<label>Type</label>
								  <input type="text" class="form-control" name="projectType">
								</div>
								
								<div class="top-margin">
								<label>Top</label>
								  <input type="text" class="form-control" name="top">
								</div>
								</div>
									
								<div class="FACULTY_RESOURCES box">
								<label>Faculty Resources</label> 
								<div class="top-margin">
								<label>Department</label>
								<input type="text" class="form-control" name="department">
								</div>
								<div class="top-margin">
								<label>Semester</label>
								<input type="text" class="form-control" name="semester">
								</div>
								</div>
											
						</div>
								<br/>
								
								<hr>

								<div class="row">
									<div class="col-lg-8"></div>
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">Search</button>
									</div>
									
									
								</div>
						</div>
					</div>

				</div>
				</form>
			</article>
			<!-- /Article -->
				
		</div>
	</div>	
	
	<!-- /container -->
	

	<%@ include file="Footer.jsp" %>
	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
</body>
</html>