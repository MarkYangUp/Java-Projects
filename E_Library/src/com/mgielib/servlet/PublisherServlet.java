package com.mgielib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mgielib.dao.AuthorDao;
import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.PublisherDao;
import com.mgielib.entity.Publisher;

/**
 * Servlet implementation class PublisherServlet
 */
@WebServlet("/PublisherServlet")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		Publisher pub=new Publisher();
		try {
			BeanUtils.populate(pub,request.getParameterMap());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		PublisherDao obj=DaoFactory.getPublisherDao();
		int r=obj.addPublisher(pub);
		
		
		
		if(r!=0)
			{
		response.sendRedirect("PublisherListServlet");
		}		
		else{
			request.setAttribute("error", "Error in insertion");
			RequestDispatcher rd=request.getRequestDispatcher("AddMaster.jsp");
			rd.forward(request, response);
			}

	}

}
