package com.okan.service;

import java.util.Map;

import com.okan.domain.Kullanici;
import com.okan.domain.Ogretmen;

public interface KullaniciServisi {

	Map<Integer, Ogretmen> getOgretmenler();

	public Kullanici kullaniciGetir();

	public boolean girisYap(String kullaniciAdi, String sifre);

	public boolean kullaniciVarMı();




}
