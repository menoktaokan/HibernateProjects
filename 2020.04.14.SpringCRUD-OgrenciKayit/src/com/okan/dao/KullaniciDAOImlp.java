package com.okan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okan.domain.Kullanici;

@Repository
public class KullaniciDAOImlp implements KullaniciDAO {

	@Autowired
	Kullanici kullanici;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Kullanici kullaniciGetir() {
		if(kullanici==null) {
			return new Kullanici();
		}
		else 
			return kullanici;
	}

	@Transactional
	@Override
	public boolean girisYap(String kullaniciAdı, String sifre) {
		Session session = sessionFactory.getCurrentSession();
		Kullanici kullaniciKontrol;
		try {
			kullaniciKontrol = session.get(Kullanici.class, kullaniciAdı);
			if(kullaniciKontrol.getSifre().equals(sifre)) {
				kullanici=kullaniciKontrol;
				return true;
			}
		} catch (Exception e) {
			
		}
		
		return false;
	}

	@Override
	public boolean kullaniciVarMı() {
		if(kullanici==null) {
			return false;
		}
		return true;
	}



}
