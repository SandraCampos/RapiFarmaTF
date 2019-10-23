package com.hampcode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.entity.Product;
import com.hampcode.model.repository.ProductRepository;
import com.hampcode.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override	
	public List<Product> getAll() throws Exception {
		return this.productRepository.findAll();
	}

	@Override
	public List<Product> fetchProductByName(String name) throws Exception {
		return this.productRepository.fetchProductByName(name);
	}
	
	@Override
	public Product getOneById(Long id) throws Exception {
		return this.productRepository.findById(id).orElseThrow(
				()->new RuntimeException("Product Not Found!"));
	}

	@Override
	public Long create(Product entity) throws Exception {
		this.productRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Product entity) throws Exception {
		Product currentProduct = this.getOneById(id);
		currentProduct.setName(entity.getName());
		currentProduct.setLocation(entity.getLocation());
		currentProduct.setMin_stock(entity.getMin_stock());
		currentProduct.setPrice(entity.getPrice());
		currentProduct.setStock(entity.getStock());
		currentProduct.setUnit(entity.getUnit());
		currentProduct.setSupplier(entity.getSupplier());
		currentProduct.setCategories(entity.getCategories());
		this.productRepository.save(currentProduct);
	}

	@Override
	public void delete(Long id) throws Exception {
		this.productRepository.deleteById(id);		
	}

}
