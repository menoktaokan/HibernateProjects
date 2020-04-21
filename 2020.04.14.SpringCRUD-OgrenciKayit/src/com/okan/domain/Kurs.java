package com.okan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KURS")
public class Kurs {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "kurs_seq", sequenceName = "KURS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs_seq")
	private Integer id;

	@Column(name = "ADI")
	private String ad;

	@Column(name = "SAATI")
	private Integer saat;
	
	

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

	public Integer getSaat() {
		return saat;
	}

	public void setSaat(Integer saat) {
		this.saat = saat;
	}

	public Kurs(String ad, Integer saat) {
		super();
		this.ad = ad;
		this.saat = saat;
	}

	public Kurs() {
		super();
	}

}
