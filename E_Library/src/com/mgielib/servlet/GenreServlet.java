package com.mgielib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.GenreDao;
import com.mgielib.entity.Genre;

/**
 * Servlet implementation class GenreServlet
 */
@WebServlet("/GenreServlet")
public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Genre gen=new Genre();
		try {
			BeanUtils.populate(gen,request.getParameterMap());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		GenreDao obj=DaoFactory.getGenreDao();
		int r=obj.addGenre(gen);
		
		
		
		if(r!=0)
			{
			
			response.sendRedirect("GenreListServlet");
		
		
		}		
		else{
			request.setAttribute("error", "Error in insertion");
			RequestDispatcher rd=request.getRequestDispatcher("AddMaster.jsp");
			rd.forward(request, response);
			}

	
	}

}
