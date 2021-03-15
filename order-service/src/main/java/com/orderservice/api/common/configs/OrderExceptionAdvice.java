package com.orderservice.api.common.configs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionAdvice {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handelValidationExceptions(ConstraintViolationException exception) {

		Map<String, Object> body = new LinkedHashMap<String, Object>();
		List<String> errors = new ArrayList<String>();
		errors.add("validation failes in request body object");
		body.put("errors", errors);
		return new ResponseEntity<Object>(body, HttpStatus.PRECONDITION_FAILED);
	}
}
