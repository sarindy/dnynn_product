package com.sarindy.productPropertyDetail;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productProperty.ProductPropertyServiceImpl;
import com.sarindy.responseCode.ResponseCodeModel;

@Service
public class ProductPropertyDetailServiceImpl implements ProductPropertyDetailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductPropertyDetailRepository productPropertyDetailRepository;

	@Autowired
	private ProductPropertyServiceImpl productPropertyServiceImpl;

	@Autowired
	private ProductPropertyDetailHisRepository productPropertyDetailHisRepo;

	@Autowired
	private ProductPropertyDetail		productPropertyDetailModel;
	@Autowired
	private ProductPropertyDetailHis	productPropertyDetailHisModel;

	@Override
	public ResponseCodeModel addProductPropertyDetailService(String propertyDetailName, int modifiedBy, int propertyId) {

		try {

			if (productPropertyServiceImpl.getProductPropertyService(propertyId) == null) {
				logger.info("Product Property not found.");
				return new ResponseCodeModel("002", "Product Property  not found : ", modifiedBy);
			}

			if (productPropertyDetailRepository.findByName(propertyDetailName) == null) {
				ProductPropertyDetail productPropertyDetail = productPropertyDetailModel.productPropertyDetail();
				productPropertyDetail.setName(propertyDetailName);
				productPropertyDetail.setLastModifiedDate(new Date());
				productPropertyDetail.setLastModifiedBy(modifiedBy);
				productPropertyDetail.setProductPropertyId(propertyId);

				productPropertyDetailRepository.save(productPropertyDetail);
				logger.info("Product Property Detail Added.");
				return new ResponseCodeModel("000", "Product Property Detail Added : " + productPropertyDetail.toString(), modifiedBy);

			}

			else {
				logger.info("Product Property Detail already exist.");
				return new ResponseCodeModel("001", "Product Property Detail already exist named : " + propertyDetailName, modifiedBy);
			}

		} catch (Exception e) {
			logger.error(e.toString() + " " + e.getMessage());
			StackTraceElement[] elements = e.getStackTrace();
			String err = null;
			err = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName() + " Line Number:"
					+ elements[0].getLineNumber();
			logger.error(err);
			return new ResponseCodeModel("999", "System Error : " + e.getMessage(), modifiedBy);
		}

	}

	@Override
	public ResponseCodeModel deleteProductPropertyDetailService(String propertyDetailName, int modifiedBy) {

		try {
			ProductPropertyDetail productPropertyDetail = productPropertyDetailModel.productPropertyDetail();
			productPropertyDetail = productPropertyDetailRepository.findByName(propertyDetailName);
			if (productPropertyDetail != null) {

				ProductPropertyDetailHis productPropertyDetailHis = productPropertyDetailHisModel.productPropertyDetailHis();
				productPropertyDetailHis.setName(productPropertyDetail.getName());
				productPropertyDetailHis.setLastModifiedDate(productPropertyDetail.getLastModifiedDate());
				productPropertyDetailHis.setLastModifiedBy(productPropertyDetail.getLastModifiedBy());
				productPropertyDetailHis.setProductPropertyId(productPropertyDetail.getProductPropertyId());
				productPropertyDetailHis.setProductPropertyDetailHisId(productPropertyDetail.getId());

				productPropertyDetail.setDeleted(1);
				productPropertyDetail.setLastModifiedDate(new Date());
				productPropertyDetail.setLastModifiedBy(modifiedBy);
				productPropertyDetailRepository.save(productPropertyDetail);
				productPropertyDetailHisRepo.save(productPropertyDetailHis);
				logger.info("Product Property Detail deleted.");
				return new ResponseCodeModel("000", "Product Property Detail deleted : " + productPropertyDetail.toString(), modifiedBy);

			}

			else {
				logger.info("Product Property Detail not found.");
				return new ResponseCodeModel("002", "Product Property Detail not found, named : " + propertyDetailName, modifiedBy);
			}

		} catch (Exception e) {
			logger.error(e.toString() + " " + e.getMessage());
			StackTraceElement[] elements = e.getStackTrace();
			String err = null;
			err = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName() + " Line Number:"
					+ elements[0].getLineNumber();
			logger.error(err);
			return new ResponseCodeModel("999", "System Error : " + e.getMessage(), modifiedBy);
		}
	}

	@Override
	public ResponseCodeModel updateProductPropertyDetailService(String propertyDetailName, String oldName, int modifiedBy, int propertyId) {

		try {

			if (productPropertyServiceImpl.getProductPropertyService(propertyId) == null) {
				logger.info("Product Property not found.");
				return new ResponseCodeModel("002", "Product Property  not found : ", modifiedBy);
			}

			ProductPropertyDetail productPropertyDetail = productPropertyDetailModel.productPropertyDetail();
			productPropertyDetail = productPropertyDetailRepository.findByName(oldName);
			if (productPropertyDetail != null) {

				ProductPropertyDetailHis productPropertyDetailHis = productPropertyDetailHisModel.productPropertyDetailHis();
				productPropertyDetailHis.setName(productPropertyDetail.getName());
				productPropertyDetailHis.setLastModifiedDate(productPropertyDetail.getLastModifiedDate());
				productPropertyDetailHis.setLastModifiedBy(productPropertyDetail.getLastModifiedBy());
				productPropertyDetailHis.setProductPropertyId(productPropertyDetail.getProductPropertyId());
				productPropertyDetailHis.setProductPropertyDetailHisId(productPropertyDetail.getId());

				productPropertyDetail.setName(propertyDetailName);
				productPropertyDetail.setLastModifiedDate(new Date());
				productPropertyDetail.setLastModifiedBy(modifiedBy);
				productPropertyDetail.setProductPropertyId(propertyId);

				productPropertyDetailRepository.save(productPropertyDetail);
				productPropertyDetailHisRepo.save(productPropertyDetailHis);
				logger.info("Product Property Detail update.");
				return new ResponseCodeModel("000", "Product Property Detail update : " + productPropertyDetail.toString(), modifiedBy);

			}

			else {
				logger.info("Product Property Detail not found.");
				return new ResponseCodeModel("002", "Product Property Detail not found, named : " + propertyDetailName, modifiedBy);
			}

		} catch (Exception e) {
			logger.error(e.toString() + " " + e.getMessage());
			StackTraceElement[] elements = e.getStackTrace();
			String err = null;
			err = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName() + " Line Number:"
					+ elements[0].getLineNumber();
			logger.error(err);
			return new ResponseCodeModel("999", "System Error : " + e.getMessage(), modifiedBy);
		}
	}

	@Override
	public List<ProductPropertyDetail> getAllProductPropertyDetailService() {

		try {
			return (List<ProductPropertyDetail>) productPropertyDetailRepository.findAll();

		} catch (Exception e) {
			logger.error(e.toString() + " " + e.getMessage());
			StackTraceElement[] elements = e.getStackTrace();
			String err = null;
			err = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName() + " Line Number:"
					+ elements[0].getLineNumber();
			logger.error(err);
			return null;
		}
	}

	@Override
	public ProductPropertyDetail getProductPropertyDetailService(int id) {

		try {
			return productPropertyDetailRepository.findOne(id);

		} catch (Exception e) {
			logger.error(e.toString() + " " + e.getMessage());
			StackTraceElement[] elements = e.getStackTrace();
			String err = null;
			err = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName() + " Line Number:"
					+ elements[0].getLineNumber();
			logger.error(err);
			return null;
		}
	}

	@Override
	public ProductPropertyDetail getProductPropertyDetailServiceByNameService(String name) {

		try {
			return productPropertyDetailRepository.findByName(name);

		} catch (Exception e) {
			logger.error(e.toString() + " " + e.getMessage());
			StackTraceElement[] elements = e.getStackTrace();
			String err = null;
			err = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName() + " Line Number:"
					+ elements[0].getLineNumber();
			logger.error(err);
			return null;
		}
	}

	@Override
	public List<ProductPropertyDetail> getProductPropertyDetailServiceByNameLikeService(String name) {

		try {
			return (List<ProductPropertyDetail>) productPropertyDetailRepository.findByNameLikeOrderByNameAsc(name);

		} catch (Exception e) {
			logger.error(e.toString() + " " + e.getMessage());
			StackTraceElement[] elements = e.getStackTrace();
			String err = null;
			err = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName() + " Line Number:"
					+ elements[0].getLineNumber();
			logger.error(err);
			return null;
		}
	}

}
