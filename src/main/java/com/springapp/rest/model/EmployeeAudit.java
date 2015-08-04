package com.springapp.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit_table")
public class EmployeeAudit implements Serializable{
	   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    @Column(name="id_audit_table")
    private Long id;
    @Column(name="method")
    private String method;
	@Column(name="prev_obj_value")
    private String prevObj;
    @Column(name="time_stamp")
    private Date timeStamp;
    @Column(name="emp_id")
    private Long empId;
    public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public EmployeeAudit(String method, String prevObj, Date timeStamp, long empId){
    	this.method = method;
    	this.prevObj = prevObj;
    	this.timeStamp = timeStamp;
    	this.empId = empId;
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPrevObj() {
		return prevObj;
	}
	public void setPrevObj(String prevObj) {
		this.prevObj = prevObj;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
        return "Employee Audit [id= " + id + ", method=" + method
                + ", prevObj= " + prevObj + ", timeStamp=" + timeStamp + "Employee Id"+ empId + "]";
    }

}
