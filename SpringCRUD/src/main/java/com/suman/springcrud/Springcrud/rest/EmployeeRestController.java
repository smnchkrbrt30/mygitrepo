package com.suman.springcrud.Springcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suman.springcrud.Springcrud.entity.Employee;
import com.suman.springcrud.Springcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable int empId) {
		Employee theEmployee= employeeService.findById(empId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee Not Found with ID = "+empId);
		}
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.addEmployee(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.addEmployee(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		Employee theEmployee=employeeService.findById(empId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee Not Found with ID = "+empId);
		}
		employeeService.deletebyId(empId);
		return "Deleted Employee = "+empId;
	}
}

