package com.medibidz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.entity.Bid;

/**
 * Servlet implementation class BuyHistoryServlet
 */
@WebServlet("/BuyHistoryServlet")
public class BuyHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		int buyerId=(Integer)session.getAttribute("userid");
		ItemDao dao=DaoFactory.getItemDao();
		List<Bid> buyItem=dao.getActiveBidsForBuyer(buyerId);
		request.setAttribute("buyItem",buyItem);
		RequestDispatcher rd=request.getRequestDispatcher("ItemsAsBuyer.jsp");
		rd.forward(request,response);
	}

}
