package com.sarindy.productProperty;

import java.util.List;

import com.sarindy.responseCode.ResponseCodeModel;

public interface ProductPropertyService {

	public ResponseCodeModel addProductPropertyService(String name, int modifiedBy, int productSubCategoryId);

	public ResponseCodeModel deleteProductPropertyService(String name,int modifiedBy);

	public ResponseCodeModel updateProductPropertyService(String name,String oldName,int modifiedBy,int productSubCategoryId);

	public List<ProductProperty> getAllProductPropertyService();

	public ProductProperty getProductPropertyService(int id);

	public ProductProperty getProductPropertyByNameService(String name);

	public List<ProductProperty> getProductPropertyByNameLikeService(String name);

}
