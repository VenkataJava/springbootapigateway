package com.resourceserver.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/public")
	public String publicHello() {
		return "Hi there";
	}

	@GetMapping("/private")
	public String privateHello() {
		return "welcome to private";
	}

}