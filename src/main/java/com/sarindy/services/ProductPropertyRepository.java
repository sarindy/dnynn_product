package com.sarindy.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sarindy.model.ProductProperty;

public interface ProductPropertyRepository extends CrudRepository<ProductProperty, Integer> {
	
	public ProductProperty findByNameOrderByNameAsc(String name);
	public List<ProductProperty> findByNameLikeOrderByNameAsc(String containing_name);
	
	
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods to see the keyword


}
