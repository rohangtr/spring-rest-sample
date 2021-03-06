package com.springapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springapp.rest.model.Employee;
import com.springapp.rest.repository.EmployeeRepository;
import com.springapp.rest.service.EmployeeService;

/**
 * @author Rohan Kushwaha
 *
 */

@Controller
public class EmployeeRESTController {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> emp = employeeService.getEmployeeList();

		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {

		Employee employee = employeeService.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<JSONPObject> deleteEmployeeById(@PathVariable("id") Long id) {

		String deleteMessage = employeeService.deleteEmployee(id);
		JSONPObject jsonObject = new JSONPObject("message", deleteMessage);
		return new ResponseEntity<JSONPObject>(jsonObject, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<JSONPObject> postEmployeeById(@RequestBody Employee employee) {
		String createMsg = employeeService.createEmployee(employee);
		JSONPObject jsonObject = new JSONPObject("message", createMsg);
		return new ResponseEntity<JSONPObject>(jsonObject, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<JSONPObject> updateEmployee(@RequestBody Employee employee) {
		String updateMsg = employeeService.updateEmployee(employee);
		JSONPObject jsonObject = new JSONPObject("message", updateMsg);
		return new ResponseEntity<JSONPObject>(jsonObject, HttpStatus.OK);
	}
}