package com.medibidz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.UserDao;
import com.medibidz.entity.Registeration;

/**
 * Servlet implementation class NewRegisterationServlet
 */
@WebServlet("/GetNewRegisterations")
public class GetNewRegisterations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		UserDao dao=DaoFactory.getUserDao();
		List<Registeration> newReg=dao.getNewRegisterations();
		request.setAttribute("newReg",newReg);
		RequestDispatcher rd=request.getRequestDispatcher("ListNewRegisterations.jsp");
		rd.forward(request, response);
		
		
	}

}
