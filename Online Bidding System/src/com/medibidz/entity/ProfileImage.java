package com.medibidz.entity;

import java.io.InputStream;

public class ProfileImage {
	private Integer picId;
	private String contentType;
	private long imageSize;
	private InputStream imageData;

	public ProfileImage()
	{}

	public ProfileImage(Integer picId, String contentType, long imageSize,
			InputStream imageData) {
		super();
		this.picId = picId;
		this.contentType = contentType;
		this.imageSize = imageSize;
		this.imageData = imageData;
	}

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
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
	
	
	
}
