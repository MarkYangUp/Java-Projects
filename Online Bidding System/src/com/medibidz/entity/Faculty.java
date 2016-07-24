package com.medibidz.entity;

public class Faculty extends User 
{
private String facultyId;
private Department department;
public Faculty()
{}






public Faculty(Integer id, String password, UserType userType,
		String firstName, String lastName, String email, String contactNo,
		int activeStatus, String title, ItemImage picId, String facultyId,
		Department department) {
	super(id, password, userType, firstName, lastName, email, contactNo,
			activeStatus, title, picId);
	this.facultyId = facultyId;
	this.department = department;
}





public Department getDepartment() {
	return department;
}






public void setDepartment(Department department) {
	this.department = department;
}






public String getFacultyId() {
	return facultyId;
}
public void setFacultyId(String facultyId) {
	this.facultyId = facultyId;
}
}
