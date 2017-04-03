package com.sarindy.services;

import org.springframework.data.repository.CrudRepository;

import com.sarindy.model.ProductSubCategory;

public interface ProductSubCategoryRepository extends CrudRepository<ProductSubCategory, Integer> {
	public ProductSubCategory findByNameOrderByNameAsc(String name);
	public ProductSubCategory findByNameLikeOrderByNameAsc(String containing_name);
	
	
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods to see the keyword

}
