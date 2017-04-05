package com.sarindy.productPropertyDetail;

import java.util.List;

public interface ProductPropertyDetailService {

	public void addProductPropertyDetailService(ProductPropertyDetail productPropertyDetail);

	public void deleteProductPropertyDetailService(ProductPropertyDetail productPropertyDetail);

	public void updateProductPropertyDetailService(ProductPropertyDetail productPropertyDetail);

	public List<ProductPropertyDetail> getAllProductPropertyDetailService();

	public ProductPropertyDetail getProductPropertyDetailService(int id);

	public ProductPropertyDetail getProductPropertyDetailServiceByNameService(String name);

	public List<ProductPropertyDetail> getProductPropertyDetailServiceByNameLikeService(String name);

}
