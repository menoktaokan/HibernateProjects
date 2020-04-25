package com.okan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OGRENCI")
public class Ogrenci {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "ogr_seq", sequenceName = "OGRENCI_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ogr_seq")
	private Integer id;

	@Column(name = "ISIM")
	private String ad;

	@Column(name = "SOYISIM")
	private String soyad;

	@Column(name = "OGRENCI_NO")
	private Integer ogrenciNo;
	
	@Column(name = "DURUM")
	private Integer durum;

	
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

	public Integer getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(Integer ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	public Integer getDurum() {
		return durum;
	}

	public void setDurum(Integer durum) {
		this.durum = durum;
	}

	public Ogrenci() {
	}

	public Ogrenci(String ad, String soyad, Integer ogrenciNo) {
		this.ad = ad;
		this.soyad = soyad;
		this.ogrenciNo = ogrenciNo;
	}
	
	
}
