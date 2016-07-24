package com.medibidz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.entity.Item;

/**
 * Servlet implementation class BuyerServlet
 */
@WebServlet("/BidServlet")
public class BidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String itemId=request.getParameter("bidItemId");
		Integer bidItemId=null;
		if(itemId==null)
		bidItemId=(Integer)session.getAttribute("bidItemId");			
		else			
		bidItemId=Integer.parseInt(itemId);		
		
		session.setAttribute("bidItemId",bidItemId);
		
		Integer userId=(Integer)session.getAttribute("userid");
		
		String next=null;
		
		
		if(userId==null)
		{
			next="Login.jsp";

			response.sendRedirect(next);
		return;
		}		
		else
		{
			ItemDao dao=DaoFactory.getItemDao();
			Item item=dao.getNewItem(bidItemId);
			if(item!=null)
			{
				request.setAttribute("itm",item);
				RequestDispatcher rd=request.getRequestDispatcher("ItemBid.jsp");
				rd.forward(request, response);
			}
			else{
				next="DisplayItems.jsp";

				response.sendRedirect(next);
			}
		}
		
	}

}
