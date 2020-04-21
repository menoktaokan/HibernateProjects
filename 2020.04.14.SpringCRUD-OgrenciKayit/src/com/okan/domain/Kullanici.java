package com.okan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
@Entity
@Table(name = "LOGIN_DB")
public class Kullanici {

	@Id
	@Column(name = "USER_NAME")
	private String kullaniciAdi;

	@Column(name = "PASSWORD")
	private String sifre;

	@Column(name = "NAME")
	private String ad;

	@Column(name = "SURNAME")
	private String soyad;

	@Column(name = "ROLE")
	private String rol;

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Kullanici(String kullaniciAdi, String sifre, String ad, String soyad, String rol) {
		this.kullaniciAdi = kullaniciAdi;
		this.sifre = sifre;
		this.ad = ad;
		this.soyad = soyad;
		this.rol = rol;
	}

	public Kullanici() {
	}

}
