package com.medibidz.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.medibidz.dao.DaoFactory;
import com.medibidz.dao.ItemDao;
import com.medibidz.entity.Item;
import com.medibidz.entity.ItemImage;
import com.medibidz.entity.User;
import com.medibidz.util.DateUtil;

/**
 * Servlet implementation class SellerServlet
 */
@WebServlet("/addItem")
@MultipartConfig
public class AddItemServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer userid=(Integer)session.getAttribute("userid");
		if(userid==null){
			response.sendRedirect("InvalidUser.jsp");
			return;			
		}
		
		Item item = new Item();
		try 
		{
			BeanUtils.populate(item, request.getParameterMap());
		} catch (IllegalAccessException e) {
					e.printStackTrace();
		} catch (InvocationTargetException e) {		
			e.printStackTrace();
		}

		
		String ldStr=request.getParameter("lastDateStr");

		item.setLastDate(DateUtil.stringToDate(ldStr));
		item.setInsertionDate(new Date());
		
		Part p1 = request.getPart("img1");
		Part p2 = request.getPart("img2");
		Part p3 = request.getPart("img3");		
		if (p1 != null && p1.getSize()!=0) {
			ItemImage image1 = new ItemImage();
			image1.setContentType(p1.getContentType());
			image1.setImageData(p1.getInputStream());
			image1.setImageSize(p1.getSize());
			item.setImage1(image1);
		}
		if (p2 != null && p2.getSize()!=0) {
			ItemImage image2 = new ItemImage();
			image2.setContentType(p2.getContentType());
			image2.setImageData(p2.getInputStream());
			image2.setImageSize(p2.getSize());
			item.setImage2(image2);
		}
		if (p3 != null && p3.getSize()!=0) {
			ItemImage image3 = new ItemImage();
			image3.setContentType(p3.getContentType());
			image3.setImageData(p3.getInputStream());
			image3.setImageSize(p3.getSize());
			item.setImage3(image3);
		}
			
			item.setSeller(new User(userid));
			
			ItemDao itemDao=DaoFactory.getItemDao();
			itemDao.addItem(item);
			response.sendRedirect(session.getAttribute("home").toString());
	}

}
