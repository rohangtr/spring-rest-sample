package com.springapp.rest.repository;
import org.springframework.data.repository.CrudRepository;

import com.springapp.rest.model.Employee;

/**
 * @author Rohan Kushwaha
 *
 */

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}