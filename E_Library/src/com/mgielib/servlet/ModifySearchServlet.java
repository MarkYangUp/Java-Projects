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

import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.SearchCriteriaDao;
import com.mgielib.entity.EMaterialsBaseEntity;
import com.mgielib.entity.SearchCriteria;

/**
 * Servlet implementation class ModifySearchServlet
 */
@WebServlet("/ModifySearchServlet")
public class ModifySearchServlet extends HttpServlet {

        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		SearchCriteria searchCriteria=new SearchCriteria();
		List<EMaterialsBaseEntity> searchList=null;
			try {
			BeanUtils.populate(searchCriteria,request.getParameterMap());
			
			SearchCriteriaDao obj=DaoFactory.getSearchCriteriaDao();
			searchList=obj.quickSearch(searchCriteria.getQuickSearch());
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("list",searchList);
			RequestDispatcher rd=request.getRequestDispatcher("ModifySearchResult.jsp");
			rd.forward(request, response);

	
	}

}
