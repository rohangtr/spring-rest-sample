package com.springapp.rest.controller;
 
import java.util.List;

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
import com.springapp.rest.repository.StaticEmployeeDAO;

import net.minidev.json.JSONObject;
 
@Controller
public class EmployeeRESTController 
{
    @RequestMapping(value = "/employees", 
    		method=RequestMethod.GET, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<List<Employee>> getAllEmployees() 
    {
    	EmployeeDAO empDAO = new StaticEmployeeDAO();
    	
        return  new ResponseEntity<List<Employee>>(empDAO.getEmployeeList(), HttpStatus.OK);
    }
     
    @RequestMapping(value = "/employees/{id}", 
    		method=RequestMethod.GET, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") int id) 
    {
    	EmployeeDAO empDAO = new StaticEmployeeDAO();
    	
        if (empDAO.getEmployee(id)!=null) {
            Employee employee = empDAO.getEmployee(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/employees/{id}", 
    		method=RequestMethod.DELETE, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<JSONObject> deleteEmployeeById (@PathVariable("id") int id) 
    {
    	EmployeeDAO empDAO = new StaticEmployeeDAO();
    	
        if (empDAO.deleteEmployee(id)) {
        	JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "Employee succesfully deleted");
            return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
        }else{
        	JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "Can not find");
        	return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/employees", 
    		method=RequestMethod.POST, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<JSONObject> postEmployeeById (@RequestBody String str) 
    {
    	System.out.println(str);
    	Employee employee = new Employee();
    	EmployeeDAO empDAO = new StaticEmployeeDAO();
    	
        empDAO.saveEmployee(employee);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Employee succesfully added");
        return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
    }
}