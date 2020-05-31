package com.food.productsservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.food.productsservice.model.Product;

/**
 * Class responsible to access entity products
 * @author j.a.vasconcelos
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

}
