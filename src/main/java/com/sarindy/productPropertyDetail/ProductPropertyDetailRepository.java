package com.sarindy.productPropertyDetail;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductPropertyDetailRepository extends CrudRepository<ProductPropertyDetail, Integer> {

	public ProductPropertyDetail findByNameOrderByNameAsc(String name);

	public List<ProductPropertyDetail> findByNameLikeOrderByNameAsc(String name);

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	// to see the keyword

}
