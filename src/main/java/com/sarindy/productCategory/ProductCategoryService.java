package com.sarindy.productCategory;

import java.util.List;

public interface ProductCategoryService {
	
	public void addProductCategoryService(ProductCategory productCategory);

	public ProductCategory getProductCategoryService(int id);

	public List<ProductCategory> getAllProductCategoryService();

	public void updateProductCategoryService(ProductCategory productCategory);

	public void deleteProductCategoryService(ProductCategory productCategory);

	public ProductCategory getProductCategoryByNameService(String name);
	
	
	

}
