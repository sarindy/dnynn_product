package com.sarindy.productPropertyDetail;

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
@Table(name = "product_property_detail_his")
@Component
public class ProductPropertyDetailHis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "product_property_detail_his_id")
	private int productPropertyDetailHisId;

	@Column(name = "name")
	private String name;

	@Column(name = "last_modified_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Column(name = "product_property_id")
	private int productPropertyId;

	@Column(name = "last_modified_by")
	private int lastModifiedBy;

	@Column(name = "deleted")
	private int deleted = 0;

	public ProductPropertyDetailHis() {

	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public int getProductPropertyDetailHisId() {

		return productPropertyDetailHisId;
	}

	public void setProductPropertyDetailHisId(int productPropertyDetailHisId) {

		this.productPropertyDetailHisId = productPropertyDetailHisId;
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

	public int getProductPropertyId() {

		return productPropertyId;
	}

	public void setProductPropertyId(int productPropertyId) {

		this.productPropertyId = productPropertyId;
	}

	public int getLastModifiedBy() {

		return lastModifiedBy;
	}

	public void setLastModifiedBy(int lastModifiedBy) {

		this.lastModifiedBy = lastModifiedBy;
	}

	public int getDeleted() {

		return deleted;
	}

	public void setDeleted(int deleted) {

		this.deleted = deleted;
	}
	
	public ProductPropertyDetailHis productPropertyDetailHis(){
		return new ProductPropertyDetailHis();
	}

}
