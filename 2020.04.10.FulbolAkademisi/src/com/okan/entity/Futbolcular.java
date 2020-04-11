package com.okan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FUTBOLCULAR")
public class Futbolcular {
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "fut_seq", sequenceName = "FULBOLCU_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fut_seq")
	private Integer id;

	@Column(name = "AD")
	private String ad;
	
	@ManyToOne  //*********
	@JoinColumn(name = "TAKIM_ID")
	private Takim takim;

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

	public Futbolcular(String ad, Takim takim) {
		this.ad = ad;
		this.takim = takim;
	}

	public Futbolcular() {
	}

	@Override
	public String toString() {
		return "Futbolcular [id=" + id + ", ad=" + ad + "]";
	}
	
	  

}
