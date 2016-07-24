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
 * Servlet implementation class DeleteItemServlet
 */
@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ItemDao dao=DaoFactory.getItemDao();
		int itemId;
		if(request.getParameter("itm_id")!=null)
		itemId=Integer.parseInt(request.getParameter("itm_id"));
		else
		itemId=Integer.parseInt(request.getParameter("itemId"));	
		dao.delete(itemId);
		response.sendRedirect("GetNewItems");
	}

}
