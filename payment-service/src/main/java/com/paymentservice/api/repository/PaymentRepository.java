package com.paymentservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentservice.api.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}