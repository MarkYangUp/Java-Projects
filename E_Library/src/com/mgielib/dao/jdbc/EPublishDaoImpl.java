package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mgielib.dao.EPublishDao;
import com.mgielib.entity.EPublish;
import com.mgielib.util.DBUtil;


public class EPublishDaoImpl extends BaseDao implements EPublishDao {

	public int addEPublish(EPublish publish)
	
	{
		int r=0;
		Connection con = null;
		
		try {
	        con = DBUtil.getConnection();
	        PreparedStatement pstMaster = con.prepareStatement("insert into ematerialsbasemaster(pub_id,genre_name,cat_name,sub_id,data_storage_id,material_type,title,language,pub_year,edition,volume,link,authors) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
	        PreparedStatement pstPublish = con.prepareStatement("insert into epublish(id,publishType,year,month,frequency)values (?,?,?,?,?)");
	        
	       if(publish.getPublisher()!=null)
	        pstMaster.setInt(1,publish.getPublisher().getPubId());
	       else
	    	   pstMaster.setObject(1,null);
	          
	        pstMaster.setString(2,publish.getGenre());
	        pstMaster.setString(3,publish.getCategory());
	      
	        if(publish.getSubject()!=null)
	                    pstMaster.setInt(4,publish.getSubject().getSubId());
	        else
	     	   pstMaster.setObject(4,null);
	         
	        Integer dataId=null;
	        if(publish.getData()!=null){
	        	 dataId=addData(publish.getData(), con);
	        }
	             
	        pstMaster.setObject(5,dataId);
	       
	         
	        pstMaster.setString(6,publish.getMaterialType().toString());
	        pstMaster.setString(7,publish.getTitle());
	        pstMaster.setString(8, publish.getLanguage());
	        pstMaster.setInt(9, publish.getPubYear());
	        pstMaster.setString(10,publish.getEdition());
	        pstMaster.setString(11,publish.getVolume());
	        pstMaster.setString(12,publish.getLink());
	        pstMaster.setString(13,publish.getAuthors());
	        //pstMaster.setString(14,publish.getDescription());
	        r = pstMaster.executeUpdate();
	        ResultSet rsKeys=pstMaster.getGeneratedKeys();
	        rsKeys.next();
	        int id=rsKeys.getInt(1);
	        rsKeys.close();
	        publish.setId(id);
	        pstPublish.setInt(1,publish.getId());
	        pstPublish.setString(2,publish.getPublishType());
	        pstPublish.setInt(3,publish.getYear());
	        pstPublish.setInt(4,publish.getMonth());
	        pstPublish.setString(5,publish.getFrequency());
	       r=pstPublish.executeUpdate();
	        pstMaster.close();
	        pstPublish.close();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    DBUtil.closeConnection(con);	
		return r;

		
		
	}

}
