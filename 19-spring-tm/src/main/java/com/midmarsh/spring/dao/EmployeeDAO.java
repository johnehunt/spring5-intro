package com.midmarsh.spring.dao;

import java.util.List;

import com.midmarsh.spring.employee.Employee;

public interface EmployeeDAO {

	List<Employee> getEmployees();
	int addEmployee(Employee e);
	int update(Employee e);
	
}
