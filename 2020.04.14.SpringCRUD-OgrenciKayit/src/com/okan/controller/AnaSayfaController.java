package com.okan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String girisYap(@Valid @ModelAttribute("kullanici") Kullanici kullanici, BindingResult br) {
		String kullaniciAdi=kullanici.getKullaniciAdi();
		String sifre=kullanici.getSifre();
		if(br.hasErrors())
			return "giris-ekrani";
		if(kullaniciServisi.girisYap(kullaniciAdi, sifre))
		return "index";
		return "giris-ekrani";
	}
}
