package com.mgielib.entity;

public class Genre {

String genreName;

public Genre(){}

public Genre(String genreName) {
	super();
	
	this.genreName = genreName;
}


public String getGenreName() {
	return genreName;
}

public void setGenreName(String genreName) {
	this.genreName = genreName;
}



}
