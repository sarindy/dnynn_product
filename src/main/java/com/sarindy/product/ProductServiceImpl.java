package com.sarindy.product;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProductService(Product product) {
		product.setLastModifiedDate(new Date());
		productRepository.save(product);

	}

	@Override
	public void deleteProductService(Product product) {
		productRepository.delete(product);

	}

	@Override
	public void updateProductService(Product product) {
		product.setLastModifiedDate(new Date());
		productRepository.save(product);

	}

	@Override
	public List<Product> getAllProductService() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProductService(long id) {
		return productRepository.findOne(id);
	}

	@Override
	public Product getProductServiceByNameService(String name) {

		return productRepository.findByNameOrderByNameAsc(name);
	}

	@Override
	public List<Product> getProductServiceByNameLikeService(String name) {

		return (List<Product>) productRepository.findByNameLikeOrderByNameAsc(name);
	}

}
