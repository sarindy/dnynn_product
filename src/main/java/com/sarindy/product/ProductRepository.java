package com.sarindy.product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

	public Product findByNameOrderByNameAsc(String name);

	public List<Product> findByNameLikeOrderByNameAsc(String name);

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	// to see the keyword

}
