package com.hampcode.service;

import java.util.List;

import com.hampcode.model.entity.Category;

public interface CategoryService extends CrudService<Category, Long>{
	public List<Category> fetchCategoryByName (String name) throws Exception;
}
