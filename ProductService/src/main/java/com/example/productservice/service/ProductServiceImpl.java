package com.example.productservice.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.entity.Product;
import com.example.productservice.exception.ProductCustomException;
import com.example.productservice.model.ProductBody;
import com.example.productservice.repository.ProductRepository;


import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository repo;
	

	@Override
	public long addProduct(ProductBody product) {
		// TODO Auto-generated method stub
		Product p=new Product(product.getProductName(),product.getPrice(),product.getQuantity());
		
		Long id=repo.save(p).getProductId();
		log.info("product saved into db"+p);
		return id;
		
		
		
	}


	@Override
	public ProductBody findProduct(Long id) {
		// TODO Auto-generated method stub
		Product pt= repo.findById(id).orElseThrow(()->new ProductCustomException("id not found","not found"));
		ProductBody p=new ProductBody(pt.getProductId(),pt.getProductName(),pt.getPrice(),pt.getQuantity());
		return p;
	}


	@Override
	public void reduceQuantity(long id, long quantity) {
		// TODO Auto-generated method stub
		log.info("reduced quantity "+quantity);
		Product product=repo.findById(id)
				.orElseThrow(()-> new ProductCustomException("product not fount exception","Product_NOT_FOUND"));
		if(product.getQuantity()<quantity) {
			throw new ProductCustomException("insufficient quantity of products","INFUFFICIENT_QUANTITY");
		}
		product.setQuantity(product.getQuantity()-quantity);
		repo.save(product);
		log.info("product updated and  saved successfully");
		}


	@Override
	public void increaseQantity(long id, long quantity) {
		// TODO Auto-generated method stub
		log.info("increase quantity"+quantity);
		Product product=repo.findById(id)
		.orElseThrow(()-> new ProductCustomException("product not fount exception","Product_NOT_FOUND"));
		product.setQuantity(product.getQuantity()+quantity);
		repo.save(product);
		log.info("product increased as payment failed");
	}
	
	
				
		
		
	}
	
