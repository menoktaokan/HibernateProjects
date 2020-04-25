package com.okan.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	@SequenceGenerator(name = "EMPLOYEES_SEQ", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_SEQ")
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String lastname;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	
	@ManyToOne
	@JoinColumn(name = "JOB_ID")
	private Jobs job;
	
	@Max(value = 9999999, message = "Çok yüksek")
	@Min(value = 0, message = "Eksi olamaz")
	@Column(name = "SALARY")
	private Integer salary;
	
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Departments department;
	
	@Column(name = "STATUS")
	private Integer status;

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	public Employee() {
	}

	public Employee(String name, String lastname, String email, String phoneNumber, Date hireDate, Integer salary) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name;
	}

	

}
