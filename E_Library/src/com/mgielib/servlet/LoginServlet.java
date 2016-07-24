package com.mgielib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mgielib.util.DBUtil;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginId=request.getParameter("loginId");
		String password=request.getParameter("password");
		String next=null;	
		Connection con=null;
		HttpSession session=request.getSession();
		try{
			con=DBUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from user where loginId=? and password=?");
			pst.setString(1,loginId);
			pst.setString(2,password);		
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{	System.out.println("entered if");
				String userId=rs.getString(1);
				String userType=rs.getString(3);
				String firstName=rs.getString(4);
				String lastName=rs.getString(5);
				firstName=firstName+" "+lastName;
				System.out.println(userType);
				session.setAttribute("uid",userId);
				session.setAttribute("userType",userType);
				session.setAttribute("userName",firstName);
				next="UserTypeServlet";
			
			}
			else
			{
				next="Invalid.jsp";
			}
			rs.close();
			pst.close();
			con.close();	
		}
		catch (Exception e) {		
	PrintWriter out=response.getWriter();
			out.println(e);
		}		
		
		response.sendRedirect(next);
		}
	
	}
