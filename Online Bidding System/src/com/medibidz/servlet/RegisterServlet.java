package com.medibidz.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.medibidz.dao.BranchDao;
import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.DepartmentDao;
import com.medibidz.dao.UserDao;
import com.medibidz.entity.Branch;
import com.medibidz.entity.Department;
import com.medibidz.entity.ItemImage;
import com.medibidz.entity.Registeration;
import com.medibidz.entity.UserType;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
BranchDao dao=DaoFactory.getBranchDao();
List<Branch>	branchList=	dao.getBranchList();
request.setAttribute("brLst", branchList);

DepartmentDao dao1=DaoFactory.getDepartmentDao();
List<Department> departmentList=dao1.getDepartmentList();
request.setAttribute("dptLst",departmentList);


RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
				
		String next=null;	
		Registeration reg=new Registeration();
		try {
			BeanUtils.populate(reg, request.getParameterMap());
		
			String branch=request.getParameter("branchId");
			Branch b=new Branch();
			b.setBranchId(Integer.parseInt(branch));
			reg.setBranch(b);
			String department=request.getParameter("deptId");
			Department d=new Department();
			d.setDepartmentId(Integer.parseInt(department));
			reg.setDepartment(d);
			
			String userType=request.getParameter("user");
			
			Part p1 = request.getPart("pic");		
			if (p1 != null && p1.getSize()!=0) {
				ItemImage image = new ItemImage();
				image.setContentType(p1.getContentType());
				image.setImageData(p1.getInputStream());
				image.setImageSize(p1.getSize());
				reg.setPicId(image);
			}
			
			
			reg.setUserType(UserType.valueOf(userType));
			
			UserDao dao=DaoFactory.getUserDao();
			dao.register(reg);
			
			
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		response.sendRedirect("RegisterWait.jsp");
		
	
			}
	}


