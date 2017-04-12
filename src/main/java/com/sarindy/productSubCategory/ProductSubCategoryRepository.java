package com.sarindy.productSubCategory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductSubCategoryRepository extends CrudRepository<ProductSubCategory, Integer> {

	public ProductSubCategory findByName(String name);

	public List<ProductSubCategory> findByNameLikeOrderByNameAsc(String name);

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	// to see the keyword

}
