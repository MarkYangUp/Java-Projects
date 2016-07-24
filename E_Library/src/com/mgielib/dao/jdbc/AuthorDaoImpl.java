package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mgielib.dao.AuthorDao;
import com.mgielib.entity.Author;
import com.mgielib.util.DBUtil;

public class AuthorDaoImpl implements AuthorDao{

	public int addAuthor(Author aut)
	{
		Connection con = null;
        int r=0;
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into author(authorId,firstName,lastName,description) values(?,?,?,?)");
            pst.setInt(1, aut.getAuthorId());
            pst.setString(2,aut.getFirstName());
            pst.setString(3,aut.getLastName());
            pst.setString(4,aut.getDescription());
            r = pst.executeUpdate();
            pst.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		return r;
	}
	
	public ArrayList<Author> viewAuthor()
	{
		ArrayList<Author> al = null;
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from author");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                al = new ArrayList<Author>();
                do {
                    Author aut = new Author(rs.getInt("authorId"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("description"));
                    al.add(aut);
                } while (rs.next());
                
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
