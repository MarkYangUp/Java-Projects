package com.medibidz.entity;

import java.sql.Date;

public class Bid 
{
private int bidId;
private Date bidDate;
private double bidPrice;
private User buyer;
private Item item;
private Integer dealStatus;

public Bid(int bidId, Date bidDate, double bidPrice, User buyer, Item item) {
	super();
	this.bidId = bidId;
	this.bidDate = bidDate;
	this.bidPrice = bidPrice;
	this.buyer = buyer;
	this.item = item;
}




public Integer getDealStatus() {
	return dealStatus;
}




public void setDealStatus(Integer dealStatus) {
	this.dealStatus = dealStatus;
}




public int getBidId() {
	return bidId;
}
public void setBidId(int bidId) {
	this.bidId = bidId;
}
public Date getBidDate() {
	return bidDate;
}
public void setBidDate(Date bidDate) {
	this.bidDate = bidDate;
}
public double getBidPrice() {
	return bidPrice;
}
public void setBidPrice(double bidPrice) {
	this.bidPrice = bidPrice;
}
public User getBuyer() {
	return buyer;
}
public void setBuyer(User buyer) {
	this.buyer = buyer;
}
public Item getItem() {
	return item;
}
public void setItem(Item item) {
	this.item = item;
}




}
