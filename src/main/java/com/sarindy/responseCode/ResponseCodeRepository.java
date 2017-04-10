package com.sarindy.responseCode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseCodeRepository extends CrudRepository<ResponseCodeModel, Integer> {
	public ResponseCodeModel findByDescriptionLike(ResponseCodeModel responseCodeModel);
	public ResponseCodeModel findByCode(String code);
}
