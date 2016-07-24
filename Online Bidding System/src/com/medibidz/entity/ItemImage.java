package com.medibidz.entity;

import java.io.InputStream;

public class ItemImage 
{
private Integer imageId;
private String contentType;
private long imageSize;
private InputStream imageData;


public Integer getImageId() {
	return imageId;
}

public ItemImage()
{}



public ItemImage(Integer imageId) {
	super();
	this.imageId = imageId;
}

public ItemImage(Integer imageId, String contentType, long imageSize,
		InputStream imageData) {
	super();
	this.imageId = imageId;
	this.contentType = contentType;
	this.imageSize = imageSize;
	this.imageData = imageData;
}

public String getContentType() {
	return contentType;
}

public void setContentType(String contentType) {
	this.contentType = contentType;
}

public long getImageSize() {
	return imageSize;
}

public void setImageSize(long imageSize) {
	this.imageSize = imageSize;
}

public InputStream getImageData() {
	return imageData;
}

public void setImageData(InputStream imageData) {
	this.imageData = imageData;
}

public void setImageId(Integer imageId) {
	this.imageId = imageId;
}





}
