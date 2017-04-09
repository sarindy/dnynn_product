package com.sarindy.productCategory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product_category")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false)
	@NotEmpty(message = "Name can not blank")
	private String name;

	@Column(name = "last_modofied_date", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name="deleted")
	private String deleted="N";

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
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
	
	

	public ProductCategory(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
