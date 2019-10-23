package com.hampcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hampcode.model.entity.Supplier;
import com.hampcode.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping
	public String showAllSuppliers(Model model) {
		try {
			model.addAttribute("suppliers", this.supplierService.getAll());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "suppliers/list";
	}
	
	@GetMapping("/search")
	public String showSuppliersByName(@RequestParam("name") String name, Model model) {
		try {
			if(!name.isEmpty()) {
				if(!this.supplierService.fetchSupplierByName(name).isEmpty()) {
					model.addAttribute("suppliers", this.supplierService.fetchSupplierByName(name));
				}else {					
					model.addAttribute("suppliers", this.supplierService.getAll());
				}
			}else {				
				model.addAttribute("suppliers", this.supplierService.getAll());
			}
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "suppliers/list";
	}
	
	@GetMapping("/new")
	public String newSupplierForm(Model model) {
		try {
			model.addAttribute("supplier", new Supplier());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "suppliers/new";
	}
	
	@PostMapping("/save")
	public String saveNewSupplier(Supplier supplier) {
		try {
			this.supplierService.create(supplier);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/suppliers";
	}
	
	@GetMapping("/edit/{id}")
	public String editSupplierForm(@PathVariable("id") long id, Model model) {
		try {
			Supplier supplier = this.supplierService.getOneById(id);
			model.addAttribute("supplier", supplier);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "suppliers/edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateSupplier(@PathVariable("id") long id, Supplier supplier) {
		try {
			this.supplierService.update(id, supplier);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/suppliers";
	}
}
