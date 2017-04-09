package com.sarindy.productSubCategory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product_sub_category", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class ProductSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "last_modified_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Column(name = "product_category_id")
	private int productCategoryId;

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

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

	public ProductSubCategory() {
	}

	@Override
	public String toString() {
		return "ProductSubCategory [id=" + id + ", name=" + name + ", lastModifiedDate=" + lastModifiedDate + ", productCategoryId="
				+ productCategoryId + "]";
	}

}
