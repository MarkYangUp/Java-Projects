package com.mgielib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.mgielib.dao.DaoFactory;
import com.mgielib.dao.EProjectDao;
import com.mgielib.entity.DataEntity;
import com.mgielib.entity.EMaterialTypes;
import com.mgielib.entity.EProject;
import com.mgielib.entity.Publisher;
import com.mgielib.entity.Subject;

/**
 * Servlet implementation class AddEProjectServlet
 */
@WebServlet("/AddEProjectServlet")
@MultipartConfig
public class AddEProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int r=0;
		EProject project=new EProject();
			try {
				BeanUtils.populate(project,request.getParameterMap());
				int pubId=Integer.parseInt(request.getParameter("publisherId"));
				int subId=Integer.parseInt(request.getParameter("subjectId"));
				if(pubId!=-1){
				Publisher p=new Publisher();
				p.setPubId(pubId);
				project.setPublisher(p);
				}
			
				Subject s=new Subject();
				s.setSubId(subId);
				project.setSubject(s);
				
				Part p1=request.getPart("fn");	
				DataEntity data=new DataEntity();
				data.setFileName(request.getParameter("title"));
				data.setFileContents(p1.getInputStream());
				data.setFileContentType(p1.getContentType());
				data.setFileOriginalName(PartService.getFileName(p1));
				data.setFileSize(p1.getSize());
				project.setData(data);
				
			
			
			project.setMaterialType(EMaterialTypes.PROJECTS);
			EProjectDao obj=DaoFactory.getEProjectDao();
			r=obj.addEProject(project);
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			if(r!=0)
				{
				request.setAttribute("success", "DATA ADDED SUCCESSFULLY");
				RequestDispatcher rd=request.getRequestDispatcher("EnterAdmin.jsp");
				rd.forward(request, response);
			}		
			else{
				request.setAttribute("error", "Error in insertion");
				RequestDispatcher rd=request.getRequestDispatcher("EnterAdmin.jsp");
				rd.forward(request, response);
				}


	
	
	
	}

}
