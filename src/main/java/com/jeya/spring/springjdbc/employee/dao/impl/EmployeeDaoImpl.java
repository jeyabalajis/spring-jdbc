package com.jeya.spring.springjdbc.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jeya.spring.springjdbc.employee.dao.EmployeeDao;
import com.jeya.spring.springjdbc.employee.dao.rowmapper.EmployeeRowMapper;
import com.jeya.spring.springjdbc.employee.dto.Employee;

@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int Create(Employee employee) {

		String sql = "insert into employee(first_name, last_name) values(?,?)";
		int result = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName());

		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int Update(Employee employee) {
		String sql = "UPDATE employee SET first_name = ?, last_name = ? WHERE id = ?";
		int result = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());

		return result;
	}

	@Override
	public int Delete(int id) {
		String sql = "DELETE FROM employee WHERE id = ?";
		int result = jdbcTemplate.update(sql, id);

		return result;
	}

	@Override
	public Employee Read(int id) {
		String sql = "SELECT * FROM employee WHERE id = ?";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return employee;
	}

	@Override
	public List<Employee> Read() {
		String sql = "SELECT * FROM employee";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		List<Employee> listEmployee = jdbcTemplate.query(sql, rowMapper);
		return listEmployee;
	}

}
