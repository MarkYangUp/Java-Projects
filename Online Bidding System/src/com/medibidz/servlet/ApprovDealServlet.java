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
 * Servlet implementation class ApprovDealServlet
 */
@WebServlet("/ApprovDealServlet")
public class ApprovDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    	Integer bidId=Integer.parseInt(request.getParameter("bidId"));	
    	Integer itemId=Integer.parseInt(request.getParameter("itemId"));
    	ItemDao dao=DaoFactory.getItemDao();
    	dao.updateDealStatus(bidId);
    	
    	
    	response.sendRedirect("WaitDeal.jsp");
    	
    	}

	

}
