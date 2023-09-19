package com.example.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.model.ProductBody;
import com.example.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody ProductBody product){
		long id=service.addProduct(product);
		return new ResponseEntity<>("product added"+id,HttpStatus.CREATED);
	}
	@GetMapping("/getProducts/{id}")
	public ResponseEntity<ProductBody>getProducts(@PathVariable Long id){
		ProductBody p=service.findProduct(id);
		return new ResponseEntity<>(p,HttpStatus.FOUND);
	}
	
	@PutMapping("/reduceQuantiy/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable long id,@RequestParam long quantity){
		service.reduceQuantity(id,quantity);
		return new ResponseEntity<>(HttpStatus.OK);
		}
	@PutMapping("/increaseQuantity/{id}/{quantity")
	public ResponseEntity<Void> increaseQuantity(@PathVariable long id,@PathVariable long quanity){
		service.increaseQantity(id, quanity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
