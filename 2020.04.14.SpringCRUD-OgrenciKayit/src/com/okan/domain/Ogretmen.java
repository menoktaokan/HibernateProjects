package com.okan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OGRETMEN")
public class Ogretmen {
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "OGR_SEQ", sequenceName = "OGR_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OGR_SEQ")
	private Integer id;
	
	@Column(name = "ADI")
	private String ad;
	
	@Column(name = "SOYADI")
	private String soyad;
	
	@Column(name = "EPOSTA")
	private String eposta;
	
	@Column(name = "OGRETMEN_DETAY_ID")
	private Integer ogretmenDetayId;

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

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public Integer getOgretmenDetayId() {
		return ogretmenDetayId;
	}

	public void setOgretmenDetayId(Integer ogretmenDetayId) {
		this.ogretmenDetayId = ogretmenDetayId;
	}

	public Ogretmen(String ad, String soyad, String eposta, Integer ogretmenDetayId) {
		this.ad = ad;
		this.soyad = soyad;
		this.eposta = eposta;
		this.ogretmenDetayId = ogretmenDetayId;
	}

	public Ogretmen() {
	}

	@Override
	public String toString() {
		return ad + " " + soyad;
	}
	
	

}
