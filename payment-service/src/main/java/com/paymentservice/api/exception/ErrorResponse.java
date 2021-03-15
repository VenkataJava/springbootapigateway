package com.paymentservice.api.exception;

import java.util.List;

public class ErrorResponse {

	private String errorMessage;
	List<String> details;

	public ErrorResponse(String errorMessage, List<String> details) {
		super();
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

}
