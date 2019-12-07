package com.jeya.spring.springjdbc.employee.dao;

import java.util.List;

import com.jeya.spring.springjdbc.employee.dto.Employee;

public interface EmployeeDao {

	int Create(Employee employee);
	
	int Update(Employee employee);
	
	int Delete(int id);
	
	Employee Read(int id);
	
	List<Employee> Read();
}
