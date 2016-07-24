package com.medibidz.dao;

import java.io.InputStream;
import java.util.List;

import com.medibidz.entity.Bid;
import com.medibidz.entity.Item;
import com.medibidz.entity.SearchCriteria;

public interface ItemDao 
{
public void addItem(Item item);

public List<Item> getItemBySeller(int sellerId);

public List<Item> getFreeItems();

public List<Item> getItemsByCategoryName(String catName);
//public List<Item> getItemByBuyer(int buyerId);

//public List<Deal> getDealsByBuyer(int buyerId);

//public List<Deal> getDealsBySeller(int sellerId);


public void addBid(int itemId,int buyerId,double price);

public List<Bid> getBidsForItem(int itemId);

public List<Bid> getActiveBidsForBuyer(int buyerId);


//public Item findItemByBid(int id);

public List<Item> getItemsByPrice(int min,int max);

public List<Item> getNewItems();
public List<Item> getAllItems();
public Item getNewItem(int itemId);

public List<Item> getRecentItemsForBid();
public List<Item> displayRecentItemsForBid();
public List<Item> getItemsbyBidClosing();

public List<Item> searchItem(SearchCriteria search);

public void validateItem(int itemId); 

public InputStream getImageData(int imageId);

public double getMaxBid(int itemId);

public int getCountBidder(int itemId);

public void delete(int itemId);

public Item getItem(Integer id);

public void updateDealStatus(int bidId);

public boolean getDealStatus(int bidId);

public void updateDealStatusSeller(int bidId);



public boolean getDealStatusSeller(int bidId);

}
