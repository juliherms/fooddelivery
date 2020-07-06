package com.food.productsitemservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.food.productsitemservice.model.Product;

/**
 * This class responsible to configure call external microservice
 * 
 * @author j.a.vasconcelos
 *
 */
@FeignClient(name = "product-service")
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
	
	/**
	 * Method responsible to create product 
	 * @param product
	 * @return
	 */
	@PostMapping("/create")
	public Product create(@RequestBody Product product);
	
	/**
	 * Method responsible to update product
	 * @param product
	 * @param id
	 * @return
	 */
	@PutMapping("/edit/{id}")
	public Product update(@RequestBody Product product, @PathVariable Long id);
	
	/**
	 * Method responsible to delete product
	 * @param id
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id);
}
