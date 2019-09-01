package com.midmarsh.spring.employee;

public class EmployeeImpl implements Employee {
	
	private String name;
	private String employeeId;
	private String employeer;
	
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
		return name + ": " + employeeId + "(" + employeer + ")";
	}
}
