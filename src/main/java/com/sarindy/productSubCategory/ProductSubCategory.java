package com.sarindy.productSubCategory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.sarindy.productCategory.ProductCategory;

@Entity
@Table(name="product_sub_category",uniqueConstraints=@UniqueConstraint(columnNames={"name"}))
public class ProductSubCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_modified_date")
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@ManyToOne
	@JoinColumn(name="product_category_id")
	private ProductCategory productCategory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public ProductSubCategory() {
	}

	public ProductSubCategory(String name, Date lastModifiedDate, ProductCategory productCategory) {
		
		this.name = name;
		this.lastModifiedDate = lastModifiedDate;
		this.productCategory = productCategory;
	}
	
	
	
	
	

}
