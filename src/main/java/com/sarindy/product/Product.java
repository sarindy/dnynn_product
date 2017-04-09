package com.sarindy.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "last_modified_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Column(name = "sub_product_category_id")
	private int subProductCategoryId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Product() {

	}

	public Product(String name, String description, Date lastModifiedDate) {
		this.name = name;
		this.description = description;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	public int getSubProductCategoryId() {
		return subProductCategoryId;
	}

	public void setSubProductCategoryId(int subProductCategoryId) {
		this.subProductCategoryId = subProductCategoryId;
	}
	
	

}
