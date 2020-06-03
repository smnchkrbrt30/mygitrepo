package com.suman.springcrud.Springcrud.dao;

import java.util.List;

import com.suman.springcrud.Springcrud.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAllEmployees();
	
	public Employee findById(int empId);
	
	public void addEmployee(Employee theEmployee);
	
	public void deletebyId(int empId);
}
