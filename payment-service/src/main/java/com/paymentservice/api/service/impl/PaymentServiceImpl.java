package com.paymentservice.api.service.impl;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.api.entity.Payment;
import com.paymentservice.api.exception.PaymentNotFoundException;
import com.paymentservice.api.repository.PaymentRepository;
import com.paymentservice.api.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment doPayment(Payment payment) {
		// TODO Auto-generated method stub
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	public String paymentProcessing() {
		// api should be 3rd party payment gateway (paypal)
		return new Random().nextBoolean() ? "sucess" : "false";
	}

	public Optional<Payment> findPaymentHistoryByOrderId(int orderId) {
		// TODO Auto-generated method stub
		Optional<Payment> payment = paymentRepository.findById(orderId);
		if (payment.isPresent()) {
			return payment;
		} else {
			throw new PaymentNotFoundException("Payment is Not Found Against this OrderId");
		}
	}
}
