package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mgielib.dao.EProjectDao;
import com.mgielib.entity.EProject;
import com.mgielib.util.DBUtil;


public class EProjectDaoImpl extends BaseDao implements EProjectDao {

	public int addEProject(EProject project)
	{
	int r=0;
	Connection con = null;
	
	try {
        con = DBUtil.getConnection();
        PreparedStatement pstMaster = con.prepareStatement("insert into ematerialsbasemaster(pub_id,genre_name,cat_name,sub_id,data_storage_id,material_type,title,language,pub_year,edition,volume,link,authors) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        PreparedStatement pstProject = con.prepareStatement("insert into eproject(id,topic,type,top)values (?,?,?,?)");
        
       if(project.getPublisher()!=null)
        pstMaster.setInt(1,project.getPublisher().getPubId());
       else
    	   pstMaster.setObject(1,null);
          
        pstMaster.setString(2,project.getGenre());
        pstMaster.setString(3,project.getCategory());
      
        if(project.getSubject()!=null)
                    pstMaster.setInt(4,project.getSubject().getSubId());
        else
     	   pstMaster.setObject(4,null);
         
        Integer dataId=null;
        if(project.getData()!=null){
        	 dataId=addData(project.getData(), con);
        }
             
        pstMaster.setObject(5,dataId);
       
        
        pstMaster.setString(6,project.getMaterialType().toString());
        pstMaster.setString(7,project.getTitle());
        pstMaster.setString(8, project.getLanguage());
        pstMaster.setInt(9, project.getPubYear());
        pstMaster.setString(10,project.getEdition());
        pstMaster.setString(11,project.getVolume());
        pstMaster.setString(12,project.getLink());
        pstMaster.setString(13,project.getAuthors());
        //pstMaster.setString(14,project.getDescription());
        r = pstMaster.executeUpdate();
        ResultSet rsKeys=pstMaster.getGeneratedKeys();
        rsKeys.next();
        int id=rsKeys.getInt(1);
        rsKeys.close();
        project.setId(id);
        pstProject.setInt(1,project.getId());
        pstProject.setString(2,project.getTopic());
        pstProject.setString(3,project.getProjectType());
        pstProject.setString(4,project.getTop());
       r=pstProject.executeUpdate();
        pstMaster.close();
        pstProject.close();
    } catch (Exception e1) {
        e1.printStackTrace();
    }
    DBUtil.closeConnection(con);	
	return r;

	}


}
