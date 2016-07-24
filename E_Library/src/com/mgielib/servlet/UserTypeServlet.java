package com.mgielib.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserTypeServlet
 */
@WebServlet("/UserTypeServlet")
public class UserTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String userType=(String)session.getAttribute("userType");
		
		if(userType.equals("STUDENT")||userType.equals("NONFACULTY"))
		response.sendRedirect("entryServlet?uid=f");
		
		else if(userType.equals("ADMIN"))
		response.sendRedirect("EnterAdmin.jsp");
	
		else if(userType.equals("FACULTY"))
		response.sendRedirect("EnterFaculty.jsp");	
	
	}

}
