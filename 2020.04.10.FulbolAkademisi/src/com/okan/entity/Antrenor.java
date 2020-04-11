package com.okan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ANTRENOR")
public class Antrenor {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "ant_seq", sequenceName = "ANTRENOR_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ant_seq")
	private Integer id;
	
	@OneToOne(mappedBy = "antrenor")  //******
	private Takim takim;

	@Column(name = "AD")
	private String ad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Takim getTakim() {
		return takim;
	}

	public void setTakim(Takim takim) {
		this.takim = takim;
	}

	public Antrenor() {
	}

	@Override
	public String toString() {
		return "Antrenor [id= " + id + ", ad= " + ad + "]";
	}

	public Antrenor(Takim takim, String ad) {
		this.takim = takim;
		this.ad = ad;
	}
	
	public void add(Takim t) {
		this.setTakim(t);
	}

}
