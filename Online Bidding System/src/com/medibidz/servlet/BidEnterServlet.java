package com.medibidz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;

/**
 * Servlet implementation class BidEnterServlet
 */
@WebServlet("/BidEnterServlet")
public class BidEnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
	ItemDao dao=DaoFactory.getItemDao();
	double price=Double.parseDouble(request.getParameter("bidPrice"));
	int buyerId=(Integer)session.getAttribute("userid");
	Integer itemId=(Integer)session.getAttribute("bidItemId");
	dao.addBid(itemId, buyerId, price);
	session.removeAttribute("bidItemId");
	response.sendRedirect("Buyer.jsp");
	}
}
