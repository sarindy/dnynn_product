package com.sarindy.services;

import java.util.List;

import com.sarindy.model.ProductProperty;

public interface ProductPropertyService {
	
	public void addProductPropertyService(ProductProperty productProperty);
	public void deleteProductPropertyService(ProductProperty productProperty);
	public void updateProductPropertyService(ProductProperty productProperty);
	public List<ProductProperty> getAllProductPropertyService();
	public ProductProperty getProductPropertyService(int id);
	public ProductProperty getProductPropertyByNameService(String name);
	public List<ProductProperty> getProductPropertyByNameLikeService(String containing_name);

}
