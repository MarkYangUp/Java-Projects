package com.mgielib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.SubjectDao;
import com.mgielib.entity.Subject;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Subject sub=new Subject();
		try {
			BeanUtils.populate(sub,request.getParameterMap());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		SubjectDao obj=DaoFactory.getSubjectDao();
		int r=obj.addSubject(sub);
		
		
		
		if(r!=0)
			{
		response.sendRedirect("SubjectListServlet");
		}		
		else{
			request.setAttribute("error", "Error in insertion");
			RequestDispatcher rd=request.getRequestDispatcher("AddMaster.jsp");
			rd.forward(request, response);
			}

	}

}
