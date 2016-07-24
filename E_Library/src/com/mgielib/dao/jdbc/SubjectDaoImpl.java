package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mgielib.dao.SubjectDao;
import com.mgielib.entity.Subject;
import com.mgielib.util.DBUtil;

public class SubjectDaoImpl implements SubjectDao {

	public int addSubject(Subject sub)
	{
		Connection con = null;
        int r=0;
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into subject(subId,subName,category) values(?,?,?)");
            pst.setInt(1, sub.getSubId());
            pst.setString(2,sub.getSubName());
            pst.setString(3,sub.getCategory());
           r = pst.executeUpdate();
            pst.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		return r;
	}
	
	public ArrayList<Subject> viewSubject()
	{
		ArrayList<Subject> al = null;
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from subject");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                al = new ArrayList<Subject>();
                do {
                    Subject sub = new Subject(rs.getInt("subId"),rs.getString("subName"),rs.getString("category"));
                    al.add(sub);
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
