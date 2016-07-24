package com.mgielib.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.entity.EMaterialTypes;
import com.mgielib.entity.EMaterialsBaseEntity;
import com.mgielib.entity.Publisher;
import com.mgielib.entity.Subject;
import com.mgielib.util.DBUtil;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EMaterialsBaseEntity data=new EMaterialsBaseEntity();
		String s=request.getParameter("uid");
		int rs=0;
		System.out.println(s);
		int id=Integer.parseInt(s);
		Connection con=null;
		try {
	        con = DBUtil.getConnection();
	        PreparedStatement pst=con.prepareStatement("delete from ematerialsbasemaster where id=?");
			pst.setInt(1,id);
			rs=pst.executeUpdate();
	
		}catch (Exception e1) {
	        e1.printStackTrace();
	    }
		
		
		if(rs!=0)
		{
			request.setAttribute("success","Data Deleted ");
			RequestDispatcher rd=request.getRequestDispatcher("DeleteContent.jsp");
			rd.forward(request, response);
			
		}
		
		else
		{
			request.setAttribute("error","Error in Deletion ");
			RequestDispatcher rd=request.getRequestDispatcher("DeleteContent.jsp");
			rd.forward(request, response);
				
			
		}
		
		
		
	    DBUtil.closeConnection(con);

	
	
	
	}

}
