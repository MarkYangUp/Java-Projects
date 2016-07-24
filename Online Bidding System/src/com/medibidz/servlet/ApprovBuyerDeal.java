package com.medibidz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;

/**
 * Servlet implementation class ApprovBuyerDeal
 */
@WebServlet("/ApprovBuyerDeal")
public class ApprovBuyerDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
	
		Integer bidId=Integer.parseInt(request.getParameter("bidId"));	
    	Integer itemId=Integer.parseInt(request.getParameter("itemId"));
    	
    	ItemDao dao=DaoFactory.getItemDao();
    	dao.updateDealStatusSeller(bidId);
    	
    	response.sendRedirect("DiplayItemsByBidClosing");
	}

}
