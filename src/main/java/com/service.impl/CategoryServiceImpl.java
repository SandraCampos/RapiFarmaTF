package com.hampcode.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.entity.Category;
import com.hampcode.model.repository.CategoryRepository;
import com.hampcode.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() throws Exception {
		return this.categoryRepository.findAll();
	}
	
	@Override
	public List<Category> fetchCategoryByName(String name) throws Exception {
		return this.categoryRepository.fetchCategoryByName(name);
	}
	
	@Override
	public Category getOneById(Long id) throws Exception {
		return this.categoryRepository.findById(id).orElseThrow(
				()->new RuntimeException("Category Not Found!"));
	}

	@Transactional
	@Override
	public Long create(Category entity) throws Exception {
		this.categoryRepository.save(entity);
		return entity.getId();
	}

	@Transactional
	@Override
	public void update(Long id, Category entity) throws Exception {
		Category currentCategory = this.getOneById(id);
		currentCategory.setName(entity.getName());
		this.categoryRepository.save(currentCategory);
	}

	@Transactional
	@Override
	public void delete(Long id) throws Exception {
		this.categoryRepository.deleteById(id);
	}

}
