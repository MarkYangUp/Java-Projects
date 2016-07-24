package com.mgielib.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgielib.entity.EMaterialTypes;
import com.mgielib.entity.EMaterialsBaseEntity;
import com.mgielib.entity.Publisher;
import com.mgielib.entity.Subject;
import com.mgielib.util.DBUtil;

/**
 * Servlet implementation class SearchDetailsServlet
 */
@WebServlet("/SearchDetailsServlet")
public class SearchDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EMaterialsBaseEntity data=new EMaterialsBaseEntity();
		String s=request.getParameter("uid");
		System.out.println(s);
		int id=Integer.parseInt(s);
		Connection con=null;
		try {
	        con = DBUtil.getConnection();
	        PreparedStatement pst=con.prepareStatement("select * from ematerialsbasemaster where id=?");
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
	        
	        
	        
	        
	        String title=null;
	        String authors=null;
	        String language=null;
	        int pubYear=0;
	        String edition=null;
	        String volume=null;
	        String category=null;
	        String genre=null;
	        int publisherId=0;
	        int subjectId=0;
	        
	        String eMaterialType=null;
	        	        if(rs.next())
	        {	
	        	
	        	 title=rs.getString("title");
	        	 authors=rs.getString("authors");
	        	 language=rs.getString("language");
	        	 edition=rs.getString("edition");
	        	 String link=rs.getString("link");
	        	 volume=rs.getString("volume");
	        	 pubYear=rs.getInt("pub_year");
	        	 category=rs.getString("cat_name");
	        	 genre=rs.getString("genre_name");
	        	 eMaterialType=rs.getString("material_type");
	        	 
	        	 publisherId=rs.getInt("pub_id");
	        	 subjectId=rs.getInt("sub_id");
	        	
	        	
	        	
	        	 	data.setId(id);	
	        	 	data.setTitle(title);
	        	 	data.setAuthors(authors);
	        	 	data.setLanguage(language);
		 	        data.setEdition(edition);
		 	        data.setLink(link);
		 	        data.setVolume(volume);
		 	        data.setPubYear(pubYear);
		 	        data.setCategory(category);
		 	        data.setGenre(genre);
		 	        data.setMaterialType(EMaterialTypes.valueOf(eMaterialType));
		 	        data.setDataStorageId(rs.getInt("data_storage_id"));
		 	        System.out.println("Details");
	        	}
	        
	        PreparedStatement pst1=con.prepareStatement("select * from subject where subId=?");
	        PreparedStatement pst2=con.prepareStatement("select * from publisher  where pubId=?");
	        pst1.setInt(1,subjectId);
	        pst2.setInt(1,publisherId);
			ResultSet rs1=pst1.executeQuery();
			ResultSet rs2=pst2.executeQuery();
	        
	        if(rs2.next())
	        {
	        data.setPublisher(new Publisher(rs2.getInt("pubId"), rs2.getString("pubName"),rs2.getString("url"), rs2.getString("description")));
	        
	        System.out.println("Details");
	        }
	        if(rs1.next())
	        {
	        
	        data.setSubject(new Subject(rs1.getInt("subId"),rs1.getString("subName"),rs1.getString("category")));	
	        System.out.println("Details");
	        }
	        
	
	
		}catch (Exception e1) {
	        e1.printStackTrace();
	    }
		
		
		request.setAttribute("data",data);
		RequestDispatcher rd=request.getRequestDispatcher("DetailSearchResult.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
	    DBUtil.closeConnection(con);

}
	
}

