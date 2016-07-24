package com.medibidz.entity;

import static com.medibidz.entity.UserType.*;

import java.sql.Date;

public class Registeration
{
private int registerationId;
private String firstName;

private String lastName;
private String emailId;
private String enrollment;
private String facultyId;
private String title;
private Branch branch;
private String semester;
private Department department;
private UserType userType;

private Date registerationDate;
private  String password;
private String contactNumber;
private ItemImage picId;
public Registeration()
{}

public Registeration(int registerationId, String firstName, String lastName,
		String emailId, String enrollment, String facultyId, String title,
		Branch branch, String semester, Department department,
		UserType userType,Date registerationDate, String password,
		String contactNumber) {
	super();
	this.registerationId = registerationId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.enrollment = enrollment;
	this.facultyId = facultyId;
	this.title = title;
	this.branch = branch;
	this.semester = semester;
	this.department = department;
	this.userType = userType;
	this.registerationDate = registerationDate;
	this.password = password;
	this.contactNumber = contactNumber;
}

public Registeration(int registerationId, String firstName, String lastName,
		String emailId, String enrollment, String facultyId, String title,
		Branch branch, String semester, Department department,
		UserType userType, Date registerationDate, String password,
		String contactNumber,ItemImage picId) {
	super();
	this.registerationId = registerationId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.enrollment = enrollment;
	this.facultyId = facultyId;
	this.title = title;
	this.branch = branch;
	this.semester = semester;
	this.department = department;
	this.userType = userType;
	this.registerationDate = registerationDate;
	this.password = password;
	this.contactNumber = contactNumber;
	this.picId = picId;
}

public ItemImage getPicId() {
	return picId;
}

public void setPicId(ItemImage picId) {
	this.picId = picId;
}

public Date getRegisterationDate() {
	return registerationDate;
}


public void setRegisterationDate(Date registerationDate) {
	this.registerationDate = registerationDate;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getContactNumber() {
	return contactNumber;
}


public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}


public int getRegisterationId() {
	return registerationId;
}
public void setRegisterationId(int registerationId) {
	this.registerationId = registerationId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getEnrollment() {
	return enrollment;
}
public void setEnrollment(String enrollment) {
	this.enrollment = enrollment;
}
public String getFacultyId() {
	return facultyId;
}
public void setFacultyId(String facultyId) {
	this.facultyId = facultyId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getSemester() {
	return semester;
}
public void setSemester(String semester) {
	this.semester = semester;
}

public UserType getUserType() {
	return userType;
}

public void setUserType(UserType userType) {
	this.userType = userType;
}

public Branch getBranch() {
	return branch;
}

public void setBranch(Branch branch) {
	this.branch = branch;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}


public boolean isAdmin(){
	return ADMIN.equals(userType);
}
public boolean isStudent(){
	return STUDENT.equals(userType);
}
public boolean isFaculty(){
	return FACULTY.equals(userType);
}

}
