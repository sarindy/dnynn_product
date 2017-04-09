package com.sarindy.productSubCategory;

import java.util.List;

public interface ProductSubCategoryService {
	
	public boolean addProductSubCategoryService(ProductSubCategory productSubCategory);
	public boolean deleteProductSubCategoryService(ProductSubCategory productSubCategory);
	public boolean updateProductSubCategoryService(ProductSubCategory productSubCategory);
	public List<ProductSubCategory> getAllProductSubCategoryService();
	public ProductSubCategory getProductSubCategoryService(int id);
	public ProductSubCategory getProductSubCategoryByNameService(String name);
	public List<ProductSubCategory> getProductSubCategoryByNameLikeService(String containing_name);
	
	
	

}
