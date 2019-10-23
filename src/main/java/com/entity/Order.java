package com.hampcode.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order", nullable = false, length = 20)
	private String order;
	
	@Column(name = "date_emission", nullable = false)
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	private Date dateEmission;
	
	@Column(name = "date_reception", nullable = false)
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	private Date dateReception;
	
	@Column(name = "state", nullable = false, length = 1)
	private String state;
	
	@OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetails;
	
	@PrePersist
	public void init() {
		this.dateReception = new Date();
		this.state = "R";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOrder() {
		return order;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	public Date getDateReception() {
		return dateReception;
	}

	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
