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
import com.mgielib.dao.EBookDao;
import com.mgielib.entity.DataEntity;
import com.mgielib.entity.EBook;
import com.mgielib.entity.EMaterialTypes;
import com.mgielib.entity.Publisher;
import com.mgielib.entity.Subject;

/**
 * Servlet implementation class AddEBookServlet
 */
@WebServlet("/AddEBookServlet")
@MultipartConfig
public class AddEBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	int r=0;
	EBook book=new EBook();
		try {
			BeanUtils.populate(book,request.getParameterMap());
			int pubId=Integer.parseInt(request.getParameter("publisherId"));
			int subId=Integer.parseInt(request.getParameter("subjectId"));
			if(pubId!=-1){
			Publisher p=new Publisher();
			p.setPubId(pubId);
			book.setPublisher(p);
			}
		
			Subject s=new Subject();
			s.setSubId(subId);
			book.setSubject(s);
		Part p1=request.getPart("fn");	
		DataEntity data=new DataEntity();
		data.setFileName(request.getParameter("title"));
		data.setFileContents(p1.getInputStream());
		data.setFileContentType(p1.getContentType());
		data.setFileOriginalName(PartService.getFileName(p1));
		data.setFileSize(p1.getSize());
		book.setData(data);
		
		book.setMaterialType(EMaterialTypes.BOOK);
		EBookDao obj=DaoFactory.getEBookDao();
		r=obj.addEBook(book);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(r!=0)
			{
			request.setAttribute("success", "Data added Successfully");
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
