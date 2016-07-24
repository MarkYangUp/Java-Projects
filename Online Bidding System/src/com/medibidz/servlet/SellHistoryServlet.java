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
import com.medibidz.entity.Item;

/**
 * Servlet implementation class SellHistoryServlet
 */
@WebServlet("/SellHistoryServlet")
public class SellHistoryServlet extends HttpServlet {
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
		int sellerId=(Integer)session.getAttribute("userid");
		ItemDao dao=DaoFactory.getItemDao();
		List<Item> sellItem=dao.getItemBySeller(sellerId);
		request.setAttribute("sellItem",sellItem);
		RequestDispatcher rd=request.getRequestDispatcher("ItemsBySeller.jsp");
		rd.forward(request,response);
	
	}

}
