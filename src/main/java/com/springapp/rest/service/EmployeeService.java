package com.springapp.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.rest.model.Employee;
import com.springapp.rest.repository.EmployeeRepository;
import com.springapp.rest.utilities.Utilities;

/**
 * @author Rohan Kushwaha
 *
 */

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployeeList() {
		List<Employee> employees = Utilities.makeList(employeeRepository.findAll());
		return employees;

	}

	public Employee getEmployee(Long id) {
		Employee emp = employeeRepository.findOne(id);
		return emp;
	}

	public String deleteEmployee(Long id) {
		if (employeeRepository.exists(id)) {
			employeeRepository.delete(id);
			return "Employee deleted Successfully";
		} else
			return "Cannot find Employee";
	}

	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee created succesfully";
	}

	public boolean ifEmployeeExists(Long id) {

		return employeeRepository.exists(id);

	}

	public String updateEmployee(Employee employee) {
		if (employee.getId() != null) {
			if (employeeRepository.exists(employee.getId())) {
				employeeRepository.save(employee);
				return "Employee updated succesfully";
			} else
				return "Employee does not exsits";
		}
		return "Cannot find Employee";
	}
}