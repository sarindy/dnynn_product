package com.sarindy.productCategory;

import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
	
	public ProductCategory findByName(String name);

}
