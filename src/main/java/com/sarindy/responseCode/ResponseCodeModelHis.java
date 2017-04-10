package com.sarindy.responseCode;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="response_code_His")
public class ResponseCodeModelHis {
	
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

	public ResponseCodeModelHis() {
		
	}

	public ResponseCodeModelHis(String code, String description, int lastModifiedBy) {
		this.code = code;
		this.description = description;
		this.lastModifiedBy = lastModifiedBy;
	}

}
