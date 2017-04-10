package com.sarindy.responseCode;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Entity
@Table(name="response_code",uniqueConstraints=@UniqueConstraint(columnNames={"response_code"}))
@Component
public class ResponseCodeModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="response_code_id")
	private int id;
	
	@Column(name="response_code")
	private String code;
	
	@Column(name="response_description")
	private String description;
	
	@Column(name="last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name="modeified_by")
	private int lastModifiedBy;
	
	@Column(name="deleted")
	private int deleted=0;

	@Override
	public String toString() {
		return "ReponseCodeModel [id=" + id + ", code=" + code + ", description=" + description + ", lastModifiedDate="
				+ lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy + ", deleted=" + deleted + "]";
	}

	public ResponseCodeModel() {
		
		
	}

	public ResponseCodeModel(String code, String description, int lastModifiedBy) {
		this.code = code;
		this.description = description;
		this.lastModifiedBy = lastModifiedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	
	public ResponseCodeModel responseCodeModel(){
		return new ResponseCodeModel();
	}
	
	

}
