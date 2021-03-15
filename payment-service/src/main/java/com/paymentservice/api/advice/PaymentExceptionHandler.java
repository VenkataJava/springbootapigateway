package com.paymentservice.api.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.paymentservice.api.exception.ErrorResponse;
import com.paymentservice.api.exception.PaymentNotFoundException;

@RestControllerAdvice
public class PaymentExceptionHandler {

	@ExceptionHandler(value = PaymentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handelPaymentException(PaymentNotFoundException exception) {
		System.out.println("exception messge::>>>" + exception.getMessage());
		List<String> details = new ArrayList<String>();
		details.add(exception.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(exception.getMessage(), details);
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
