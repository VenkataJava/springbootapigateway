package com.orderservice.model.resp;

import com.orderservice.api.entity.Order;

public class TransactionResponse {

	private Order order;
	private double amount;
	private String transactionid;
	private String message;

	public TransactionResponse(Order order, double amount, String transactionid, String message) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionid = transactionid;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

}
