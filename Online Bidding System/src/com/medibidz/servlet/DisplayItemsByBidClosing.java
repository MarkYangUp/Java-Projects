package com.medibidz.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.entity.Item;

/**
 * Servlet implementation class DisplayItemsByBidClosing
 */
@WebServlet("/DisplayItemsByBidClosing")
public class DisplayItemsByBidClosing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		ItemDao dao=DaoFactory.getItemDao();
		
		List<Item> bidclose=dao.getItemsbyBidClosing();
	
		request.setAttribute("bidclose",bidclose);
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
		
		rd.forward(request,response);
		
		List<Item> recItem= dao.getRecentItemsForBid();
		request.setAttribute("recent",recItem);
		RequestDispatcher rd1=request.getRequestDispatcher("HomePage.jsp");
		rd1.forward(request, response);
		
		
	}

}
