package com.mgielib.entity;

import com.mgielib.entity.EMaterialsBaseEntity;

public class EBook extends EMaterialsBaseEntity{

private String isbnTen;
private String isbnThirteen;
public EBook(String isbnTen, String isbnThirteen) {
	super();
	this.isbnTen = isbnTen;
	this.isbnThirteen = isbnThirteen;
}

public EBook(){}

public String getIsbnTen() {
	return isbnTen;
}

public void setIsbnTen(String isbnTen) {
	this.isbnTen = isbnTen;
}

public String getIsbnThirteen() {
	return isbnThirteen;
}

public void setIsbnThirteen(String isbnThirteen) {
	this.isbnThirteen = isbnThirteen;
}


}
