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
public class Department {

	// Oracle yazımı
	@Id
	@Column(name = "DEPARTMENT_ID")
	@SequenceGenerator(name = "dept_seq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	private Integer id;

	/*
	 * @Id
	 * 
	 * @Column
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int
	 * DEPARTMENT_ID;
	 */

	@Column(name = "DEPARTMENT_NAME")
	private String name;

	@Column(name = "MANAGER_ID")
	private Integer namagerId;

	@Column(name = "LOCATION_ID")
	private Integer locationId;

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

	public Integer getNamagerId() {
		return namagerId;
	}

	public void setNamagerId(Integer namagerId) {
		this.namagerId = namagerId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Department(Integer id, String name, Integer namagerId, Integer locationId) {
		super();
		this.id = id;
		this.name = name;
		this.namagerId = namagerId;
		this.locationId = locationId;
	}

	public Department(String name, Integer namagerId, Integer locationId) {
		super();
		this.name = name;
		this.namagerId = namagerId;
		this.locationId = locationId;
	}

	public Department() {
		super();
	}

 }
