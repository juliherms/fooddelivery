package com.food.productsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.food.productsservice.model.Product;
import com.food.productsservice.service.ProductService;

/**
 * Class responsible to expose product endpoint
 * @author j.a.vasconcelos
 *
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/list")
	public List<Product> list() {
		return service.findAll();
	}
	
	/**
	 * Responsible to view product by id
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/view/{id}")
	public Product details(@PathVariable Long id){
	
		/*
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return service.findById(id);
	}
}
