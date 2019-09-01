package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.employee.Employee;
import com.midmarsh.employee.EmployeeImpl;
import com.midmarsh.spring.dao.EmployeeDAO2;

public class CreateAnEmployee {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("bean-context.xml")) {
			EmployeeDAO2 dao = context.getBean("employeeDao2", EmployeeDAO2.class);
			System.out.println("Inserting a new employee");
			Employee e = new EmployeeImpl("5", "James");
			dao.addEmployee(e);
			
//			Employee [] employees = new Employee[] {new EmployeeImpl("6", "Joselyn") };
//			dao.addAllEmployees(employees);
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
