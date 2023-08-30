package com.ojulari.inventory.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ojulari.inventory.model.Category;
import com.ojulari.inventory.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category obj) {
		
		Category object = new Category();
		object.setCategoryName(obj.getCategoryName());
		object.setCategoryDescription(obj.getCategoryDescription());
		object.setCreationdate(obj.getCreationdate());

		return categoryRepository.save(object);
	}

	@Override
	public Category UpdateCategory(long id, Category obj) {
		obj.setId(id);
		return categoryRepository.save(obj);
	}

	@Override
	public void deleteCategoryById(long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<Category> allCategory() {
		List<Category> obj = categoryRepository.findAll();
		return obj;
	}

	@Override
	public Category findCategoryId(long id) {
		Category obj = categoryRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not find category"));
		
		return obj;
	}

}
