package com.sarindy.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void addProduct(@RequestBody Product product) {
		productServiceImpl.addProductService(product);
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void deleteProduct(@RequestBody Product product) {

		productServiceImpl.deleteProductService(product);
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void updateProduct(@RequestBody Product product) {

		productServiceImpl.updateProductService(product);
	}

	@RequestMapping(value = "/getAllProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Product> getAllProduct() {
		return productServiceImpl.getAllProductService();
	}

	@RequestMapping(value = "/getProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Product getProduct(@RequestBody Product product) {
		return productServiceImpl.getProductService(product.getId());
	}

	@RequestMapping(value = "/getProductByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Product getProductByName(@RequestBody Product product) {
		return productServiceImpl.getProductServiceByNameService(product.getName());
	}

	@RequestMapping(value = "/getProductByNameLike", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Product> getProductByNameLike(@RequestBody Product product) {
		return productServiceImpl.getProductServiceByNameLikeService(product.getName());
	}

}
