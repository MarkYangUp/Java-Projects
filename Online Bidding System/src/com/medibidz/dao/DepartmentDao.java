package com.medibidz.dao;

import java.util.List;

import com.medibidz.entity.Department;

public interface DepartmentDao 
{
public void addDepartment(Department dep);
	
public List<Department> getDepartmentList();
	
}
