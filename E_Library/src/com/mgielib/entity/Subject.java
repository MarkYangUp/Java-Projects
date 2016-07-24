package com.mgielib.entity;

public class Subject {

private int subId;
private String subName;
private String category;
public Subject()
{}


public Subject(int subId, String subName, String category) {
	super();
	this.subId = subId;
	this.subName = subName;
	this.category = category;
}


public int getSubId() {
	return subId;
}
public void setSubId(int subId) {
	this.subId = subId;
}
public String getSubName() {
	return subName;
}
public void setSubName(String subName) {
	this.subName = subName;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
	
	
	
}
