package com.paymentservice.api.service;

import java.util.Optional;

import com.paymentservice.api.entity.Payment;

public interface PaymentService {

	public Payment doPayment(Payment payment);

	public Optional<Payment> findPaymentHistoryByOrderId(int orderId);

}
