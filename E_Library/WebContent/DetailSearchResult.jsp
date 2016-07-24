<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.mgielib.dao.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.mgielib.entity.*"%>
<head>
<title>Show </title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript">
 $(function() {
		/* For zebra striping */
        $("table tr:nth-child(odd)").addClass("odd-row");
		/* For cell text alignment */
		$("table td:first-child, table th:first-child").addClass("first");
		/* For removing the last border */
		$("table td:last-child, table th:last-child").addClass("last");
});
</script>


<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sanil Jain (sanil.jain15@gmail.com)">
	
	<title>Search Result </title>

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
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">View Search Details</h1>
				</header>
				
				<div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Detailed Result</h3>
							<p class="text-center text-muted">Click on down arrow download the content </p>
							<hr>

<%EMaterialsBaseEntity data=(EMaterialsBaseEntity)request.getAttribute("data");%>
	
	<div class="top-margin">
									<label>Title </label>
									${data.getTitle()}
						
	</div>
								
	<div class="top-margin">
									<label>Authors </label>
									${data.getAuthors()}
	</div>
	
	
	
	<div class="top-margin">
									<label>Category </label>
									${data.getCategory()}
	</div>
	
	<div class="top-margin">
									<label>Genre </label>
									${data.getGenre()}
	</div>
	
	
	<div class="top-margin">
									<label>Subject </label>
									${data.getSubject().getSubName()}
	</div>
	
	
	
	
	<div class="top-margin">
									<label>Material Type </label>
									${data.getMaterialType()}
	</div>
	
	<div class="top-margin">
									<label>Language </label>
									${data.getLanguage()}
	</div>
	
	<div class="top-margin">
									<label>Publication Year </label>
									${data.getPubYear()}
	</div>
	
	<div class="top-margin">
									<label>Edition </label>
									${data.getEdition()}
	</div>
	
	<div class="top-margin">
									<label>Volume </label>
									${data.getVolume()}
	</div>
	
	<div class="top-margin">
									<label>Link </label>
									${data.getLink()}
	</div>
						
	<div class="top-margin">
									<label>Publisher </label>
									${data.getPublisher().getPubName()}
	</div>
								
								
								
								
								<hr>
	
	<c:url value="download" var="u">
    <c:param name="dnid" value="${data.getDataStorageId()}"></c:param>
    
    </c:url>
   	<a href="${u}">Download</a> 
  

</div>

</div>
					</div>

				</article>
				</div>
				
			
`

</div>






<br>
<br>
<br>
<br>
<br>

<%@ include file="Footer.jsp" %>
<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>


</body>
</html>
