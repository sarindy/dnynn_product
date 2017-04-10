package com.sarindy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

	@Autowired
	private TestBean testBean;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//testBean.addCategory("Phone");
		//testBean.addCategory("Computer");
		//testBean.addCategory("Cosmetic");
		//testBean.updateProductCategory("new Phone", "phone");
		//testBean.deleteProductCategory("phone");
		//testBean.addProductSubCategory("Mobile Phone Accessories");
		//testBean.addProductSubCategory("Power Bank");
		
		

	}
}
