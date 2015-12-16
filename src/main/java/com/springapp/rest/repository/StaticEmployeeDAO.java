package com.springapp.rest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springapp.rest.model.Employee;

public class StaticEmployeeDAO implements EmployeeDAO {

	static Map<Long, Employee> empMap;

	static {
		empMap = new HashMap<Long, Employee>();
		Employee empOne = new Employee(1l, "A", "K", "ak@gmail.com");
		Employee empTwo = new Employee(2l, "B", "K", "bk@yahoo.com");
		Employee empThree = new Employee(3l, "C", "K", "ck@gmail.com");

		empMap.put(1l, empOne);
		empMap.put(2l, empTwo);
		empMap.put(3l, (empThree));
	}

	public StaticEmployeeDAO() {

	}

	public Employee getEmployee(Long id) {
		Employee emp = empMap.get(id);
		return emp;
	}

	public List<Employee> getEmployeeList() {
		List<Employee> empList = new ArrayList<Employee>(empMap.values());
		return empList;
	}

	public void saveEmployee(Employee emp) {
		empMap.put(emp.getId(), emp);

	}

	public boolean deleteEmployee(Long id) {
		if (empMap.remove(id) != null)
			return true;
		else
			return false;
	}

}
