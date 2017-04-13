package com.sarindy.subProductPropertyDetail;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.productPropertyDetail.ProductPropertyDetailServiceImpl;
import com.sarindy.responseCode.ResponseCodeModel;

@Service
public class SubProductPropertyDetailServiceImpl implements SubProductPropertyDetailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SubProductPropertyDetailRepository subProductPropertyDetailRepository;
	
	private ProductPropertyDetailServiceImpl productPropertyDetailServiceImpl;
	
	private SubProductPropertyDetail subProductPropertyDetailModel;
	
	private SubProductPropertyDetailHis subProductPropertyDetailHisModel;
	
	private SubProductPropertyDetailHisRepository subProductProprtyHisRepository;
	

	
	@Override
	public ResponseCodeModel addSubProductPropertyDetailService(String propertyDetailName, int modifiedBy, int propertyId) {

		try {

			if (productPropertyDetailServiceImpl.getProductPropertyDetailService(propertyId) == null) {
				logger.info("Product Property Detail not found.");
				return new ResponseCodeModel("002", "Product Property detail  not found : ", modifiedBy);
			}

			if (subProductPropertyDetailRepository.findByName(propertyDetailName) == null) {
				SubProductPropertyDetail subProductPropertyDetail = subProductPropertyDetailModel.subProductPropertyDetail();
				subProductPropertyDetail.setName(propertyDetailName);
				subProductPropertyDetail.setLastModifiedDate(new Date());
				subProductPropertyDetail.setLastModifiedBy(modifiedBy);
				subProductPropertyDetail.setProductPropertyId(propertyId);

				subProductPropertyDetailRepository.save(subProductPropertyDetail);
				logger.info("Sub Product Property Detail Added.");
				return new ResponseCodeModel("000", "Sub Product Property Detail Added : " + subProductPropertyDetail.toString(), modifiedBy);

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
			SubProductPropertyDetail productPropertyDetail = subProductPropertyDetailModel.subProductPropertyDetail();
			productPropertyDetail = subProductPropertyDetailRepository.findByName(propertyDetailName);
			if (productPropertyDetail != null) {

				SubProductPropertyDetailHis productPropertyDetailHis = subProductPropertyDetailHisModel.subProductPropertyDetailHis();
				productPropertyDetailHis.setName(productPropertyDetail.getName());
				productPropertyDetailHis.setLastModifiedDate(productPropertyDetail.getLastModifiedDate());
				productPropertyDetailHis.setLastModifiedBy(productPropertyDetail.getLastModifiedBy());
				productPropertyDetailHis.setProductPropertyId(productPropertyDetail.getProductPropertyId());
				productPropertyDetailHis.setProductPropertyDetailHisId(productPropertyDetail.getId());

				productPropertyDetail.setDeleted(1);
				productPropertyDetail.setLastModifiedDate(new Date());
				productPropertyDetail.setLastModifiedBy(modifiedBy);
				subProductPropertyDetailRepository.save(productPropertyDetail);
				subProductProprtyHisRepository.save(productPropertyDetailHis);
				logger.info("Sub Product Property Detail deleted.");
				return new ResponseCodeModel("000", "Sub Product Property Detail deleted : " + productPropertyDetail.toString(), modifiedBy);

			}

			else {
				logger.info("Sub Product Property Detail not found.");
				return new ResponseCodeModel("002", "Sub Product Property Detail not found, named : " + propertyDetailName, modifiedBy);
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

			if (productPropertyDetailServiceImpl.getProductPropertyDetailService(propertyId) == null) {
				logger.info("Product Property detail not found.");
				return new ResponseCodeModel("002", "Product Property detail not found : ", modifiedBy);
			}

			SubProductPropertyDetail productPropertyDetail = subProductPropertyDetailModel.subProductPropertyDetail();
			productPropertyDetail = subProductPropertyDetailRepository.findByName(oldName);
			if (productPropertyDetail != null) {

				SubProductPropertyDetailHis productPropertyDetailHis = subProductPropertyDetailHisModel.subProductPropertyDetailHis();
				productPropertyDetailHis.setName(productPropertyDetail.getName());
				productPropertyDetailHis.setLastModifiedDate(productPropertyDetail.getLastModifiedDate());
				productPropertyDetailHis.setLastModifiedBy(productPropertyDetail.getLastModifiedBy());
				productPropertyDetailHis.setProductPropertyId(productPropertyDetail.getProductPropertyId());
				productPropertyDetailHis.setProductPropertyDetailHisId(productPropertyDetail.getId());

				productPropertyDetail.setName(propertyDetailName);
				productPropertyDetail.setLastModifiedDate(new Date());
				productPropertyDetail.setLastModifiedBy(modifiedBy);
				productPropertyDetail.setProductPropertyId(propertyId);

				subProductPropertyDetailRepository.save(productPropertyDetail);
				subProductProprtyHisRepository.save(productPropertyDetailHis);
				logger.info("Sub Product Property Detail update.");
				return new ResponseCodeModel("000", "Sub Product Property Detail update : " + productPropertyDetail.toString(), modifiedBy);

			}

			else {
				logger.info("Sub Product Property Detail not found.");
				return new ResponseCodeModel("002", "Sub Product Property Detail not found, named : " + propertyDetailName, modifiedBy);
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
			return (List<SubProductPropertyDetail>) subProductPropertyDetailRepository.findAll();

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
			return subProductPropertyDetailRepository.findOne(id);

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
			return subProductPropertyDetailRepository.findByName(name);

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
			return (List<SubProductPropertyDetail>) subProductPropertyDetailRepository.findByNameLikeOrderByNameAsc(name);

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
