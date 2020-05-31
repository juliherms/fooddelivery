package com.food.productsitemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Microservice responsible to management items
 * @author j.a.vasconcelos
 *
 */
@RibbonClient(name="product-service") //allow load balance
@EnableFeignClients //allow enable
@SpringBootApplication
public class ProductsItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsItemServiceApplication.class, args);
	}

}
