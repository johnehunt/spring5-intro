package com.midmarsh.spring.employee;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.midmarsh.spring.employee.Department;
import com.midmarsh.spring.employee.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:app-context.xml" })
// @ContextConfiguration("classpath:app-context.xml")
public class DepartmentImplTest {
	
	@Autowired
	Department department;
	
	@BeforeClass 
	public static void onceOnlySetup() {
		// Set up for all tests
	}

	@AfterClass
	public static void onceOnlyTeardown() {
		// Clean up after all tests
	}
	
	
	@Before
	public void setup() {
		// set up scenario required before each test
	}
	
	@After
	public void teardown() {
		// tear down scenario after each test
	}
	

	@Test
	public void testGetName() {
		String name = department.getName();
		assertEquals("Names inconsistent", "Development", name);
	}

	@Test
	public void testGetEmployees() {
		List<Employee> employees = department.getEmployees();
		int size = employees.size();
		assertEquals("Size not 2 ", 2, size);
	}

}
