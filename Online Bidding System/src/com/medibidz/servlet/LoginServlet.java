 package com.medibidz.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medibidz.util.DBUtil;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements Servlet 
{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String loginId=request.getParameter("loginId");
		
		String password=request.getParameter("pwd");
		//System.out.println(loginId+" "+password);
		String next=null;	
		Connection con=null;
			HttpSession session=request.getSession();
		try{
			con=DBUtil.getConnection();
			PreparedStatement pstuser=con.prepareStatement("select * from user where loginId=? and password=?");
			pstuser.setString(1, loginId);
			pstuser.setString(2, password);		
			ResultSet rs=pstuser.executeQuery();
			
			if(rs.next())
			{	
				String userid=rs.getString(1);
				
				String userType=rs.getString(3);
				String firstName=rs.getString(4);
				//System.out.println(firstName);
				String lastName=rs.getString(5);
				String email=rs.getString(6);
				//System.out.println(email);
				String contactNo=rs.getString(7);
				String userName=firstName.concat(" "+lastName);
				System.out.println(userName);

				session.setAttribute("uid",userid);
				session.setAttribute("userType",userType);
				session.setAttribute("userName",userName);
				
				session.setAttribute("contactNo",contactNo);
				session.setAttribute("email",email);
				
				next="MainPage.jsp";
			
			}
			else
			{
				next="invalid.html";
			}
			rs.close();
			pstuser.close();
			con.close();	
		}
		catch (Exception e) {		
		System.out.println(e);
		}		
		response.sendRedirect(next);

	}

}
