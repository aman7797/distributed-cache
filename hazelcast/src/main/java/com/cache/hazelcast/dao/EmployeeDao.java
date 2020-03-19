package com.cache.hazelcast.dao;

import java.util.List;

import com.cache.hazelcast.model.Employee;


public interface EmployeeDao {
	void insertEmployee(Employee cus);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empId);
}