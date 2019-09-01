package com.midmarsh.spring.main;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.employee.Employee;
import com.midmarsh.spring.dao.EmployeeDAO;

public class Main {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("bean-context.xml")) {
			EmployeeDAO dao = ctx.getBean("employeeDao", EmployeeDAO.class);

			List<Employee> employees = dao.getEmployees();
			employees.forEach((Employee e) -> System.out.println(e));

//			List<Employee> employees = dao.getAltEmployees();
//			employees.forEach((Employee e) -> System.out.println(e));

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
