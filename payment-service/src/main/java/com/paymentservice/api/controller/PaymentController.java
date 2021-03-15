package com.paymentservice.api.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paymentservice.api.entity.Payment;
import com.paymentservice.api.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		System.out.println("In doPayment");
		return paymentService.doPayment(payment);
	}

	@GetMapping("/{orderId}")
	public Optional<Payment> findPaymentHistoryByOrderId(@PathVariable int orderId) {
		System.out.println("findPaymentHistoryByOrderId::>>>" + orderId);
		return paymentService.findPaymentHistoryByOrderId(orderId);
	}

}
