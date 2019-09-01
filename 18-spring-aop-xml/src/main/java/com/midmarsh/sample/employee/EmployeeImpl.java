package com.midmarsh.sample.employee;

import org.springframework.stereotype.Component;

@Component("Employee")
public class EmployeeImpl implements Employee {
	
	private String name = "John";
	private String employeeId = "ABC123AA";
	private String employeer = "BBC";

	public void setEmployeer(String employeer) {
		this.employeer = employeer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String toString() {
		return name + ", " + employeeId + "(" + employeer + ")";
	}
	
}
