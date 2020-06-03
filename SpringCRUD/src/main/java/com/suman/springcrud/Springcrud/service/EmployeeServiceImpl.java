package com.suman.springcrud.Springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suman.springcrud.Springcrud.dao.EmployeeDAO;
import com.suman.springcrud.Springcrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}
	
	
	@Override
	@Transactional
	public List<Employee> findAllEmployees() {
		return employeeDAO.findAllEmployees();
	}

	@Override
	@Transactional
	public Employee findById(int empId) {
		return employeeDAO.findById(empId);
	}

	@Override
	@Transactional
	public void addEmployee(Employee theEmployee) {
		employeeDAO.addEmployee(theEmployee);
	}

	@Override
	@Transactional
	public void deletebyId(int empId) {
		employeeDAO.deletebyId(empId);
	}
	
}
