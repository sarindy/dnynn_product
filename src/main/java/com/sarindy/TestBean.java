package com.sarindy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productCategory.ProductCategoryServiceImpl;
import com.sarindy.productProperty.ProductPropertyServiceImpl;
import com.sarindy.productSubCategory.ProductSubCategoryServiceImpl;

@Service
public class TestBean {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductSubCategoryServiceImpl productSubCategoryServiceImpl;

	@Autowired
	private ProductCategoryServiceImpl productCategoryServiceImpl;
	
	@Autowired
	private ProductPropertyServiceImpl productPropertyServiceImpl;
	
	
	
	public void addCategory(String name){
		productCategoryServiceImpl.addProductCategoryService(name, 0);
	}
	
	public void updateProduct(String oldName,String newName,int modifiedBy){
		productCategoryServiceImpl.updateProductCategoryService(newName, oldName, 0);
	}
	
	public void deleteCategory(String categoryName,int modifiedBy){
		productCategoryServiceImpl.deleteProductCategoryService(categoryName, modifiedBy);
	}
	
	public void addSubCategory(String subCategoryName,int categoryId,int modifiedBy){
		productSubCategoryServiceImpl.addProductSubCategoryService(subCategoryName, categoryId, modifiedBy);
	}
	
	public void updateSubCategory(String categoryName,String oldName,int categoryId,int modifiedBy){
		productSubCategoryServiceImpl.updateProductSubCategoryService(oldName, categoryName, categoryId, modifiedBy);
	}
	
	public void addProductProperty(String propertyName,int modifiedBy,int SubCategoyId){
		productPropertyServiceImpl.addProductPropertyService(propertyName, modifiedBy, SubCategoyId);
	}
	
	public void addProductProperties(List<String> propertiesList,int modifiedBy,int SubCategoyId){
		List<String> properties = new ArrayList<String>();
		propertiesList.forEach(properties::add);
		for (String elements : properties) {
			productPropertyServiceImpl.addProductPropertyService(elements, modifiedBy, SubCategoyId);
		}
	}
	
	public void updateProductProperty(String name,String oldName,int modifiedBy,int productSubCategoryId){
		productPropertyServiceImpl.updateProductPropertyService(name, oldName, modifiedBy, productSubCategoryId);
	}
	
	public void deleteProductProperty(String name,int modifiedBy){
		productPropertyServiceImpl.deleteProductPropertyService(name, modifiedBy);
	}

	

}
