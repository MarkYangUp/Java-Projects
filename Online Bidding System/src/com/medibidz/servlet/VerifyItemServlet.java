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
 * Servlet implementation class VerifyItemServlet
 */
@WebServlet("/VerifyItemServlet")
public class VerifyItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemDao dao=DaoFactory.getItemDao();
		String itmId=request.getParameter("itm_id");
		int itemId=Integer.parseInt(itmId);
		dao.validateItem(itemId);
		
		response.sendRedirect("GetNewItems");

	}

}
