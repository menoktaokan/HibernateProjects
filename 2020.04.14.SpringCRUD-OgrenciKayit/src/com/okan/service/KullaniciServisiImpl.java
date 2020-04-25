package com.okan.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okan.dao.KullaniciDAO;
import com.okan.domain.Kullanici;
import com.okan.domain.Ogretmen;

@Service
public class KullaniciServisiImpl implements KullaniciServisi {

	@Autowired
	KullaniciDAO kullaniciDAO;
	
	@Transactional
	@Override
	public Kullanici kullaniciGetir() {
		
		return kullaniciDAO.kullaniciGetir();
//		return null;
	}

	@Transactional
	@Override
	public boolean girisYap(String kullaniciAdi, String sifre) {
		
		return kullaniciDAO.girisYap(kullaniciAdi, sifre);
	}

	@Override
	public boolean kullaniciVarMı() {
		// TODO Auto-generated method stub
		return kullaniciDAO.kullaniciVarMı();
	}

	@Transactional
	@Override
	public Map<Integer, Ogretmen> getOgretmenler() {
		// TODO Auto-generated method stub
		return kullaniciDAO.getOgretmenler();
	}



}
