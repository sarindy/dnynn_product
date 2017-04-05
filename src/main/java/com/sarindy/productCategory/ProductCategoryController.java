package com.sarindy.productCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;

	@RequestMapping(value = "/addProductCategory", method = RequestMethod.GET)
	public ModelAndView addProductCategory() {
		ModelAndView modelAndView = new ModelAndView();
		ProductCategory productCategory = new ProductCategory();
		modelAndView.addObject("productCategory", productCategory);
		modelAndView.setViewName("/productCategory/productCategory");

		return modelAndView;

	}

	/*@RequestMapping(value = "/addProductCategory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView addProductCategory(@Valid @RequestBody ProductCategory productCategory, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/user/products/addProductCategory");
			System.out.println("has Error" + bindingResult.toString());
		} else {
			productCategoryService.addProductCategoryService(productCategory);
			modelAndView.addObject("productCategory", productCategory);
			modelAndView.addObject("successMessage", "Success!!");
			modelAndView.setViewName("/productCategory/productCategory");
		}

		return modelAndView;

	}*/

	@RequestMapping(value = "/addProductCategoryJSON", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductCategory> addProductCategory(@RequestBody ProductCategory productCategory) {
		
		productCategoryService.addProductCategoryService(productCategory);
		return new ResponseEntity<ProductCategory>(productCategory, HttpStatus.OK);

	}
	
	

}
