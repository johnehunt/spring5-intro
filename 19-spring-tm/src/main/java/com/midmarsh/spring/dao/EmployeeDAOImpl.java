package com.midmarsh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.midmarsh.spring.employee.Employee;
import com.midmarsh.spring.employee.EmployeeImpl;

/**
 * See also org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport.<br>
 * Handles the SimpleJdbcTemplate for you.
 */
@Component("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public List<Employee> getEmployees() {
		String sql = "SELECT * FROM employee";
		List<Employee> employees = this.jdbcTemplate.query(sql,
				new EmployeeMapper());
		return employees;
	}

	public int addEmployee(Employee e) {
		String sql = "INSERT INTO employee (id, name) values (?,?)";
		int c = this.jdbcTemplate.update(sql, e.getId(), e.getName());
		return c;
	}

	public int update(Employee e) {
		int c = 0;
		String sql = "UPDATE employees.employee SET name = ? WHERE id = ?";
		try {
			c = this.jdbcTemplate.update(sql, e.getName(), e.getId());
		} catch (Exception exp) {
			// Programmatically trigger rollback - but now tied to Spring
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return c;
	}

	// ---------------------------------------------------------------
	// Using a mapper
	// ---------------------------------------------------------------

	class EmployeeMapper implements RowMapper<Employee> {

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new EmployeeImpl();
			emp.setName(rs.getString("name"));
			emp.setId(rs.getLong("id") + "");
			return emp;
		}

	}

}
