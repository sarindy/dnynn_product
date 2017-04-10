package com.sarindy.responseCode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseCodeHisRepository extends CrudRepository<ResponseCodeModelHis, Integer> {

}
