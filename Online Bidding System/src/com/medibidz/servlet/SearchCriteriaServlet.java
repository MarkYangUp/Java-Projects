package com.medibidz.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.entity.Item;
import com.medibidz.entity.SearchCriteria;

/**
 * Servlet implementation class SearchCriteriaServlet
 */
@WebServlet("/SearchCriteriaServlet")
public class SearchCriteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		SearchCriteria search= new SearchCriteria();
		try 
		{
			BeanUtils.populate(search,request.getParameterMap());
		} 
		catch (IllegalAccessException e)
		{
					e.printStackTrace();
		} 
		catch (InvocationTargetException e)
		{		
					e.printStackTrace();
		}

		ItemDao dao=DaoFactory.getItemDao();
		List<Item> item=dao.searchItem(search);
		request.setAttribute("item",item);
		RequestDispatcher rd=request.getRequestDispatcher("DisplayItems.jsp");
		rd.forward(request,response);
	}
}
