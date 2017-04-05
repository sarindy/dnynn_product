package com.sarindy.productSubCategory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductSubCategoryRepository extends CrudRepository<ProductSubCategory, Integer> {
	public ProductSubCategory findByNameOrderByNameAsc(String name);
	public List<ProductSubCategory> findByNameLikeOrderByNameAsc(String containing_name);
	
	
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods to see the keyword

}
