package com.example.productservice.service;

import com.example.productservice.model.ProductBody;

public interface ProductService {

	long addProduct(ProductBody product);

	ProductBody findProduct(Long id);

	void reduceQuantity(long id, long quantity);
	void increaseQantity(long id,long quantity);

}
