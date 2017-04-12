package com.sarindy.productPropertyDetail;

import java.util.List;

import com.sarindy.responseCode.ResponseCodeModel;

public interface ProductPropertyDetailService {

	public ResponseCodeModel addProductPropertyDetailService(String propertyDetailName, int modifiedBy, int propertyId);

	public ResponseCodeModel deleteProductPropertyDetailService(String propertyDetailName, int modifiedBy);

	public ResponseCodeModel updateProductPropertyDetailService(String propertyDetailName, String oldName, int modifiedBy, int propertyId);

	public List<ProductPropertyDetail> getAllProductPropertyDetailService();

	public ProductPropertyDetail getProductPropertyDetailService(int id);

	public ProductPropertyDetail getProductPropertyDetailServiceByNameService(String name);

	public List<ProductPropertyDetail> getProductPropertyDetailServiceByNameLikeService(String name);

}
