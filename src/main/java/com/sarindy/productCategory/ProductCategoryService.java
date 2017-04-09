package com.sarindy.productCategory;

import java.util.List;

public interface ProductCategoryService {
	
	public boolean addProductCategoryService(ProductCategory productCategory);

	public ProductCategory getProductCategoryService(int id);

	public List<ProductCategory> getAllProductCategoryService();

	public boolean updateProductCategoryService(ProductCategory productCategory);

	public boolean deleteProductCategoryService(ProductCategory productCategory);

	public ProductCategory getProductCategoryByNameService(String name);
	
	
	

}
