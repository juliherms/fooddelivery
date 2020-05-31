package com.food.productsitemservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This class responsible to configuration rest template for call another service
 * @author j.a.vasconcelos
 *
 */
@Configuration
public class RestTemplateConfig {

	
	@Bean("clientRest")
	public RestTemplate registerRestTemplate() {
		return new RestTemplate();
	}
}
