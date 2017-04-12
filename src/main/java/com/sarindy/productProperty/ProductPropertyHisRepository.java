package com.sarindy.productProperty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPropertyHisRepository extends CrudRepository<ProductPropertyHis, Integer> {

}
