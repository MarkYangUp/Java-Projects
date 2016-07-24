package com.mgielib.dao;

import java.util.List;

import com.mgielib.entity.Subject;


public interface SubjectDao {

	public int addSubject(Subject sub);
	public List<Subject> viewSubject();	
}
