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
import org.springframework.stereotype.Component;

@Entity
@Table(name = "product_category_his")
@Component
public class ProductCategoryHis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name", nullable = false)
	@NotEmpty(message = "Name can not blank")
	private String name;

	@Column(name = "last_modofied_date", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Column(name = "deleted")
	private int deleted = 0;

	@Column(name = "modified_by")
	private int modifiedBy;

	public int getCategoryId() {

		return categoryId;
	}

	public void setCategoryId(int categoryId) {

		this.categoryId = categoryId;
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

	public ProductCategoryHis(String name, Date lastModifiedDate) {

		this.name = name;
		this.lastModifiedDate = lastModifiedDate;
	}

	public ProductCategoryHis() {

	}

	public ProductCategoryHis(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return "ProductCategory [id=" + id + ", name=" + name + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	public ProductCategoryHis productCategoryHis() {

		return new ProductCategoryHis();
	}

}
