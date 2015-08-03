package com.springapp.rest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.rest.model.Employee;
import com.springapp.rest.model.EmployeeAudit;
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
			EmployeeAudit employeeAudit = new EmployeeAudit("get"," ", new Date(),-1l);
			employeeAuditService.excecuteAudit(employeeAudit);
			return employees;
			
		}
		
		public Employee getEmployee(Long id){
			Employee emp = employeeRepository.findOne(id);
			EmployeeAudit employeeAudit = new EmployeeAudit("get"," ", new Date(),id);
			employeeAuditService.excecuteAudit(employeeAudit);
			return emp;
		}
		
		public void deleteEmployee(Long id){
			
			EmployeeAudit employeeAudit = new EmployeeAudit("delete",employeeRepository.findOne(id).toString(), new Date(),id);
			employeeAuditService.excecuteAudit(employeeAudit);
			employeeRepository.delete(id);
		}
		
		public String createEmployee(Employee employee){
			EmployeeAudit employeeAudit = new EmployeeAudit("create","", new Date(),-1l);
			employeeAuditService.excecuteAudit(employeeAudit);
			employeeRepository.save(employee);
			return "Employee created succesfully";
		}
		
		public boolean ifEmployeeExists(Long id){
			
			return employeeRepository.exists(id);
			
		}
		public String updateEmployee(Employee employee){
			
			if(employee.getId()!=null){
				if(employeeRepository.exists(employee.getId())){
					EmployeeAudit employeeAudit = new EmployeeAudit("update",employeeRepository.findOne(employee.getId()).toString(), new Date(),employee.getId());
					employeeAuditService.excecuteAudit(employeeAudit);
					employeeRepository.save(employee);
					return "Employee updated succesfully";	
				}
			}			
			return createEmployee(employee);
		}
}
