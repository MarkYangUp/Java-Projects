package com.medibidz.dao.jdbc;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.medibidz.entity.ItemImage;
import com.medibidz.entity.ProfileImage;

public class BaseDao {
	
	
 int addImage(ItemImage image,Connection con){
	 int id=0;

		try{
		
			PreparedStatement pstSave=con.prepareStatement("INSERT INTO item_images(content_type,image_size,image_data) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pstSave.setString(1,image.getContentType());
			pstSave.setLong(2,image.getImageSize());
			pstSave.setBlob(3, image.getImageData());
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
 
InputStream getImageAsStream(int imageId,Connection con){
	InputStream is=null;
	try{
		PreparedStatement pst=con.prepareStatement("select image_data from item_images where image_id=?");
		pst.setInt(1, imageId);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			//String fileType=rs.getString(1);
			Blob blob=rs.getBlob(1);
			is=blob.getBinaryStream();
		}
		rs.close();
		pst.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return is;
 }

}
