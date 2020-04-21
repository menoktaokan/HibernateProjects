package com.okan.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Departments {

	@Id
	@Column(name = "DEPARTMENT_ID")
	@SequenceGenerator(name = "dept_seq", sequenceName = "departments_seq", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	private Integer departmentid;

	@Column(name = "DEPARTMENT_NAME")
	private String departmantName;

//	@Column(name = "MANAGER_ID")
//	private Integer managerid;
//
//	@Column(name = "LOCATION_ID")
//	private Integer locationid;

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "department_id")
//	private List<Employee> employees;
//
//	public void addDepartment(Employee employee) {
//		if (employees == null) {
//			employees = new ArrayList<Employee>();
//		}
//		employees.add(employee);
//	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmantName() {
		return departmantName;
	}

	public void setDepartmantName(String departmantName) {
		this.departmantName = departmantName;
	}


	@Override
	public String toString() {
		return departmantName;
	}

}
