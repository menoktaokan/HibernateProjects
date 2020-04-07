package com.okan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Departments {
	
	@Id
	@Column
	@SequenceGenerator(name ="dept_seq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	private int DEPARTMENT_ID;
	
	@Column
	private String DEPARTMENT_NAME;
	
	@Column
	private int MANAGER_ID;
	
	@Column
	private int LOCATION_ID;

	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}

	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}

	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}

	public int getMANAGER_ID() {
		return MANAGER_ID;
	}

	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}

	public int getLOCATION_ID() {
		return LOCATION_ID;
	}

	public void setLOCATION_ID(int lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}

	public Departments(int dEPARTMENT_ID, String dEPARTMENT_NAME, int mANAGER_ID, int lOCATION_ID) {
		super();
		DEPARTMENT_ID = dEPARTMENT_ID;
		DEPARTMENT_NAME = dEPARTMENT_NAME;
		MANAGER_ID = mANAGER_ID;
		LOCATION_ID = lOCATION_ID;
	}

	public Departments(String dEPARTMENT_NAME, int mANAGER_ID, int lOCATION_ID) {
		super();
		DEPARTMENT_NAME = dEPARTMENT_NAME;
		MANAGER_ID = mANAGER_ID;
		LOCATION_ID = lOCATION_ID;
	}
	
	

}
