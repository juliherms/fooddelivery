package com.food.productsitemservice.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.food.productsitemservice.model.Item;
import com.food.productsitemservice.model.Product;

/**
 * Class responsible about service items.
 * 
 * @author j.a.vasconcelos
 *
 */
@Service("serviceImpl")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clientRest;

	/**
	 * This method responsible to get items for products
	 * 
	 * @return
	 */
	@Override
	public List<Item> findAll() {

		// call microservice products with restTemplate
		List<Product> products = Arrays.asList(clientRest.getForObject("http://product-service/list", Product[].class));
		// convert products to item
		return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	/**
	 * This method responsible to find product by id.
	 * 
	 * @param id
	 * @param quantity
	 * @return
	 */
	@Override
	public Item findById(Long id, Integer quantity) {

		// makes a param
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());

		// call rest endpoint
		Product product = clientRest.getForObject("http://product-service/view/{id}", Product.class, pathVariables);

		return new Item(product, quantity);
	}

	@Override
	public Product saveProduct(Product product) {

		HttpEntity<Product> body = new HttpEntity<Product>(product);

		ResponseEntity<Product> response = clientRest.exchange("http://product-service/create", HttpMethod.POST, body,
				Product.class);

		Product productResponse = response.getBody();
		return productResponse;
	}

	@Override
	public Product updateProduct(Product product, Long id) {

		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());

		HttpEntity<Product> body = new HttpEntity<Product>(product);
		ResponseEntity<Product> response = clientRest.exchange("http://product-service/edit/{id}", HttpMethod.PUT, body,
				Product.class, pathVariables);

		return response.getBody();
	}

	@Override
	public void deleteProduct(Long id) {

		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());

		clientRest.delete("http://product-service/{id}", pathVariables);

	}
}
