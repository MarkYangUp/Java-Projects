package com.mgielib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.SearchCriteriaDao;
import com.mgielib.entity.EMaterialTypes;
import com.mgielib.entity.EMaterialsBaseEntity;
import com.mgielib.entity.SearchCriteria;

/**
 * Servlet implementation class SearchContentServlet
 */
@WebServlet("/SearchContentServlet")
public class SearchContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		SearchCriteria searchCriteria=new SearchCriteria();
		List<EMaterialsBaseEntity> searchList=null;
			try {
				BeanUtils.populate(searchCriteria,request.getParameterMap());
			System.out.println(request.getParameter("eMaterialType"));
			if(request.getParameter("eMaterialType").equals("PUBLISH"))
			{
				if(request.getParameter("publishType").equals("JOURNAL"))
					searchCriteria.seteMaterialType("JOURNAL");
				else
					searchCriteria.seteMaterialType("PAPER");
			}
				
				
			SearchCriteriaDao obj=DaoFactory.getSearchCriteriaDao();
			searchList=obj.search(searchCriteria);
			
			
			
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("\n");
			System.out.println(searchList);
			System.out.println("\n");
			request.setAttribute("list",searchList);
			RequestDispatcher rd=request.getRequestDispatcher("SearchResult.jsp");
			rd.forward(request, response);
				
	
	}

}
