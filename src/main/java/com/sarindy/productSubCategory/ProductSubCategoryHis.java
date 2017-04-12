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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "product_sub_category_his")
@Component
public class ProductSubCategoryHis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "product_sub_category_id")
	private int productSubCategoryId;

	@Column(name = "product_sub_category_name")
	private String productSubCatgoryName;

	@Column(name = "last_modified_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Column(name = "product_category_id")
	private int productCategoryId;

	@Column(name = "modified_by")
	private int modifiedBy;

	@Column(name = "deleted")
	private int deleted = 0;

	public ProductSubCategoryHis() {

	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public int getProductSubCategoryId() {

		return productSubCategoryId;
	}

	public void setProductSubCategoryId(int productSubCategoryId) {

		this.productSubCategoryId = productSubCategoryId;
	}

	public String getProductSubCatgoryName() {

		return productSubCatgoryName;
	}

	public void setProductSubCatgoryName(String productSubCatgoryName) {

		this.productSubCatgoryName = productSubCatgoryName;
	}

	public Date getLastModifiedDate() {

		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {

		this.lastModifiedDate = lastModifiedDate;
	}

	public int getProductCategoryId() {

		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {

		this.productCategoryId = productCategoryId;
	}

	public int getModifiedBy() {

		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {

		this.modifiedBy = modifiedBy;
	}

	public int getDeleted() {

		return deleted;
	}

	public void setDeleted(int deleted) {

		this.deleted = deleted;
	}

	public ProductSubCategoryHis productSubCategoryHis() {

		return new ProductSubCategoryHis();
	}

}
