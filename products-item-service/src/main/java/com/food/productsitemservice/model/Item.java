package com.food.productsitemservice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class responsible to persist item in the database
 * @author j.a.vasconcelos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	private long id;
	
	private Product product;
	private Integer quantity;
	
	public Item(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	/**
	 * Calc total from items
	 * @return
	 */
	public BigDecimal getTotal() {
		return product.getPrice().multiply(new BigDecimal(this.quantity));
	}
	
}
