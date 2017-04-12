package com.sarindy.productSubCategory;

import java.util.List;

import com.sarindy.responseCode.ResponseCodeModel;

public interface ProductSubCategoryService {

	public ResponseCodeModel addProductSubCategoryService(String productSubCategoryName, int categoryId, int modifiedBy);

	public ResponseCodeModel deleteProductSubCategoryService(String productSubCategoryName, int modifiedBy);

	public ResponseCodeModel updateProductSubCategoryService(String oldName, String productSubCategoryName, int categoryId, int modifiedBy);

	public List<ProductSubCategory> getAllProductSubCategoryService();

	public ProductSubCategory getProductSubCategoryService(int id);

	public ProductSubCategory getProductSubCategoryByNameService(String name);

	public List<ProductSubCategory> getProductSubCategoryByNameLikeService(String containing_name);

}
