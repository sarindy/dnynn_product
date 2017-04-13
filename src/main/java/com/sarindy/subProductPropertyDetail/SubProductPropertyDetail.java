package com.sarindy.subProductPropertyDetail;

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
import org.springframework.stereotype.Component;

@Entity
@Table(name = "sub_product_property_detail", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
@Component
public class SubProductPropertyDetail {

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

	@Column(name = "product_property_detail_id")
	private int productPropertyDetailId;

	@Column(name = "last_modified_by")
	private int lastModifiedBy;

	@Column(name = "deleted")
	private int deleted = 0;

	public SubProductPropertyDetail() {

	}

	public SubProductPropertyDetail(String name, int productPropertyId, int lastModifiedBy, int deleted) {

		this.name = name;
		this.productPropertyDetailId = productPropertyId;
		this.lastModifiedBy = lastModifiedBy;
		this.deleted = deleted;
	}

	@Override
	public String toString() {

		return "ProductPropertyDetail [id=" + id + ", name=" + name + ", lastModifiedDate=" + lastModifiedDate + ", productPropertyId="
				+ productPropertyDetailId + ", lastModifiedBy=" + lastModifiedBy + ", deleted=" + deleted + "]";
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

	public int getProductPropertyId() {

		return productPropertyDetailId;
	}

	public void setProductPropertyId(int productPropertyId) {

		this.productPropertyDetailId = productPropertyId;
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

	public SubProductPropertyDetail productPropertyDetail() {

		return new SubProductPropertyDetail();
	}

}
