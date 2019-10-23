package com.hampcode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.entity.Supplier;
import com.hampcode.model.repository.SupplierRepository;
import com.hampcode.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> getAll() throws Exception {
		return this.supplierRepository.findAll();
	}

	@Override
	public List<Supplier> fetchSupplierByName(String name) throws Exception {
		return this.supplierRepository.fetchSupplierByName(name);
	}
	
	@Override
	public Supplier getOneById(Long id) throws Exception {
		return this.supplierRepository.findById(id).orElseThrow(
				()->new RuntimeException("Supplier Not Found!"));
	}

	@Override
	public Long create(Supplier entity) throws Exception {
		this.supplierRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Supplier entity) throws Exception {
		Supplier currentSupplier = this.getOneById(id);
		currentSupplier.setAdress(entity.getAdress());
		currentSupplier.setContact(entity.getContact());
		currentSupplier.setEmail(entity.getEmail());
		currentSupplier.setName(entity.getName());
		currentSupplier.setPhone(entity.getPhone());
		currentSupplier.setRuc(entity.getRuc());
		this.supplierRepository.save(currentSupplier);
	}

	@Override
	public void delete(Long id) throws Exception {
		this.supplierRepository.deleteById(id);
	}

}
