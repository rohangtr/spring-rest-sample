package com.springapp.rest.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAuditService {
	
	@Async
	public void excecuteAudit(String str) {
		
		System.out.println("Audit ::"+ str);
	}
}
