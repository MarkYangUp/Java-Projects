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
 * Servlet implementation class UserValidateServlet
 */
@WebServlet("/UserValidateServlet")
public class UserValidateServlet extends HttpServlet {
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	
		//HttpSession session=request.getSession();
		String loginId=request.getParameter("loginId");
		String password=request.getParameter("pwd");
		String next="Login.jsp";
		UserDao dao=DaoFactory.getUserDao();
		User user=dao.validateLogin(loginId, password);
				
		if(user==null)
		 {
			
				next=next+"?error=Invalid Data";
		 }
		 else{
			 
			HttpSession session=request.getSession();
				session.setAttribute("userid", user.getId());
				session.setAttribute("uname", user.getFirstName().concat(" "+user.getLastName()));
				session.setAttribute("userType",user.getUserType());
			
				 next="AdminProfile.jsp";				
				 
				 Integer bidId=(Integer)session.getAttribute("bidItemId");
						
				 
				 if(bidId!=null)
				 {
					 next="BidServlet";
				 }
				 else
				 {				 
				 if((user.getUserType().equals(UserType.FACULTY))||(user.getUserType().equals(UserType.STUDENT)))
				 next="MyProfileServlet";
				 else if(user.getUserType().equals(UserType.ADMIN))
						 next="AdminProfile.jsp";	
				 }
				 session.setAttribute("home", next);
		 }
		response.sendRedirect(next);

	}


}
