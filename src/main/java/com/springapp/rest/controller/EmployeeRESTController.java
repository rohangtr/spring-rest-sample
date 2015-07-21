package com.springapp.rest.controller;
 
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springapp.rest.model.Employee;
import com.springapp.rest.repository.EmployeeDAO;
import com.springapp.rest.repository.EmployeeRepository;
import com.springapp.rest.repository.StaticEmployeeDAO;
import com.springapp.rest.utilities.Utilities;

import net.minidev.json.JSONObject;
 
@Controller
public class EmployeeRESTController 
{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
    @RequestMapping(value = "/employees", 
    		method=RequestMethod.GET, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<List<Employee>> getAllEmployees() 
    {
    	List<Employee> emp = Utilities.makeList(employeeRepository.findAll());
    	
        return  new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
    }
     
    @RequestMapping(value = "/employees/{id}", 
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
    
    @RequestMapping(value = "/employees/{id}", 
    		method=RequestMethod.DELETE, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<JSONObject> deleteEmployeeById (@PathVariable("id") Long id) 
    {

        if (employeeRepository.exists(id)) {
        	JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "Employee succesfully deleted");
            employeeRepository.delete(id);
            return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
        }else{
        	JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "Can not find Employee");
        	return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/employees", 
    		method=RequestMethod.POST, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<JSONObject> postEmployeeById (@RequestBody Employee employee) 
    {
    	System.out.println(employee);
    	
    	employeeRepository.save(employee);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Employee succesfully added");
        return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
    }
}