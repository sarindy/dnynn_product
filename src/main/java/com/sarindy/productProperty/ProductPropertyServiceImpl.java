package com.sarindy.productProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productSubCategory.ProductSubCategoryServiceImpl;
import com.sarindy.responseCode.ResponseCodeModel;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductPropertyRepository productPropertyRepository;

	@Autowired
	private ProductProperty productPropertyModel;

	@Autowired
	private ProductPropertyHis productPropertyHisModel;

	@Autowired
	private ProductPropertyHisRepository productPropertyHisRepository;

	@Autowired
	private ProductSubCategoryServiceImpl productSubCategoryServiceImpl;

	@Override
	public ResponseCodeModel addProductPropertyService(String name, int modifiedBy, int productSubCategoryId) {

		try {

			if (productSubCategoryServiceImpl.getProductSubCategoryService(productSubCategoryId) == null) {
				logger.info("Product Sub Category not found : " + productSubCategoryId);
				return new ResponseCodeModel("002", "Product Sub Category not found", modifiedBy);
			}

			ProductProperty productProperty = productPropertyModel.productProperty();

			
			if (productPropertyRepository.findByName(name) == null) {
				productProperty.setLastModifiedDate(new Date());
				productProperty.setModifiedBy(modifiedBy);
				productProperty.setProductSubCategoryId(productSubCategoryId);
				productProperty.setName(name);
				productPropertyRepository.save(productProperty);
				logger.info("Product Property added");
				return new ResponseCodeModel("000", "Product Property added", modifiedBy);

			} else {
				logger.info("Product Property already exist " + productProperty.toString());
				return new ResponseCodeModel("001", "Product Property Exist", modifiedBy);
			}

		} catch (Exception e) {

			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error", modifiedBy);
		}

	}

	@Override
	public ResponseCodeModel deleteProductPropertyService(String name, int modefiedBy) {

		try {
			ProductProperty productProperty = productPropertyModel.productProperty();
			productProperty = productPropertyRepository.findByName(name);

			if (productProperty != null) {
				ProductPropertyHis productPropertyHis = productPropertyHisModel.productPropertyHis();
				productPropertyHis.setName(productProperty.getName());
				productPropertyHis.setProductSubCategoryId(productProperty.getProductSubCategoryId());
				productPropertyHis.setProductPropertyId(productProperty.getId());
				productPropertyHis.setModifiedBy(productProperty.getModifiedBy());
				productPropertyHis.setLastModifiedDate(productProperty.getLastModifiedDate());
				productPropertyHis.setDeleted(productProperty.getDeleted());

				productProperty.setLastModifiedDate(new Date());
				productProperty.setModifiedBy(modefiedBy);
				productProperty.setDeleted(1);
				productPropertyRepository.save(productProperty);
				productPropertyHisRepository.save(productPropertyHis);
				logger.info("Product Property deleted");
				return new ResponseCodeModel("000", "Product Property deleted", modefiedBy);

			} else {
				logger.info("Product Property not found : " + name);
				return new ResponseCodeModel("002", "Product Property not found", modefiedBy);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error", modefiedBy);
		}
	}

	@Override
	public ResponseCodeModel updateProductPropertyService(String name, String oldName, int modifiedBy, int productSubCategoryId) {

		try {
			ProductProperty productProperty = productPropertyModel.productProperty();
			productProperty = productPropertyRepository.findByName(oldName);

			if (productProperty != null) {
				ProductPropertyHis productPropertyHis = productPropertyHisModel.productPropertyHis();
				productPropertyHis.setName(productProperty.getName());
				productPropertyHis.setProductSubCategoryId(productProperty.getProductSubCategoryId());
				productPropertyHis.setProductPropertyId(productProperty.getId());
				productPropertyHis.setModifiedBy(productProperty.getModifiedBy());
				productPropertyHis.setLastModifiedDate(productProperty.getLastModifiedDate());
				productPropertyHis.setDeleted(productProperty.getDeleted());

				productProperty.setLastModifiedDate(new Date());
				productProperty.setModifiedBy(modifiedBy);
				productProperty.setProductSubCategoryId(productSubCategoryId);
				productProperty.setName(name);

				productPropertyRepository.save(productProperty);
				productPropertyHisRepository.save(productPropertyHis);
				logger.info("Product Property updated");
				return new ResponseCodeModel("000", "Product Property updated", modifiedBy);

			} else {
				logger.info("Product Property not found : " + name);
				return new ResponseCodeModel("002", "Product Property not found", modifiedBy);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseCodeModel("999", "System Error", modifiedBy);
		}

	}

	@Override
	public List<ProductProperty> getAllProductPropertyService() {

		try {
			List<ProductProperty> productProperties = new ArrayList<>();
			productPropertyRepository.findAll().forEach(productProperties::add);

			return productProperties;

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	@Override
	public ProductProperty getProductPropertyService(int id) {

		try {

			return productPropertyRepository.findOne(id);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public ProductProperty getProductPropertyByNameService(String name) {

		try {

			return productPropertyRepository.findByName(name);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	@Override
	public List<ProductProperty> getProductPropertyByNameLikeService(String name) {

		try {
			List<ProductProperty> productProperties = new ArrayList<>();
			productPropertyRepository.findByNameLikeOrderByNameAsc(name).forEach(productProperties::add);

			return productProperties;

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

}
