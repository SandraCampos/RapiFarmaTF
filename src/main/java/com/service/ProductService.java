package com.hampcode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.model.entity.Product;

public interface ProductService extends CrudService<Product, Long>{
	public Page<Product> findAll(Pageable pageable) throws Exception;
	public Page<Product> fetchByName (String name, Pageable pageable) throws Exception;
}
