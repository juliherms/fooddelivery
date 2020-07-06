package com.food.productsitemservice.service;

import java.util.List;

import com.food.productsitemservice.model.Item;
import com.food.productsitemservice.model.Product;

/**
 * This interface responsible contract access services
 * @author j.a.vasconcelos
 *
 */
public interface ItemService {

	/**
	 * This method responsible to get items for products
	 * @return
	 */
	public List<Item> findAll();
	
	/**
	 * This method responsible to find product by id.
	 * @param id
	 * @param quantity
	 * @return
	 */
	public Item findById(Long id, Integer quantity);
	
	/**
	 * Method responsible to save product
	 * Call the another microservice
	 * @param product
	 * @return
	 */
	public Product saveProduct (Product product);
	
	/**
	 * Method responsible to update product
	 * Call the another microservice
	 * @param product
	 * @param id
	 * @return
	 */
	public Product updateProduct (Product product,Long id);
	
	/**
	 * Method responsible to delete product
	 * Call the another microservice
	 * @param id
	 */
	public void deleteProduct(Long id);
}
