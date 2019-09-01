package com.midmarsh.sample.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.sample.employee.Department;

public class Main {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-context.xml")) {
			Department bean = ctx.getBean("Department", Department.class);
			System.out.println(bean);
			System.out.println(bean.getEmployee().toString());
		}
	}

}
