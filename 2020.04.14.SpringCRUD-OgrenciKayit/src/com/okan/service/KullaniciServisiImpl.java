package com.okan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okan.dao.KullaniciDAO;
import com.okan.domain.Kullanici;

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
	public boolean girisYap(String kullaniciAdı, String sifre) {
		
		return kullaniciDAO.girisYap(kullaniciAdı, sifre);
	}

	@Override
	public boolean kullaniciVarMı() {
		// TODO Auto-generated method stub
		return kullaniciDAO.kullaniciVarMı();
	}



}
