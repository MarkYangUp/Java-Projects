package com.mgielib.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mgielib.dao.PublisherDao;

import com.mgielib.entity.Publisher;
import com.mgielib.util.DBUtil;

public class PublisherDaoImpl implements PublisherDao{
	public int addPublisher(Publisher pub)
	{
		Connection con = null;
        int r=0;
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into publisher(pubId,pubName,url,description) values(?,?,?,?)");
            pst.setInt(1,pub.getPubId());
            pst.setString(2,pub.getPubName());
            pst.setString(3,pub.getUrl());
            pst.setString(4,pub.getDescription());
            r = pst.executeUpdate();
            pst.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		return r;
	}
	
	public ArrayList<Publisher> viewPublisher()
	{
		ArrayList<Publisher> al = null;
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from publisher");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                al = new ArrayList<Publisher>();
                do {
                    Publisher pub = new Publisher(rs.getInt("pubId"), rs.getString("pubName"),rs.getString("url"),rs.getString("description"));
                    al.add(pub);
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
		
}}
