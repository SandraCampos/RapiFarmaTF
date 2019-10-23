package com.hampcode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hampcode.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
	public List<Product> fetchProductByName (String name);
}
