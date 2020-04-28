package com.okan.controller;

import java.util.List;
import java.util.Map;

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
import com.okan.domain.Ogretmen;
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
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		List<Kurs> kurslar=kursServisi.getKurslar();
		model.addAttribute("kurs", kurslar);
		Kurs kursAra = new Kurs();
		model.addAttribute("kursAra", kursAra);
		return "kurs-liste";
	}
	
	@GetMapping("/kurs-ekle")
	public String kursEkle(Model model) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		
		Kurs kurs = new Kurs();
		model.addAttribute("kurs", kurs);		
		return "kurs-form";
	}
	
	@PostMapping("/kurs-kaydet")
	public String kursKaydet(@ModelAttribute("kurs") Kurs kurs) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		
		kursServisi.saveKurs(kurs);	
		
		return "redirect:/kurs/list";
	}

	@GetMapping("/kurs-guncelle")
	public String kursGuncelle(@RequestParam("ogrenciId") int kursId, Model model) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		
		Kurs kurs = kursServisi.getKurs(kursId);
		model.addAttribute("kurs", kurs);		
		
		return "kurs-form";
	}
	
	@GetMapping("/kurs-sil")
	public String kursSil(@RequestParam("ogrenciId") int kursId) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
//		Kurs kurs = kursServisi.getKurs(kursId);
			
		kursServisi.deleteKurs(kursId);
		
		return "redirect:/kurs/list";
	}
	
	@RequestMapping("/index")
	public String anaSayfa() {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "redirect:../index";
	}
	
	@ModelAttribute("ogretmenler")
	public Map<Integer, Ogretmen> getOgretmenler(){
		
		
		return kullaniciServisi.getOgretmenler();
	}
	
	@PostMapping("/kurs-ara")
	public String kursAra(@ModelAttribute("kursAra") Kurs kursAra, Model model) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		System.out.println(kursAra.getId()+" "+kursAra.getAd()+" "+kursAra.getSaat()+" "+kursAra.getOgretmen().getId());
		List<Kurs>  arananKurslar =kursServisi.searchKurs(kursAra);
		model.addAttribute("kurs", arananKurslar);
		
		return "kurs-liste";
	}
}
