package com.springapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springapp.rest.model.Employee;
import com.springapp.rest.repository.EmployeeRevionRepository;
import com.springapp.rest.utilities.Utilities;

@Controller
public class ReviosnRESTController {
		@Autowired
		EmployeeRevionRepository employeeRevionRepository;
		
		
	    @RequestMapping(value = "/revision", 
	    		method=RequestMethod.GET, 
	    		produces=MediaType.APPLICATION_JSON_VALUE)
	    
	    public ResponseEntity<Revision<Integer, Employee>> getAllEmployees() {
	    	Revision<Integer, Employee>  emp = employeeRevionRepository.findLastChangeRevision(1l);
	    	System.out.println(emp);
    	
	    	return  new ResponseEntity<Revision<Integer, Employee>>(emp, HttpStatus.OK);
	    }

}
