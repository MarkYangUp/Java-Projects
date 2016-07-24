package com.mgielib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.entity.EMaterialsBaseEntity;
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
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EMaterialsBaseEntity data=new EMaterialsBaseEntity();
		String uid=request.getParameter("uid");
		String mtype=request.getParameter("mtype");
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
		
		
		if(mtype.equals("BOOK"))
		{
			request.setAttribute("eid",uid);
			RequestDispatcher rd=request.getRequestDispatcher("ModifyEBook.jsp");
			rd.forward(request, response);

	
		}
		else if(mtype.equals("PAPER")||mtype.equals("JOURNAL"))
		{
			request.setAttribute("eid",uid);
			RequestDispatcher rd=request.getRequestDispatcher("ModifyEPaperEJournal.jsp");
			rd.forward(request, response);

	
		}
			
		else if(mtype.equals("PROJECTS"))
		{
			request.setAttribute("eid",uid);
			RequestDispatcher rd=request.getRequestDispatcher("ModifyEProjects.jsp");
			rd.forward(request, response);

	
		}
			
		else if(mtype.equals("FACULTY_RESOURCES"))
		{
			request.setAttribute("eid",uid);
			RequestDispatcher rd=request.getRequestDispatcher("ModifyEFaculty_Resources.jsp");
			rd.forward(request, response);

	
		}
			
		
			
		
	}

}
