package com.food.productsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.productsservice.model.Product;
import com.food.productsservice.service.ProductService;

/**
 * Class responsible to expose product end point
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	/**
	 * Method responsible to list products
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<Product> list() {
		return service.findAll();
	}

	/**
	 * Responsible to view product by id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/view/{id}")
	public Product details(@PathVariable Long id) {

		/*
		 * try { Thread.sleep(2000L); } catch (Inte rruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		return service.findById(id);
	}

	/**
	 * Method responsible to create product
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return service.save(product);
	}

	/**
	 * Method responsible to update product
	 * 
	 * @param product
	 * @param id
	 * @return
	 */
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product edit(@RequestBody Product product, @PathVariable Long id) {

		Product p = service.findById(id);
		p.setName(product.getName());
		p.setPrice(product.getPrice());

		return service.save(p);
	}

	/**
	 * Method responsible to delete product' *
	 * 
	 * @param id
	 */
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {

		service.remove(id);

	}

}
