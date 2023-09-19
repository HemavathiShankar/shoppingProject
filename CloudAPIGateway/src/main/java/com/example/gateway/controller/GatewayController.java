package com.example.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
	
	@GetMapping("/orderServiceFallBack")
	public ResponseEntity<String> orderServiceFallBack() {
		return new ResponseEntity<>("ORDER_SERVICE is down",HttpStatus.OK);
	}
	@GetMapping("/productServiceFallBack")
	public ResponseEntity<String> productServiceFallBack() {
		return new ResponseEntity<>("PRODUCT_SERVICE is down",HttpStatus.OK);
	}
	@GetMapping("/paymentServiceFallBack")
	public ResponseEntity<String> paymentServiceFallBack() {
		return new ResponseEntity<>("PAYMENT_SERVICE is down",HttpStatus.OK);
	}
}
