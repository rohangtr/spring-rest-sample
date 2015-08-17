package com.springapp.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.springapp.rest.model.Employee;

public interface EmployeeRevionRepository extends RevisionRepository<Employee, Long, Integer>, CrudRepository<Employee, Long> {

	}