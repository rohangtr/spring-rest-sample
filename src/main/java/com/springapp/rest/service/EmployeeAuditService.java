package com.springapp.rest.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAuditService {
	
	@Async
	public void excecuteAudit(String str){
		//Sleep for 5 sec to see that it has run in other thread
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Audit ::"+ str);
	}
}
