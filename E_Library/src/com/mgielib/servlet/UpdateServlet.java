package com.mgielib.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.util.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usid=(String)request.getParameter("usid");
		Integer uid=Integer.parseInt(usid);
		String mtype=(String)request.getParameter("mtype");
		String authors=request.getParameter("authors");
		String title=request.getParameter("title");
		String language=request.getParameter("language");
		int pubYear=Integer.parseInt(request.getParameter("pubYear"));
		String edition=request.getParameter("edition");
		String volume=request.getParameter("volume");
		String desc=request.getParameter("desc");
		String link=request.getParameter("link");
		String category=request.getParameter("category");
		int subject=Integer.parseInt(request.getParameter("subjectId"));
		String genre=request.getParameter("genre");
		int publisher=Integer.parseInt(request.getParameter("publisherId"));
		try
		{
			Connection con=DBUtil.getConnection();
	
		PreparedStatement pst=con.prepareStatement("update ematerialsbasemaster set genre_name=?,cat_name=?,pub_id=?,sub_id=?,title=?,pub_year=?,edition=?,volume=?,link=?,authors=?,language=? where id=? ");	
		pst.setString(1,genre);
		pst.setString(2,category);
		pst.setInt(3,publisher);
		pst.setInt(4,subject);
		pst.setString(5,title);
		pst.setInt(6,pubYear);
		pst.setString(7,edition);
		pst.setString(8,volume);
		pst.setString(9,link);
		pst.setString(10,authors);
		pst.setString(11,language);
		pst.setInt(12,uid);
		int r=pst.executeUpdate();
		
		if((r!=0)&&(mtype.equals("BOOK")))
				{
			String isbn10=request.getParameter("isbnten");
			String isbn13=request.getParameter("isbnthirteen");
			PreparedStatement pst2=con.prepareStatement("update ebook set isbn_10=?,isbn_13=? where id=? ");	
			pst2.setString(1,isbn10);
			pst2.setString(2,isbn13);
			pst2.setInt(3,uid);
			int r2=pst2.executeUpdate();
			if(r2!=0)	
			{
				request.setAttribute("success", "DATA UPDATED SUCCESSFULLY");
				RequestDispatcher rd=request.getRequestDispatcher("EnterAdmin.jsp");
				rd.forward(request, response);	
			}
			else
			{
				request.setAttribute("error", "Error in updation");
				RequestDispatcher rd=request.getRequestDispatcher("EnterAdmin.jsp");
				rd.forward(request, response);
			}
			
				}
		else if((r!=0)&&(mtype.equals("FACULTY_RESOURCES")))
		{
			String department=request.getParameter("department");
			String semester=request.getParameter("semester");
			PreparedStatement pst1=con.prepareStatement("update efacultyresource set department=?,semester=? where id=? ");	
			pst1.setString(1,department);
			pst1.setString(2,semester);
			pst1.setInt(3,uid);
			int r1=pst1.executeUpdate();
			if(r1!=0)	
			{
				request.setAttribute("success", "DATA UPDATED SUCCESSFULLY");
				RequestDispatcher rd=request.getRequestDispatcher("EnterFaculty.jsp");
				rd.forward(request, response);	
			}
			else
			{
				request.setAttribute("error", "Error in updation");
				RequestDispatcher rd=request.getRequestDispatcher("EnterFaculty.jsp");
				rd.forward(request, response);
			}
		}
		else if((r!=0)&&(mtype.equals("PROJECTS")))
		{
			String topic=request.getParameter("topic");
			String type=request.getParameter("type");
			String top=request.getParameter("top");
			PreparedStatement pst3=con.prepareStatement("update eproject set type=?,topic=?,top=? where id=? ");	
			pst3.setString(1,type);
			pst3.setString(2,topic);
			pst3.setString(3,top);
			pst3.setInt(4,uid);
			int r3=pst3.executeUpdate();
			if(r3!=0)	
			{
				request.setAttribute("success", "DATA UPDATED SUCCESSFULLY");
				RequestDispatcher rd=request.getRequestDispatcher("EnterAdmin.jsp");
				rd.forward(request, response);	
			}
			else
			{
				request.setAttribute("error", "Error in updation");
				RequestDispatcher rd=request.getRequestDispatcher("EnterAdmin.jsp");
				rd.forward(request, response);
			}
			
	
		}
		else if((r!=0)&&((mtype.equals("PAPER"))||(mtype.equals("JOURNAL"))))
		{
		
			String year=request.getParameter("year");
			String month=request.getParameter("month");
			String frequency=request.getParameter("frequency");
			PreparedStatement pst4=con.prepareStatement("update epublish set month=?,year=?,frequency=? where id=? ");	
			pst4.setString(1,month);
			pst4.setString(2,year);
			pst4.setString(3,frequency);
			pst4.setInt(4,uid);
			int r4=pst4.executeUpdate();
			if(r4!=0)	
			{
				request.setAttribute("success", "DATA UPDATED SUCCESSFULLY");
				RequestDispatcher rd=request.getRequestDispatcher("EnterAdmin.jsp");
				rd.forward(request, response);	
			}
			else
			{
				request.setAttribute("error", "Error in updation");
				RequestDispatcher rd=request.getRequestDispatcher("EnterAdmin.jsp");
				rd.forward(request, response);
			}
	
	
		}
		}catch (Exception e1) {
	        e1.printStackTrace();
	    }
	
	}

}
