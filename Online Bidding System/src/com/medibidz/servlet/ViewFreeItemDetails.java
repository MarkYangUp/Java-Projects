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

/**
 * Servlet implementation class ViewFreeItemDetails
 */
@WebServlet("/ViewFreeItemDetails")
public class ViewFreeItemDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemDao dao=DaoFactory.getItemDao();
		String itmid=request.getParameter("ItemId");
		int itmId=Integer.parseInt(itmid);
		request.setAttribute("itm", dao.getNewItem(itmId));
		RequestDispatcher rd1=request.getRequestDispatcher("FreeItemDetails.jsp");
		rd1.forward(request, response);
	
	}

}
