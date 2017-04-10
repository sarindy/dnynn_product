package com.sarindy.productCategory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.responseCode.ResponseCodeModel;

@Service
public class ProductCategoryHisServiceImpl implements ProductCategoryHisService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductCategoryHisRepository productCategoryHisRepository;

	

	@Override
	public ResponseCodeModel addProductCategoryHis(ProductCategoryHis productCategoryHis) {

		try {
			productCategoryHisRepository.save(productCategoryHis);
			return new ResponseCodeModel("000", "Category " + productCategoryHis.getName() + " has moved to history", 0);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error, Category " + productCategoryHis.getName() + " not moved to history", 0);
		}
	}

}
