package com.mgielib.dao.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.Part;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import com.mgielib.dao.EBookDao;
import com.mgielib.entity.EBook;
import com.mgielib.util.DBUtil;


public class EBookDaoImpl extends BaseDao implements EBookDao {

public int addEBook(EBook book)
	{
	int r=0;
	Connection con = null;
	
	try {
        con = DBUtil.getConnection();
        PreparedStatement pstMaster = con.prepareStatement("insert into ematerialsbasemaster(pub_id,genre_name,cat_name,sub_id,data_storage_id,material_type,title,language,pub_year,edition,volume,link,authors) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        PreparedStatement pstBook = con.prepareStatement("insert into ebook(id,isbn_10,isbn_13)values (?,?,?)");
        
       if(book.getPublisher()!=null)
        pstMaster.setInt(1,book.getPublisher().getPubId());
       else
    	   pstMaster.setObject(1,null);
          
        pstMaster.setString(2,book.getGenre());
        pstMaster.setString(3,book.getCategory());
      
        if(book.getSubject()!=null)
                    pstMaster.setInt(4,book.getSubject().getSubId());
        else
     	   pstMaster.setObject(4,null);
        Integer dataId=null;
        if(book.getData()!=null){
        	 dataId=addData(book.getData(), con);
        }
             
        pstMaster.setObject(5,dataId);
         
        pstMaster.setString(6,book.getMaterialType().toString());
        pstMaster.setString(7,book.getTitle());
        pstMaster.setString(8, book.getLanguage());
        pstMaster.setInt(9, book.getPubYear());
        pstMaster.setString(10,book.getEdition());
        pstMaster.setString(11,book.getVolume());
        pstMaster.setString(12,book.getLink());
        pstMaster.setString(13,book.getAuthors());
        System.out.println(book.getDescription());
        //pstMaster.setString(14,book.getDescription());
        
        r = pstMaster.executeUpdate();
        ResultSet rsKeys=pstMaster.getGeneratedKeys();
        rsKeys.next();
        int id=rsKeys.getInt(1);
        rsKeys.close();
        
        book.setId(id);
        pstBook.setInt(1,book.getId());
        pstBook.setString(2,book.getIsbnTen());
        pstBook.setString(3,book.getIsbnThirteen());
       r=pstBook.executeUpdate();
        pstMaster.close();
        pstBook.close();
    } catch (Exception e1) {
        e1.printStackTrace();
    }
    DBUtil.closeConnection(con);	
	return r;

	}





}
