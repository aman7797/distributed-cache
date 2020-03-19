package com.cache.hazelcast.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cache.hazelcast.dao.EmployeeDao;
import com.cache.hazelcast.model.Employee;
import com.cache.hazelcast.service.EmployeeService;

@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		LOG.info("Inserting the insertEmployee");
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		LOG.info("Inserting the List of insertEmployee");
		employeeDao.insertEmployees(employees);
	}

	@Override
	@Cacheable()
	public List<Employee> getAllEmployees() {
		LOG.info("Inside the service layer");
		return employeeDao.getAllEmployees();

	}

	@Override
	public void getEmployeeById(String empId) {
		Employee employee = employeeDao.getEmployeeById(empId);
		LOG.info("Getting Employee by ID" + employee);
	}

}