package com.sarindy.productSubCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productCategory.ProductCategoryServiceImpl;
import com.sarindy.responseCode.ResponseCodeModel;

@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;

	@Autowired
	private ProductSubCategory productSubCategory;

	@Autowired
	private ProductSubCategoryHisRepository productSubCategoryHisRepository;

	@Autowired
	private ProductSubCategoryHis productSubCategoryHis;

	@Autowired
	private ProductCategoryServiceImpl productCategoryServiceImpl;

	@Override
	public ResponseCodeModel addProductSubCategoryService(String productSubCategoryName, int categoryId, int modifiedBy) {

		try {
			ProductSubCategory productSubCategoryModel = productSubCategory.productSubCategory();

			if (productCategoryServiceImpl.getProductCategoryService(categoryId) == null) {
				logger.info("product category not found : ");
				return new ResponseCodeModel("002", "Product Category Not found", 0);

			}

			// Check for existing SubCategory
			if (productSubCategoryRepository.findByName(productSubCategoryName) == null) {
				productSubCategoryModel.setProductSubCatgoryName(productSubCategoryName);
				productSubCategoryModel.setLastModifiedDate(new Date());
				productSubCategoryModel.setModifiedBy(modifiedBy);
				productSubCategoryModel.setProductCategoryId(categoryId);
				productSubCategoryRepository.save(productSubCategoryModel);
				logger.info("product sub category added. : " + productSubCategoryModel.toString());
				return new ResponseCodeModel("000", "Product Sub Category added", 0);

			} else {
				logger.info("product sub category already exist. : " + productSubCategoryModel.toString());
				return new ResponseCodeModel("001", "Product already exist", 0);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error", 0);

		}

	}

	@Override
	public ResponseCodeModel deleteProductSubCategoryService(String productSubCategoryName, int modifiedBy) {

		try {
			ProductSubCategory productSubCategoryModel = productSubCategory.productSubCategory();
			productSubCategoryModel = productSubCategoryRepository.findByName(productSubCategoryName);

			// Check for existing SubCategory
			if (productSubCategoryModel != null) {
				// move to history file
				ProductSubCategoryHis productSubCategoryHisModel = productSubCategoryHis.productSubCategoryHis();
				productSubCategoryHisModel.setProductCategoryId(productSubCategoryModel.getId());
				productSubCategoryHisModel.setProductSubCatgoryName(productSubCategoryModel.getProductSubCatgoryName());
				productSubCategoryHisModel.setLastModifiedDate(productSubCategoryModel.getLastModifiedDate());
				productSubCategoryHisModel.setModifiedBy(productSubCategoryModel.getModifiedBy());
				productSubCategoryModel.setDeleted(1);
				productSubCategoryModel.setLastModifiedDate(new Date());
				productSubCategoryModel.setModifiedBy(modifiedBy);
				productSubCategoryRepository.save(productSubCategoryModel);
				productSubCategoryHisRepository.save(productSubCategoryHisModel);
				logger.info("product sub category deleted. : " + productSubCategoryModel.toString());
				return new ResponseCodeModel("000", "Product Sub Category deleted", 0);

			} else {
				logger.info("product sub category not found");
				return new ResponseCodeModel("002", "Product Sub Category not found", 0);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error", 0);

		}

	}

	@Override
	public ResponseCodeModel updateProductSubCategoryService(String oldName, String productSubCategoryName, int categoryId, int modifiedBy) {

		try {
			ProductSubCategory productSubCategoryModel = productSubCategory.productSubCategory();
			productSubCategoryModel = productSubCategoryRepository.findByName(oldName);
			
			if (productCategoryServiceImpl.getProductCategoryService(categoryId) == null) {
				logger.info("product category not found : ");
				return new ResponseCodeModel("002", "Product Category Not found", 0);

			}

			// Check for existing SubCategory
			if (productSubCategoryModel != null) {
				// move to history file
				ProductSubCategoryHis productSubCategoryHisModel = productSubCategoryHis.productSubCategoryHis();
				productSubCategoryHisModel.setProductCategoryId(productSubCategoryModel.getId());
				productSubCategoryHisModel.setProductSubCatgoryName(productSubCategoryModel.getProductSubCatgoryName());
				productSubCategoryHisModel.setLastModifiedDate(productSubCategoryModel.getLastModifiedDate());
				productSubCategoryHisModel.setModifiedBy(productSubCategoryModel.getModifiedBy());
				productSubCategoryHisModel.setProductCategoryId(productSubCategoryModel.getProductCategoryId());

				productSubCategoryModel.setProductSubCatgoryName(productSubCategoryName);;
				productSubCategoryModel.setLastModifiedDate(new Date());
				productSubCategoryModel.setModifiedBy(modifiedBy);
				productSubCategoryRepository.save(productSubCategoryModel);
				productSubCategoryHisRepository.save(productSubCategoryHisModel);
				logger.info("product sub category deleted. : " + productSubCategoryModel.toString());
				return new ResponseCodeModel("000", "Product Sub Category updated", 0);

			} else {
				logger.info("product sub category not found");
				return new ResponseCodeModel("002", "Product Sub Category not found", 0);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error", 0);

		}
	}

	@Override
	public List<ProductSubCategory> getAllProductSubCategoryService() {

		try {
			List<ProductSubCategory> productSubCategories = new ArrayList<>();
			productSubCategoryRepository.findAll().forEach(productSubCategories::add);
			logger.info("Get a List of Product Sub Category");
			return productSubCategories;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	@Override
	public ProductSubCategory getProductSubCategoryService(int id) {

		try {
			logger.info("Get Product Sub Category");
			return productSubCategoryRepository.findOne(id);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;

		}
	}

	@Override
	public ProductSubCategory getProductSubCategoryByNameService(String name) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductSubCategory> getProductSubCategoryByNameLikeService(String containing_name) {

		try {
			List<ProductSubCategory> productSubCategories = new ArrayList<>();
			productSubCategoryRepository.findByNameLikeOrderByNameAsc(containing_name).forEach(productSubCategories::add);
			return productSubCategories;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

}
