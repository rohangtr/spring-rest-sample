package com.springapp.rest.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import com.springapp.rest.service.EmployeeRevisionListener;

@Entity
@RevisionEntity(EmployeeRevisionListener.class)
public class EmployeeRevisionEntity extends DefaultRevisionEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7387549815500904487L;
	@ManyToOne
	@JoinColumn(name = "auditor_id")
	private Employee auditor;

	public Employee getAuditor() {
		return auditor;
	}

	public void setAuditor(Employee auditor) {
		this.auditor = auditor;
	}
}
