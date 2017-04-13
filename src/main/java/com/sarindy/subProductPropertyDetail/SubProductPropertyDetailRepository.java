package com.sarindy.subProductPropertyDetail;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SubProductPropertyDetailRepository extends CrudRepository<SubProductPropertyDetail, Integer> {

	public SubProductPropertyDetail findByName(String name);

	public List<SubProductPropertyDetail> findByNameLikeOrderByNameAsc(String name);

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	// to see the keyword

}
