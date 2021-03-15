package com.orderservice.api.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import com.orderservice.api.entity.Order;
import com.orderservice.api.model.Payment;
import com.orderservice.api.model.TransactionRequest;
import com.orderservice.api.repository.OrderRepository;
import com.orderservice.api.rest.config.OrderRestClient;
import com.orderservice.api.service.OrderService;
import com.orderservice.model.resp.TransactionResponse;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderRestClient orderRestClient;

	@Value("${payment.service-url}")
	private String paymentServiceUrl;

	// @HystrixCommand(fallbackMethod = "paymentFallBackMethod")
	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		// TODO Auto-generated method stub
		String response = null;
		Order order = transactionRequest.getOrder();
		Payment paymentRequest = transactionRequest.getPayment();
		paymentRequest.setOrderId(order.getId());
		paymentRequest.setAmount(order.getPrice());
		System.out.println("paymentServiceUrl::>>" + paymentServiceUrl);
		Payment paymentRes = orderRestClient.post(paymentServiceUrl, new ParameterizedTypeReference<Payment>() {}, paymentRequest);
		System.out.println("paymentRes>>" + paymentRes);
		response = paymentRes.getPaymentStatus().equals("sucess") ? "payment processed successfully"
				: "there is a failure from payment api";
		orderRepository.save(order);
		return new TransactionResponse(order, paymentRes.getAmount(), paymentRes.getTransactionId(), response);
	}

	@SuppressWarnings("unused")
	private String paymentFallBackMethod(String fallBackMethod) {
		return "PayemntSevice is taking to long to respond or down, please try againg later ";
	}
}
