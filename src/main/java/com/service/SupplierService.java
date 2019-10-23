package com.hampcode.service;

import java.util.List;

import com.hampcode.model.entity.Supplier;

public interface SupplierService extends CrudService<Supplier, Long>{
	public List<Supplier> fetchSupplierByName(String name) throws Exception;
}
