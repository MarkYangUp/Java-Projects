package com.medibidz.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.medibidz.dao.BranchDao;
import com.medibidz.entity.Branch;
import com.medibidz.util.DBUtil;
public class BranchDaoImpl implements  BranchDao
{
	
public void addBranch(Branch br)
	{
	Connection con=null;
	try
		{
        con = DBUtil.getConnection();
        PreparedStatement pst = con.prepareStatement("insert into branch_master(branch_name) values(?)");
        pst.setString(1,br.getBranchName());
    	} 
	catch (Exception e1)
		{
        e1.printStackTrace();
		}

    DBUtil.closeConnection(con);
	}


public List<Branch> getBranchList()
{
	ArrayList<Branch> al=null;
	Connection con=null;
	try
	{
    con = DBUtil.getConnection();
    PreparedStatement pst = con.prepareStatement("select * from branch_master");
    ResultSet rs=pst.executeQuery();
    if(rs.next())	
    {
    	al=new ArrayList<Branch>();
    	do
    	{
    		Branch br=new Branch(rs.getInt(1),rs.getString(2));		
    		al.add(br);
    	}while(rs.next());
    	
    	
    }
    rs.close();
    pst.close();
    
} 
catch (Exception e1)
	{
    e1.printStackTrace();
	}

	  DBUtil.closeConnection(con);
      return al;
		
}


}
