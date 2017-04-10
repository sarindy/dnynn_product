package com.sarindy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productCategory.ProductCategoryServiceImpl;
import com.sarindy.productSubCategory.ProductSubCategoryServiceImpl;

@Service
public class TestBean {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductSubCategoryServiceImpl productSubCategoryServiceImpl;

	@Autowired
	private ProductCategoryServiceImpl productCategoryServiceImpl;
	
	public void addCategory(String name){
		productCategoryServiceImpl.addProductCategoryService(name, 0);
	}
	
	public void updateProduct(String oldName,String newName,int modifiedBy){
		productCategoryServiceImpl.updateProductCategoryService(newName, oldName, 0);
	}
	
	public void deleteCategory(String categoryName,int modifiedBy){
		productCategoryServiceImpl.deleteProductCategoryService(categoryName, modifiedBy);
	}
	

	

}
