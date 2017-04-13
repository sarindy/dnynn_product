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

		// testBean.addCategory("Phone and Communication");
		// testBean.addSubCategory("Mobile Phone", 1, 0);

		/*
		 * List<String> myList = new ArrayList<String>(); myList.add("Feature");
		 * myList.add("Language"); myList.add("Color"); myList.add("Design");
		 * myList.add("Cellular");
		 * 
		 * testBean.addProductProperties(myList, 1, 1);
		 */
		
		
		/*List<String> myList = new ArrayList<String>();
		myList.add("2G");
		myList.add("3G");
		myList.add("4G");
		testBean.addPropertyDetails(myList, 0, 5);*/
		
		

		//testBean.addSubProductPropertyDetail("LTE band 1(2100), 2(1900), 3(1800), 4(1700/2100), 5(850), 7(2600), 8(900), 17(700), 20(800), 28(700)", 0, 3);
	}
}
