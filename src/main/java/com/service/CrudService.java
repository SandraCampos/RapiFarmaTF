package com.hampcode.service;

import java.util.List;

public interface CrudService<T, ID> {
	
	public List<T> getAll() throws Exception;
	
	public T getOneById(ID id) throws Exception;
	
	public Long create(T entity) throws Exception;
	
	public void update(ID id, T entity) throws Exception;
	
	public void delete(ID id) throws Exception;

}
