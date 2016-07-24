package com.mgielib.dao.jdbc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.Part;

import com.mgielib.entity.DataEntity;

public class BaseDao {
	
protected int addData(DataEntity data,Connection con){
	int id=0;
	
	try{
	/*	PreparedStatement pst=con.prepareStatement("select max(id) from file_data");
		ResultSet rs=pst.executeQuery();
		int id=0;
		if(rs.next()){
			id=rs.getInt(1);				
		}
		rs.close();
		pst.close();
		id++;		*/	
		PreparedStatement pstSave=con.prepareStatement("INSERT INTO file_data(file_name,file_ct,file_original_name,file_size,file_contents) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		pstSave.setString(1,data.getFileName());
		pstSave.setString(2, data.getFileContentType());
		pstSave.setString(3, data.getFileOriginalName());
		pstSave.setLong(4, data.getFileSize());
		pstSave.setBlob(5, data.getFileContents());
		pstSave.executeUpdate();
		ResultSet rs=pstSave.getGeneratedKeys();
		if(rs.next()){
			id=rs.getInt(1);				
		}
		rs.close();
		pstSave.close();
	
	}catch(Exception e){
		e.printStackTrace();
		return 0;
	}	
	
return id;

}



}
