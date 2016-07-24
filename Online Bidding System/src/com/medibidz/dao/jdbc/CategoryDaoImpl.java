package com.medibidz.dao.jdbc;

import java.util.Set;
import java.util.TreeSet;

import com.medibidz.dao.CategoryDao;

public class CategoryDaoImpl implements CategoryDao
{
	public Set<String> getCategories()
	{
		Set<String> catSet=new TreeSet<String>();
		catSet.add("");
		
		
		
		
		return catSet;
		
	}
	
}
