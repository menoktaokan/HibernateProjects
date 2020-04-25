package com.okan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Entity
@Table(name = "LOGIN_DB")
public class Kullanici {

	@Id
	@Column(name = "USER_NAME")
	@NotEmpty(message = "Boş geçilemez gardaş")
	private String kullaniciAdi;

	@Column(name = "PASSWORD")
	@NotEmpty(message = "Boş geçilemez gardaş")
	private String sifre;

	@Column(name = "NAME")
	private String ad;

	@Column(name = "SURNAME")
	private String soyad;

	@Column(name = "ROLE")
	private String rol;
	
	@Column(name = "DURUM")
	private Integer durum;

	
	public Integer getDurum() {
		return durum;
	}

	public void setDurum(Integer durum) {
		this.durum = durum;
	}

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kullanici other = (Kullanici) obj;
		if (kullaniciAdi == null) {
			if (other.kullaniciAdi != null)
				return false;
		} else if (!kullaniciAdi.equals(other.kullaniciAdi))
			return false;
		if (sifre == null) {
			if (other.sifre != null)
				return false;
		} else if (!sifre.equals(other.sifre))
			return false;
		return true;
	}

}
