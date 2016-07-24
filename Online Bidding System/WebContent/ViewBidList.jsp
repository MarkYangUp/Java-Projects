<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Integer itemId=(Integer)request.getAttribute("itemId"); %>
<c:if test="${not empty lstbid}">
<table  width="100%" border="1">
<tr><th>Bid No</th><th>Bid Date</th><th> Bid Price</th><th>Buyer's Name</th><th>Email</th></tr>
<c:forEach var="lb" items="${lstbid}" varStatus="s">  
<tr><td>${s.count}</td><td><f:formatDate value="${lb.bidDate}" pattern="dd-MMM-yyyy" />
</td><td>${lb.bidPrice}</td><td>${lb.buyer.firstName }&nbsp;&nbsp;</td><td>email</td>
<td><a href="SellerDealServlet?bid=${lb.buyer.id}&itemId=${itemId}&bidp=${lb.bidPrice}&bidId=${lb.bidId}">Deal</a></td>
</tr>
</c:forEach>

</table>

</c:if>
${lb.bidId}

</body>
</html>