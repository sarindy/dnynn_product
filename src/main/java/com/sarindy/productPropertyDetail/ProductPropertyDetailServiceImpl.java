package com.sarindy.productPropertyDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPropertyDetailServiceImpl implements ProductPropertyDetailService {

	@Autowired
	private ProductPropertyDetailRepository productPropertyDetailRepository;

	@Override
	public void addProductPropertyDetailService(ProductPropertyDetail productPropertyDetail) {
		productPropertyDetail.setLastModifiedDate(new Date());
		productPropertyDetailRepository.save(productPropertyDetail);

	}

	@Override
	public void deleteProductPropertyDetailService(ProductPropertyDetail productPropertyDetail) {
		productPropertyDetailRepository.delete(productPropertyDetail);

	}

	@Override
	public void updateProductPropertyDetailService(ProductPropertyDetail productPropertyDetail) {
		productPropertyDetail.setLastModifiedDate(new Date());
		productPropertyDetailRepository.save(productPropertyDetail);

	}

	@Override
	public List<ProductPropertyDetail> getAllProductPropertyDetailService() {
		List<ProductPropertyDetail> ProductPropertyDetails = new ArrayList<>();
		productPropertyDetailRepository.findAll().forEach(ProductPropertyDetails::add);
		return ProductPropertyDetails;
	}

	@Override
	public ProductPropertyDetail getProductPropertyDetailService(int id) {
		return productPropertyDetailRepository.findOne(id);
	}

	@Override
	public ProductPropertyDetail getProductPropertyDetailServiceByNameService(String name) {
		return productPropertyDetailRepository.findByNameOrderByNameAsc(name);
	}

	@Override
	public List<ProductPropertyDetail> getProductPropertyDetailServiceByNameLikeService(String name) {
		return productPropertyDetailRepository.findByNameLikeOrderByNameAsc(name);
	}

}
