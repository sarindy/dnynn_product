package com.sarindy;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productCategory.ProductCategory;
import com.sarindy.productCategory.ProductCategoryServiceImpl;
import com.sarindy.productSubCategory.ProductSubCategoryServiceImpl;

@Service
public class TestBean {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    

	@Autowired
	private ProductSubCategoryServiceImpl productSubCategoryServiceImpl;

	@Autowired
	private ProductCategoryServiceImpl productCategoryServiceImpl;

	public void addCategory(String categoryName) {

		productCategoryServiceImpl.addProductCategoryService(new ProductCategory(categoryName));

	}
	
	public void updateProductCategory(String categoryName,String newName){
		ProductCategory updated = new ProductCategory();
		updated =productCategoryServiceImpl.getProductCategoryByNameService(categoryName);
		updated.setName(newName);
		productCategoryServiceImpl.updateProductCategoryService(updated);
	}
	
	public void deleteProductCategory(String categoryName){
		ProductCategory category = new ProductCategory();
		category = productCategoryServiceImpl.getProductCategoryByNameService(categoryName);
		if(category != null) {
			productCategoryServiceImpl.deleteProductCategoryService(category);
			logger.info("Deleted!!!");
		}
		
	}

}
