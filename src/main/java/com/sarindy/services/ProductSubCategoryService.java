package com.sarindy.services;

import java.util.List;

import com.sarindy.model.ProductSubCategory;

public interface ProductSubCategoryService {
	
	public void addProductSubCategoryService(ProductSubCategory productSubCategory);
	public void deleteProductSubCategoryService(ProductSubCategory productSubCategory);
	public void updateProductSubCategoryService(ProductSubCategory productSubCategory);
	public List<ProductSubCategory> getAllProductSubCategoryService();
	public ProductSubCategory getProductSubCategoryService(int id);
	public ProductSubCategory getProductSubCategoryByNameService(String name);
	public ProductSubCategory getProductSubCategoryByNameLikeService(String containing_name);
	
	
	

}
