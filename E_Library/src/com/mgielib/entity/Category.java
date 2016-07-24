package com.mgielib.entity;

public class Category {

private String catName;
public Category(){}

public Category(String catName) {
	super();
	this.catName = catName;
}

public String getCatName() {
	return catName;
}
public void setCatName(String catName) {
	this.catName = catName;
}

}
