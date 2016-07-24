package com.medibidz.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.medibidz.util.DBUtil;

/**
 * Servlet implementation class SellerServlet
 */
@WebServlet("/SellerServlet")
public class SellerServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Category=request.getParameter("category");
		
		String ItemName=request.getParameter("itemname");
		
		String Description=request.getParameter("desc");
		
		String lastName=request.getParameter("lname");
		
		String email=request.getParameter("email");
		
		String contactNo=request.getParameter("contactNo");
		
		String LastDate=request.getParameter("lastdate");
		
		String StartBid=request.getParameter("startbid");
		String name1=request.getParameter("name1");
		String name2=request.getParameter("name2");
		String name3=request.getParameter("name3");
		
		Part p1=request.getPart("img1");
		Part p2=request.getPart("img2");
		Part p3=request.getPart("img3");
		
		String fileType1=p1.getContentType();
		String fileType2=p2.getContentType();
		String fileType3=p2.getContentType();
		InputStream is1=p1.getInputStream();
		InputStream is2=p2.getInputStream();
		InputStream is3=p3.getInputStream();
		
		String fileOriginalName1=getFileName(p1);
		String fileOriginalName2=getFileName(p2);
		String fileOriginalName3=getFileName(p3);
		
		long sz1=p1.getSize();
		long sz2=p2.getSize();
		long sz3=p3.getSize();

		String next=null;	
		Connection con=null;
			
		HttpSession session=request.getSession();
		try{
			String userName=(String)session.getAttribute("userName");
			String userType=(String)session.getAttribute("userType");
			con=DBUtil.getConnection();
			PreparedStatement pstseller=con.prepareStatement("insert into sellerinfo(username,enrollment,category,itemname,description,image1,image2,image3,lastdate,startbid,email,contactNo) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstseller.setString(1,userName);	
			if(userType.equals("FACULTY"))
			{
			String facid=(String)session.getAttribute("facid");
			pstseller.setString(2,facid);
			}
			else if(userType.equals("STUDENT"))
			{
				String enrollment=(String)session.getAttribute("enroll");
				pstseller.setString(2,enrollment);
			}
			
				
			pstseller.setString(3,Category);	
			pstseller.setString(4,ItemName);	
			pstseller.setString(5,Description);
			pstseller.setString(6,email);	
			pstseller.setString(6,email);
			pstseller.setString(6,email);
			pstseller.setString(6,email);
			pstseller.setString(6,email);
			pstseller.setString(11,email);
			pstseller.setString(12,contactNo);
			
			int r=pstseller.executeUpdate();
			if(r!=0)
			{
				System.out.println("Seller info done");
			}
			PreparedStatement pstsimage=con.prepareStatement("INSERT INTO image(number,filename,filetype,filesize,filecontents) values(?,?,?,?,?)");
			if(name1.equals("1."))
			{
			pstsimage.setString(1,name1);
			pstsimage.setString(2, fileOriginalName1);
			pstsimage.setString(3, fileType1);
			pstsimage.setLong(4, sz1);
			pstsimage.setBlob(5, p1.getInputStream());
			}
			if(name1.equals("1."))
			{
			pstsimage.setString(1,name1);
			pstsimage.setString(2, fileOriginalName1);
			pstsimage.setString(3, fileType1);
			pstsimage.setLong(4, sz1);
			pstsimage.setBlob(5, p1.getInputStream());
			}
			else if(name2.equals("2."))
			{
			pstsimage.setString(1,name2);
			pstsimage.setString(2, fileOriginalName2);
			pstsimage.setString(3, fileType2);
			pstsimage.setLong(4, sz2);
			pstsimage.setBlob(5, p2.getInputStream());
			}
			else if(name3.equals("3."))
			{
			pstsimage.setString(1,name3);
			pstsimage.setString(2, fileOriginalName3);
			pstsimage.setString(3, fileType3);
			pstsimage.setLong(4, sz3);
			pstsimage.setBlob(5, p3.getInputStream());
			}
			int r1=pstsimage.executeUpdate();
			if(r1!=0)
			{
				System.out.println("image info done");
			}
			pstsimage.close();	
					
			
			
				next="register.jsp";
			
			
			pstseller.close();
			con.close();	
		}
		catch (Exception e) {		
		System.out.println(e);
		}	
		
		response.sendRedirect(next);
	}
		private String getFileName(Part part){
	  		String fn=null;
			String partHeader = part.getHeader("content-disposition");
			String [] s=partHeader.split(";");
		    for (String e : s) {
		    	System.out.println(e);
		      if (e.trim().startsWith("filename")) {
		    	  
		    	  //remove " from filename
		        fn=e.substring(e.indexOf('=') + 1).trim().replace("\"", "");
		        System.out.println("FN="+fn);
		        if(fn.indexOf("\\")!=0){
		        	fn=fn.substring(fn.lastIndexOf("\\")+1);
		        }
		      }
		    }
			return fn;
		}
		void saveFile(Part part,String fileName) throws IOException{
			String path="c:\\abc\\uploaded_data";
			File dir=new File(path);
			if(!dir.exists()){
				dir.mkdir();
			}
			String filePath=path+"\\"+fileName;
			part.write(filePath);
			System.out.println("--------------------"+filePath);
			
			
	
	

	
	
	}

}
