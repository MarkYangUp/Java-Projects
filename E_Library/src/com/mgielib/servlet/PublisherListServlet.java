package com.mgielib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.dao.AuthorDao;
import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.PublisherDao;
import com.mgielib.entity.Author;
import com.mgielib.entity.Publisher;

/**
 * Servlet implementation class PublisherListServlet
 */
@WebServlet("/PublisherListServlet")
public class PublisherListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PublisherDao obj=DaoFactory.getPublisherDao();
		List<Publisher> al=obj.viewPublisher();
		request.setAttribute("pub",al);
		request.setAttribute("success","DATA ADDED");
		RequestDispatcher rd=request.getRequestDispatcher("AddMaster.jsp");
		rd.forward(request, response);

	
	}

}
