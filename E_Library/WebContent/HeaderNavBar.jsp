<% 
String ut=(String)session.getAttribute("userType");
String next="index.jsp";
			if(ut!=null){
			
				if(ut.equals("STUDENT")||ut.equals("NONFACULTY"))
					next="entryServlet?uid=f";
					
					else if(ut.equals("ADMIN"))
					next="EnterAdmin.jsp";
				
					else if(ut.equals("FACULTY"))
					next="EnterFaculty.jsp";	
				
			
			
			}

%>

<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="index.html"><img src="" alt=""></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li><a href="">MGI Home</a></li>
					<li><a href="<%=next%>">E-Library Home</a></li>
					<li><a href="Contact.jsp">Contact</a></li>
					<li><a class="btn" href="LogoutServlet">Logout</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->
