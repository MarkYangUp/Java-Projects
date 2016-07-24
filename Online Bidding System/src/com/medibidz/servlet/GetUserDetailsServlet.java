package com.medibidz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.UserDao;
import com.medibidz.entity.User;

/**
 * Servlet implementation class GetUserDetailsServlet
 */
@WebServlet("/GetUserDetailsServlet")
@MultipartConfig
public class GetUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	HttpSession session=request.getSession();
	int id=(Integer)session.getAttribute("userid");
	
	UserDao dao=DaoFactory.getUserDao();
		
	User user=dao.getUserDetails(id);
	
	request.setAttribute("user",user);

	RequestDispatcher rd=request.getRequestDispatcher("EditProfile.jsp");
	rd.forward(request, response);
	
	
	}

}
