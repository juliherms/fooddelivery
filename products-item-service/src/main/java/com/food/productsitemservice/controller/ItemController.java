package com.food.productsitemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.productsitemservice.model.Item;
import com.food.productsitemservice.model.Product;
import com.food.productsitemservice.service.ItemService;

/**
 * This class responsible to item end point
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	private ItemService service;

	/**
	 * Responsible to list all products in database
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<Item> list() {
		return service.findAll();
	}

	/**
	 * Responsible to find products by id and quantity
	 * 
	 * @param id
	 * @param quantity
	 * @return
	 */
	@GetMapping("/view/{id}/quantity/{quantity}")
	public Item detail(@PathVariable Long id, @PathVariable Integer quantity) {
		return service.findById(id, quantity);
	}

	/**
	 * Responsible to create a new product
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	/**
	 * Responsible to edit a product
	 * 
	 * @param product
	 * @param id
	 * @return
	 */
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product edit(@RequestBody Product product, @PathVariable Long id) {
		return service.updateProduct(product, id);
	}

	/**
	 * Responsible to delete product
	 * @param id
	 */
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteProduct(id);
	}
}
