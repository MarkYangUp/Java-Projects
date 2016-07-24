package com.medibidz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.UserDao;
import com.medibidz.entity.User;
import com.medibidz.entity.UserType;

/**
 * Servlet implementation class MyProfileServlet
 */
@WebServlet("/MyProfileServlet")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		HttpSession session=request.getSession();
		
		AuthStatus status= AuthenticationService.checkValidAndUser(session);
		if(status==AuthStatus.INVALID){
			response.sendRedirect("Invalid.jsp");
			return;
		}else if (status==AuthStatus.UN_AUTHORIZED){
			response.sendRedirect("unauthorized.jsp");
			return;
		}
	
		
		CacheService.off(response);
		
		int id=(Integer)session.getAttribute("userid");
		UserDao dao=DaoFactory.getUserDao();
		User user=dao.findById(id);


		request.setAttribute("user",user);
		RequestDispatcher rd=request.getRequestDispatcher("MyProfile.jsp");
		rd.forward(request,response);
	}

}
