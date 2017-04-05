package com.sarindy.productSubCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;

	@Override
	public void addProductSubCategoryService(ProductSubCategory productSubCategory) {
		productSubCategory.setLastModifiedDate(new Date());
		productSubCategoryRepository.save(productSubCategory);

	}

	@Override
	public void deleteProductSubCategoryService(ProductSubCategory productSubCategory) {
		productSubCategoryRepository.delete(productSubCategory);

	}

	@Override
	public void updateProductSubCategoryService(ProductSubCategory productSubCategory) {
		productSubCategory.setLastModifiedDate(new Date());
		productSubCategoryRepository.save(productSubCategory);
	}

	@Override
	public List<ProductSubCategory> getAllProductSubCategoryService() {
		List<ProductSubCategory> productSubCategories = new ArrayList<>();
		productSubCategoryRepository.findAll().forEach(productSubCategories::add);
		return productSubCategories;
	}

	@Override
	public ProductSubCategory getProductSubCategoryService(int id) {
		return productSubCategoryRepository.findOne(id);
	}

	@Override
	public ProductSubCategory getProductSubCategoryByNameService(String name) {
		return productSubCategoryRepository.findByNameOrderByNameAsc(name);
	}

	@Override
	public List<ProductSubCategory> getProductSubCategoryByNameLikeService(String containing_name) {

		List<ProductSubCategory> productSubCategories = new ArrayList<>();

		productSubCategoryRepository.findByNameLikeOrderByNameAsc("%" + containing_name + "%")
				.forEach(productSubCategories::add);
		
		return productSubCategories;

	}

}
