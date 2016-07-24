package com.medibidz.entity;

public class Student extends User 
{
private String enrollment;
private Branch branch;
private String semester;
public Student()
{}



public Student(String password, String email, String contactNo,
		ItemImage picId, UserType userType, String semester) {
	super(password, email, contactNo, picId, userType);
	this.semester = semester;
}



public Student(Integer id, String password, UserType userType,
		String firstName, String lastName, String email, String contactNo,
		int activeStatus, String title, ItemImage picId, String enrollment,
		Branch branch, String semester) {
	super(id, password, userType, firstName, lastName, email, contactNo,
			activeStatus, title, picId);
	this.enrollment = enrollment;
	this.branch = branch;
	this.semester = semester;
}
public Student(String enrollment, Branch branch, String semester) {
	super();
	this.enrollment = enrollment;
	this.branch = branch;
	this.semester = semester;
}
public String getEnrollment() {
	return enrollment;
}
public void setEnrollment(String enrollment) {
	this.enrollment = enrollment;
}
public Branch getBranch() {
	return branch;
}
public void setBranch(Branch branch) {
	this.branch = branch;
}
public String getSemester() {
	return semester;
}
public void setSemester(String semester) {
	this.semester = semester;
}


}
