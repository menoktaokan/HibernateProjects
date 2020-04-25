package com.okan.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okan.domain.Kullanici;
import com.okan.domain.Ogretmen;

@Repository
public class KullaniciDAOImlp implements KullaniciDAO {

	

	@Autowired
	Kullanici kullanici;

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Kullanici kullaniciGetir() {
	
		System.out.println("\n\n"+kullanici+"\n\n");

		return kullanici;
	}

	@Transactional
	@Override
	public boolean girisYap(String kullaniciAdi, String sifre) {
		Session session = sessionFactory.getCurrentSession();
		Kullanici kullaniciKontrol;
		try {
			kullaniciKontrol = session.get(Kullanici.class, kullaniciAdi);			
			if (kullaniciKontrol.getSifre().equals(sifre)) {
				kullanici.setAd(kullaniciKontrol.getAd());
				kullanici.setSoyad(kullaniciKontrol.getSoyad());
				kullanici.setKullaniciAdi(kullaniciAdi);
				kullanici.setSifre(sifre);
				kullanici.setRol(kullaniciKontrol.getRol());
				return true;
			}
		} catch (Exception e) {

		}

		return false;
	}

	@Override
	public boolean kullaniciVarMı() {
		System.out.println(kullanici.getRol());
		if(kullanici.getKullaniciAdi()==null)
			return false;
		return true;
	}

	@Override
	public Map<Integer, Ogretmen> getOgretmenler() {
		Session session = sessionFactory.getCurrentSession();
		List<Ogretmen> ogretmenList=session.createQuery("from Ogretmen", Ogretmen.class).getResultList();
		Map<Integer, Ogretmen> getOgretmenler=new HashMap<Integer, Ogretmen>();
		for (Ogretmen ogr : ogretmenList){
			getOgretmenler.put(ogr.getId(), ogr);
		}
		return getOgretmenler;
	}

}
