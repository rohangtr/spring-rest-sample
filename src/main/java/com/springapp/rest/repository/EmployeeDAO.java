package com.springapp.rest.repository;

import java.util.List;

import com.springapp.rest.model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployee(Integer id);
		
	public List<Employee> getEmployeeList();
	
	public void saveEmployee(Employee emp);
	
	public boolean deleteEmployee(Integer id);
}