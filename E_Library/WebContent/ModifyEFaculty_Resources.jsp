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
	<meta name="author"      content="Sanil Jain (sanil.jain15@gmail.com)">
	
	<title>E-book</title>

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
		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Modify E-Faculty Resources</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form action="UpdateServlet">		
				
						<div class="panel panel-default">
						<div class="panel-body rowspan=120">
				
							<hr/>
	
	<%@page import="java.sql.*"%>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mgielib","root","root");
PreparedStatement pst=con.prepareStatement("select * from efacultyresource e,ematerialsbasemaster m where e.id=m.id and e.id=?");
		String uid=(String)request.getAttribute("eid");
		pst.setString(1,uid);
		ResultSet rs=pst.executeQuery();
		
		
		
		
		
		
		if(rs.next())
				{
			
			%>
								
								<input type="hidden" name="usid" value="<%=Integer.parseInt(uid)%>">
								<input type="hidden" name="mtype" value="<%=rs.getString("material_type")%>">
		
									<div class="top-margin">
									<label>Title</label>
									<input type="text" class="form-control" name="title" value="<%=rs.getString("title")%>">
								</div>
								<div class="top-margin">
									<label>Author</label>
									<input type="text" class="form-control" name="authors" value="<%=rs.getString("authors") %>">
								</div>
								<div class="top-margin">
									<label>Language</label>
									<input type="text" class="form-control" name="language" value="<%=rs.getString("language")%>">
								</div>
								<div class="top-margin">
									<label>Publication Year</label>
									<input type="text" class="form-control" name="pubYear" value="<%=rs.getInt("pub_year")%>">
								</div>
								<div class="top-margin">
									<label>Edition</label>
									<input type="text" class="form-control" name="edition" value="<%=rs.getString("edition")%>">
								</div>
								<div class="top-margin">
									<label>Volume</label>
									<input type="text" class="form-control" name="volume" value="<%=rs.getString("volume")%>">
								</div>
								
								<div class="top-margin">
									<label>Description</label>
									<input type="text" class="form-control" name="desc" value="<%=rs.getString("desc")%>">
								</div>
								<div class="top-margin">
									<label>Link</label>
									<input type="text" class="form-control" name="link" value="<%=rs.getString("link")%>">
								</div>
						
												<div class="row top-margin">
								<div class="col-sm-6">
								
								
								<lable>Category</lable>
								
								<select name="category" class="form-control">
								 <%      
								 
								    ArrayList<Category> al=(ArrayList<Category>)request.getAttribute("category");		
								 String cname=rs.getString("cat_name");    
								 for(Category cat:al){   %>
								     <option selected=<%=cat.getCatName()==cname %>><%=cat.getCatName()%></option>
								      <% } %> 
								</select>
								</div>

								<div class="col-sm-6">
								<label>Subject</label>
								<select name="subjectId" class="form-control" >
								
								<%      
								int sid=rs.getInt("sub_id");
								
								    ArrayList<Subject> al1=(ArrayList<Subject>)request.getAttribute("subject");		
								     for(Subject sub:al1){   %>
								     
								     <option value="<%=sub.getSubId()%>"   selected=<%=sub.getSubId()==sid %>><%=sub.getSubName()%></option>
								      <%      
								      }
								     %> 
 
								</select>
								
															</div>
								</div>
								
								
								<div class="row top-margin">
								<div class="col-sm-6">Genre<select name="genre" class="form-control" value="<%=rs.getString("genre_name")%>">
								<%      
								String gname=rs.getString("genre_name"); 
								ArrayList<Genre> al2=(ArrayList<Genre>)request.getAttribute("genre");		
								if(al2!=null){ 
								for(Genre gen:al2){   %>
								     <option selected=<%=gen.getGenreName()==gname%>><%=gen.getGenreName()%></option>
								      <%}} %> 
								</select>
								</div>
								
								
								<div class="col-sm-6"><lable>Publisher</lable><select name="publisherId" class="form-control" value="<%=rs.getInt("pub_id")%>">
								<%      
								int pid=rs.getInt("pub_id");
								
								ArrayList<Publisher> al3=(ArrayList<Publisher>)request.getAttribute("publisher");		
     							for(Publisher pub:al3){   %>
   							 	<option value="<%=pub.getPubId()%>" selected=<%=pub.getPubId()==pid %>><%=pub.getPubName()%></option>
      							<%      
      							}
     							%> 
								</select>
								</div>
								
							</div>
											






								
						<div class="top-margin">	 
										<label>Department</label>
										  <input type="text" class="form-control" name="department" value=<%=rs.getString("department") %>>
										</div>
								
								<div class="top-margin">
								<label>Semester</label>
										  <input type="text" class="form-control" name="semester" value=<%=rs.getString("semester") %>>
										</div>
										
								<%} %>
							
								
								<hr>
								
								<div class="col-lg-12 text-right">
										<button class="btn btn-action" type="submit">Update</button>
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