package com.mgielib.entity;

public class User 
{
private String loginId;
private String password;
private String userType;
private String firstName;
private String lastName;
private int activeStatus;


public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
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
public int getActiveStatus() {
	return activeStatus;
}
public void setActiveStatus(int activeStatus) {
	this.activeStatus = activeStatus;
}


}
