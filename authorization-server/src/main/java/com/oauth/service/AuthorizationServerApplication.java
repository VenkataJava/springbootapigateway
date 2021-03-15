package com.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import com.oauth.service.entity.Account;
import com.oauth.service.repository.AccountRepository;

@SpringBootApplication
public class AuthorizationServerApplication implements CommandLineRunner {

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountRepository.deleteAll();
		accountRepository.save(new Account("venkata", "12345"));
	}

}