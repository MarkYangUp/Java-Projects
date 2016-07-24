package com.mgielib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mgielib.dao.CategoryDao;
import com.mgielib.dao.DaoFactory;
import com.mgielib.entity.Category;

/**
 * Servlet implementation class Category
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	Category cat=new Category();
	try {
		BeanUtils.populate(cat,request.getParameterMap());
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	CategoryDao obj=DaoFactory.getCategoryDao();
	int r=obj.addCategory(cat);
	
	
	
	if(r!=0)
		{
	response.sendRedirect("categoryList");
	}		
	else{
		request.setAttribute("error", "Error in insertion");
		RequestDispatcher rd=request.getRequestDispatcher("AddMaster.jsp");
		rd.forward(request, response);
		}
	
	}
	
}

