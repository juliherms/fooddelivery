package com.food.productsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.productsservice.model.Product;
import com.food.productsservice.repository.ProductRepository;

/**
 * Class responsible to provide service for product
 * 
 * @author j.a.vasconcelos
 *
 */

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	/**
	 * Return all products in the database
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>) repo.findAll();
	}

	/**
	 * Return product by id
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	/**
	 * Save product
	 * 
	 * @param p
	 * @return
	 */
	@Transactional
	public Product save(Product p) {
		return repo.save(p);
	}

	/**
	 * Remove product
	 * 
	 * @param id
	 */
	@Transactional
	public void remove(Long id) {
		repo.deleteById(id);
	}
}
