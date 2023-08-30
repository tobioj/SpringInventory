package com.ojulari.inventory.service;

import com.ojulari.inventory.model.Product;

public interface ProductService {
	
	Product createProduct(long id, Product newproduct);
	Product updateProduct(long productid,long categoryid, Product updateObj);
	void deleteProduct(long productid,long categoryid);
	
}
