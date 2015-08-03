package com.springapp.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.springapp.rest.model.EmployeeAudit;
import com.springapp.rest.repository.EmployeeAuditRepository;
import com.springapp.rest.repository.EmployeeRepository;

@Service
public class EmployeeAuditService {
	
	@Autowired
	EmployeeAuditRepository employeeAuditRepository;
	@Async
	public void excecuteAudit(EmployeeAudit employeeAudit) {
		
		employeeAuditRepository.save(employeeAudit);
	}
}
