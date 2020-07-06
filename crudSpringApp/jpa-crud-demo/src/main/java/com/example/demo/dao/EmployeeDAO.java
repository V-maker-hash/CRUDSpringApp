package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
