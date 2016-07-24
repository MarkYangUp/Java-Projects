package com.medibidz.entity;

public class Wish {
	
private int wishId;	
private User userId;
private String wish;
private int activeStatus;
public int getWishId() {
	return wishId;
}
public void setWishId(int wishId) {
	this.wishId = wishId;
}
public User getUserId() {
	return userId;
}
public void setUserId(User userId) {
	this.userId = userId;
}
public String getWish() {
	return wish;
}
public void setWish(String wish) {
	this.wish = wish;
}
public int getActiveStatus() {
	return activeStatus;
}
public void setActiveStatus(int activeStatus) {
	this.activeStatus = activeStatus;
}
public Wish(int wishId, User userId, String wish, int activeStatus) {
	super();
	this.wishId = wishId;
	this.userId = userId;
	this.wish = wish;
	this.activeStatus = activeStatus;
}

}
