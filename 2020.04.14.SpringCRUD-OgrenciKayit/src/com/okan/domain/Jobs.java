package com.okan.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Jobs")
public class Jobs {

	@Id
	@Column(name = "job_id")
	private String jobId;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "min_salary")
	private Double minSalary;

	@Column(name = "max_salary")
	private Double maxSalary;

//	@OneToMany(mappedBy = "ogretmen", cascade = CascadeType.ALL)
//	private List<Employee> employee;
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "job_id")
//	private List<Employee> employeeList;
//
//	public void addEmployee(Employee employee) {
//		if (employeeList == null) {
//			employeeList = new ArrayList<Employee>();
//		}
//		employeeList.add(employee);
//	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	@Override
	public String toString() {
		return jobId;
	}

	public Jobs() {
		super();
	}


}