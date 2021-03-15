package com.orderservice.api.rest.config;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderRestClient {

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */

	public <S, V> S post(String url, ParameterizedTypeReference<S> responseType, V requestData) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
		HttpEntity<V> request = new HttpEntity<V>(requestData, headers);
		ResponseEntity<S> response = new RestTemplate().exchange(url, HttpMethod.POST, request, responseType);
		return response.getBody();
	}
}
