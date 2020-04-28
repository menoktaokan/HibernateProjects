package com.okan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okan.dao.EmployeeDAO;
import com.okan.domain.Departments;
import com.okan.domain.Employee;
import com.okan.domain.Jobs;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO  employeeDAO;

	
	@Override
	public List<Employee> listEmployees() {
		return employeeDAO.listEmployees();
	}

	
	@Override
	public List<Departments> listDepartments() {
		
		return employeeDAO.listDepartments();
	}

	
	@Override
	public List<Jobs> listJobs() {
		return employeeDAO.listJobs();
	}

	
	@Override
	public Employee getEmployee(int empId) {
		return employeeDAO.getEmployee(empId);
	}


	@Override
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
		
	}


	@Override
	public void deleteEmployee(int empId) {
		employeeDAO.deleteEmployee(empId);
	}


	@Override
	public Jobs getJob(String jobId) {
		
		return employeeDAO.getJob(jobId);
	}


	@Override
	public List<Employee> searchEmployee(Employee employee) {
		
		return employeeDAO.searchEmployee(employee);
	}


	


	

}
