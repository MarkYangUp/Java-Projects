package com.mgielib.entity;

public class DataStorage {
private int id;
private byte[] binaryData;
private String dataMimeType;
private long dataSize;
private String localPath;


public byte[] getBinaryData() {
	return binaryData;
}
public void setBinaryData(byte[] binaryData) {
	this.binaryData = binaryData;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDataMimeType() {
	return dataMimeType;
}
public void setDataMimeType(String dataMimeType) {
	this.dataMimeType = dataMimeType;
}
public long getDataSize() {
	return dataSize;
}
public void setDataSize(long dataSize) {
	this.dataSize = dataSize;
}
public String getLocalPath() {
	return localPath;
}
public void setLocalPath(String localPath) {
	this.localPath = localPath;
}

	
}
