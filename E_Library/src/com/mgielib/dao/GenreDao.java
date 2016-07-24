package com.mgielib.dao;

import java.util.List;

import com.mgielib.entity.Genre;

public interface GenreDao {
	

		public int addGenre(Genre gen);
		public List<Genre> viewGenre();	
	
}
