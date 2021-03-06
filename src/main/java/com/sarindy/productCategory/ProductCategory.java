package com.sarindy.productCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "product_category", uniqueConstraints = @UniqueConstraint(columnNames = { "category_name" }))
@Component
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private int id;

	@Column(name = "category_name", nullable = false)
	@NotEmpty(message = "Name can not blank")
	private String name;

	@Column(name = "last_modofied_date", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name="deleted")
	private int deleted=0;
	
	@Column(name="modified_by")
	private int modifiedBy;

	
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

	public ProductCategory(String name, Date lastModifiedDate) {

		this.name = name;
		this.lastModifiedDate = lastModifiedDate;
	}

	public ProductCategory() {

	}


	public ProductCategory(String name, int modifiedBy) {
		
		this.name = name;
		this.modifiedBy = modifiedBy;
	}


	@Override
	public String toString() {

		return "ProductCategory [id=" + id + ", name=" + name + ", lastModifiedDate=" + lastModifiedDate + ", deleted=" + deleted + ", modifiedBy="
				+ modifiedBy + "]";
	}
	
	public ProductCategory productCategory(){
		return new ProductCategory();
	}
	
	public List<ProductCategory> productCategories(){
		return new ArrayList<ProductCategory>();
	}
	
	
	
	


	

}
