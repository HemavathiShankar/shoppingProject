package com.example.payment.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentReponse {
	
	private long orderId;
	private long amount;
	private String referenceNumber;
	private PaymentMode paymentMode;
	private String referencNumber;
	private Instant paymentDate;
	private String paymentStatus;

}
