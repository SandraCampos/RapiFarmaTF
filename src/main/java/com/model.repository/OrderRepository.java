package com.hampcode.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
}
