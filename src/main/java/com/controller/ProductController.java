package com.hampcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hampcode.model.entity.Product;
import com.hampcode.service.CategoryService;
import com.hampcode.service.ProductService;
import com.hampcode.service.SupplierService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String showAllProducts(Model model) {
		try {
			model.addAttribute("products", this.productService.getAll());
			model.addAttribute("suppliers", this.supplierService.getAll());
			model.addAttribute("categories", this.categoryService.getAll());
		}catch (Exception e) {
			
		}
		
		return "products/list";
	}
	
	@GetMapping("/search")
	public String showProductsByName(@RequestParam("name") String name, Model model) {
		try {
			if(!name.isEmpty()) {
				if(!this.productService.fetchProductByName(name).isEmpty()) {
					model.addAttribute("products", this.productService.fetchProductByName(name));
				}else {					
					model.addAttribute("products", this.productService.getAll());
				}
			}else {				
				model.addAttribute("products", this.productService.getAll());
			}
		}catch (Exception e) {			
		}
		return "products/list";
	}
	
	@GetMapping("/new")
	public String newProductForm(Model model) {
		try {
			model.addAttribute("product", new Product());			
			model.addAttribute("suppliers", this.supplierService.getAll());
			model.addAttribute("categories", this.categoryService.getAll());
		}catch (Exception e) {
			// TODO: handle exception
		}		
		return "products/new";
	}
	
	@PostMapping("/save")
	public String saveNewProduct(Product product) {
		try {
			this.productService.create(product);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public String editProductForm(@PathVariable("id") long id, Model model) {
		try {
			Product product = this.productService.getOneById(id);
			model.addAttribute("product", product);
			model.addAttribute("suppliers", this.supplierService.getAll());
			model.addAttribute("categories", this.categoryService.getAll());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "products/edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateProduct(@PathVariable("id") long id, Product product) {
		try {
			this.productService.update(id, product);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/products";
	}
}
