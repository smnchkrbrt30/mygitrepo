package com.suman.springcrud.Springcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suman.springcrud.Springcrud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
	//Entity Manager
	EntityManager entitymanager;
	
	//Contructor Injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntity) {
		entitymanager=theEntity;
	}

	@Override
	public List<Employee> findAllEmployees() {
		Session sess=entitymanager.unwrap(Session.class);
		Query<Employee> theQuery=sess.createQuery("from Employee",Employee.class);
		List<Employee> theEmployees=theQuery.getResultList();
		return theEmployees;
	}

	@Override
	public Employee findById(int empId) {
		Session sess=entitymanager.unwrap(Session.class);
		Employee theEmployee=sess.get(Employee.class, empId);
		return theEmployee;
	}

	@Override
	public void addEmployee(Employee theEmployee) {
		Session sess=entitymanager.unwrap(Session.class);
		sess.saveOrUpdate(theEmployee);
	}

	@Override
	public void deletebyId(int empId) {
		Session sess=entitymanager.unwrap(Session.class);
		Query theQuery=sess.createQuery("delete from Employee where id=:empId");
		theQuery.setParameter("empId",empId);
		theQuery.executeUpdate();
	}

}
