package com.hampcode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hampcode.model.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	@Query("SELECT s FROM Supplier s WHERE s.name LIKE %?1%")
	public List<Supplier> fetchSupplierByName(String name);
}
