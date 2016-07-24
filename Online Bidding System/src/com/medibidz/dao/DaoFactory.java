package com.medibidz.dao;

import com.medibidz.dao.jdbc.BranchDaoImpl;
import com.medibidz.dao.jdbc.CategoryDaoImpl;
import com.medibidz.dao.jdbc.DepartmentDaoImpl;
import com.medibidz.dao.jdbc.ItemDaoImpl;
import com.medibidz.dao.jdbc.UserDaoImpl;

public class DaoFactory 
{
	public static UserDao getUserDao()
	{
	return new UserDaoImpl();
	}
	
public static ItemDao getItemDao()
	{
	return new ItemDaoImpl();
	}

public static BranchDao getBranchDao()
{
return new BranchDaoImpl();
}
public static CategoryDao getCategoryDao()
{
return new CategoryDaoImpl();
}
public static DepartmentDao getDepartmentDao()
{
return new DepartmentDaoImpl();
}

}
