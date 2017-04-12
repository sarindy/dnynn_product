package com.sarindy;

import java.util.ArrayList;
import java.util.List;

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

		// testBean.addCategory("");
		// testBean.addSubCategory("Mobile Phone", 5, 0);

		/*
		 * List<String> properties = new ArrayList<String>();
		 * properties.add("Dimensions");
		 * testBean.addProductProperties(properties, 1, 2);
		 */

		// testBean.updateProductProperty("Dimensions", "Dimension", 0, 2);
		// testBean.deleteProductProperty("Dimensions", 1);

		/*
		 * List<String> properties = new ArrayList<String>();
		 * properties.add("Touch Screen"); properties.add("Message");
		 * properties.add("DUst Proof"); properties.add("Email");
		 * properties.add("FM Radio"); properties.add("Front Camera");
		 * properties.add("Camera"); properties.add("Wifi");
		 * properties.add("Mp3 Player");
		 * 
		 * testBean.addPropertyDetails(properties, 0, 1);
		 */
		testBean.updatePropertyDetail();
	}
}
