package com.sarindy;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sarindy.productCategory.ProductCategory;
import com.sarindy.productCategory.ProductCategoryServiceImpl;
import com.sarindy.productSubCategory.ProductSubCategory;
import com.sarindy.productSubCategory.ProductSubCategoryServiceImpl;

@Service
public class TestBean {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductSubCategoryServiceImpl productSubCategoryServiceImpl;

	@Autowired
	private ProductCategoryServiceImpl productCategoryServiceImpl;
	
	

	/*public void addCategory(String categoryName) {

		productCategoryServiceImpl.addProductCategoryService(new ProductCategory(categoryName));

	}

	public void updateProductCategory(String categoryName, String newName) {

		ProductCategory updated = new ProductCategory();
		updated = productCategoryServiceImpl.getProductCategoryByNameService(categoryName);
		updated.setName(newName);
		productCategoryServiceImpl.updateProductCategoryService(updated);
	}

	public void deleteProductCategory(String categoryName) {

		ProductCategory category = new ProductCategory();
		category = productCategoryServiceImpl.getProductCategoryByNameService(categoryName);
		if (category != null) {
			productCategoryServiceImpl.deleteProductCategoryService(category);
			logger.info("Deleted!!!");
		}

	}

	public void addProductSubCategory(String productSubCategoryName,String categoryName) {

		ProductSubCategory productSubCategory = new ProductSubCategory(productSubCategoryName);


		if (productSubCategoryServiceImpl.getProductSubCategoryByNameService(productSubCategory.getName()) != null) {
			productSubCategoryServiceImpl.addProductSubCategoryService(productSubCategory,categoryName);

		}

	}*/

}
