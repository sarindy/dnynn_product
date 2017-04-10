package com.sarindy.productCategory;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.responseCode.ResponseCodeModel;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductCategoryRepository	productCategoryRepository;
	@Autowired
	private ResponseCodeModel			responseCodeModel;

	@Autowired
	private ProductCategory productCategoryModel;
	@Autowired
	private ProductCategoryHisServiceImpl productCategoryHisServiceImpl;
	
	@Autowired
	private ProductCategoryHis productCategoryModelHis;

	@Override
	public ResponseCodeModel addProductCategoryService(String productCategoryName, int modifiedBy) {

		try {
			ResponseCodeModel responseCode = responseCodeModel.responseCodeModel();
			ProductCategory productCategory = productCategoryModel.productCategory();
			productCategory.setName(productCategoryName);
			productCategory.setLastModifiedDate(new Date());
			productCategory.setModifiedBy(modifiedBy);
			if (productCategoryRepository.findByName(productCategoryName) != null) {
				responseCode.setCode("001");
				responseCode.setDescription("Category already existed");;
				return responseCode;
			} else {

				productCategoryRepository.save(productCategory);
				responseCode.setCode("000");
				responseCode.setDescription("Category Sucessfuly Register");;
				return responseCode;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "Error", 1);
		}

	}

	@Override
	public ProductCategory getProductCategoryService(String categoryName) {

		try {

			ProductCategory productCategory = productCategoryModel.productCategory();
			productCategory.setName(categoryName);
			productCategory.setLastModifiedDate(new Date());
			productCategory.setModifiedBy(0);
			if (productCategoryRepository.findByName(categoryName) == null) {
				return null;
			} else {

				return productCategory;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<ProductCategory> getAllProductCategoryService() {

		try {
			List<ProductCategory> productCategories = productCategoryModel.productCategories();
			productCategoryRepository.findAll().forEach(productCategories::add);

			return productCategories;

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;

		}

	}

	@Override
	public ResponseCodeModel updateProductCategoryService(String productCategoryName, String oldName, int modifiedBy) {

		try {
			ResponseCodeModel responseCode = responseCodeModel.responseCodeModel();
			ProductCategory productCategory = productCategoryModel.productCategory();
			productCategory = productCategoryRepository.findByName(oldName) ;
			
			
			if (productCategory == null) {
				responseCode.setCode("002");
				responseCode.setDescription("Category not found");;
				return responseCode;
			} else {
				ProductCategoryHis productCategoryHis = productCategoryModelHis.productCategoryHis();
				productCategoryHis.setName(productCategory.getName());
				productCategoryHis.setLastModifiedDate(productCategory.getLastModifiedDate());
				productCategoryHis.setModifiedBy(productCategory.getModifiedBy());
				productCategoryHis.setCategoryId(productCategory.getId());
				productCategoryHisServiceImpl.addProductCategoryHis(productCategoryHis);
				productCategory.setName(productCategoryName);
				productCategory.setLastModifiedDate(new Date());
				productCategory.setModifiedBy(modifiedBy);

				productCategoryRepository.save(productCategory);
				responseCode.setCode("000");
				responseCode.setDescription("Category updated");;
				return responseCode;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error", 1);
		}

	}

	@Override
	public ResponseCodeModel deleteProductCategoryService(String productCategoryName, int modifiedBy) {

		try {
			ResponseCodeModel responseCode = responseCodeModel.responseCodeModel();
			ProductCategory productCategory = productCategoryModel.productCategory();
			productCategory = productCategoryRepository.findByName(productCategoryName);
			if (productCategory == null) {
				responseCode.setCode("002");
				responseCode.setDescription("Category not found");;
				return responseCode;
			} else {
				ProductCategoryHis productCategoryHis = productCategoryModelHis.productCategoryHis();
				productCategoryHis.setName(productCategory.getName());
				productCategoryHis.setLastModifiedDate(productCategory.getLastModifiedDate());
				productCategoryHis.setModifiedBy(productCategory.getModifiedBy());
				productCategoryHis.setCategoryId(productCategory.getId());
				productCategoryHisServiceImpl.addProductCategoryHis(productCategoryHis);
				productCategory.setDeleted(1);
				productCategory.setLastModifiedDate(new Date());
				productCategory.setModifiedBy(modifiedBy);
				productCategoryHis.setCategoryId(productCategory.getId());
				productCategoryRepository.save(productCategory);
				responseCode.setCode("000");
				responseCode.setDescription("Category Deleted");;
				return responseCode;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error", 1);
		}

	}

	@Override
	public ProductCategory getProductCategoryByNameService(String productCategoryName) {

		try {
			return productCategoryRepository.findByName(productCategoryName);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

}
