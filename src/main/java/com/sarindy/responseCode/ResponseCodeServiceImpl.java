package com.sarindy.responseCode;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseCodeServiceImpl implements ResponseCodeService {

	@Autowired
	private ResponseCodeRepository responseCodeRepository;

	@Autowired
	private ResponseCodeModel responseCodeModel;

	@Override
	public void addResponseCode(String code, String description) {
		ResponseCodeModel responseCode = responseCodeModel.responseCodeModel();
		if (responseCodeRepository.findByCode(code) == null) {
			responseCode.setCode(code);
			responseCode.setDescription(description);
			responseCode.setLastModifiedDate(new Date());
			responseCode.setLastModifiedBy(999);
			responseCodeRepository.save(responseCode);
		}

	}

	@Override
	public void updateResponseCode(String oldCode, String newCode, String newDescription,int modifiedBy) {
		ResponseCodeModel responseCode = responseCodeModel.responseCodeModel();
		if (responseCodeRepository.findByCode(oldCode) != null) {
			responseCode.setCode(newCode);
			responseCode.setDescription(newDescription);
			responseCode.setLastModifiedDate(new Date());
			responseCode.setLastModifiedBy(modifiedBy);
			responseCodeRepository.save(responseCode);
		}

	}

	@Override
	public void deleteResponseCode(String code,int modifiedBy) {
		ResponseCodeModel responseCode = responseCodeModel.responseCodeModel();
		if (responseCodeRepository.findByCode(code) != null) {
			responseCode.setDeleted(1);
			responseCode.setLastModifiedDate(new Date());
			responseCode.setLastModifiedBy(modifiedBy);
			responseCodeRepository.save(responseCode);
		}

	}

	@Override
	public String getResponseDescriptionByCode(String code) {
		ResponseCodeModel responseCode = responseCodeModel.responseCodeModel();
		responseCode=responseCodeRepository.findByCode(code);
		if (responseCode != null){
			return responseCode.getDescription();
		}
		return "Response Code not found";
	}

	@Override
	public String findByDescriptionLike(String description) {
		// TODO Auto-generated method stub
		return null;
	}

}
