package com.hampcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hampcode.model.entity.Category;
import com.hampcode.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String showAllCategories(Model model) {
		try {
			model.addAttribute("categories", this.categoryService.getAll());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "categories/list";
	}
	
	@GetMapping("/search")
	public String showCategoriesByName(@RequestParam("name") String name, Model model) {		
		try {			
			if(!name.isEmpty()) {
				if(!this.categoryService.fetchCategoryByName(name).isEmpty()) {
					model.addAttribute("categories", this.categoryService.fetchCategoryByName(name));
				}else {					
					model.addAttribute("categories", this.categoryService.getAll());
				}
			}else {				
				model.addAttribute("categories", this.categoryService.getAll());
			}			
		}catch (Exception e) {			
		}			
		return "categories/list";
	}
	
	@GetMapping("/new")
	public String newCategoryForm(Model model) {
		try {
			model.addAttribute("category", new Category());			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "categories/new";
	}
	
	@PostMapping("/save")
	public String saveNewCategory(Category category) {
		try {
			this.categoryService.create(category);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/categories";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategoryForm(@PathVariable("id") long id, Model model) {
		try {
			Category category = this.categoryService.getOneById(id);
			model.addAttribute("category", category);			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "categories/edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateCategory(@PathVariable("id") long id, Category category) {
		try {
			this.categoryService.update(id, category);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/categories";
	}
}
