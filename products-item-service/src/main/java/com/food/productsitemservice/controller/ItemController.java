package com.food.productsitemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.food.productsitemservice.model.Item;
import com.food.productsitemservice.service.ItemService;

/**
 * This class responsible to item endpoint
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
}
