package com.ojulari.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ojulari.inventory.model.Category;
import com.ojulari.inventory.model.Product;
import com.ojulari.inventory.repository.CategoryRepository;
import com.ojulari.inventory.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Product createProduct(long categoryid, Product newproduct) {
		
		 Category obj=categoryRepository.findById(categoryid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not find category"));
		Product productObj = new Product();
		productObj.setProductName(newproduct.getProductName());
		productObj.setCompanyName(newproduct.getCompanyName());
		productObj.setPrice(newproduct.getPrice());
		productObj.setStock(newproduct.getStock());
		productObj.setStatus(newproduct.getStatus());
		productObj.setCategory(obj);
		Product saved = productRepository.save(productObj);
		return saved;
	}

	@Override
	public Product updateProduct(long productid,long categoryid, Product updateObj) {
		Product productObj = productRepository.findById(productid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not find product"));

		productObj.setProductName(updateObj.getProductName());
		productObj.setCompanyName(updateObj.getCompanyName());
		productObj.setPrice(updateObj.getPrice());
		productObj.setStock(updateObj.getStock());
		productObj.setStatus(updateObj.getStatus());
		Category categoryObj = categoryRepository.findById(categoryid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not find category"));

		productObj.setCategory(categoryObj);
		Product saved = productRepository.save(productObj);
		return saved;
	}

	@Override
	public void deleteProduct(long productid,long categoryid) {
		Category categoryObj = categoryRepository.findById(categoryid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not find category"));

		Product productObj = productRepository.findById(productid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not find product"));
		productRepository.deleteById(productid);
		
	}
	
}
