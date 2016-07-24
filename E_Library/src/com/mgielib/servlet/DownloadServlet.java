package com.mgielib.servlet;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.util.DBUtil;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("dnid");
		System.out.println(uid);
		int id=Integer.parseInt(uid);
		System.out.println(id);
		try{
			Connection con=DBUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from file_data where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				String fileName=rs.getString(2);
				String fileType=rs.getString(3);
				String fileOriginalName=rs.getString(4);
				Blob blob=rs.getBlob(6);
				//String path="c:\\abc\\uploaded_data";
			//	InputStream is=new FileInputStream(path+"\\"+fileName);
				InputStream is=blob.getBinaryStream();
				response.setContentType(fileType);	
				response.setHeader("content-disposition", "Attachment;Filename="+fileOriginalName);
				OutputStream os = response.getOutputStream();
				int b=-1;
				while((b=is.read())!=-1)
					os.write(b);
				os.flush();
				os.close();
			}
			rs.close();
			id++;				
			pst.close();
			con.close();	
			
			
		}catch(Exception e){
			e.printStackTrace();
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			out.println("Error : "+e);
			out.println("</body></html>");
		}
	}

}
