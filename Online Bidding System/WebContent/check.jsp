<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<html>

<head>
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
	#grad3
       {
        
       background: -webkit-radial-gradient(#55aba8,#fce45c,white); /* For Safari 5.1 to 6.0 */
       background: -o-radial-gradient(#55aba8,#fce45c,white); /* For Opera 11.1 to 12.0 */
       background: -moz-gradient(#55aba8,#fce45c,white); /* For Firefox 3.6 to 15 */
       background: linear-gradient(#55aba8,#fce45c,white)); /* Standard syntax (must be last) */
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
  <div style ="width:1200px; height:3000px; background:; "  >



       <center>
       <div style="width:1030px; height:130px; background:; border-radius:20px;padding:10px; ">
            
            <font color="white" size=6><h1 align="left"><i>Medibidzs</i></h1></font>            
            
      </div>
       <div style="width:65%; height:120px; background:;  border-radius: 20px ;float:right;color: red;" >
            <font color="white" size=4><a href="Login.jsp">LOGIN</a></font>

            </div>
     
       </center>

      
      

     <center>
      <div style="width:1030px; height:1900px; background:; border-radius:20px;padding:10px; ">
           


 		<center>
               <div id="grad2" style="width:1030px; height:50px; background:; border-radius: 10px ; box-shadow: 5px 5px 5px grey; ">
 

                    <div class="div_hover" style="width:150px; height:50px; background:; float:left;">
                            <div  style="width:150px; height:10px; background:; ">
                            </div>

                            <div style="width:150px; height:30px; background:; border-right:thin solid white;  ">
                                  <font  size=5><a class="a_link" href="HomePage.jsp"   style="text-decoration:none;" >Home </a></font> 
                            </div>
                    </div>
                    <div class="div_hover" style="width:150px; height:50px; background:; float:left;">
                            <div  style="width:150px; height:10px; background:; ">
                            </div>

                            <div style="width:150px; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href="AboutUs.jsp"   style="text-decoration:none;" >About Us </a></font>
                            </div> 
                    </div>
                    <div class="div_hover" style="width:165px; height:50px; background:; float:left;">
                            <div  style="width:165px; height:10px; background:; ">
                            </div>

                            <div style="width:165px; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href="Categories.jsp" s  style="text-decoration:none" >Categories</a></font>
                            </div> 
                    </div>
                    <div class="div_hover" style="width:165px; height:50px; background:; float:left;">
                            <div  style="width:165px; height:10px; background:; ">
                            </div>

                            <div style="width:165px; height:30px; background:; border-right:thin solid white;  ">
                               <font  size=5><a class="a_link" href="GetFreeItemServlet"   style="text-decoration:none" >Free Items</a></font> 
                            </div>
                    </div>
                    <div class="div_hover" style="width:155px; height:50px; background:; float:left;">
                            <div  style="width:155px; height:10px; background:; ">
                            </div>

                            <div style="width:155px; height:30px; background:;  border-right:thin solid white; ">
                               <font  size=5><a class="a_link" href="GetItemByPrice"   style="text-decoration:none" >All Items</a></font>
                            </div> 
                    </div>

                    <div style="width:220px; height:30px; background:; float:left;text-align:center;padding:10px;">
                            <div id="tfheader">
		               <form id="tfnewsearch" action="SearchCriteriaServlet">
		               <input type="text" id="tfq" class="tftextinput2" name="q" size="21" maxlength="120" value="Search our website"><input type="submit" value=">" class="tfbutton2">
		               </form>
		               <div class="tfclear">
                               </div>
	                    </div>     
                   
                    </div>
             </div>
	     </center>
<br>
<br>

                   <center>


                   <div class="wrapper col3" style="width:1130px; height:300px; background:;  text-align:center;border-radius: 20px ;">
                            <div id="waterwheelCarousel">
                                 
				 <a href="HomePage.jsp"> <img src="images/Categories1/Stationary.jpg" alt="" /></a>
                                 <a href="HomePage.jsp">  <img src="images/Categories1/Drafter.jpg" alt="" /></a>+>
                                 <img src="images/Categories1/Pendrive.jpg" alt="" />
                                 
    				 <img src="images/Categories1/Laptops.jpg" alt="" />
				 <img src="images/Categories1/Book.jpg" alt="" />
				 <img src="images/Categories1/Harddisk.jpg" alt="" />
    				 <img src="images/Categories1/Blazer.jpg" alt="" />
				 <img src="images/Categories1/Camera.jpg" alt="" />
   				 <img src="images/Categories1/Phone.jpeg" alt="" />
   				
                                 
  				 <img src="images/Categories1/Bag.jpg" alt="" />
				 
                                 <img src="images/Categories1/Calculator.jpg" alt="" />
                          </div>
                  </div>
                  </center>

<br>
<br><br>
<br>

                <center>
                <div id="grad2" style="width:1010px; height:1100px;  border-radius: 10px ; box-shadow: 5px 5px 5px grey;padding:10px; ">
                          
                         
                         <div   style="width:1010px; height:40px; background:;border-radius: 10px ; box-shadow: 5px 5px 5px grey; background: radial-gradient(white,#fce45c ); ">
                               <font color="grey" size=5><div style="width:200px; height:30px; background:;float:left;padding:5px;" >Recently Closing</div></font>
                         </div>
                         
                         <div style="width:1010px; height:10px;">
			 </div>
                         
                         <div   style="width:315px; height:440px;  float:left;padding:10px;background:;">
                 
                               

                               <div  style="width:280px; height:431px;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                                         
			      </div>
                   
                         </div>
                         <div   style="width:315px; height:440px;  float:left;padding:10px;background:;">
                 
                               

                               <div  style="width:280px; height:431px;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                               </div>
                   
                         </div>
			<div   style="width:315px; height:440px;  float:left;padding:10px;background:;">
                 
                               

                               <div  style="width:280px; height:431px;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                               </div>
                         </div>
			<div   style="width:315px; height:440px;  float:left;padding:10px;background:;">
                 
                               

                               <div  style="width:280px; height:431px;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                                         
			      </div>
                   
                         </div>
                         <div   style="width:315px; height:440px;  float:left;padding:10px;background:;">
                 
                               

                               <div  style="width:280px; height:431px;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                               </div>
                   
                         </div>
			<div   style="width:315px; height:440px;  float:left;padding:10px;background:;">
                 
                               

                               <div  style="width:280px; height:431px;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                               </div>
                         </div>
			 
             </div>
             </center>


	     <div  style="width:1010px; height:20px; background:; ">
             </div>


             <center>
                <div  id="grad2" style="width:1010; height:350px;  border-radius: 10px ; box-shadow: 5px 5px 5px grey;padding:10px; ">
				
                         <div   style="width:1010px; height:40px; background:;border-radius: 10px ; box-shadow: 5px 5px 5px grey; background: radial-gradient(white,#fce45c); ">
                               <font color="grey" size=5><div style="width:200px; height:30px; background:;float:left;padding:5px;" >Recently Added</div></font>
                         </div>
                         
				<div class="wrapper col2">
  					<div id="featured_slide">
    						<div id="featured_content">
      						<ul>
        						<li><img src="images/demo/Sebesta.jpg" alt="" />
          							<div  style ="width:350px; height:260px; float:left;border-radius: 10px ; background: radial-gradient(white,#fce45c); " >
            							<font color="grey" size=5 >Description</font><br><br><br>
								<font color="grey" size=3 >Concepts of Programming Languages<br><br>
								 By Robert W. Sebesta<br><hr><br>Minimum Bid price:Rs.250<br><hr><br>
									Closing Date:21th April 2014


								</font>

          							</div>
 								
        						<li><img src="images/demo/Ray.jpg" alt="" />
          							 <div  style ="width:350px; height:260px;float:left;border-radius: 10px ; background: radial-gradient(white,#fce45c);" >
         	   						 
								<font color="grey" size=3 ><font color="grey" size=5 >Description</font><br><br><br>
								<font color="grey" size=3 >Computer architecture and parallel processing<br><br>
								 By A K Ray K M Bhurchandi<br><hr><br>Minimum Bid price:Rs.250<br><hr><br>
									Closing Date:24th April 2014


								</font><br><br>
								

								</font>
          							 </div>
        						</li>
        						<li><img src="images/demo/KaiHwang.jpg" alt="" />
          							 <div  style ="width:350px; height:260px; float:left;border-radius: 10px ; background: radial-gradient(white,#fce45c); " >
            							  <font color="grey" size=5 align="left">Description</font><br><br><br>
								  <font color="grey" size=3 >Computer architecture and parallel processing<br><br>
								 By Kai Hwang, Fayé Alayé Briggs<br><hr><br>Minimum Bid price:Rs.150<br><hr><br>
									Closing Date:29th April 2014

								</font>
          							 </div>
       							 </li>
      						</ul>
    						</div>
   					 <a href="javascript:void(0);" id="featured-item-prev"><img src="images/prev.png" alt="" /></a> <a href="javascript:void(0);" id="featured-item-next"><img src="images/next.png" alt="" /></a> </div>
					</div>
				</div>

               </div>
           </center>
    </div>
    </center>


   
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
</body>

</html>

</body>
</html>