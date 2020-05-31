package com.food.productsitemservice.service;

import java.util.List;

import com.food.productsitemservice.model.Item;

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
}
