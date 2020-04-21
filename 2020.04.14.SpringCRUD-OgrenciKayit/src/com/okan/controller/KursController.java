package com.okan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.okan.dao.KursDAO;
import com.okan.domain.Kurs;
import com.okan.service.KullaniciServisi;
import com.okan.service.KursServisi;

@Controller
@RequestMapping("/kurs")
public class KursController {
	
	@Autowired
	KursServisi kursServisi;
	
	@Autowired
	KullaniciServisi kullaniciServisi;
	
	@GetMapping("/list")
	public String kursListele(Model model) {
		
		List<Kurs> kurslar=kursServisi.getKurslar();
		model.addAttribute("kurs", kurslar);
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "kurs-liste";
	}
	
	@GetMapping("/kurs-ekle")
	public String kursEkle(Model model) {
		Kurs kurs = new Kurs();
		model.addAttribute("kurs", kurs);		
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "kurs-form";
	}
	
	@PostMapping("/kurs-kaydet")
	public String kursKaydet(@ModelAttribute("kurs") Kurs kurs) {
		
		kursServisi.saveKurs(kurs);	
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "redirect:/kurs/list";
	}

	@GetMapping("/kurs-guncelle")
	public String kursGuncelle(@RequestParam("ogrenciId") int kursId, Model model) {
		
		Kurs kurs = kursServisi.getKurs(kursId);
		
		model.addAttribute("kurs", kurs);		
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "kurs-form";
	}
	
	@GetMapping("/kurs-sil")
	public String kursSil(@RequestParam("ogrenciId") int kursId) {
		
//		Kurs kurs = kursServisi.getKurs(kursId);
			
		kursServisi.deleteKurs(kursId);
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "redirect:/kurs/list";
	}
	
	@RequestMapping("/index")
	public String anaSayfa() {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "redirect:../index";
	}
}
