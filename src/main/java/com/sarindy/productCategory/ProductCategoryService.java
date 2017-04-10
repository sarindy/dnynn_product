package com.sarindy.productCategory;

import java.util.List;

public interface ProductCategoryService {
	
	public boolean addProductCategoryService(String productCategoryName);

	public ProductCategory getProductCategoryService(int id);

	public List<ProductCategory> getAllProductCategoryService();

	public boolean updateProductCategoryService(String productCategoryName);

	public boolean deleteProductCategoryService(String productCategoryName);

	public ProductCategory getProductCategoryByNameService(String productCategoryName);
	
	
	

}
