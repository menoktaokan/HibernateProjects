package com.okan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Departments")
public class Department {

	// Oracle yazımı
	@Id
	@Column(name = "DEPARTMENT_ID")
	@SequenceGenerator(name = "dept_seq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	@Min(value = 0, message = "0'dan küçük değer girilemez")
	private Integer id;

//	@NotEmpty(message = "İsim boş olamaz!")
	@Column(name = "DEPARTMENT_NAME")
	private String name;
	
	@Min(value = 0, message = "0'dan küçük değer girilemez")
	@Column(name = "MANAGER_ID")
	private Integer managerId;
	
	@Min(value = 0, message = "0'dan küçük değer girilemez")
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

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Department(Integer id, String name, Integer magerId, Integer locationId) {
		super();
		this.id = id;
		this.name = name;
		this.managerId = magerId;
		this.locationId = locationId;
	}

	public Department() {
		super();
	}

	public Department(String name, Integer magerId, Integer locationId) {
		super();
		this.name = name;
		this.managerId = magerId;
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", managerId=" + managerId + ", locationId=" + locationId
				+ "]";
	}

}
