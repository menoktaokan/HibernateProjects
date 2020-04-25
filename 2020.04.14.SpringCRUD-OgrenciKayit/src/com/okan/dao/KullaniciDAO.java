package com.okan.dao;

import java.util.Map;

import com.okan.domain.Kullanici;
import com.okan.domain.Ogretmen;

public interface KullaniciDAO {

	Kullanici kullaniciGetir();

	boolean girisYap(String kullaniciAdi, String sifre);

	boolean kullaniciVarMı();

	Map<Integer, Ogretmen> getOgretmenler();


}
