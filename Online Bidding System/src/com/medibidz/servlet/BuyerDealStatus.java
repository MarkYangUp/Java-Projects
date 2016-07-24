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
 * Servlet implementation class BuyerDealStatus
 */
@WebServlet("/BuyerDealStatus")
public class BuyerDealStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer itemId=Integer.parseInt(request.getParameter("itemId"));
		Double bidPrice=Double.parseDouble(request.getParameter("bidPrice"));
		Integer sellerId=Integer.parseInt(request.getParameter("sellerId"));
		Integer bidId=Integer.parseInt(request.getParameter("bidId"));
		HttpSession session=request.getSession();
		ItemDao dao=DaoFactory.getItemDao();
		
		Item item=dao.getItem(itemId);

		UserDao dao1=DaoFactory.getUserDao();
		User seller=dao1.findById(sellerId);
		System.out.println(seller);
		request.setAttribute("bidId", bidId);
		request.setAttribute("item", item);
		request.setAttribute("seller", seller);
		request.setAttribute("bidPrice",bidPrice);
		request.setAttribute("buyer",session.getAttribute("userid"));
		RequestDispatcher rd=request.getRequestDispatcher("BuyerItemDeal.jsp");
		rd.forward(request, response);
	}

}
