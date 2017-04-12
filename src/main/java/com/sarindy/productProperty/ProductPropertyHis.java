package com.sarindy.productProperty;

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
@Table(name = "product_property_his")
@Component
public class ProductPropertyHis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "product_property_id")
	private int productPropertyId;

	@Column(name = "name")
	private String name;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Column(name = "modified_by")
	private int modifiedBy;

	@Column(name = "product_sub_category_id")
	private int productSubCategoryId;

	@Column(name = "deleted")
	private int deleted = 0;

	public ProductPropertyHis() {

	}

	@Override
	public String toString() {

		return "ProductPropertyHis [id=" + id + ", productPropertyId=" + productPropertyId + ", name=" + name + ", lastModifiedDate="
				+ lastModifiedDate + ", modifiedBy=" + modifiedBy + ", productSubCategoryId=" + productSubCategoryId + ", deleted=" + deleted + "]";
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public int getProductPropertyId() {

		return productPropertyId;
	}

	public void setProductPropertyId(int productPropertyId) {

		this.productPropertyId = productPropertyId;
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

	public int getModifiedBy() {

		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {

		this.modifiedBy = modifiedBy;
	}

	public int getProductSubCategoryId() {

		return productSubCategoryId;
	}

	public void setProductSubCategoryId(int productSubCategoryId) {

		this.productSubCategoryId = productSubCategoryId;
	}

	public int getDeleted() {

		return deleted;
	}

	public void setDeleted(int deleted) {

		this.deleted = deleted;
	}

	public ProductPropertyHis productPropertyHis() {

		return new ProductPropertyHis();
	}

}
