<%@page import="com.medibidz.entity.CategoryTypes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
                <link rel="stylesheet" href="styles/expstickybar.css" />
        <link rel="stylesheet" href="styles/featured_slide.css" type="text/css" />



<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">

 <link rel="stylesheet" type="text/css" href="css/font-awesome.css">
  
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">





        <script src="scripts/expstickybar.js"></script>
        <script type="text/javascript" src="scripts/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="scripts/jquery.jcarousel.pack.js"></script>
	<script type="text/javascript" src="scripts/jquery.jcarousel.setup.js"></script>
       
        <script type="text/javascript" src="scripts/jquery.waterwheelCarousel.js"></script>
        <script type="text/javascript" src="scripts/jquery.waterwheelCarousel.setup.js"></script>
        <script >
        window.onload = function(){ 
	//Get submit button
	var submitbutton = document.getElementById("tfq");
	//Add listener to submit button
	if(submitbutton.addEventListener){
		submitbutton.addEventListener("click", function() {
			if (submitbutton.value == 'Search our website'){//Customize this text string to whatever you want
				submitbutton.value = '';
			}
		});
	  }
        }
</script>
       <style>

	.tftextinput2{
		margin: 0;
		padding: 5px 15px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		color:grey;
		border:1px solid grey; border-right:0px;
		border-top-left-radius: 5px 5px;
		border-bottom-left-radius: 5px 5px;
	}
	.tfbutton2 {
		margin: 0;
		padding: 5px 7px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		font-weight:bold;
		outline: none;
		cursor: pointer;
		text-align: center;
		text-decoration: none;
		color: white;
		border: solid 1px grey; 
		background: -webkit-radial-gradient(grey,white); /* Safari 5.1 to 6.0 */
	        background: -o-radial-gradient(grey,white ); /* For Opera 11.6 to 12.0 */
                background: -moz-radial-gradient(grey,white ); /* For Firefox 3.6 to 15 */
                background: radial-gradient(grey,white ); /* Standard syntax (must be last) */
		border-top-right-radius: 5px 5px;
		border-bottom-right-radius: 5px 5px;
	}
	.tfbutton2:hover {
		text-decoration: none;
                background: -webkit-radial-gradient(white,grey); /* Safari 5.1 to 6.0 */
	        background: -o-radial-gradient(white,grey ); /* For Opera 11.6 to 12.0 */
                background: -moz-radial-gradient(white,grey ); /* For Firefox 3.6 to 15 */
                background: radial-gradient(white,grey); /* Standard syntax (must be last) */
		
	}
	/* Fixes submit button height problem in Firefox */
	.tfbutton2::-moz-focus-inner {
	  border: 0;
	}
	.tfclear{
		clear:both;
	}
       #grad1
       {
        height:700px;
       background: -webkit-linear-gradient(#55aba8,#fce45c,white); /* For Safari 5.1 to 6.0 */
       background: -o-linear-gradient(#55aba8,#fce45c,white); /* For Opera 11.1 to 12.0 */
       background: -moz-linear-gradient(#55aba8,#fce45c,white); /* For Firefox 3.6 to 15 */
       background: linear-gradient(#55aba8,#fce45c,white)); /* Standard syntax (must be last) */
       }
       #grad2
       {
	 height:150px;
	 width:200px;
	 background: -webkit-radial-gradient(white,#55aba8); /* Safari 5.1 to 6.0 */
	 background: -o-radial-gradient(white,#55aba8); /* For Opera 11.6 to 12.0 */
         background: -moz-radial-gradient(white,#55aba8); /* For Firefox 3.6 to 15 */
         background: radial-gradient(white,#55aba8 ); /* Standard syntax (must be last) */
       }
       .a_link
       {
           color: grey;
       }
       .a_link2
       {
           color: black;
       }
       .a_link3
       {
           color: #2E2E2E;
       }
       .div_hover:hover 
       { 
          background-color: white;
          
          
       } 
       .div_hover2:hover 
       { 
           
          border:solid 2px yellow; 
       }
      
       div.transbox:hover
       {
           border:solid 2px yellow; 
           background-color:black;
           opacity:0.3;
           filter:alpha(opacity=60); /* For IE8 and earlier */
       }
       #wrapper .text 
        {
           position:relative;
           bottom:200px;
           left:20px;
           visibility:hidden;
        }

       #wrapper:hover .text
       {

        visibility:visible;
       }

       
       </style>



</head>

<body>
<div id="grad1" >

   <center>
   <div style ="width:90%; height:3000px; background:; "  >




      <div style="width:85%; height:150px; background:; border-radius:20px;padding:10px; ">
            <div style="width:65%; height:120px; background:;  border-radius: 20px ;float:left;" >
            <font color="white" size=6><h1 align="left"><i>Medibidzs</i></h1></font>            </div>
     
            
      </div>


      
      

      <center>
      <div style="width:85%; height:1900px; background:; border-radius:20px;padding:10px; ">
               
           


 
             <div id="grad2" style="width:100%; height:50px; background:; border-radius: 10px ; box-shadow: 5px 5px 5px grey; ">
 

                    <div class="div_hover" style="width:12%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:; border-right:thin solid white;  ">
                                  <font  size=5><a class="a_link" href="Homepage.html"   style="text-decoration:none" >Home </a></font> 
                            </div>
                    </div>
                    <div class="div_hover" style="width:12%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href=""   style="text-decoration:none" >About us </a></font>
                            </div> 
                    </div>
                    <div class="div_hover" style="width:16%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href=""   style="text-decoration:none" >All Items</a></font>
                            </div> 
                    </div>
                    <div class="div_hover" style="width:17%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:; border-right:thin solid white;  ">
                               <font  size=5><a class="a_link" href=""   style="text-decoration:none" >Free Items</a></font> 
                            </div>
                    </div>
                    <div class="div_hover" style="width:15%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href=""   style="text-decoration:none" >Contact Us</a></font>
                            </div> 
                    </div>

                    <div style="width:21%; height:30px; background:; float:left;padding:10px;">
                            <div id="tfheader">
		               <form id="tfnewsearch" >
		               <input type="text" id="tfq" class="tftextinput2" name="q" size="21" maxlength="120" value="Search our website"><input type="submit" value=">" class="tfbutton2">
		               </form>
		               <div class="tfclear">
                               </div>
	                    </div>     
                   
                    </div>
             </div>

<br>
<br>
 
 <div id="grad2" style="width:98.5%; height:800px; background:; border-radius: 10px ;padding:1%; box-shadow: 5px 5px 5px grey; ">
       

        <div   style="width:100%; height:3%; text-align:center; float:right;background:;"><font size=5 color="grey">CATEGORIES</font>

</div>
<div   style="width:100%; height:4%; text-align:center; float:right;background:;">

</div>

<div   style="width:100%; height:100%; text-align:left; float:left;background:;">   
  
 

  <div   style="width:38%; height:63%; text-align:left; float:left;background:;">   
  		<a href="CategoryServlet?catName=<%=CategoryTypes.BOOKS%>">
<div   style="width:100%;height:30%; text-align:center; float:left;background:#1E90FF;">

			<div   style="width:90%; height:100%; text-align:center; float:left;background:;">
				<br><br><font size=4  color="white"> <i class="fa fa-book fa-5x"></i> </font>   
			</div>
			<div   style="width:5%; height:100%; text-align:center; float:RIGHT;background:;">
		 		<font  size=5 color="white">B O O K S </font>
			</div>

</div>  </a>
   <div   style="width:100%; height:1%; text-align:left; float:left;background:;">

</div>
  <div   style="width:100%; height:70%; text-align:left; float:left;background:;"> 

     <div   style="width:100%; height:49.5%; text-align:left; float:left;background:;"> 
 <a href="CategoryServlet?catName=<%=CategoryTypes.NOTES%>">
 	 <div   style="width:49.5%; height:100%; text-align:center; float:left;background:#9ACD32;"> 

			<div   style="width:90%; height:100%; text-align:center; float:left;background:;">
				<br><br><font size=4  color="white"> <i class="fa fa-list fa-5x"></i> </font>   
			</div>
			<div   style="width:10%; height:100%; text-align:center; float:LEFT;background:;">

		 	<br><font  size=5 color="white">N O T E S</font>
			</div>

	</div>
</a>
<div   style="width:1%; height:100%; text-align:left; float:left;background:;"> 

</div>
<a href="CategoryServlet?catName=<%=CategoryTypes.TOOLS%>">

<div   style="width:49.5%; height:100%; text-align:center; float:left;background:#F08080;">

			<div   style="width:100%; height:80%; text-align:center; float:left;background:;">
				<br><br><font size=4  color="white"> <i class="fa fa-gavel fa-5x"></i> </font>   
			</div>
			<div   style="width:100%; height:12%; text-align:center; float:LEFT;background:;">
		 		<font  size=5 color="white">T O O L S </font>
			</div>			
			

</div>
</a>
</div>
<div   style="width:100%; height:1%; text-align:left; float:left;background:;">

</div>

<div   style="width:100%; height:49.5%; text-align:left; float:left;background:;"> 
   <a href="CategoryServlet?catName=<%=CategoryTypes.STATIONERY%>">
   
  <div   style="width:49.5%; height:100%; text-align:center; float:left;background:#9932CC;"> 

		<div   style="width:100%; height:80%; text-align:center; float:left;background:;">
				<br><br><font size=4  color="white"> <i class="fa fa-pencil fa-5x"></i> </font>   
			</div>
			<div   style="width:100%; height:12%; text-align:center; float:LEFT;background:;">
		 		<font  size=5 color="white">S T A T I O N E R Y </font>
			</div>
</div>
</a>
<div   style="width:1%; height:100%; text-align:left; float:left;background:;"> 

</div>
<a href="CategoryServlet?catName=<%=CategoryTypes.OTHERS%>">

<div   style="width:49.5%; height:100%; text-align:center; float:left;background:#00BFFF;"> 

			<div   style="width:90%; height:100%; text-align:center; float:left;background:;">
				<br><br><font size=4  color="white"> <i class="fa fa-tag fa-5x"></i> </font>   
			</div>
			<div   style="width:10%; height:100%; text-align:center; float:LEFT;background:;">
		 		<font  size=5 color="white">O T H E R S </font>
			</div>

</div>
</a>
</div>



</div>
</div>
        <div   style="width:1%; height:63%; text-align:left; float:left;background:;">

</div>
<a href="CategoryServlet?catName=<%=CategoryTypes.ELECTRONICGADGETS%>">

    <div   style="width:20%; height:63%; text-align:center; float:left;background:#9370DB;"> 
 
	<div   style="width:90%; height:100%; text-align:center; float:left;background:;">
		<br><br><br><br><br><br><br><br><br><font size=4  color="white"> <i class="fa fa-laptop fa-5x"></i> </font> 
	</div>	
	<div   style="width:10%; height:100%; text-align:center; float:right;background:;">
		<font  size=5 color="white">E L E C T R O N I C &nbsp;&nbsp; G A D G E T S  </font>
	</div>
	
    </div>
</a>
    <div   style="width:1%; height:63%; text-align:left; float:left;background:;">

    </div>
    <div   style="width:39.7%; height:63%; text-align:left;padding:1px; float:left;background:;">

    	<div   style="width:100%; height:49%; text-align:left;padding:; float:left;background:;">

<a href="CategoryServlet?catName=<%=CategoryTypes.TOLET%>">
   
     		<div   style="width:49.5%; height:100%; text-align:center; float:left;background:#C71585;">

			<div   style="width:100%; height:88%; text-align:center; float:left;background:;">
				<br><br><br><br><font size=4  color="white"> <i class="fa fa-home fa-5x"></i> </font>   
			</div>
			<div   style="width:100%; height:12%; text-align:center; float:LEFT;background:;">
		 		<font  size=5 color="white">T O-L E T</font>
			</div>
		</div>
</a>         	
		<div   style="width:1%; height:100%; text-align:left; float:left;background:;">

		</div>
		<a href="CategoryServlet?catName=<%=CategoryTypes.CLOTHES%>">
		
		<div   style="width:49.5%; height:100%; text-align:center; float:left;background:#006400;"> 

			<div   style="width:90%; height:100%; text-align:center; float:left;background:;">
			      <br>  <br><br><br><font size=4  color="white"> <i class="fa fa-shopping-cart fa-5x"></i> </font>
			</div> 
			<div   style="width:10%; height:100%; text-align:center; float:LEFT;background:;">
		 		<br><font  size=5 color="white">C L O T H E S</font>
			</div>
		</div>
		</a>
	</div>

<div   style="width:100%; height:1%; text-align:left; float:left;background:;">

</div>

<div   style="width:100%; height:50%; text-align:left;padding:; float:left;background:;">

   <a href="CategoryServlet?catName=<%=CategoryTypes.BAGS%>">
   
     <div   style="width:49.5%; height:100%; text-align:center; float:left;background:#FF7F50;">

			<div   style="width:90%; height:100%; text-align:center; float:left;background:;">
			        <br><br><br><br><font size=4  color="white"> <i class="fa fa-suitcase fa-5x"></i> </font>
			</div> 
			<div   style="width:10%; height:100%; text-align:center; float:LEFT;background:;">
		 		<br><br><br><font  size=5 color="white">B A G S </font>
			</div> 
	</div></a>


         <div   style="width:1%; height:100%; text-align:left; float:left;background:;">

		</div>
		
		<a href="CategoryServlet?catName=<%=CategoryTypes.VEHICLES%>">
		
			<div   style="width:49.5%; height:100%; text-align:center;float:left;background:#0000FF;"> 

<div   style="width:100%; height:88%; text-align:center; float:left;background:;">	
				<br><br><br><br><font size=4  color="white"> <i class="fa fa-truck fa-5x"></i> </font>   
			</div>
			<div   style="width:100%; height:12%; text-align:center; float:LEFT;background:;">
		 		<font  size=5 color="white">V E H I C L E S</font>
			</div>
</div>
</a>

</div>
</div>

<div   style="width:100%; height:1%; text-align:left; float:left;background:;">   
</div>
<a href="CategoryServlet?catName=<%=CategoryTypes.SOUVENIRS%>">

<div   style="width:100%; height:20%; text-align:center; float:left;background:#DB7093;"> 

			<div   style="width:100%; height:80%; text-align:center; float:left;background:;">
				<br><font size=4  color="white"> <i class="fa fa-trophy fa-5x"></i> </font>   
			</div>
			<div   style="width:100%; height:10%; text-align:center; float:LEFT;background:;">
		 		<font  size=5 color="white">C O L L E G E &nbsp &nbsp  S O U V E N I R </font>
			</div>
</div>
</a>
    </div>   
   
   <div  id="stickybar" class="expstickybar">
<a href="#togglebar"><img src="images/open.gif" data-closeimage="images/close.gif" data-openimage="images/open.gif" style="border-width:0; float:right;" /></a>

        <div style="text-align:center;padding-top:3px">Quick Links</div>


            <div class="resources" style="margin-top:10px">


               <div style="float:left;">
		
                <ul>
	
                   <li><a href="">Home</a></li>
	
                   <li><a href="">Categories</a></li>
	
                   <li><a href="">About Us</a></li>
	
               </ul>

              </div>


           <div style="float:left">

            <ul>
	
                 <li><a href="">Sign Out</a></li>
	
                 <li><a href="">Sign In</a></li>
	
                 <li><a href="">Sign Up</a></li>
	
            </ul>
 
   </div>
</div>




 
 
</div>
</center>
</div>
</body></html>
