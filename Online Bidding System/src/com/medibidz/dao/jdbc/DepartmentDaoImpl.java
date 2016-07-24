package com.medibidz.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.medibidz.dao.DepartmentDao;
import com.medibidz.entity.Department;
import com.medibidz.util.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao 
{
	public void addDepartment(Department dep)
	{
	Connection con=null;
	try
		{
        con = DBUtil.getConnection();
        PreparedStatement pst = con.prepareStatement("insert into dept_master(department_id,department_name) values(?,?)");
        pst.setInt(1,dep.getDepartmentId());
        pst.setString(2,dep.getDepartmentName());
    	} 
	catch (Exception e1)
		{
        e1.printStackTrace();
		}

    DBUtil.closeConnection(con);
	}
	
public List<Department> getDepartmentList()
{
	ArrayList<Department> al=null;
	Connection con=null;
	try
	{
    con = DBUtil.getConnection();
    PreparedStatement pst = con.prepareStatement("select * from dept_master");
    ResultSet rs=pst.executeQuery();
    if(rs.next())	
    {
    	al=new ArrayList<Department>();
    	do
    	{
    		Department dep=new Department(rs.getInt(1),rs.getString(2));
    		al.add(dep);
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
