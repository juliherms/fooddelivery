package com.food.productsitemservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.food.productsitemservice.clients.ProductClientRest;
import com.food.productsitemservice.model.Item;

/**
 * Implements ItemService with feign
 * @author j.a.vasconcelos
 *
 */
@Service("serviceFeign")
@Primary //set this service is principal
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductClientRest clientFeign;

	@Override
	public List<Item> findAll() {

		return clientFeign.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {

		return new Item(clientFeign.details(id), quantity);
	}
}
