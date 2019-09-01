package com.midmarsh.sample.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.sample.address.Address;
import com.midmarsh.sample.config.MyConfig;
import com.midmarsh.sample.employee.Department;
import com.midmarsh.sample.employee.Employee;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting Main Application!");
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class)) {
			Department bean = ctx.getBean("Department", Department.class);
			Employee employee = bean.getEmployee();
			System.out.println(employee);

			Address addr = ctx.getBean("Address", Address.class);
			System.out.println(addr);
		}
		System.out.println("Existing Main Application!");
	}

}
