package com.springapp.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.springapp.rest.model.EmployeeAudit;

public interface EmployeeAuditRepository extends CrudRepository<EmployeeAudit, Long> {


}
