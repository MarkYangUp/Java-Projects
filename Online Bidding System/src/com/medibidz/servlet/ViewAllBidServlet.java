package com.medibidz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.entity.Bid;

/**
 * Servlet implementation class ViewAllBidServlet
 */
@WebServlet("/ViewAllBidServlet")
public class ViewAllBidServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	
	ItemDao dao=DaoFactory.getItemDao();
	int itemId=Integer.parseInt(request.getParameter("ItemId"));
	
	List<Bid> lstbid=dao.getBidsForItem(itemId);
	
	request.setAttribute("lstbid", lstbid);
	request.setAttribute("itemId",itemId);
	RequestDispatcher rd=request.getRequestDispatcher("ViewBidList.jsp");
	rd.forward(request,response);
	}

}
