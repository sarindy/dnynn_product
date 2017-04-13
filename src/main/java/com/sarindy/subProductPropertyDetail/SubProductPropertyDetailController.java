package com.sarindy.subProductPropertyDetail;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubProductPropertyDetailController {

	/*@Autowired
	private ProductPropertyDetailServiceImpl productPropertyDetailServiceImpl;

	@RequestMapping(value = "/getAllProductPropertyDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductPropertyDetail>> getAllProductPropertyDetail() {
		List<ProductPropertyDetail> productPropertyDetails = new ArrayList<>();
		productPropertyDetailServiceImpl.getAllProductPropertyDetailService().forEach(productPropertyDetails::add);
		return new ResponseEntity<List<ProductPropertyDetail>>(productPropertyDetails, HttpStatus.OK);

	}

	@RequestMapping(value = "/getProductPropertyDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductPropertyDetail> getProductPropertyDetail(
			@RequestBody ProductPropertyDetail productPropertyDetail) {

		return new ResponseEntity<ProductPropertyDetail>(
				productPropertyDetailServiceImpl.getProductPropertyDetailService(productPropertyDetail.getId()),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/getProductPropertyDetailByName", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductPropertyDetail> getProductPropertyDetailByName(
			@RequestBody ProductPropertyDetail productPropertyDetail) {

		return new ResponseEntity<ProductPropertyDetail>(productPropertyDetailServiceImpl
				.getProductPropertyDetailServiceByNameService(productPropertyDetail.getName()), HttpStatus.OK);

	}

	@RequestMapping(value = "/getProductPropertyDetailByNameLike", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductPropertyDetail>> getProductPropertyDetailByNameLike(
			@RequestBody ProductPropertyDetail productPropertyDetail) {

		return new ResponseEntity<List<ProductPropertyDetail>>(productPropertyDetailServiceImpl
				.getProductPropertyDetailServiceByNameLikeService(productPropertyDetail.getName()), HttpStatus.OK);

	}

	@RequestMapping(value = "/addProductPropertyDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductPropertyDetail> addProductPropertyDetail(
			@RequestBody ProductPropertyDetail productPropertyDetail) {
		productPropertyDetailServiceImpl.addProductPropertyDetailService(productPropertyDetail);
		return new ResponseEntity<ProductPropertyDetail>(productPropertyDetail, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateProductPropertyDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductPropertyDetail> updateProductPropertyDetail(
			@RequestBody ProductPropertyDetail productPropertyDetail) {
		productPropertyDetailServiceImpl.updateProductPropertyDetailService(productPropertyDetail);
		return new ResponseEntity<ProductPropertyDetail>(productPropertyDetail, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteProductPropertyDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductPropertyDetail> deleteProductPropertyDetail(
			@RequestBody ProductPropertyDetail productPropertyDetail) {
		productPropertyDetailServiceImpl.deleteProductPropertyDetailService(productPropertyDetail);
		return new ResponseEntity<ProductPropertyDetail>(productPropertyDetail, HttpStatus.OK);

	}*/

}
