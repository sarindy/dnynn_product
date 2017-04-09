package com.sarindy.productCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public boolean addProductCategoryService(ProductCategory productCategory) {
		try {
			productCategory.setLastModifiedDate(new Date());
			if (productCategoryRepository.findByName(productCategory.getName()) == null) {
				productCategoryRepository.save(productCategory);
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}

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
	public boolean updateProductCategoryService(ProductCategory productCategory) {

		productCategoryRepository.save(productCategory);
		return true;
	}

	@Override
	public boolean deleteProductCategoryService(ProductCategory productCategory) {
		productCategory.setDeleted("Y");
		productCategory.setLastModifiedDate(new Date());
		productCategoryRepository.save(productCategory);
		return true;
	}

	@Override
	public ProductCategory getProductCategoryByNameService(String name) {
		return productCategoryRepository.findByName(name);
	}

}
