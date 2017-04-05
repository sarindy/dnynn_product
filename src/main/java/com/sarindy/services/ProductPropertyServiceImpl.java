package com.sarindy.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarindy.model.ProductProperty;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

	@Autowired
	private ProductPropertyRepository productPropertyRepository;

	@Override
	public void addProductPropertyService(ProductProperty productProperty) {
		productProperty.setLastModifiedDate(new Date());
		productPropertyRepository.save(productProperty);

	}

	@Override
	public void deleteProductPropertyService(ProductProperty productProperty) {
		productPropertyRepository.delete(productProperty);

	}

	@Override
	public void updateProductPropertyService(ProductProperty productProperty) {
		productProperty.setLastModifiedDate(new Date());
		productPropertyRepository.save(productProperty);
	}

	@Override
	public List<ProductProperty> getAllProductPropertyService() {
		List<ProductProperty> productProperties = new ArrayList<>();
		productPropertyRepository.findAll().forEach(productProperties::add);
		return productProperties;
	}

	@Override
	public ProductProperty getProductPropertyService(int id) {
		return productPropertyRepository.findOne(id);
	}

	@Override
	public ProductProperty getProductPropertyByNameService(String name) {		
		return productPropertyRepository.findByNameOrderByNameAsc(name);
	}

	@Override
	public List<ProductProperty> getProductPropertyByNameLikeService(String containing_name) {
		List<ProductProperty> productProperties = new ArrayList<>();
		productPropertyRepository.findByNameLikeOrderByNameAsc(containing_name).forEach(productProperties::add);
		return productProperties;
	}

}
