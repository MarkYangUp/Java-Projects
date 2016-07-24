package com.medibidz.entity;

import static com.medibidz.entity.UserType.ADMIN;
import static com.medibidz.entity.UserType.FACULTY;
import static com.medibidz.entity.UserType.STUDENT;

public class User
{
private Integer id;
private String password;

private String firstName;
private String lastName;
private String email;
private String contactNo;

private int activeStatus;
private String title;
private ItemImage picId;
private UserType userType;


public User(String password, String email, String contactNo, ItemImage picId,
		UserType userType) {
	super();
	this.password = password;
	this.email = email;
	this.contactNo = contactNo;
	this.picId = picId;
	this.userType = userType;
}

public User(Integer id, String password, UserType userType, String firstName,
		String lastName, String email, String contactNo, int activeStatus,
		String title, ItemImage picId) {
	super();
	this.id = id;
	this.password = password;
	this.userType = userType;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.contactNo = contactNo;
	this.activeStatus = activeStatus;
	this.title = title;
	this.picId = picId;
}

public ItemImage getPicId() {
	return picId;
}

public void setPicId(ItemImage picId) {
	this.picId = picId;
}

public User()
{}
public User(Integer id){
	super();
	this.id=id;
	
}


public User(Integer id, String firstName, String lastName) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
}
public User(Integer id, String password, UserType userType, String firstName,
		String lastName, String email, String contactNo, int activeStatus,String title) {
	super();
	this.id=id;
	this.password = password;
	this.userType = userType;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.contactNo = contactNo;
	this.activeStatus = activeStatus;
	this.title = title;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}




public UserType getUserType() {
	return userType;
}
public void setUserType(UserType userType) {
	this.userType = userType;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public int getActiveStatus() {
	return activeStatus;
}
public void setActiveStatus(int activeStatus) {
	this.activeStatus = activeStatus;
}
@Override
public String toString() {
	return "User [id=" + id + ", password=" + password + ", firstName="
			+ firstName + ", lastName=" + lastName + ", email=" + email
			+ ", contactNo=" + contactNo + ", activeStatus=" + activeStatus
			+ ", title=" + title + ", picId=" + picId + ", userType="
			+ userType + "]";
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
