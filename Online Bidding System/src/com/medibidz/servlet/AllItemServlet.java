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
 * Servlet implementation class AllItemServlet
 */
@WebServlet("/AllItemServlet")
public class AllItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ItemDao dao=DaoFactory.getItemDao();
		List<Item> Item=dao.getAllItems();
		request.setAttribute("Item",Item);
		RequestDispatcher rd=request.getRequestDispatcher("ListNewItems.jsp");
		rd.forward(request, response);
		
	}

}
