package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mgielib.dao.EFacultyResourceDao;
import com.mgielib.entity.EFacultyResource;
import com.mgielib.util.DBUtil;


public class EFacultyResourceDaoImpl extends BaseDao implements EFacultyResourceDao {

	public int addEFacultyResource(EFacultyResource resource)
	{
		int r=0;
		Connection con = null;
		
		try {
	        con = DBUtil.getConnection();
	        PreparedStatement pstMaster = con.prepareStatement("insert into ematerialsbasemaster(pub_id,genre_name,cat_name,sub_id,data_storage_id,material_type,title,language,pub_year,edition,volume,link,authors) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
	        PreparedStatement pstResource = con.prepareStatement("insert into efacultyresource(id,department,semester)values (?,?,?)");
	        
	       if(resource.getPublisher()!=null)
	        pstMaster.setInt(1,resource.getPublisher().getPubId());
	       else
	    	   pstMaster.setObject(1,null);
	          
	        pstMaster.setString(2,resource.getGenre());
	        pstMaster.setString(3,resource.getCategory());
	      
	        if(resource.getSubject()!=null)
	                    pstMaster.setInt(4,resource.getSubject().getSubId());
	        else
	     	   pstMaster.setObject(4,null);
	         
	      
	        Integer dataId=null;
	        if(resource.getData()!=null){
	        	 dataId=addData(resource.getData(), con);
	        }
	             
	        pstMaster.setObject(5,dataId);
	       
	        
	        
	        
	        pstMaster.setString(6,resource.getMaterialType().toString());
	        pstMaster.setString(7,resource.getTitle());
	        pstMaster.setString(8, resource.getLanguage());
	        pstMaster.setInt(9, resource.getPubYear());
	        pstMaster.setString(10,resource.getEdition());
	        pstMaster.setString(11,resource.getVolume());
	        pstMaster.setString(12,resource.getLink());
	        pstMaster.setString(13,resource.getAuthors());
	        //pstMaster.setString(14,resource.getDescription());
	        r = pstMaster.executeUpdate();
	        ResultSet rsKeys=pstMaster.getGeneratedKeys();
	        rsKeys.next();
	        int id=rsKeys.getInt(1);
	        rsKeys.close();
	        resource.setId(id);
	        pstResource.setInt(1,resource.getId());
	        pstResource.setString(2,resource.getDepartment());
	        pstResource.setString(3,resource.getSemester());
	       r=pstResource.executeUpdate();
	        pstMaster.close();
	        pstResource.close();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    DBUtil.closeConnection(con);	
		return r;


		
	}

}