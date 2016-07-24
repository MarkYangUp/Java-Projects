package com.medibidz.entity;

public class SearchCriteria 
{
private String searchText;

public String getSearchText() {
	return searchText;
}
public SearchCriteria()
{}
public void setSearchText(String searchText) {
	this.searchText = searchText;
}

public SearchCriteria(String searchText) {
	super();
	this.searchText = searchText;
}

}

