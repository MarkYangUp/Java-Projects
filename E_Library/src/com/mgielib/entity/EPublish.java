package com.mgielib.entity;

public class EPublish extends EMaterialsBaseEntity{

private int id;
private String publishType;
private int year;
private int month;
private String frequency;
public EPublish(int id, String publishType, int year, int month,
		String frequency) {
	super();
	this.id = id;
	this.publishType = publishType;
	this.year = year;
	this.month = month;
	this.frequency = frequency;
}

public EPublish(){}

public Integer getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getPublishType() {
	return publishType;
}

public void setPublishType(String publishType) {
	this.publishType = publishType;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public String getFrequency() {
	return frequency;
}

public void setFrequency(String frequency) {
	this.frequency = frequency;
}




	
}
