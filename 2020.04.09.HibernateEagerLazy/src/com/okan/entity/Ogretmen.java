package com.okan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ogretmen", cascade = CascadeType.ALL)
	private List<Kurs> kurslar;

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

	public OgretmenDetay getOgretmenDetay() {
		return ogretmenDetay;
	}

	public void setOgretmenDetay(OgretmenDetay ogretmenDetay) {
		this.ogretmenDetay = ogretmenDetay;
	}

	public List<Kurs> getKurslar() {
		return kurslar;
	}

	public void setKurslar(List<Kurs> kurslar) {
		this.kurslar = kurslar;
	}

	public Ogretmen() {
	}

	public Ogretmen(OgretmenDetay ogretmenDetay, String ad, String soyad, String eposta) {
		this.ogretmenDetay = ogretmenDetay;
		this.ad = ad;
		this.soyad = soyad;
		this.eposta = eposta;
	}

	public void add(Kurs kurs) {
		if (kurslar == null)
			kurslar = new ArrayList<Kurs>();
		kurslar.add(kurs);
		kurs.setOgretmen(this);
	}

	@Override
	public String toString() {
		return "Ogretmen [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", eposta=" + eposta + "]";
	}

}
