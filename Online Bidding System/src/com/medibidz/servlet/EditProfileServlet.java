package com.medibidz.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.UserDao;
import com.medibidz.entity.ItemImage;
import com.medibidz.entity.User;
import com.medibidz.entity.UserType;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
@MultipartConfig
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}
	
	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		User user=new User();
		HttpSession session=request.getSession(); 
		try {
			BeanUtils.populate(user,request.getParameterMap());
		
			Part p1 = request.getPart("pic");		
			if (p1!= null && p1.getSize()!=0)
			{
				ItemImage image = new ItemImage();
				image.setContentType(p1.getContentType());
				image.setImageData(p1.getInputStream());
				image.setImageSize(p1.getSize());
				user.setPicId(image);
			}
			int uid=(Integer)session.getAttribute("userid");
			UserDao dao=DaoFactory.getUserDao();
			dao.editProfile(user,uid);
	
		request.setAttribute("user",user);
		UserType ut=(UserType) session.getAttribute("userType");
		if(ut==UserType.ADMIN)
		{
		RequestDispatcher rd=request.getRequestDispatcher("AdminProfile.jsp");
		rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd1=request.getRequestDispatcher("MyProfile.jsp");
			rd1.forward(request, response);
		}
				
		
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
