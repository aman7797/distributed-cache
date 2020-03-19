package com.cache.hazelcast;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import com.cache.hazelcast.model.Employee;
import com.cache.hazelcast.service.EmployeeService;


@SpringBootApplication
@EnableCaching
public class HazelcastApplication {
	
	@Autowired
	EmployeeService employeeService;
	
	private static Logger LOG = LoggerFactory.getLogger(HazelcastApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HazelcastApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		
		Employee emp= new Employee();
		emp.setEmpId("1");
		emp.setEmpName("Aman");
		
		Employee emp1= new Employee();
		emp1.setEmpId("2");
		emp1.setEmpName("Kunal");
		
		Employee emp2= new Employee();
		emp2.setEmpId("3");
		emp2.setEmpName("Manish");

		
		employeeService.insertEmployee(emp);

		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employeeService.insertEmployees(employees);
		
		
		
		LOG.info("Inside the main class making call to service first time");
		List<Employee> employeeList1 = employeeService.getAllEmployees();
		for (Employee employee : employeeList1) {
			LOG.info(employee.toString());
		}
		
		
		LOG.info("Inside the main class making call to service -----second time------- where it will use hazelcast");
		List<Employee> employeeList2 = employeeService.getAllEmployees();
		for (Employee employee : employeeList2) {
			LOG.info(employee.toString());
		}
		

	}
}