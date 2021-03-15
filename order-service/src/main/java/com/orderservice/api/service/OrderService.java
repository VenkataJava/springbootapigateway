package com.orderservice.api.service;

import com.orderservice.api.model.TransactionRequest;
import com.orderservice.model.resp.TransactionResponse;

public interface OrderService {

	public TransactionResponse saveOrder(TransactionRequest transactionRequest);
}
