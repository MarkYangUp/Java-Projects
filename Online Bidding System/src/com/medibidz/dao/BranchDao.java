package com.medibidz.dao;

import java.util.List;

import com.medibidz.entity.Branch;

public interface BranchDao 

{
	public void addBranch(Branch br);

public List<Branch> getBranchList();

}
