package com.example.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payment.entity.TransactionDetails;
@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails, Long> {
	TransactionDetails findByOrderId(long orderId);

}
