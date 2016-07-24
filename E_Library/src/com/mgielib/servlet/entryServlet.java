package com.mgielib.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.dao.CategoryDao;
import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.GenreDao;
import com.mgielib.dao.PublisherDao;
import com.mgielib.dao.SubjectDao;
import com.mgielib.entity.Category;
import com.mgielib.entity.Genre;
import com.mgielib.entity.Publisher;
import com.mgielib.entity.Subject;

import java.util.*;

/**
 * Servlet implementation class entryServlet
 */
@WebServlet("/entryServlet")
public class entryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setHeader("Cache-control", "no-cache");
		response.addHeader("Cache-Control", "no-store");  
		response.addHeader("Cache-Control", "must-revalidate");
		response.setHeader("pragma", "no-cache");
		
		
		CategoryDao obj=DaoFactory.getCategoryDao();
		List<Category> al=obj.viewCategory();
		request.setAttribute("category",al);
		
		SubjectDao obj1=DaoFactory.getSubjectDao();
		List<Subject> al1=obj1.viewSubject();
		request.setAttribute("subject",al1);
		
		GenreDao obj2=DaoFactory.getGenreDao();
		List<Genre> al2=obj2.viewGenre();
		request.setAttribute("genre",al2);
		
		PublisherDao obj3=DaoFactory.getPublisherDao();
		List<Publisher> al3=obj3.viewPublisher();
		request.setAttribute("publisher",al3);
		
		String uid=request.getParameter("uid");
	
		if(uid.equals("a"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("AddEBook.jsp");
		rd.forward(request, response);
		}
		
		else if(uid.equals("c"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("AddEProject.jsp");
		rd.forward(request, response);
		}
		
		else if(uid.equals("b"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("AddEFacultyResource.jsp");
		rd.forward(request, response);
		}
	
		else if(uid.equals("d"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("AddEPublish.jsp");
		rd.forward(request, response);
		}
		
		else if(uid.equals("e"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("EnterLibrary.jsp");
		rd.forward(request, response);
		}
		else if(uid.equals("f"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("EnterLibrary.jsp");
		rd.forward(request, response);
		}
		else if(uid.equals("g"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("ModifyContent.jsp");
		rd.forward(request, response);
		}
		else if(uid.equals("h"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("DeleteContent.jsp");
		rd.forward(request, response);
		}
		else if(uid.equals("i"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("AddMaster.jsp");
		rd.forward(request, response);
		}
	}

}
