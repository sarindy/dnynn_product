package com.sarindy.product;

import java.util.List;

public interface ProductService {
	
	public void addProductService(Product product);

	public void deleteProductService(Product product);

	public void updateProductService(Product product);

	public List<Product> getAllProductService();

	public Product getProductService(long id);

	public Product getProductServiceByNameService(String name);

	public List<Product> getProductServiceByNameLikeService(String name);

}
