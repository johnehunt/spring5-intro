package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.dao.EmployeeDAO;
import com.midmarsh.spring.employee.Employee;
import com.midmarsh.spring.employee.EmployeeImpl;

public class CreateAnEmployee {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("bean-context.xml")) {
			EmployeeDAO dao = context.getBean("employeeDao2", EmployeeDAO.class);
			System.out.println("Inserting a new employee");
			Employee e = new EmployeeImpl("7", "Isobel");
			dao.addEmployee(e);
			System.out.println("//----------------------------------");
			System.out.println("Inserting a new employee");
			e = new EmployeeImpl("8", "Sofie");
			dao.addEmployee(e);
			System.out.println("//----------------------------------");
			System.out.println("Updating an employee");
			e = new EmployeeImpl("9", "Fiona");
			dao.update(e);
			System.out.println("//----------------------------------");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
