package com.sarindy.services;

import org.springframework.data.repository.CrudRepository;

import com.sarindy.model.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
	
	public ProductCategory findByName(String name);

}
