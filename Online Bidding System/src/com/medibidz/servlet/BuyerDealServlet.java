package com.medibidz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.dao.UserDao;
import com.medibidz.entity.Item;
import com.medibidz.entity.User;

/**
 * Servlet implementation class BuyerDealServlet
 */
@WebServlet("/BuyerDealServlet")
public class BuyerDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Integer itemId=Integer.parseInt(request.getParameter("itemId"));
		Integer buyerId=Integer.parseInt(request.getParameter("buyerId"));
		Integer sellerId=Integer.parseInt(request.getParameter("sellerId"));
		Double bidp=Double.parseDouble(request.getParameter("bidPrice"));	
		
		UserDao dao=DaoFactory.getUserDao();
		
		
		
		User buyer=dao.findById(buyerId);
		User seller=dao.findById(sellerId);
		ItemDao dao1=DaoFactory.getItemDao();
		Item item=dao1.getItem(itemId);
		
		System.out.println(seller);
		request.setAttribute("itemp", bidp);
		request.setAttribute("seller",seller);
		request.setAttribute("buyer",  buyer);
		request.setAttribute("item", item);
		RequestDispatcher rd=request.getRequestDispatcher("BuyerItemDeal.jsp");
		rd.forward(request, response);

	
	
	}

}
