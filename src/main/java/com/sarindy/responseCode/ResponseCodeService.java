package com.sarindy.responseCode;

public interface ResponseCodeService {

	public void addResponseCode(String code, String description);

	public void updateResponseCode(String oldCode, String newCode, String newDescription,int modifiedBy);

	public void deleteResponseCode(String code,int modifiedBy);
	
	public String getResponseDescriptionByCode(String code);
	
	public String findByDescriptionLike(String description);

}
