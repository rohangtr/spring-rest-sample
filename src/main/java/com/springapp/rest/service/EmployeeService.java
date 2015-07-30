package com.springapp.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.rest.model.Employee;
import com.springapp.rest.repository.EmployeeRepository;
import com.springapp.rest.utilities.Utilities;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeAuditService employeeAuditService;
	
		public List<Employee> getEmployeeList(){
			List<Employee> employees = Utilities.makeList(employeeRepository.findAll());
			employeeAuditService.excecuteAudit(employees.toString());
			return employees;
			
		}

}