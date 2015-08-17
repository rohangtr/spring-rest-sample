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
import com.springapp.rest.utilities.Utilities;
 
@Controller
public class EmployeeRESTController 
{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
    @RequestMapping(value = "/employee", 
    		method=RequestMethod.GET, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<List<Employee>> getAllEmployees() 
    {
    	List<Employee> emp = Utilities.makeList(employeeRepository.findAll());
    	
        return  new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
    }
     
    @RequestMapping(value = "/employee/{id}", 
    		method=RequestMethod.GET, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) 
    {
    	
        if (employeeRepository.findOne(id)!=null) {
            Employee employee = employeeRepository.findOne(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/employee/{id}", 
    		method=RequestMethod.DELETE, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<JSONPObject> deleteEmployeeById (@PathVariable("id") Long id) 
    {

        if (employeeRepository.exists(id)) {
        	
            employeeRepository.delete(id);
            JSONPObject jsonObject = new JSONPObject("message", "Employee succesfully deleted");
            return new ResponseEntity<JSONPObject>(jsonObject,HttpStatus.OK);
        }else{
        	JSONPObject jsonObject = new JSONPObject("message", "Can not find Employee");
        	return new ResponseEntity<JSONPObject>(jsonObject,HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/employee", 
    		method=RequestMethod.POST, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<JSONPObject> postEmployeeById (@RequestBody Employee employee) 
    {
	   	employeeRepository.save(employee);
	   	JSONPObject jsonObject = new JSONPObject("message", "Employee succesfully added");
        return new ResponseEntity<JSONPObject>(jsonObject,HttpStatus.OK);
    }
    @RequestMapping(value = "/employee", 
    		method=RequestMethod.PUT, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<JSONPObject> updateEmployee (@RequestBody Employee employee) 
    {
	   	employeeRepository.save(employee);
	   	JSONPObject jsonObject = new JSONPObject("message", "Employee succesfully Updated");
        return new ResponseEntity<JSONPObject>(jsonObject,HttpStatus.OK);
    }
}