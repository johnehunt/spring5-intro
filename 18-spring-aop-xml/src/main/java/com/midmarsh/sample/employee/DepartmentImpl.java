package com.midmarsh.sample.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Department")
public class DepartmentImpl implements Department {
	
	private String name = "Spring Store";
	private Employee employee;

	public void setName(String name) {
		this.name = name;
	}
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public DepartmentImpl() {
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
}
