package com.food.productsitemservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.food.productsitemservice.model.Product;

/**
 * This class responsible to configure call external microservice
 * 
 * @author j.a.vasconcelos
 *
 */
@FeignClient(name = "product-service", url = "localhost:8001")
public interface ProductClientRest {

	/**
	 * Method responsible call product-service/list
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<Product> list();

	/**
	 * Method responsible call product-service/view/1
	 * 
	 * @return
	 */
	@GetMapping("/view/{id}")
	public Product details(@PathVariable Long id);
}
