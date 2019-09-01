package com.midmarsh.spring.beans.employee;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component("Employee")
public class EmployeeImpl implements Employee {

	@NotNull
	private String name;
	private String employeeId;
	private String employeer;

	@Min(18)
	@Max(65)
	private int age;

	@AssertTrue
	private boolean enabled = true;

	@Email(message = "Email should be valid")
	private String email;

	public EmployeeImpl() {
		name = "John Hunt";
		employeeId = "ABC123AA";
		employeer = "ABC";
	}

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
		return name + "[" + age + "] : " + employeeId + "(" + employeer + ")";
	}

}
