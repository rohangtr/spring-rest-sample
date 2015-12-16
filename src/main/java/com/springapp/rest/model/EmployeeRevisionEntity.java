package com.springapp.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import com.springapp.rest.service.EmployeeRevisionListener;

@Entity
@Table(name = "AUDIT_REVISION_INFO")
@RevisionEntity(EmployeeRevisionListener.class)

/**
 * @author Rohan Kushwaha
 */
public class EmployeeRevisionEntity{

	private static final long serialVersionUID = -7387549815500904487L;

	@Id
	@GeneratedValue
	@RevisionNumber
	private int id;

	@RevisionTimestamp
	private long timestamp;

	@Column(name = "user_id")
	private String userId;

	public String getAuditor() {
		return userId;
	}

	public void setAuditor(String userId) {
		this.userId = userId;
	}
}
