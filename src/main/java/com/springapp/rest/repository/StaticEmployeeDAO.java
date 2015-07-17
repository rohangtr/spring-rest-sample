package com.springapp.rest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springapp.rest.model.Employee;

public class StaticEmployeeDAO implements EmployeeDAO {
	
	static Map<Integer, Employee> empMap;
	static{
		empMap = new HashMap<Integer, Employee>();
		Employee empOne = new Employee(1,"A","K","ak@gmail.com");
	    Employee empTwo = new Employee(2,"B","K","bk@yahoo.com");
	    Employee empThree = new Employee(3,"C","K","ck@gmail.com");
	     
	     
	    empMap.put(1,empOne);
	    empMap.put(2,empTwo);
	    empMap.put(3,(empThree));
    }
	
	public StaticEmployeeDAO(){
		
	}
	
	
	
	public Employee getEmployee(Integer id) {
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

	public boolean deleteEmployee(Integer id) {
		if(empMap.remove(id)!=null)
			return true;
		else return
				false;
	}
}
