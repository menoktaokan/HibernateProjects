package com.okan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OGRETMEN_DETAY")
public class OgretmenDetay {

	// Oracle yazımı
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "ogr_detay_seq", sequenceName = "OGR_DETAY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ogr_detay_seq")
	private Integer id;

	/*
	 * @Id
	 * 
	 * @Column
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int
	 * DEPARTMENT_ID;
	 */

	@Column(name = "UZMANLIK")
	private String uzmanlik;

	@Column(name = "HOBILER")
	private String hobiler;

	@Column(name = "WEB_SITE")
	private String webSite;

	@Column(name = "FB_SAYFASI")
	private String fbSayfasi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUzmanlik() {
		return uzmanlik;
	}

	public void setUzmanlik(String uzmanlik) {
		this.uzmanlik = uzmanlik;
	}

	public String getHobiler() {
		return hobiler;
	}

	public void setHobiler(String hobiler) {
		this.hobiler = hobiler;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getFbSayfasi() {
		return fbSayfasi;
	}

	public void setFbSayfasi(String fbSayfasi) {
		this.fbSayfasi = fbSayfasi;
	}

	public OgretmenDetay() {
	}

	public OgretmenDetay(String uzmanlik, String hobiler, String webSite, String fbSayfasi) {
		this.uzmanlik = uzmanlik;
		this.hobiler = hobiler;
		this.webSite = webSite;
		this.fbSayfasi = fbSayfasi;
	}

}
