package com.mgielib.dao;

import java.util.List;

import com.mgielib.entity.Author;

public interface AuthorDao {

	public int addAuthor(Author aut);
	public List<Author> viewAuthor();	
}
