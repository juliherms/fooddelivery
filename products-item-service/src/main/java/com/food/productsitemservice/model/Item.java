package com.food.productsitemservice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class responsible to persist item in the database
 * @author j.a.vasconcelos
 *
 */
@Entity
@Table(name="TB_ITEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	private Product product;
	private Integer quantity;
	
	/**
	 * Calc total from items
	 * @return
	 */
	public BigDecimal getTotal() {
		return product.getPrice().multiply(new BigDecimal(this.quantity));
	}
	
}
