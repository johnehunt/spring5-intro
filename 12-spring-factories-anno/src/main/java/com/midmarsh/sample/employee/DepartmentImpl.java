package com.midmarsh.sample.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "Department")
public class DepartmentImpl implements Department {

	private String name;
	
	@Autowired
	private Employee employee;

	public DepartmentImpl() {
		name = "Spring Store";
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
