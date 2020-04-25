package com.okan.service;

import java.util.List;

import com.okan.domain.Departments;
import com.okan.domain.Employee;
import com.okan.domain.Jobs;

public interface EmployeeService {

	List<Employee> listEmployees();

	List<Departments> listDepartments();

	List<Jobs> listJobs();

	Employee getEmployee(int empId);

	void saveEmployee(Employee employee);

	void deleteEmployee(int empId);

	Jobs getJob(String jobId);



}
