package com.medibidz.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.entity.Item;

/**
 * Servlet implementation class GetRangeServlet
 */
@WebServlet("/GetRangeServlet")
public class GetRangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	String range=request.getParameter("range");
	System.out.println(range);
	String[] min1=range.split(" - ");
	String[] ranges=range.trim().split("Rs");
	String max=ranges[ranges.length-1];
	String min2=min1[0];
	String min=min2.replace("Rs", "");
	System.out.println(max);
	System.out.println(min); 
	
	ItemDao dao=DaoFactory.getItemDao();
	List<Item> al=dao.getItemsByPrice(Integer.parseInt(min), Integer.parseInt(max));
	if(al!=null)
	{
	for(Item a:al)
		System.out.println(a);
	}
	
	}


}
