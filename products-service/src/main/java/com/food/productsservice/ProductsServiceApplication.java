package com.food.productsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Microservice responsible to persist products in the application
 * @author j.a.vasconcelos
 *
 */
@SpringBootApplication
@EnableEurekaClient //allow service discovery
public class ProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceApplication.class, args);
	}

}
