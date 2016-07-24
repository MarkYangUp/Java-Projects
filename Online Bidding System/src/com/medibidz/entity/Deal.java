package com.medibidz.entity;

import java.sql.Date;

public class Deal
{
private int dealId;
private int itemId;
private int bidId;
private int sellerId;
private int buyerId;
private Date dealDate;
private double dealPrice;
public Deal()
{}

public Deal(int dealId, int itemId, int bidId, int sellerId, int buyerId,
		Date dealDate, double dealPrice) {
	super();
	this.dealId = dealId;
	this.itemId = itemId;
	this.bidId = bidId;
	this.sellerId = sellerId;
	this.buyerId = buyerId;
	this.dealDate = dealDate;
	this.dealPrice = dealPrice;
}

public double getDealPrice() {
	return dealPrice;
}
public void setDealPrice(double dealPrice) {
	this.dealPrice = dealPrice;
}
public int getDealId() {
	return dealId;
}
public void setDealId(int dealId) {
	this.dealId = dealId;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public int getBidId() {
	return bidId;
}
public void setBidId(int bidId) {
	this.bidId = bidId;
}
public int getSellerId() {
	return sellerId;
}
public void setSellerId(int sellerId) {
	this.sellerId = sellerId;
}
public int getBuyerId() {
	return buyerId;
}
public void setBuyerId(int buyerId) {
	this.buyerId = buyerId;
}
public Date getDealDate() {
	return dealDate;
}
public void setDealDate(Date dealDate) {
	this.dealDate = dealDate;
}

}
