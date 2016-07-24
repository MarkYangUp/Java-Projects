<!DOCTYPE html>
<%@page import="com.mgielib.util.DBUtil"%>
<html lang="en">
<%@page import="com.mgielib.dao.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.mgielib.entity.*"%>

<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sanil Jain (sanil.jain15@gmail.com)">
	
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
	
	
<%@ include file="HeaderNavBar.jsp" %>
<header id="head" class="secondary"></header>


				
				<% 
				Connection con=DBUtil.getConnection();
		PreparedStatement pstMaterial=con.prepareStatement("select * from ematerialsbasemaster where id=?");
				String uid=(String)request.getAttribute("uid");
		pstMaterial.setString(1,uid);
		ResultSet rs=pstMaterial.executeQuery();
		
		
		if(rs.next())
				{
			
			%>
									<div class="top-margin">
									<label>Title</label>
									<input type="text" class="form-control" name="title" value="<%=rs.getString(8) %>">
								</div>
								<div class="top-margin">
									<label>Author</label>
									<input type="text" class="form-control" name="authors" value="<%=rs.getString(14) %>">
								</div>
								<div class="top-margin">
									<label>Language</label>
									<input type="text" class="form-control" name="language" value="<%=rs.getString(9)%>">
								</div>
								<div class="top-margin">
									<label>Publication Year</label>
									<input type="text" class="form-control" name="pubYear" value="<%=rs.getInt(10)%>">
								</div>
								<div class="top-margin">
									<label>Edition</label>
									<input type="text" class="form-control" name="edition" value="<%=rs.getString(14)%>">
								</div>
								<div class="top-margin">
									<label>Volume</label>
									<input type="text" class="form-control" name="volume" value="<%=rs.getString(12)%>">
								</div>
								
								<div class="top-margin">
									<label>Description</label>
									<input type="text" class="form-control" name="desc" value="<%=rs.getString(15)%>">
								</div>
								<div class="top-margin">
									<label>Link</label>
									<input type="text" class="form-control" name="link" value="<%=rs.getString(13)%>">
								</div>
						
						
							<div class="row top-margin">
								<div class="col-sm-6">
								
								<label>Category</label>
								
								<input type="text" class="form-control" name="category" value=<%=rs.getString(4)%>>
								
								</div>

								<div class="col-sm-6">
								
								<label>Subject</label>
								<input type="text" class="form-control" name="subject" value="<%=rs.getInt(5)%>">
						
								</div>
								</div>
								
								
							<div class="row top-margin">
								<div class="col-sm-6"><label>Genre</label>
								<input type="text" class="form-control" name="genre" value="<%=rs.getString(3)%>">
								</div>
								
								
								<div class="col-sm-6"><label>Publisher</label>
								<input type="text" class="form-control" name="publisher" value="<%=rs.getInt(2)%>">
								
								</div>
								
							</div>
							<%
							}%>
							
	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>						
							
</body>
</html>