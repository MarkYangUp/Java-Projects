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

/**
 * Servlet implementation class DetailsRegisterationServlet
 */
@WebServlet("/DetailsRegisterationServlet")
public class DetailsRegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		UserDao dao=DaoFactory.getUserDao();
			String rid=request.getParameter("rid");
		int regId=Integer.parseInt(rid);
			request.setAttribute("reg", dao.getNewRegisteration(regId));
		RequestDispatcher rd1=request.getRequestDispatcher("RegisterationDetails.jsp");
		rd1.forward(request, response);
	
	}

}
