package com.sarindy.productSubCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productCategory.ProductCategory;
import com.sarindy.productCategory.ProductCategoryRepository;

@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepoi;

	/*@Override
	public boolean addProductSubCategoryService(ProductSubCategory productSubCategory,String productCategoryName) {

		productSubCategory.setLastModifiedDate(new Date());
		ProductCategory productCategory = new ProductCategory();
		productCategory = productCategoryRepoi.findByName(productCategoryName);
		if (productCategory== null){
			return false;
		}

		if (productCategoryRepoi.findOne(productSubCategory.getName() != null) {
			productSubCategory.setProductCategoryId(productCategory.getId());
			productSubCategoryRepository.save(productSubCategory);
			return true;
		}

		return false;

	}*/

	@Override
	public boolean deleteProductSubCategoryService(ProductSubCategory productSubCategory) {

		productSubCategory.setDeleted("Y");
		productSubCategory.setLastModifiedDate(new Date());
		productSubCategoryRepository.save(productSubCategory);
		return true;

	}

	@Override
	public boolean updateProductSubCategoryService(ProductSubCategory productSubCategory) {

		productSubCategory.setLastModifiedDate(new Date());
		productSubCategoryRepository.save(productSubCategory);
		return true;

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

	@Override
	public boolean addProductSubCategoryService(ProductSubCategory productSubCategory, String productCategoryName) {

		// TODO Auto-generated method stub
		return false;
	}

}
