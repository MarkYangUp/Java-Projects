package com.medibidz.servlet;

import java.io.IOException;
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
 * Servlet implementation class RecentItemForBidServlet
 */
@WebServlet("/RecentItemForBid")
public class RecentItemForBid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	ItemDao dao=DaoFactory.getItemDao();
	
	List<Item> recItem= dao.getRecentItemsForBid();
	request.setAttribute("item",recItem);
	RequestDispatcher rd=request.getRequestDispatcher("DisplayItems.jsp");
	rd.forward(request, response);
	
	}
}
	
