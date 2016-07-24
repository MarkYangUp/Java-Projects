package com.mgielib.dao;

import java.util.List;

import com.mgielib.entity.Publisher;



public interface PublisherDao {
	public int addPublisher(Publisher pub);
	public List<Publisher> viewPublisher();	
}
