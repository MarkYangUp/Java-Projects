package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mgielib.dao.CategoryDao;
import com.mgielib.entity.Category;
import com.mgielib.util.DBUtil;


public class CategoryDaoImpl implements CategoryDao {

	public int addCategory(Category cat)
	{
		Connection con = null;
        int r=0;
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into category(catName) values(?)");
            pst.setString(1,cat.getCatName());
            r = pst.executeUpdate();
            pst.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		return r;
	}
	
	public ArrayList<Category> viewCategory()
	{
		ArrayList<Category> al = null;
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from category");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                al = new ArrayList<Category>();
                do {
                    Category cat = new Category(rs.getString("catName"));
                    al.add(cat);
                } while (rs.next());
                //System.out.println("data Found");
            }
            rs.close();
            pst.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);
        return al;
		
	}
	

}
