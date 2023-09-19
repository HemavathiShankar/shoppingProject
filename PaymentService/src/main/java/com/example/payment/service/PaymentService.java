package com.example.payment.service;

import com.example.payment.model.PaymentRequest;

public interface PaymentService {

	Long doPayment(PaymentRequest payment);

	PaymentRequest getPaymentByorderId(long id);

}
