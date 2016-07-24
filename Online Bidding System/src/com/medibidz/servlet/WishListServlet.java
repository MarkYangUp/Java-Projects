package com.medibidz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.UserDao;

/**
 * Servlet implementation class WishListServlet
 */
@WebServlet("/WishListServlet")
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	HttpSession session=request.getSession();
	int uid=(Integer)session.getAttribute("userid");
	String wish=request.getParameter("wish");
	
	UserDao dao=DaoFactory.getUserDao();
	dao.addWishList(uid, wish);
	response.sendRedirect("MyProfileServlet");
	}

}
