package com.mgielib.dao;

import com.mgielib.dao.jdbc.AuthorDaoImpl;

import com.mgielib.dao.jdbc.CategoryDaoImpl;
import com.mgielib.dao.jdbc.EBookDaoImpl;
import com.mgielib.dao.jdbc.EProjectDaoImpl;
import com.mgielib.dao.jdbc.EPublishDaoImpl;
import com.mgielib.dao.jdbc.GenreDaoImpl;
import com.mgielib.dao.jdbc.PublisherDaoImpl;
import com.mgielib.dao.jdbc.SearchCriteriaDaoImpl;
import com.mgielib.dao.jdbc.SubjectDaoImpl;
import com.mgielib.dao.jdbc.EFacultyResourceDaoImpl;

public class DaoFactory {

	public static CategoryDao getCategoryDao(){
	return new CategoryDaoImpl();
							}
public static AuthorDao getAuthorDao(){
		return new AuthorDaoImpl();

					}

public static SubjectDao getSubjectDao(){
		return new SubjectDaoImpl();
}

public static GenreDao getGenreDao(){
	return new GenreDaoImpl();
}
public static SearchCriteriaDao getSearchCriteriaDao(){
		return new SearchCriteriaDaoImpl();	
}

public static PublisherDao getPublisherDao(){
	return new PublisherDaoImpl();
}
public static EBookDao getEBookDao(){
	return new EBookDaoImpl();
}

public static EProjectDao getEProjectDao(){
	return new EProjectDaoImpl();
}

public static EFacultyResourceDao getEFacultyResouceDao(){
	return new EFacultyResourceDaoImpl();
}

public static EPublishDao getEPublishDao(){
	return new EPublishDaoImpl();
}


}
