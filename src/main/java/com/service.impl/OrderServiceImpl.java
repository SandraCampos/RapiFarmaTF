package com.hampcode.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.entity.Order;
import com.hampcode.model.repository.OrderRepository;
import com.hampcode.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getAll() throws Exception {
		return this.orderRepository.findAll();
	}

	@Override
	public Order getOneById(Long id) throws Exception {
		return this.orderRepository.findById(id).orElseThrow(
				()->new RuntimeException("Order Not Found!"));
	}

	@Transactional
	@Override
	public Long create(Order entity) throws Exception {
		entity.getOrderDetails().forEach(item ->
				item.setOrder(entity));
		this.orderRepository.save(entity);
		return entity.getId();
	}

	@Transactional
	@Override
	public void update(Long id, Order entity) throws Exception {		
		Order currentOrder = this.getOneById(id);
		currentOrder.setDateReception(entity.getDateReception());
		currentOrder.setState(entity.getState());
		currentOrder.setOrderDetails(entity.getOrderDetails());
		this.orderRepository.save(currentOrder);
	}

	@Transactional
	@Override
	public void delete(Long id) throws Exception {
		this.orderRepository.deleteById(id);
	}
}
