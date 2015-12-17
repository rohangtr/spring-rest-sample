package com.springapp.rest.service;

import org.hibernate.envers.RevisionListener;

import com.springapp.rest.model.EmployeeRevisionEntity;
import com.springapp.rest.utilities.Utilities;

public class EmployeeRevisionListener implements RevisionListener {

	public void newRevision(Object revisionEntity) {
		EmployeeRevisionEntity entity = (EmployeeRevisionEntity) revisionEntity;
		entity.setAuditor(Utilities.getCurrentUser().toString());
	}
}