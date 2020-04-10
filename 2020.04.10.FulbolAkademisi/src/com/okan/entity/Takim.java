package com.okan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAKIMLAR")
public class Takim {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "tkm_seq", sequenceName = "TAKIM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tkm_seq")
	private Integer id;

	@Column(name = "AD")
	private String ad;

	@JoinColumn(name = "ANTRENOR_ID")
	private Antrenor antrenor;

	@OneToMany(mappedBy = "FUTBOLCULAR", cascade = CascadeType.ALL)
	private List<Futbolcu> futbolcular;

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

	public Antrenor getAntrenor() {
		return antrenor;
	}

	public void setAntrenor(Antrenor antrenor) {
		this.antrenor = antrenor;
	}

	public List<Futbolcu> getFutbolcular() {
		return futbolcular;
	}

	public void setFutbolcular(List<Futbolcu> futbolcular) {
		this.futbolcular = futbolcular;
	}

	public Takim() {
	}

	public Takim(String ad, Antrenor antrenor) {
		this.ad = ad;
		this.antrenor = antrenor;
	}

	@Override
	public String toString() {
		return "Takim [id= " + id + ", ad= " + ad + ", antrenor= " + antrenor.getAd() + "]";
	}

	public void add(Futbolcu f) {
		if (futbolcular == null) {
			futbolcular = new ArrayList<Futbolcu>();
			futbolcular.add(f);
			f.setTakim(this);
		}
	}

}
