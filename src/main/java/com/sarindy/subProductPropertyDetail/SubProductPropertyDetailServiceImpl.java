package com.sarindy.subProductPropertyDetail;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productProperty.ProductPropertyServiceImpl;
import com.sarindy.responseCode.ResponseCodeModel;

@Service
public class SubProductPropertyDetailServiceImpl implements SubProductPropertyDetailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SubProductPropertyDetailRepository subProductPropertyDetailRepository;

	@Autowired
	private ProductPropertyServiceImpl productPropertyServiceImpl;

	@Autowired
	private SubProductPropertyDetailHisRepository SubProductPropertyDetailHisRepo;

	@Autowired
	private SubProductPropertyDetail		subProductPropertyDetailModel;
	@Autowired
	private SubProductPropertyDetailHis	subProductPropertyDetailHisModel;

	@Override
	public ResponseCodeModel addSubProductPropertyDetailService(String propertyDetailName, int modifiedBy, int propertyId) {

		try {

			if (productPropertyServiceImpl.getProductPropertyService(propertyId) == null) {
				logger.info("Product Property not found.");
				return new ResponseCodeModel("002", "Product Property  not found : ", modifiedBy);
			}

			if (productPropertyDetailRepository.findByName(propertyDetailName) == null) {
				SubProductPropertyDetail productPropertyDetail = productPropertyDetailModel.productPropertyDetail();
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
	public ResponseCodeModel deleteSubProductPropertyDetailService(String propertyDetailName, int modifiedBy) {

		try {
			SubProductPropertyDetail productPropertyDetail = productPropertyDetailModel.productPropertyDetail();
			productPropertyDetail = productPropertyDetailRepository.findByName(propertyDetailName);
			if (productPropertyDetail != null) {

				SubProductPropertyDetailHis productPropertyDetailHis = productPropertyDetailHisModel.productPropertyDetailHis();
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
	public ResponseCodeModel updateSubProductPropertyDetailService(String propertyDetailName, String oldName, int modifiedBy, int propertyId) {

		try {

			if (productPropertyServiceImpl.getProductPropertyService(propertyId) == null) {
				logger.info("Product Property not found.");
				return new ResponseCodeModel("002", "Product Property  not found : ", modifiedBy);
			}

			SubProductPropertyDetail productPropertyDetail = productPropertyDetailModel.productPropertyDetail();
			productPropertyDetail = productPropertyDetailRepository.findByName(oldName);
			if (productPropertyDetail != null) {

				SubProductPropertyDetailHis productPropertyDetailHis = productPropertyDetailHisModel.productPropertyDetailHis();
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
	public List<SubProductPropertyDetail> getAllSubProductPropertyDetailService() {

		try {
			return (List<SubProductPropertyDetail>) productPropertyDetailRepository.findAll();

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
	public SubProductPropertyDetail getSubProductPropertyDetailService(int id) {

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
	public SubProductPropertyDetail getSubProductPropertyDetailServiceByNameService(String name) {

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
	public List<SubProductPropertyDetail> getSubProductPropertyDetailServiceByNameLikeService(String name) {

		try {
			return (List<SubProductPropertyDetail>) productPropertyDetailRepository.findByNameLikeOrderByNameAsc(name);

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
