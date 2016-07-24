<%@page import="com.medibidz.entity.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.medibidz.dao.*" %>
<%@page import="com.medibidz.dao.jdbc.*" %>
<%@page import="java.util.*" %>
<%@page import="com.medibidz.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Bid> al=(ArrayList<Bid>)request.getAttribute("buyItem");%>
<%for(Bid bi:al){ %>
<table width="100" border="1">

<tr><th>Category Name:</th><th>Item Name</th><th>Description</th><th>seller Name</th><th>Bid Date</th><th> Bid Price</th><th>Max Bid </th><th>Total bids</th><th>Deal Status</th></tr>
<tr><td><%=bi.getItem().getCategoryName()%></td><td><%=bi.getItem().getItemName() %></td><td><%=bi.getItem().getDescription()%></td><td><%=bi.getItem().getSeller().getFirstName() %>&nbsp;&nbsp;<%=bi.getItem().getSeller().getLastName()%></td><td><%=bi.getBidDate()%></td><td><%=bi.getBidPrice()%></td><td><%=bi.getItem().getMaxBidPrice() %></td><td><%=bi.getItem().getTotalBidCount() %></td>

<td>
<%if(bi.getDealStatus()==1){ %>
   <a href="BuyerDealStatus?bidPrice=<%=bi.getBidPrice()%>&itemId=<%=bi.getItem().getItemId()%>&sellerId=<%=bi.getItem().getSeller().getId()%>&bidId=<%=bi.getBidId()%>">Approved</a>
   <%}else{ %>
   Waiting
<%} %>
</td>

</tr>
<%}%>
</table>

<c:if test="${not empty bi.item.image1}">
<img src="getImage?id=${bi.item.image1.imageId }" width="100" height="100"/>
</c:if>
<c:if test="${not empty bi.item.image2}">
<img src="getImage?id=${bi.item.image2.imageId}" width="100" height="100"/>
</c:if>
<c:if test="${not empty bi.item.image3}">
<img src="getImage?id=${bi.item.image3.imageId}" width="100" height="100"/>
</c:if>
<hr><br><br>
</body>
</html>