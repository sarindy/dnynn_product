package com.sarindy.productCategory;

import java.util.List;

import com.sarindy.responseCode.ResponseCodeModel;

public interface ProductCategoryService {
	
	public ResponseCodeModel addProductCategoryService(String productCategoryName, int modifiedBy);

	public ProductCategory getProductCategoryService(int id);

	public List<ProductCategory> getAllProductCategoryService();

	public ResponseCodeModel updateProductCategoryService(String productCategoryName,String oldName, int modifiedBy);

	public ResponseCodeModel deleteProductCategoryService(String productCategoryName,int modifiedBy);

	public ProductCategory getProductCategoryByNameService(String productCategoryName);
	
	
	

}
