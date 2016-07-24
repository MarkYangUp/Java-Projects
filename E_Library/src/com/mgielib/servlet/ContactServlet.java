package com.mgielib.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.util.DBUtil;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			
	
		String Name=request.getParameter("name");
		
		String Email=request.getParameter("email");
		
		String Phone=request.getParameter("phone");
		
		String Message=request.getParameter("msg");
			
		
		String next=null;	
		Connection con=null;
			
		try{
			con=DBUtil.getConnection();
			PreparedStatement pstInsert=con.prepareStatement("insert into contact(Name,Email,Phone,Message) values(?,?,?,?)");
			
			pstInsert.setString(1,Name);	
			pstInsert.setString(2,Email);	
			pstInsert.setString(3,Phone);	
			pstInsert.setString(4,Message);	
			int r=pstInsert.executeUpdate();
			if(r!=0)
			{
									
			
					
					next="Contact.jsp?msg=s";
			
			}
			else
			{	
				next="Contact.jsp?msg=e";
			}
			
			pstInsert.close();
			con.close();	
		}
		catch (Exception e) {		
		System.out.println(e);
		}		
		response.sendRedirect(next);
		
	

	
	}

}
