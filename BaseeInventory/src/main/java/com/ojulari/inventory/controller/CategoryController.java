package com.ojulari.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojulari.inventory.model.Category;
import com.ojulari.inventory.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;

	@PostMapping("/save")
	public ResponseEntity<Category> createCategory(@RequestBody Category newCategory) {

		Category Obj = service.createCategory(newCategory);
		return new ResponseEntity<>(Obj, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category newCategory) {

		Category updated = service.UpdateCategory(id, newCategory);

		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Category> deleteCategoryById(@PathVariable("id") long id) {

		service.deleteCategoryById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Category>> allCategory() {
		List<Category> obj = service.allCategory();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@GetMapping("/all/{id}")
	public ResponseEntity<Category> findCategoryId(@PathVariable("id") long id) {
		Category obj = service.findCategoryId(id);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

}
