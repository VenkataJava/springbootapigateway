package com.paymentservice.api.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI api(@Value("${payment.application.display-name}") String appName,
			@Value("${payment.application.version}") String componentName,
			@Value("${payment.application.component-display-name}") String version,
			@Value("${payment.application.team-mail}") String mail) {
		return new OpenAPI().info(
				new Info().title(appName).version(version).description(componentName).contact(new Contact().email(mail))
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
