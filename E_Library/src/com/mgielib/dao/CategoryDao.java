package com.mgielib.dao;

import java.util.List;

import com.mgielib.entity.Category;

public interface CategoryDao {

public int addCategory(Category cat);
public List<Category> viewCategory();

}
