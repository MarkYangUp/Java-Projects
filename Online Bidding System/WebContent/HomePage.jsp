<%@page import="java.util.Date"%>
<%@page import="com.medibidz.entity.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.medibidz.entity.CategoryTypes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
        <link rel="stylesheet" href="styles/expstickybar.css" />
        <link rel="stylesheet" href="styles/featured_slide.css" type="text/css" />
        <script src="scripts/expstickybar.js"></script>
        <script type="text/javascript" src="scripts/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="script
	s/jquery.jcarousel.pack.js"></script>
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

<title>HomePage</title>
</head>
<body>
<div id="grad1" >

   <center>
  <div style ="width:1200px; height:3000px; background:; "  >



       <center>
       <div style="width:1030px; height:130px; background:; border-radius:20px;padding:10px; ">
            
            <font color="white" size=6><h1 align="left"><i>Medibidzs</i></h1></font> 
            
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
                               <font  size=5><a class="a_link" href="Categories.jsp" style="text-decoration:none" >Categories</a></font>
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
		               <input type="text" id="tfq" class="tftextinput2" name="searchText" size="21" maxlength="120" value="Search our website"><input type="submit" value=">" class="tfbutton2">
		               </form>
		               <div class="tfclear">
                               </div>
	                    </div>     
                   
                    </div>
             </div>
	     </center>
<br>
<br>
			<div style="width:90px; height:30px; backgroundr;  border-radius: 20px ;float:right;color: red;" >
            <font color="white" size=4><a href="Login.jsp">LOGIN</a></font>

            </div>           
            

                   <center>
  

                   <div class="wrapper col3" style="width:100%; height:300px; background:;  text-align:center;border-radius: 20px ;">
                            <div id="waterwheelCarousel">
                                
                                <a href="CategoryServlet?catName=<%=CategoryTypes.STATIONERY %>"><img src="images/Categories1/Stationary.jpg" alt="" /></a> 
				 					
				 				<a href="CategoryServlet?catName=<%=CategoryTypes.TOOLS %>"><img src="images/Categories1/Drafter.jpg" alt="" /></a>
                                   
                                   <a href="CategoryServlet?catName=<%=CategoryTypes.OTHERS%>"><img src="images/Categories1/Pendrive.jpg" alt="" /></a>
                                   <a href="CategoryServlet?catName=<%=CategoryTypes.ELECTRONICGADGETS%>">
    				 <img src="images/Categories1/Laptops.jpg" alt="" /></a>
    				   <a href="CategoryServlet?catName=<%=CategoryTypes.BOOKS%>">
				 <img src="images/Categories1/Book.jpg" alt="" /></a>
				   <a href="CategoryServlet?catName=<%=CategoryTypes.SOUVENIRS %>">
				 <img src="images/Categories1/Harddisk.jpg" alt="" />
				 </a>
				   <a href="CategoryServlet?catName=<%=CategoryTypes.CLOTHES%>">
    				 <img src="images/Categories1/Blazer.jpg" alt="" />
    				 </a>
    				   <a href="CategoryServlet?catName=<%=CategoryTypes.NOTES %>">
				 <img src="images/Categories1/Camera.jpg" alt="" />
				 </a>
				   <a href="CategoryServlet?catName=<%=CategoryTypes.TOLET %>">
   				 <img src="images/Categories1/Phone.jpeg" alt="" /></a>
   				
                  <a href="CategoryServlet?catName=<%=CategoryTypes.BAGS %>">                 
  				 <img src="images/Categories1/Bag.jpg" alt="" /></a>
				 
				   <a href="CategoryServlet?catName=<%=CategoryTypes.VEHICLES %>">
                                 <img src="images/Categories1/Calculator.jpg" alt="" /></a>
                         </div>
                  </div>
                  </center>

<br>
<br><br>
<br>

			
			
                <center>
                <div id="grad2" style="width:98%; height:1100px;  border-radius: 10px ; box-shadow: 5px 5px 5px grey;padding:1%; ">
                          
                         
                         <div   style="width:100%; height:40px; background:;border-radius: 10px ; box-shadow: 5px 5px 5px grey; background: radial-gradient(white,#fce45c ); ">
                               <font color="grey" size=5>
                               <div style="width:200px; height:30px; background:;float:left;padding:5px;" >Recently Closing</div></font>
                         </div>
                         
                         <div style="width:100%; height:10px;">
						 </div>
						 
                         <div   style="width:23%; height:40%;  float:left;padding:1%;background:;">
                 			 <%
                                       List<Item> bidclose0=(List<Item>)request.getAttribute("bidclose");
                 			 			int itmId0=bidclose0.get(0).getItemId();
                                       int id0=bidclose0.get(0).getImage1().getImageId();
                                       String catName0=bidclose0.get(0).getCategoryName();
                                       String itmName0=bidclose0.get(0).getItemName();
                                       Date lastDate0=bidclose0.get(0).getLastDate();
                                       double minBid0=bidclose0.get(0).getStartBidPrice();
                                       %>
                         	<a href="BidServlet?bidItemId=<%=itmId0%>">
                              <div  style="width:98%; height:98%;border-style:solid; border-width:1px;border-color:grey;background:; ">
                                      
                                        <img src="getImage?id=<%=id0%>" width="100" height="100"/><br>
                                          Category Name:<%=catName0%><br>
                                          ItemName:<%=itmName0%><br>
                                          StartBidPrice:<%=minBid0%><br>
			     							LastDate:<%=lastDate0%><br>
			     			 </div>
                   </a>
                         </div>
                   
				 
                         <div   style="width:23%; height:40%;  float:left;padding:1%;background:;">
               					
               					    <%
                                       List<Item> bidclose1=(List<Item>)request.getAttribute("bidclose");
                                       int id1=bidclose1.get(1).getImage1().getImageId();
                                       String catName1=bidclose1.get(1).getCategoryName();
                                       String itmName1=bidclose1.get(1).getItemName();
                                       Date lastDate1=bidclose1.get(1).getLastDate();
                                       double minBid1=bidclose1.get(1).getStartBidPrice();
                			 			int itmId1=bidclose1.get(1).getItemId();

                                       %>
                         	<a href="BidServlet?bidItemId=<%=itmId1%>">
                              <div  style="width:98%; height:98%;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                                     
                                     
                                        <img src="getImage?id=<%=id1%>" width="100" height="100"/><br>
                        				 Category Name:<%=catName1%><br>
                                          ItemName:<%=itmName1%><br>
                                          StartBidPrice:<%=minBid1%><br>
			     							LastDate:<%=lastDate1%><br>
			     			 </div>
                   </a>
                         </div>
                 
                  
                         <div   style="width:23%; height:40%;  float:left;padding:1%;background:;">
                 
                         	 <%
                                       List<Item> bidclose2=(List<Item>)request.getAttribute("bidclose");
                                       int id2=bidclose2.get(2).getImage1().getImageId();
                                       String catName2=bidclose2.get(2).getCategoryName();
                                       String itmName2=bidclose2.get(2).getItemName();
                                       Date lastDate2=bidclose2.get(2).getLastDate();
                                       double minBid2=bidclose2.get(2).getStartBidPrice();
                			 			int itmId2=bidclose2.get(2).getItemId();

                                       %>
                                       
                                       	<a href="BidServlet?bidItemId=<%=itmId2%>">
                         
                              <div  style="width:98%; height:98%;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                                
                                        <img src="getImage?id=<%=id2%>" width="100" height="100"/><br>
                              			 Category Name:<%=catName2%><br>
                                          ItemName:<%=itmName2%><br>
                                          StartBidPrice:<%=minBid2%><br>
			     							LastDate:<%=lastDate2%><br>
			     			 </div>
                   </a>
                         </div>
                 
                  
                         <div   style="width:23%; height:40%;  float:left;padding:1%;background:;">
                 
                         			<%
                                       List<Item> bidclose3=(List<Item>)request.getAttribute("bidclose");
                                       int id3=bidclose3.get(3).getImage1().getImageId();
                                       String catName3=bidclose3.get(3).getCategoryName();
                                       String itmName3=bidclose3.get(3).getItemName();
                                       Date lastDate3=bidclose3.get(3).getLastDate();
                                       double minBid3=bidclose3.get(3).getStartBidPrice();
                			 			int itmId3=bidclose3.get(3).getItemId();

                                       %>
                                    
                                    <a href="BidServlet?bidItemId=<%=itmId3%>">
                                       
                              <div  style="width:98%; height:98%;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                                     
                                        <img src="getImage?id=<%=id3%>" width="100" height="100"/><br>
                                         Category Name:<%=catName3%><br>
                                          ItemName:<%=itmName3%><br>
                                          StartBidPrice:<%=minBid3%><br>
			     							LastDate:<%=lastDate3%><br>
                          
			     			 </div>
                   	</a>
                         </div>
                 
                                 
                                 <%
                                       List<Item> bidclose4=(List<Item>)request.getAttribute("bidclose");
                                       int id4=bidclose4.get(4).getImage1().getImageId();
                                       String catName4=bidclose4.get(4).getCategoryName();
                                       String itmName4=bidclose4.get(4).getItemName();
                                       Date lastDate4=bidclose4.get(4).getLastDate();
                                       double minBid4=bidclose4.get(4).getStartBidPrice();
                			 			int itmId4=bidclose4.get(4).getItemId();

                                       %>
                                    
                                 
                  
                         <div   style="width:23%; height:40%;  float:left;padding:1%;background:;">
                 
                 			
                 				<a href="BidServlet?bidItemId=<%=itmId4%>">
                         	
                              <div  style="width:98%; height:98%;border-style:solid; border-width:1px;border-color:grey;background:; ">
                                        <img src="getImage?id=<%=id4%>" width="100" height="100"/><br>
                                        Category Name:<%=catName4%><br>
                                          ItemName:<%=itmName4%><br>
                                          StartBidPrice:<%=minBid4%><br>
			     							LastDate:<%=lastDate4%><br>
                           
			     			 </div>
                  			 </a>
                         </div>
                 
                  
                         <div   style="width:23%; height:40%;  float:left;padding:1%;background:;">
                 			
                 			 <%
                                       List<Item> bidclose5=(List<Item>)request.getAttribute("bidclose");
                                       int id5=bidclose5.get(5).getImage1().getImageId();
                                       String catName5=bidclose5.get(5).getCategoryName();
                                       String itmName5=bidclose5.get(5).getItemName();
                                       Date lastDate5=bidclose5.get(5).getLastDate();
                                       double minBid5=bidclose5.get(5).getStartBidPrice();
                			 			int itmId5=bidclose5.get(5).getItemId();

                                       %>
                         	<a href="BidServlet?bidItemId=<%=itmId5%>">
                              <div  style="width:98%; height:98%;border-style:solid; border-width:1px;border-color:grey;background:;  ">
                                   
                                       <img src="getImage?id=<%=id5%>" width="100" height="100"/><br>
   									
   									       Category Name:<%=catName5%><br>
                                          ItemName:<%=itmName5%><br>
                                          StartBidPrice:<%=minBid5%><br>
			     							LastDate:<%=lastDate5%><br>
    												                        
			     			 </div>
						</a>						                   
                         </div>
                 
                  
                 

             </div>
             </center>

	     <div  style="width:100%; height:20px; background:; ">
             </div>


             <center>
                <div  id="grad2" style="width:98%; height:350px;  border-radius: 10px ; box-shadow: 5px 5px 5px grey;padding:1%; ">
				
                         <div   style="width:100%; height:40px; background:;border-radius: 10px ; box-shadow: 5px 5px 5px grey; background: radial-gradient(white,#fce45c); ">
                               <font color="grey" size=5><div style="width:200px; height:30px; background:;float:left;padding:5px;" >Recently Added</div></font>
                         </div>
                         
				<div class="wrapper col2">
  					<div id="featured_slide">
    						<div id="featured_content">
      						<ul>
        						<li><img src="images/demo/Sebesta.jpg" alt="" />
          							<div  style ="width:380px; height:250px; float:left;border-radius: 10px ; background: radial-gradient(white,#fce45c); " >
            							<font color="grey" size=5 >Description</font><br><br><br>
								<font color="grey" size=3 >Concepts of Programming Languages<br><br>
								 By Robert W. Sebesta<br><hr><br>Minimum Bid price:Rs.250<br><hr><br>
									Closing Date:21th April 2014


								</font>

          							</div>
 								
        						<li><img src="images/demo/Ray.jpg" alt="" />
          							 <div  style ="width:380px; height:250px;float:left;border-radius: 10px ; background: radial-gradient(white,#fce45c);" >
         	   						 
								<font color="grey" size=3 ><font color="grey" size=5 >Description</font><br><br><br>
								<font color="grey" size=3 >Computer architecture and parallel processing<br><br>
								 By A K Ray K M Bhurchandi<br><hr><br>Minimum Bid price:Rs.250<br><hr><br>
									Closing Date:24th April 2014


								</font><br><br>
								

								</font>
          							 </div>
        						</li>
        						<li><img src="images/demo/KaiHwang.jpg" alt="" />
          							 <div  style ="width:380px; height:250px; float:left;border-radius: 10px ; background: radial-gradient(white,#fce45c); " >
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

</div>
</body>
</html>