package com.midmarsh.employee;

import java.util.List;

public interface Department {

	String getName();

	void setName(String name);

	List<Employee> getEmployees();

	void setEmployees(List<Employee> employees);

}
