package com.okan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.okan.domain.Kullanici;
import com.okan.service.KullaniciServisi;

@Controller
public class AnaSayfaController {
	
	@Autowired
	KullaniciServisi kullaniciServisi;
	
	@GetMapping("/")
	public String girisEkrani(Model m) {
		
		Kullanici k1= kullaniciServisi.kullaniciGetir();

		
		m.addAttribute("kullanici", k1);
		return "giris-ekrani";
	}
	
	@RequestMapping("/index")
	public String anaSayfa() {
		
		return "index";
	}

	@PostMapping("/girisYap")
	public String girisYap(@ModelAttribute("kullanici") Kullanici kullanici) {
		String kullaniciAdı=kullanici.getKullaniciAdi();
		String sifre=kullanici.getSifre();
		if(kullaniciServisi.girisYap(kullaniciAdı, sifre))
		
		return "index";
		return "giris-ekrani";
	}
}
