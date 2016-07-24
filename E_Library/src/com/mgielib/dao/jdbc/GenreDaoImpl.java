package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mgielib.dao.GenreDao;
import com.mgielib.entity.Author;
import com.mgielib.entity.Genre;
import com.mgielib.util.DBUtil;

public class GenreDaoImpl implements GenreDao {
	
	
	public int addGenre(Genre gen)
	{
		Connection con = null;
        int r=0;
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into genre(genreName) values(?)");
            pst.setString(1,gen.getGenreName());
            r = pst.executeUpdate();
            pst.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		return r;
	}
	
	public ArrayList<Genre> viewGenre()
	{
		ArrayList<Genre> al = null;
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from genre");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                al = new ArrayList<Genre>();
                do {
                    Genre gen = new Genre(rs.getString("genreName"));
                    al.add(gen);
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
