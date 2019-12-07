package com.jeya.spring.springjdbc.employee.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jeya.spring.springjdbc.employee.dao.EmployeeDao;
import com.jeya.spring.springjdbc.employee.dto.Employee;

public class Test {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("com/jeya/spring/springjdbc/employee/test/config.xml");
		EmployeeDao employeeDao = (EmployeeDao) ctx.getBean("employeeDao");

		Employee emp = new Employee();
		emp.setFirstName("Xiaoxao");
		emp.setLastName("ChiangMai");

		int result = employeeDao.Create(emp);

		System.out.println("Number of records inserted are: " + result);

		emp.setFirstName("Aarav");

		int updated = employeeDao.Update(emp);
		System.out.println("Number of records updated are: " + updated);

		int deleted = employeeDao.Delete(2);
		System.out.println("Number of records deleted are: " + deleted);

		Employee employee = employeeDao.Read(1);
		System.out.println(employee);

		List<Employee> listEmployee = employeeDao.Read();
		System.out.println(listEmployee);

		employee = null;
		listEmployee = null;
		emp = null;
		ctx = null;

	}

}
