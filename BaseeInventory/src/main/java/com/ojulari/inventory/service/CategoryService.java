package com.ojulari.inventory.service;

import java.util.List;

import com.ojulari.inventory.model.Category;

public interface CategoryService {
	
	Category createCategory(Category obj);
	Category UpdateCategory(long id, Category obj);
	void deleteCategoryById(long id);
	List<Category> allCategory();
	Category findCategoryId(long id);
}
