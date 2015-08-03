package com.springapp.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.springapp.rest.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}