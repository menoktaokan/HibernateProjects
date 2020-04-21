package com.okan.dao;

import java.util.List;

import com.okan.domain.Departments;
import com.okan.domain.Employee;
import com.okan.domain.Jobs;

public interface EmployeeDAO {

	public List<Employee> listEmployees();

	public List<Departments> listDepartments();

	public List<Jobs> listJobs();

	public Employee getEmployee(int empId);


}
