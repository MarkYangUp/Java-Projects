<!DOCTYPE html>
<html lang="en">
<%@page import="com.mgielib.dao.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.mgielib.entity.*"%>

<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"     content="Sanil Jain (sanil.jain15@gmail.com)">
	
	<title>Common Material JSP</title>

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
	
	
				
							
								<div class="top-margin">
									<label>Title</label>
									<input class="form-control validate[required] text-input" type="text" name="title">
								</div>
								<div class="top-margin">
									<label>Author</label>
									<input  class="form-control validate[required] text-input" type="text" name="authors">
								</div>
								<div class="top-margin">
									<label>Language</label>
									<input  class="form-control validate[required] text-input" type="text" name="language">
								</div>
								<div class="top-margin">
									<label>Publication Year</label>
									<input  class="form-control validate[required] text-input" type="text" name="pubYear">
								</div>
								<div class="top-margin">
									<label>Edition</label>
									<input  class="form-control validate[required] text-input" type="text" name="edition">
								</div>
								<div class="top-margin">
									<label>Volume</label>
									<input  class="form-control validate[required] text-input" type="text" name="volume">
								</div>
								
								<div class="top-margin">
									<label>Description</label>
									<input  class="form-control validate[required] text-input" type="text" name="description">
								</div>
								<div class="top-margin">
									<label>Link</label>
									<input  value="http://" class="validate[required,custom[url]] form-control" type="text"  name="link">
								</div>
						
						
							<div class="row top-margin">
								<div class="col-sm-6">
								
								<lable>Category</lable>
								
								<select name="category" class="form-control validate[required] text-input ">
								 <%      
								    ArrayList<Category> al=(ArrayList<Category>)request.getAttribute("category");		
								     for(Category cat:al){   %>
								     <option><%=cat.getCatName()%></option>
								      <% }
								     %> 
								</select>
								</div>

								<div class="col-sm-6">Subject
								<select name="subjectId" class="form-control validate[required] text-input">
								
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
								<div class="col-sm-6">Genre<select name="genre" class="form-control validate[required] text-input">
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
								
								
								<div class="col-sm-6"><lable>Publisher</lable><select name="publisherId" class="form-control validate[required] text-input">
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
							
	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>						
							
</body>
</html>