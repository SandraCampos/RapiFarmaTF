package com.hampcode.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "unit", nullable = false, length = 20)
	private String unit;
	
	@Column(name = "location", nullable = false, length = 50)
	private String location;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "stock", nullable = false)
	private int stock;
	
	@Column(name = "min_stock", nullable = false)
	private int min_stock;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "products_categories",
			joinColumns = {@JoinColumn(name = "product_id")},
			inverseJoinColumns = {@JoinColumn(name = "category_id")})
	private List<Category> categories = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMin_stock() {
		return min_stock;
	}

	public void setMin_stock(int min_stock) {
		this.min_stock = min_stock;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}	
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
}
