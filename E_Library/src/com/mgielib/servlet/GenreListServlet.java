package com.mgielib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.GenreDao;
import com.mgielib.entity.Genre;

/**
 * Servlet implementation class GenreListServlet
 */
@WebServlet("/GenreListServlet")
public class GenreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		GenreDao obj=DaoFactory.getGenreDao();
		List<Genre> al=obj.viewGenre();
		request.setAttribute("gen",al);
		request.setAttribute("success", "DATA ADDED");
		RequestDispatcher rd=request.getRequestDispatcher("AddMaster.jsp");
		rd.forward(request, response);

	
	}

}
