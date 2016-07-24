<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <link rel="stylesheet" href="styles/expstickybar.css" />
        <link rel="stylesheet" href="styles/featured_slide.css" type="text/css" />
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


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width:85%; height:150px; background:; border-radius:20px;padding:10px; ">
            <div style="width:65%; height:120px; background:;  border-radius: 20px ;float:left;" >
            <font color="white" size=6><h1 align="left"><i>Medibidzs</i></h1></font>
            </div>
             			 <div style="width:65%; height:120px; background:;  border-radius: 20px ;float:right;color: red;" >
            <font color="white" size=4><a href="Login.jsp">LOGIN</a></font>

            </div>
     
                 </div>


      
      

      <center>
      <div style="width:85%; height:1900px; background:; border-radius:20px;padding:10px; ">
               
           


 
             <div id="grad2" style="width:100%; height:50px; background:; border-radius: 10px ; box-shadow: 5px 5px 5px grey; ">
 

                    <div class="div_hover" style="width:14%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:; border-right:thin solid white;  ">
                                  <font  size=5><a class="a_link" href="HomePage.jsp"   style="text-decoration:none" >Home </a></font> 
                            </div>
                    </div>
                    <div class="div_hover" style="width:14%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href="AboutUs.jsp"   style="text-decoration:none" >About us </a></font>
                            </div> 
                    </div>
                    <div class="div_hover" style="width:16%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href="Categories.jsp" style="text-decoration:none" >Categories </a></font>
                            </div> 
                    </div>
                    <div class="div_hover" style="width:16%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:; border-right:thinB solid white;  ">
                               <font  size=5><a class="a_link" href="GetFreeItemServlet"   style="text-decoration:none" >Free Items</a></font> 
                            </div>
                    </div>
                    <div class="div_hover" style="width:15%; height:50px; background:; float:left;">
                            <div  style="width:100%; height:10px; background:; ">
                            </div>

                            <div style="width:100%; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href="GetItemByPrice"   style="text-decoration:none" >View by price</a></font>
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

</body>
</html>