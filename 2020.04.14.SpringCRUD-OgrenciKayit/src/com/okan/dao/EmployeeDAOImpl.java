package com.okan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okan.domain.Departments;
import com.okan.domain.Employee;
import com.okan.domain.Jobs;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Employee> listEmployees() {
		Session session=sessionFactory.getCurrentSession();
		List<Employee> listEmployees=session.createQuery("from Employee where status=1", Employee.class).getResultList();
		return listEmployees;
	}

	@Transactional
	@Override
	public List<Departments> listDepartments() {
		Session session=sessionFactory.getCurrentSession();
		List<Departments> listDepartments=session.createQuery("from Departments", Departments.class).getResultList();
		return listDepartments;
	}

	@Transactional
	@Override
	public List<Jobs> listJobs() {
		Session session=sessionFactory.getCurrentSession();
		List<Jobs> listJobs=session.createQuery("from Jobs", Jobs.class).getResultList();
		return listJobs;
	}

	@Transactional
	@Override
	public Employee getEmployee(int empId) {
		Session session=sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, empId);
		return employee;
	}

	@Transactional
	@Override
	public void saveEmployee(Employee employee) {
		Session session=sessionFactory.getCurrentSession();
		employee.setName(employee.getName().substring(0, 1).toUpperCase()+employee.getName().substring(1));
		employee.setLastname(employee.getLastname().toUpperCase());
		employee.setEmail(employee.getEmail().toUpperCase());
		session.saveOrUpdate(employee);
		
	}
	
	@Transactional
	@Override
	public void deleteEmployee(int empId) {
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("update Employee set status=0 where id="+empId).executeUpdate();
	}

	@Transactional
	@Override
	public Jobs getJob(String jobId) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Jobs.class, jobId);
	}




}
