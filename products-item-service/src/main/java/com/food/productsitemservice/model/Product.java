package com.food.productsitemservice.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represent pojo for connect to product service
 * @author j.a.vasconcelos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor	
public class Product {

	private Long id;
	private String name;
	private BigDecimal price;
	private Date createdAt;
	
}
