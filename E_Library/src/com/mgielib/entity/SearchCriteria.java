package com.mgielib.entity;

public class SearchCriteria {


	private String quickSearch;
	
	
	private int publisherId;
	private int subjectId;
	private int storageId;


	private String genre;
	private String category;

	private String authors;
	private String language;
	private int pubYear;
	private String title;
	
	private String edition;
	private String volume;
	
	private String eMaterialType;
	
	private String isbnTen;
	private String isbnThirteen;
	
	private String department;
	private String semester;

	private String topic;
	private String projectType;
	private String top;
	
	private String publishType;
	private int year;
	private int month;
	private String frequency;

	
	
	

	public String getQuickSearch() {
		return quickSearch;
	}
	public void setQuickSearch(String quickSearch) {
		this.quickSearch = quickSearch;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getStorageId() {
		return storageId;
	}
	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public String geteMaterialType() {
		return eMaterialType;
	}
	public void seteMaterialType(String eMaterialType) {
		this.eMaterialType = eMaterialType;
	}
	
	
	
	public int getStorage() {
		return storageId;
	}
	public void setStorage(int storageId) {
		this.storageId = storageId;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getPublishType() {
		return publishType;
	}
	public void setPublishType(String publishType) {
		this.publishType = publishType;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	@Override
	public String toString() {
		return "SearchCriteria [publisherId=" + publisherId + ", subjectId="
				+ subjectId + ", storageId=" + storageId + ", genre=" + genre
				+ ", category=" + category + ", authors=" + authors
				+ ", language=" + language + ", pubYear=" + pubYear
				+ ", title=" + title + ", edition=" + edition + ", volume="
				+ volume + ", eMaterialType=" + eMaterialType + ", isbnTen="
				+ isbnTen + ", isbnThirteen=" + isbnThirteen + ", department="
				+ department + ", semester=" + semester + ", topic=" + topic
				+ ", projectType=" + projectType + ", top=" + top
				+ ", publishType=" + publishType + ", year=" + year
				+ ", month=" + month + ", frequency=" + frequency + "]";
	}
	
	
	

}
