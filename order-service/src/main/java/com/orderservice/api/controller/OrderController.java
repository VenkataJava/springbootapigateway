package com.orderservice.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.orderservice.api.entity.Order;
import com.orderservice.api.model.Payment;
import com.orderservice.api.model.TransactionRequest;
import com.orderservice.api.service.OrderService;
import com.orderservice.model.resp.TransactionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/order")
@Tag(name = "Order Controller", description = "information about book the order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/bookOrder")
	@Operation(summary = "API to save the order to given request")
	public TransactionResponse saveOrder(@Valid @RequestBody TransactionRequest transactionRequest) {
		System.out.println("In SaveOrder");
		return orderService.saveOrder(transactionRequest);
	}
}