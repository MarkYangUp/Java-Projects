package com.medibidz.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;

/**
 * Servlet implementation class GetImageServlet
 */
@WebServlet("/getImage")
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int imageId=Integer.parseInt(request.getParameter("id"));
		ItemDao dao=DaoFactory.getItemDao();
		InputStream is=dao.getImageData(imageId);
		if(is==null || is.available()<1){
			is=new FileInputStream( getServletContext().getRealPath("imgs")+"/not_found.jpg");
		}
		OutputStream out=response.getOutputStream();
		IOUtils.copy(is, out);
		is.close();
		out.flush();out.close();
	}

}
