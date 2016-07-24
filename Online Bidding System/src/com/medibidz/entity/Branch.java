package com.medibidz.entity;

public class Branch
{
private int branchId;
private String branchName;





public Branch()
{}
public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}
public String getBranchName() {
	return branchName;
}
public void setBranchName(String branchName) {
	this.branchName = branchName;
}
public Branch(int branchId, String branchName) {
	super();
	this.branchId = branchId;
	this.branchName = branchName;
}

}
