package com.mgielib.entity;

public class Publisher {
	
	private int pubId;
	private String pubName;
	private String url;
	private String description;
public Publisher()
{}

public Publisher(int pubId, String pubName, String url, String description) {
	super();
	this.pubId = pubId;
	this.pubName = pubName;
	this.url = url;
	this.description = description;
}

public int getPubId() {
		return pubId;
	}
public void setPubId(int pubId) {
		this.pubId = pubId;
	}
public String getPubName() {
		return pubName;
	}
public void setPubName(String pubName) {
		this.pubName = pubName;
	}
public String getUrl() {
		return url;
	}
public void setUrl(String url) {
		this.url = url;
	}
public String getDescription() {
		return description;
	}
public void setDescription(String description) {
		this.description = description;
	}


}
