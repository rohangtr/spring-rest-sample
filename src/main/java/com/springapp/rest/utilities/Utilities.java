package com.springapp.rest.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.springapp.rest.model.Employee;
import com.springapp.rest.repository.EmployeeRepository;
import com.springapp.rest.repository.StaticEmployeeDAO;

public class Utilities {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static <E> List<E> makeList(Iterable<E> iter) {
		List<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}
	public static void main(String[] args){
		Utilities util = new Utilities();
		System.out.println(util.employeeRepository);
	}
}
