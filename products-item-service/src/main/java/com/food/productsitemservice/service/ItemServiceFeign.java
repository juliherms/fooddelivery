package com.food.productsitemservice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.productsitemservice.clients.ProductClientRest;
import com.food.productsitemservice.model.Item;
import com.food.productsitemservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Implements ItemService with feign
 * 
 * @author j.a.vasconcelos
 *
 */
@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductClientRest clientFeign;

	@Override
	public List<Item> findAll() {

		return clientFeign.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	/**
	 * Method responsible to find product and increment quantity.
	 * 
	 * Fallback: fallbackMethod
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public Item findById(Long id, Integer quantity) {

		return new Item(clientFeign.details(id), quantity);
	}

	/**
	 * this method represents circuit breaker TODO: implement alternative in kafka
	 * or rabbitMQ.
	 * 
	 * @param id
	 * @param quantity
	 * @return
	 */
	public Item fallbackMethod(Long id, Integer quantity) {

		Item item = new Item();
		Product product = new Product();

		item.setQuantity(quantity);
		product.setId(id);
		product.setName("Coca Cola");
		product.setPrice(BigDecimal.TEN);
		item.setProduct(product);

		return item;
	}

	@Override
	public Product saveProduct(Product product) {
		return clientFeign.create(product);
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		return clientFeign.update(product, id);
	}

	@Override
	public void deleteProduct(Long id) {
		clientFeign.delete(id);

	}
}
