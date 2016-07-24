package com.medibidz.entity;

import java.util.Date;



public class Item
{
private int itemId;
private String categoryName;
private String itemName;
private String description;
private Date lastDate;
private Double startBidPrice;
private Date insertionDate;
private ItemImage image1;
private ItemImage image2;
private ItemImage image3;
private User seller;
private int activeStatus;
private int bidStatus;

private double maxBidPrice;
private int totalBidCount;


public int getBidStatus() {
	return bidStatus;
}
public void setBidStatus(int bidStatus) {
	this.bidStatus = bidStatus;
}


public Item(int itemId, String categoryName, String itemName,
		String description, ItemImage image1, ItemImage image2,
		ItemImage image3, User seller) {
	super();
	this.itemId = itemId;
	this.categoryName = categoryName;
	this.itemName = itemName;
	this.description = description;
	this.image1 = image1;
	this.image2 = image2;
	this.image3 = image3;
	this.seller = seller;
}
public Item(int itemId, String categoryName, String itemName,
		String description, Date lastDate, Double startBidPrice,
		Date insertionDate, ItemImage image1, ItemImage image2, ItemImage image3) {
	super();
	this.itemId = itemId;
	this.categoryName = categoryName;
	this.itemName = itemName;
	this.description = description;
	this.lastDate = lastDate;
	this.startBidPrice = startBidPrice;
	this.insertionDate = insertionDate;
	this.image1 = image1;
	this.image2 = image2;
	this.image3 = image3;
}
public Item()
{
	}
public Item(int itemId) {
	super();
	this.itemId = itemId;
}




public Item(int itemId, String categoryName, String itemName,
		String description, Date lastDate, Double startBidPrice,
		Date insertionDate, ItemImage image1, ItemImage image2,
		ItemImage image3, User seller, int activeStatus, int bidStatus,
		double maxBidPrice, int totalBidCount) {
	super();
	this.itemId = itemId;
	this.categoryName = categoryName;
	this.itemName = itemName;
	this.description = description;
	this.lastDate = lastDate;
	this.startBidPrice = startBidPrice;
	this.insertionDate = insertionDate;
	this.image1 = image1;
	this.image2 = image2;
	this.image3 = image3;
	this.seller = seller;
	this.activeStatus = activeStatus;
	this.bidStatus = bidStatus;
	this.maxBidPrice = maxBidPrice;
	this.totalBidCount = totalBidCount;
}
public Item(int itemId, String itemName, String description, Date lastDate,
		Double startBidPrice, ItemImage image1, User seller) {
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.description = description;
	this.lastDate = lastDate;
	this.startBidPrice = startBidPrice;
	this.image1 = image1;
	this.seller = seller;
}
public Item(int itemId, String categoryName, String itemName,
		String description, Date lastDate, Double startBidPrice,
		Date insertionDate, ItemImage image1, ItemImage image2,
		ItemImage image3, User seller, int activeStatus) {
	super();
	this.itemId = itemId;
	this.categoryName = categoryName;
	this.itemName = itemName;
	this.description = description;
	this.lastDate = lastDate;
	this.startBidPrice = startBidPrice;
	this.insertionDate = insertionDate;
	this.image1 = image1;
	this.image2 = image2;
	this.image3 = image3;
	this.seller = seller;
	this.activeStatus = activeStatus;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getLastDate() {
	return lastDate;
}
public void setLastDate(Date lastDate) {
	this.lastDate = lastDate;
}
public Double getStartBidPrice() {
	return startBidPrice;
}
public void setStartBidPrice(Double startBidPrice) {
	this.startBidPrice = startBidPrice;
}
public Date getInsertionDate() {
	return insertionDate;
}
public void setInsertionDate(Date insertionDate) {
	this.insertionDate = insertionDate;
}
public ItemImage getImage1() {
	return image1;
}
public void setImage1(ItemImage image1) {
	this.image1 = image1;
}
public ItemImage getImage2() {
	return image2;
}
public void setImage2(ItemImage image2) {
	this.image2 = image2;
}
public ItemImage getImage3() {
	return image3;
}
public void setImage3(ItemImage image3) {
	this.image3 = image3;
}
public User getSeller() {
	return seller;
}
public void setSeller(User seller) {
	this.seller = seller;
}
public int getActiveStatus() {
	return activeStatus;
}
public void setActiveStatus(int activeStatus) {
	this.activeStatus = activeStatus;
}




public double getMaxBidPrice() {
	return maxBidPrice;
}
public void setMaxBidPrice(double maxBidPrice) {
	this.maxBidPrice = maxBidPrice;
}
public int getTotalBidCount() {
	return totalBidCount;
}
public void setTotalBidCount(int totalBidCount) {
	this.totalBidCount = totalBidCount;
}
@Override
public String toString()
{
	return "Item [itemId=" + itemId + ", categoryName=" + categoryName
			+ ", itemName=" + itemName + ", description=" + description
			+ ", lastDate=" + lastDate + ", startBidPrice=" + startBidPrice
			+ ", insertionDate=" + insertionDate + ", image1=" + image1
			+ ", image2=" + image2 + ", image3=" + image3 + ", seller="
			+ seller + ", activeStatus=" + activeStatus + "]";
}





}
