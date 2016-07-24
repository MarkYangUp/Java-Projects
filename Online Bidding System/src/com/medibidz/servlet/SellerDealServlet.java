package com.medibidz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.dao.UserDao;
import com.medibidz.entity.Item;
import com.medibidz.entity.User;

/**
 * Servlet implementation class SellerDealServlet
 */
@WebServlet("/SellerDealServlet")
public class SellerDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session=request.getSession();
	Integer itemId=Integer.parseInt(request.getParameter("itemId"));
	Integer buyerId=Integer.parseInt(request.getParameter("bid"));
	Integer sellerId=(Integer) session.getAttribute("userid");
	Double bidp=Double.parseDouble(request.getParameter("bidp"));	
	Integer bidId=Integer.parseInt(request.getParameter("bidId"));
	UserDao dao=DaoFactory.getUserDao();
	
	System.out.println(bidId);
	
	User buyer=dao.findById(buyerId);
	User seller=dao.findById(sellerId);
	
	System.out.println(seller);
	System.out.println(buyer);
	
	
	ItemDao dao1=DaoFactory.getItemDao();
	Item item=dao1.getItem(itemId);
	
	Boolean status=dao1.getDealStatusSeller(bidId);
	request.setAttribute("bidId",bidId);
	request.setAttribute("itemp",bidp);
	request.setAttribute("seller",seller);
	request.setAttribute("buyer",  buyer);
	request.setAttribute("item", item);
	request.setAttribute("status", status);
	RequestDispatcher rd=request.getRequestDispatcher("ItemDeal.jsp");
	rd.forward(request, response);
	
	}

}
