package com.sarindy.productCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public void addProductCategoryService(ProductCategory productCategory) {
		productCategory.setLastModifiedDate(new Date());
		productCategoryRepository.save(productCategory);

	}

	@Override
	public ProductCategory getProductCategoryService(int id) {
		return productCategoryRepository.findOne(id);
	}

	@Override
	public List<ProductCategory> getAllProductCategoryService() {
		List<ProductCategory> productCategories = new ArrayList<>();
		productCategoryRepository.findAll().forEach(productCategories::add);
		return productCategories;
	}

	@Override
	public void updateProductCategoryService(ProductCategory productCategory) {
		ProductCategory updated = new ProductCategory();
		updated = productCategoryRepository.findOne(productCategory.getId());
		if (updated != null) {
			productCategoryRepository.delete(productCategory.getId());
			productCategory.setLastModifiedDate(new Date());
			productCategoryRepository.save(productCategory);
		} else {
			productCategory.setLastModifiedDate(new Date());
			productCategoryRepository.save(productCategory);
		}

	}

	@Override
	public void deleteProductCategoryService(ProductCategory productCategory) {
		productCategoryRepository.delete(productCategory);
	}

	@Override
	public ProductCategory getProductCategoryByNameService(String name) {
		return productCategoryRepository.findByName(name);
	}

}
