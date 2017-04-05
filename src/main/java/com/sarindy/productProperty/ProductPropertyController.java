package com.sarindy.productProperty;

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

@RestController
public class ProductPropertyController {

	@Autowired
	private ProductPropertyServiceImpl productPropertyServiceImpl;

	@RequestMapping(value = "/addProductPropertyJSON", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductProperty> addProductProperty(@RequestBody ProductProperty productProperty) {
		productPropertyServiceImpl.addProductPropertyService(productProperty);
		return new ResponseEntity<ProductProperty>(productProperty, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteProductPropertyJSON", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductProperty> deleteProductProperty(@RequestBody ProductProperty productProperty) {
		productPropertyServiceImpl.deleteProductPropertyService(productProperty);
		return new ResponseEntity<ProductProperty>(productProperty, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateProductPropertyJSON", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductProperty> updateProductProperty(@RequestBody ProductProperty productProperty) {
		productPropertyServiceImpl.updateProductPropertyService(productProperty);
		return new ResponseEntity<ProductProperty>(productProperty, HttpStatus.OK);

	}

	@RequestMapping(value = "/getAllProductPropertyJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductProperty>> getAllProductProperty() {
		return new ResponseEntity<List<ProductProperty>>(productPropertyServiceImpl.getAllProductPropertyService(),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/getProductPropertyByIdJson/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductProperty> getProductPropertyById(@PathVariable int id) {

		return new ResponseEntity<ProductProperty>(productPropertyServiceImpl.getProductPropertyService(id),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getProductPropertyByNameJson/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductProperty> getProductPropertyByName(@PathVariable String name) {

		return new ResponseEntity<ProductProperty>(productPropertyServiceImpl.getProductPropertyByNameService(name),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getProductPropertyByNameLikeJson/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductProperty>> getProductPropertyByNameLike(@PathVariable String name) {

		return new ResponseEntity<List<ProductProperty>>(
				productPropertyServiceImpl.getProductPropertyByNameLikeService(name), HttpStatus.OK);
	}

	/*
	 * { "name":"Power Bank", "lastModifiedDate":"2017-01-01",
	 * "productCategory":{"id":1} }
	 */

}
