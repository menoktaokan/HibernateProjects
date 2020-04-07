package com.okan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Jobs {

	@Id
	@Column(name = "JOB_ID")
	private String jobId;

	public Jobs(String jobId) {
		super();
		this.jobId = jobId;
	}

	@Column(name = "JOB_TITLE")
	private String jobtitle;

	@Column(name = "MIN_SALARY")
	private int minSalary;

	@Column(name = "MAX_SALARY")
	private int maxSalary;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Jobs(String jobId, String jobtitle, int minSalary, int maxSalary) {
		super();
		this.jobId = jobId;
		this.jobtitle = jobtitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

}
