package com.okan.dao;

import com.okan.domain.Kullanici;

public interface KullaniciDAO {

	Kullanici kullaniciGetir();

	boolean girisYap(String kullaniciAdı, String sifre);

	boolean kullaniciVarMı();


}
