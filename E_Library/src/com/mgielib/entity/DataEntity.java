package com.mgielib.entity;

import java.io.InputStream;

public class DataEntity {
	
	int id;
	String fileName;
	String fileContentType;
	String fileOriginalName;
	long fileSize;
	InputStream fileContents;
	
	
	
	public DataEntity() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getFileContentType() {
		return fileContentType;
	}



	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}



	public String getFileOriginalName() {
		return fileOriginalName;
	}



	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}



	public long getFileSize() {
		return fileSize;
	}



	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}



	public InputStream getFileContents() {
		return fileContents;
	}



	public void setFileContents(InputStream fileContents) {
		this.fileContents = fileContents;
	}
		

}
