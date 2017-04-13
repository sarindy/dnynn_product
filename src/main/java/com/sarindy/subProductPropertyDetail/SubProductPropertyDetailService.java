package com.sarindy.subProductPropertyDetail;

import java.util.List;

import com.sarindy.responseCode.ResponseCodeModel;

public interface SubProductPropertyDetailService {

	public ResponseCodeModel addSubProductPropertyDetailService(String subPropertyDetailName, int modifiedBy, int propertyDetailId);

	public ResponseCodeModel deleteSubProductPropertyDetailService(String SubPropertyDetailName, int modifiedBy);

	public ResponseCodeModel updateSubProductPropertyDetailService(String SubPropertyDetailName, String oldName, int modifiedBy, int propertyDetailId);

	public List<SubProductPropertyDetail> getAllSubProductPropertyDetailService();

	public SubProductPropertyDetail getSubProductPropertyDetailService(int id);

	public SubProductPropertyDetail getSubProductPropertyDetailServiceByNameService(String name);

	public List<SubProductPropertyDetail> getSubProductPropertyDetailServiceByNameLikeService(String name);

}
