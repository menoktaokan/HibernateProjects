package com.okan.service;

import com.okan.domain.Kullanici;

public interface KullaniciServisi {

	public Kullanici kullaniciGetir();

	public boolean girisYap(String kullaniciAdı, String sifre);

	public boolean kullaniciVarMı();




}
