package com.mgielib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.dao.CategoryDao;
import com.mgielib.dao.DaoFactory;
import com.mgielib.entity.Category;

/**
 * Servlet implementation class CategoryListServlet
 */
@WebServlet("/categoryList")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao obj=DaoFactory.getCategoryDao();
		List<Category> al=obj.viewCategory();
		request.setAttribute("cat",al);
		request.setAttribute("success", "DATA ADDED");
		RequestDispatcher rd=request.getRequestDispatcher("AddMaster.jsp");
		rd.forward(request, response);
		
	
	}

}
