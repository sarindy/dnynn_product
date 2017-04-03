package com.sarindy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarindy.model.ProductSubCategory;
import com.sarindy.services.ProductSubCategoryServiceImpl;

@RestController
public class ProductSubCategoryController {

	@Autowired
	private ProductSubCategoryServiceImpl productSubCategoryServiceImpl;

	// Json Section----------------------------------------------------

	@RequestMapping(value = "/addProductSubCategoryJSON", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductSubCategory> addProductSubCategory(
			@RequestBody ProductSubCategory productSubCategory) {

		productSubCategoryServiceImpl.addProductSubCategoryService(productSubCategory);
		return new ResponseEntity<ProductSubCategory>(productSubCategory, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteProductSubCategoryJson", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductSubCategory> deleteProductSubCategory(
			@RequestBody ProductSubCategory productSubCategory) {
		productSubCategoryServiceImpl.deleteProductSubCategoryService(productSubCategory);
		return new ResponseEntity<ProductSubCategory>(productSubCategory, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateProductSubCategoryJson", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductSubCategory> updateProductSubCategory(
			@RequestBody ProductSubCategory productSubCategory) {
		productSubCategoryServiceImpl.updateProductSubCategoryService(productSubCategory);
		return new ResponseEntity<ProductSubCategory>(productSubCategory, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllProductSubCategory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductSubCategory>> getAllProductSubCategory() {

		return new ResponseEntity<List<ProductSubCategory>>(productSubCategoryServiceImpl.getAllProductSubCategoryService(),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getProductSubCategoryByIdJson/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductSubCategory> getProductSubCategoryById(@PathVariable int id) {

		return new ResponseEntity<ProductSubCategory>(productSubCategoryServiceImpl.getProductSubCategoryService(id),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getProductSubCategoryByNameJson/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductSubCategory> getProductSubCategoryByName(@PathVariable String name) {

		return new ResponseEntity<ProductSubCategory>(
				productSubCategoryServiceImpl.getProductSubCategoryByNameService(name), HttpStatus.OK);
	}

	@RequestMapping(value = "/getProductSubCategoryByNameLikeJson/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductSubCategory>> getProductSubCategoryByNameLike(@PathVariable String name) {

		return new ResponseEntity<List<ProductSubCategory>>(
				productSubCategoryServiceImpl.getProductSubCategoryByNameLikeService(name), HttpStatus.OK);
	}

	/*{
		"name":"Power Bank",
		"lastModifiedDate":"2017-01-01",
		"productCategory":{"id":1}
	}*/
	
	// --------------------------------------------------------------

}
