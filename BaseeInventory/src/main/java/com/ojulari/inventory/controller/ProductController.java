package com.ojulari.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojulari.inventory.model.Product;
import com.ojulari.inventory.service.ProductService;


@RestController
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@PostMapping("/category/{categoryid}/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product obj, @PathVariable long categoryid) {
		Product newProd = pservice.createProduct(categoryid, obj);
				
		return new ResponseEntity<>(newProd, HttpStatus.OK);
	}
	
	@PutMapping("/category/{categoryid}/product/{productid}")
	public ResponseEntity<Product> updateProduct(@PathVariable ("productid") long productId, @PathVariable("categoryid") long categoryId, @RequestBody Product product){
		
		Product newProd = pservice.updateProduct(productId, categoryId, product);
		return new ResponseEntity<>(newProd, HttpStatus.OK);
	}
	
	@DeleteMapping("/category/{categoryid}/product/{productid}")
	public ResponseEntity<?> deleteProduct(@PathVariable long productid, @PathVariable("categoryid") long categoryid) {
		
		pservice.deleteProduct(productid, categoryid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
}
