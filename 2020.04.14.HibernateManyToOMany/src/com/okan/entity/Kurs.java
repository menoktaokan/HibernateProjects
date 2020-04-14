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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "OGRENCI_KURS",
				joinColumns = @JoinColumn(name ="KURS_ID"),
				inverseJoinColumns = @JoinColumn(name="OGRENCI_ID"))
	private List<Ogrenci> ogrenciler;

	@ManyToOne
	@JoinColumn(name = "OGRETMEN_ID")
	private Ogretmen ogretmen;

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

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	public Kurs() {
	}

	public Kurs(String ad, Integer saat, Ogretmen ogretmen) {
		this.ad = ad;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}

	@Override
	public String toString() {
		return "Kurs [id=" + id + ", ad=" + ad + ", saat=" + saat + "]";
	}

	public void addOgrenci(Ogrenci o) {
		if(ogrenciler==null)
			ogrenciler= new ArrayList<Ogrenci>();
		ogrenciler.add(o);
	}
}
