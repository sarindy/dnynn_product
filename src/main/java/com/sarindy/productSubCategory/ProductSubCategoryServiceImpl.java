package com.sarindy.productSubCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productCategory.ProductCategoryRepository;

@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepoi;

	@Override
	public boolean addProductSubCategoryService(ProductSubCategory productSubCategory) {
		productSubCategory.setLastModifiedDate(new Date());

		// Check Category Id
		if (productCategoryRepoi.findOne(productSubCategory.getProductCategoryId()) != null) {
			productSubCategoryRepository.save(productSubCategory);
			return true;
		}

		return false;

	}

	@Override
	public boolean deleteProductSubCategoryService(ProductSubCategory productSubCategory) {
		productSubCategoryRepository.delete(productSubCategory);
		return true;

	}

	@Override
	public boolean updateProductSubCategoryService(ProductSubCategory productSubCategory) {
		productSubCategory.setLastModifiedDate(new Date());
		productSubCategoryRepository.save(productSubCategory);
		return true;
		
		//TODO Test Update one with Create New Object and another one based on the inquiry object

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

		productSubCategoryRepository.findByNameLikeOrderByNameAsc("%" + containing_name + "%").forEach(productSubCategories::add);

		return productSubCategories;

	}

}
