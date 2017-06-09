package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Category;

public interface CategoryDAO {

	public boolean save(Category category);

	public boolean update(Category category);

	public Category get(String id);

	public void delete(String id);

	public void editCategory(Category category);

	public List<Category> search(String keyWord);

	public List<Category> list();

}
