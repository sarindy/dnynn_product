package com.sarindy.productCategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryHisRepository extends CrudRepository<ProductCategoryHis, Integer> {
	public ProductCategoryHis findByName(String name);

}
