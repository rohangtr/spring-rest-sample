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
		
		public Employee getEmployee(Long id){
			Employee emp = employeeRepository.findOne(id);
			employeeAuditService.excecuteAudit(emp.toString());
			return emp;
		}
		
		public void deleteEmployee(Long id){
			employeeRepository.delete(id);
			employeeAuditService.excecuteAudit(id.toString());
		}
		
		public String createEmployee(Employee employee){
			employeeRepository.save(employee);
			employeeAuditService.excecuteAudit("create");
			return "Employee created succesfully";
		}
		
		public boolean ifEmployeeExists(Long id){
			
			return employeeRepository.exists(id);
			
		}
		public String updateEmployee(Employee employee){
			
			if(employee.getId()!=null){
				if(employeeRepository.exists(employee.getId())){
						employeeRepository.save(employee);
						return "Employee updated succesfully";	
				}
			}			
			return createEmployee(employee);
		}
}
