package com.cache.hazelcast.service;

import java.util.List;

import com.cache.hazelcast.model.Employee;


public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	void getEmployeeById(String empid);
}