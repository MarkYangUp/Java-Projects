package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mgielib.dao.SearchCriteriaDao;
import com.mgielib.entity.EBook;
import com.mgielib.entity.EFacultyResource;
import com.mgielib.entity.EMaterialTypes;
import com.mgielib.entity.EMaterialsBaseEntity;
import com.mgielib.entity.EProject;
import com.mgielib.entity.EPublish;
import com.mgielib.entity.SearchCriteria;
import com.mgielib.util.DBUtil;

public class SearchCriteriaDaoImpl implements SearchCriteriaDao {

	public List<EMaterialsBaseEntity> search(SearchCriteria searchCriteria)
	{
		
		System.out.println("---- "+searchCriteria);
		List<EMaterialsBaseEntity> searchList=new ArrayList<EMaterialsBaseEntity>();
		
		Connection con=null;
		try {
	        con = DBUtil.getConnection();
	        String sql="select * from ematerialsbasemaster";
	        int id=0;
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
	        
	       
	        boolean flag=false;
	        
	        if(searchCriteria.getTitle().trim().length()>0)
	        		{	
	        			if(!flag)
	        				{
	        					sql=sql+" where";
	        					flag=true;
	        				
	        				}
	        			else
	        				{
	        					sql=sql+" and";
	        				}
	        			
	        			sql=sql+" title like '%"+searchCriteria.getTitle()+"%'";
	        		}
	        
	        if(searchCriteria.getAuthors().trim().length()>0)
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" authors like '%"+searchCriteria.getAuthors()+"%'";
    		}
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        if(searchCriteria.getLanguage().trim().length()>0)
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" language like '%"+searchCriteria.getLanguage()+"%'";
    		}
	        
	        
	        if(searchCriteria.getPubYear()!=0)
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" pub_year like '%"+searchCriteria.getPubYear()+"%'";
    		}
	        
	        
	        
	        if(searchCriteria.getEdition().trim().length()>0)
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" edition like '%"+searchCriteria.getEdition()+"%'";
    		}
	        
	        if(searchCriteria.getVolume().trim().length()>0)
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" volume like '%"+searchCriteria.getVolume()+"%'";
    		}
	        
	        
	        
	       if((searchCriteria.getGenre().trim().length()>0)&&(searchCriteria.getGenre().equals("NONE")!=true))
	        	
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" genre_name like '%"+searchCriteria.getGenre()+"%'";
    		}
	        
	        if((searchCriteria.getCategory().trim().length()>0)&&(searchCriteria.getCategory().equals("NONE")!=true))
	        	
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" cat_name like '%"+searchCriteria.getCategory()+"%'";
    		}
	        
	        
            if(searchCriteria.getPublisherId()!=0)
	        	
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" pub_id like '%"+searchCriteria.getPublisherId()+"%'";
    		}

            if(searchCriteria.getSubjectId()!=0)
	        	
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" sub_id like '%"+searchCriteria.getSubjectId()+"%'";
    		}

            
            
            if(searchCriteria.geteMaterialType().trim().length()>0)
	        	
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" and";
    				}
    			
    			sql=sql+" material_type like '%"+searchCriteria.geteMaterialType()+"%'";
    		}
            
	       
	        Statement st=con.createStatement();

    		PreparedStatement pst=con.prepareStatement("select * from ebook where id=?");
    		PreparedStatement pst2=con.prepareStatement("select * from epublish where id=?");
    		PreparedStatement pst3=con.prepareStatement("select * from epublish where id=?");
    		PreparedStatement pst4=con.prepareStatement("select * from eproject where id=?");
    		PreparedStatement pst5=con.prepareStatement("select * from facultyresources where id=?");
	        ResultSet rs=st.executeQuery(sql);
	        System.out.println(sql);
	        if(rs.next())
	        {	
	        	do{
	        	id=rs.getInt("id"); 
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
	        	
	        	
	        	 EMaterialsBaseEntity data=null;
	        	
	        	
	        	 if(eMaterialType.equals("BOOK"))
	        	 {
	        		pst.setInt(1, rs.getInt("id"));
	        		ResultSet rs1=pst.executeQuery();
	        		if(rs1.next()){
	        			EBook book=new EBook();
	        			book.setMaterialType(EMaterialTypes.BOOK);
	        		book.setIsbnTen(rs1.getString("isbn_10"));
	        		book.setIsbnThirteen(rs1.getString("isbn_13"));
	        		data=book;
	        		}
	        	 } 
	        	 
	        	 else if(eMaterialType.equals("PAPER"))
	        	 {
	        		 
	        		pst2.setInt(1, rs.getInt("id"));
		        	ResultSet rs2=pst2.executeQuery();
		        	if(rs2.next())
		        	{
		        	EPublish publish=new EPublish();
		        	publish.setMaterialType(EMaterialTypes.PAPER);
		        	publish.setYear(rs2.getInt("year"));
		        	publish.setMonth(rs2.getInt("month"));
		        	publish.setFrequency(rs2.getString("frequency"));
		        	data=publish;
		        	}	
	        	 }
	        	 
	        	 
	        	 else if(eMaterialType.equals("JOURNAL"))
	        	 {
	        		 
	        		 	pst3.setInt(1, rs.getInt("id"));
			        	ResultSet rs3=pst3.executeQuery();
			        	
			        	if(rs3.next())
			        	{
			        	EPublish publish=new EPublish();
			        	publish.setMaterialType(EMaterialTypes.JOURNAL);
			        	publish.setYear(rs3.getInt("year"));
			        	publish.setMonth(rs3.getInt("month"));
			        	publish.setFrequency(rs3.getString("frequency"));
			        	data=publish;
			        	}
	        		 
	        	} 
	        
	        	 
	        	 
	        	 else if(eMaterialType.equals("PROJECTS"))
	        	 {
	        		 
	        		id=rs.getInt("id");
	        		 System.out.println("P ID : "+id);
	        		 	pst4.setInt(1, id);
			        	ResultSet rs4=pst4.executeQuery();
			        	if(rs4.next())
			        	{
			        	EProject project=new EProject();
			        	project.setMaterialType(EMaterialTypes.PROJECTS);
			        	project.setTopic(rs4.getString("topic"));
			        	project.setProjectType(rs4.getString("type"));
			        	project.setTop(rs4.getString("top"));	        	
			        	data=project;
			        	}
	        	 } 
	        	 
	        	 else if(eMaterialType.equals("FACULTY_RESOURCES"))
	        	 {
	        		
	        		 
			        	pst5.setInt(1, rs.getInt("id"));
			        	ResultSet rs5=pst5.executeQuery();
			        
			        if(rs5.next())
			        {
			        EFacultyResource resource=new EFacultyResource();
			        resource.setMaterialType(EMaterialTypes.FACULTY_RESOURCES);	
			        resource.setDepartment(rs5.getString("department"));
			        resource.setSemester(rs5.getString("semester"));
			        data=resource;	
			        }
			     
	        	 } 
	        	 
	        	 	if(data!=null){
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
		 	       searchList.add(data);
		        	 
	        	 	}
	 	        
	 	        
	 	        
	 	        
	 	        System.out.println("HELLO");
	        	}while(rs.next());
	        	
	        
	        
	        }
    
    
	        
	        
		
		
		
		}catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    DBUtil.closeConnection(con);	
	    
	    
	    return searchList;
		
	}
	
	
	public List<EMaterialsBaseEntity> quickSearch(String quickSearch)
	{
		System.out.println("---- "+quickSearch);
		List<EMaterialsBaseEntity> searchList=new ArrayList<EMaterialsBaseEntity>();
		
		Connection con=null;
		try {
	        con = DBUtil.getConnection();
	        String sql="select * from ematerialsbasemaster";
	        
	        SearchCriteria searchCriteria=new SearchCriteria(); 
	        searchCriteria.setTitle(quickSearch);
	        searchCriteria.setAuthors(quickSearch);
	        int id=0;
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
	         
	        
	       
	        boolean flag=false;
	        
	        if(searchCriteria.getTitle().trim().length()>0)
	        		{	
	        			if(!flag)
	        				{
	        					sql=sql+" where";
	        					flag=true;
	        				
	        				}
	        			else
	        				{
	        					sql=sql+" or";
	        				}
	        			
	        			sql=sql+" title like '%"+searchCriteria.getTitle()+"%'";
	        		}
	        
	        if(searchCriteria.getAuthors().trim().length()>0)
    		{	
    			if(!flag)
    				{
    					sql=sql+" where";
    					flag=true;
    				
    				}
    			else
    				{
    					sql=sql+" or";
    				}
    			
    			sql=sql+" authors like '%"+searchCriteria.getAuthors()+"%'";
    		}
    
	       
	        
                        
	       
	        Statement st=con.createStatement();

    		
	        ResultSet rs=st.executeQuery(sql);
	        System.out.println(sql);
	        
	        
	        
	        if(rs.next())
	        {	
	        	do{
	        	id=rs.getInt("id"); 
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
	        	
	        	
	        	 EMaterialsBaseEntity data=new EMaterialsBaseEntity();
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
		 	        searchList.add(data);
		        	 
	        	 	System.out.println("HELLO");
	        	}while(rs.next());
	        	
	        
	        
	        }	
	        }catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    DBUtil.closeConnection(con);	
	    
	    
	    return searchList;

		
		
	}
	
	 
}
