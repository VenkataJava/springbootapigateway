package com.apigateway.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

	@RequestMapping("/orderFallBack")
	public Mono<String> orderServiceFallBack() {
		return Mono.just("OrderSevice is taking to long to respond or down, please try againg later ");
	}

	@RequestMapping("/paymentFallBack")
	public Mono<String> paymentServiceFallBack() {
		return Mono.just("PayemntSevice is taking to long to respond or down, please try againg later ");
	}
}
