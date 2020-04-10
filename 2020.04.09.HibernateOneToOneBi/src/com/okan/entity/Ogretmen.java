package com.okan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OGRETMEN")
public class Ogretmen {

	// Oracle yazımı
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "ogr_seq", sequenceName = "OGR_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ogr_seq")
	private Integer id;

	// OGRETMEN_DETAY NUMBER
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ogretmen_detay_id")
	private OgretmenDetay ogretmenDetay;
	/*
	 * @Id
	 * 
	 * @Column
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int
	 * DEPARTMENT_ID;
	 */

	
	@Column(name = "ADI")
	private String ad;

	@Column(name = "SOYADI")
	private String soyad;

	@Column(name = "EPOSTA")
	private String eposta;

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

	public Ogretmen() {
	}

	public Ogretmen(OgretmenDetay ogretmenDetay, String ad, String soyad, String eposta) {
		this.ogretmenDetay = ogretmenDetay;
		this.ad = ad;
		this.soyad = soyad;
		this.eposta = eposta;
	}



	@Override
	public String toString() {
		return "Ogretmen [id=" + id  + ", ad=" + ad + ", soyad=" + soyad
				+ ", eposta=" + eposta + "]";
	}

	
}
