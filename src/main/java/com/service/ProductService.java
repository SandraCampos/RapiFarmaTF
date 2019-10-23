package com.hampcode.service;

import java.util.List;

import com.hampcode.model.entity.Product;

public interface ProductService extends CrudService<Product, Long>{
	public List<Product> fetchProductByName (String name) throws Exception;
}
