package com.mgielib.entity;

import java.util.Date;

public class EMaterialsBaseEntity {

private Integer id;
	
private Publisher publisher;
private Subject subject;
private DataEntity data;
private int dataStorageId;

public int getDataStorageId() {
	return dataStorageId;
}
public void setDataStorageId(int dataStorageId) {
	this.dataStorageId = dataStorageId;
}

private String genre;
private String category;

private String authors;
private String language;
private int pubYear;
private String title;
private int pages;
private String edition;
private String volume;
private String desc;
private String link;
private String description;

private EMaterialTypes materialType;





private String createdUserId;
private String modifiedUserId;
private Date creationDate;
private Date lastModifiedDate;







public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Publisher getPublisher() {
	return publisher;
}
public void setPublisher(Publisher publisher) {
	this.publisher = publisher;
}
public Subject getSubject() {
	return subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
}

public DataEntity getData() {
	return data;
}
public void setData(DataEntity data) {
	this.data = data;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getAuthors() {
	return authors;
}
public void setAuthors(String authors) {
	this.authors = authors;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public int getPubYear() {
	return pubYear;
}
public void setPubYear(int pubYear) {
	this.pubYear = pubYear;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public String getEdition() {
	return edition;
}
public void setEdition(String edition) {
	this.edition = edition;
}
public String getVolume() {
	return volume;
}
public void setVolume(String volume) {
	this.volume = volume;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public EMaterialTypes getMaterialType() {
	return materialType;
}
public void setMaterialType(EMaterialTypes materialType) {
	this.materialType = materialType;
}
public String getCreatedUserId() {
	return createdUserId;
}
public void setCreatedUserId(String createdUserId) {
	this.createdUserId = createdUserId;
}
public String getModifiedUserId() {
	return modifiedUserId;
}
public void setModifiedUserId(String modifiedUserId) {
	this.modifiedUserId = modifiedUserId;
}
public Date getCreationDate() {
	return creationDate;
}
public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}
public Date getLastModifiedDate() {
	return lastModifiedDate;
}
public void setLastModifiedDate(Date lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
}
public EMaterialsBaseEntity(Integer id, Publisher publisher, Subject subject,
		DataStorage storage, String genre, String category, String authors,
		String language, int pubYear, String title, int pages, String edition,
		String volume, String desc, String link, EMaterialTypes materialType,
		String createdUserId, String modifiedUserId, Date creationDate,
		Date lastModifiedDate) {
	super();
	this.id = id;
	this.publisher = publisher;
	this.subject = subject;
	this.data = data;
	this.genre = genre;
	this.category = category;
	this.authors = authors;
	this.language = language;
	this.pubYear = pubYear;
	this.title = title;
	this.pages = pages;
	this.edition = edition;
	this.volume = volume;
	this.desc = desc;
	this.link = link;
	this.materialType = materialType;
	this.createdUserId = createdUserId;
	this.modifiedUserId = modifiedUserId;
	this.creationDate = creationDate;
	this.lastModifiedDate = lastModifiedDate;
}

public EMaterialsBaseEntity(){};


}
