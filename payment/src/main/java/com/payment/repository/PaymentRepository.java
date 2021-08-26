package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.payment.entity.Payment;

@Service
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
