package com.example.payment.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.entity.TransactionDetails;
import com.example.payment.model.PaymentMode;
import com.example.payment.model.PaymentRequest;
import com.example.payment.repository.TransactionDetailsRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private TransactionDetailsRepo repo;

	@Override
	public Long doPayment(PaymentRequest payment) {
		log.info("payment requet placed "+payment);
		// TODO Auto-generated method stub
		TransactionDetails entity= TransactionDetails.builder().paymentDate(Instant.now())
				.amount(payment.getAmount()).orderId(payment.getOrderId())
				.paymentMode(payment.getPaymentMode().name()).referencNumber(payment.getReferenceNumber())
				.paymentStatus("success").build();
		long temp=repo.save(entity).getId();
		log.info("transaction completed for order  "+entity);
		return temp;
		
	}

	/// write seperate paymentresoponse class to get all the data
	@Override
	public PaymentRequest getPaymentByorderId(long id) {
		// TODO Auto-generated method stub
		log.info("getting payment details for the orderId");
		TransactionDetails entity= repo.findByOrderId(id);
		PaymentRequest req=PaymentRequest.builder().orderId(id).amount(entity.getAmount())
				.paymentMode(PaymentMode.valueOf(entity.getPaymentMode())).build();
		log.info("payment request "+req);
		return req;
	}

}
