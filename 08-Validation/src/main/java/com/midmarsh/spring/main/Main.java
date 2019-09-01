package com.midmarsh.spring.main;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.beans.employee.Employee;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting Main Application!");
		try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("bean-context.xml")) {
			Employee bean = ctx.getBean("Employee", Employee.class);
			System.out.println(bean);

			Validator validator = ctx.getBean("validator", Validator.class);
			Set<ConstraintViolation<Employee>> errors = validator.validate(bean);

			errors.forEach(violation -> System.out.println(violation));
		}
		System.out.println("Existing Main Application!");
	}

}
