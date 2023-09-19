package com.example.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.model.PaymentRequest;
import com.example.payment.service.PaymentService;

import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/payment")
@Log4j2
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@PostMapping("/doPayment")
	public ResponseEntity<String> doPayment(@RequestBody PaymentRequest payment){
		long id=service.doPayment(payment);
		
		return new ResponseEntity<>("payment competed successfully "+id,HttpStatus.CREATED);
		
	}
	@GetMapping("/getPaymentByOrderId/{id}")
	public ResponseEntity<PaymentRequest> getPayment(@PathVariable long id){
		PaymentRequest pay=service.getPaymentByorderId(id);
		log.info(pay);
		return new ResponseEntity<>(pay,HttpStatus.FOUND);
	}
	
	

}
