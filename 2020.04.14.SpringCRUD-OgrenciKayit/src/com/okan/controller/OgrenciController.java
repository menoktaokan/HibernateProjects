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

import com.okan.domain.Ogrenci;
import com.okan.service.KullaniciServisi;
import com.okan.service.OgrenciServisi;

@Controller
@RequestMapping("/ogrenci")
public class OgrenciController {
	
	@Autowired
	OgrenciServisi ogrenciServisi;
	
	@Autowired
	KullaniciServisi kullaniciServisi;

//	@RequestMapping(path = "/list", method = RequestMethod.GET)
	@GetMapping("/list") //sayfa geçişleri için
//	@PostMapping("/list") //form verilerini gönderirken
	public String listOgrenci(Model model) {
		List<Ogrenci>ogrList= ogrenciServisi.getOgrenciler();
		
		model.addAttribute("ogrenciler", ogrList);
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "ogrenci-list";
	}
	
	@GetMapping("/ogrenci-ekle")
	public String ogrenciEkle(Model model) {
		
		Ogrenci ogr = new Ogrenci();
		
		model.addAttribute("ogrenci", ogr);
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "ogrenci-form";
	}
	
	@PostMapping("/ogrenci-kaydet")
	public String ogrenciKaydet(@ModelAttribute("ogrenci") Ogrenci ogr) {
		ogrenciServisi.saveOgrenci(ogr);
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "redirect:/ogrenci/list";
	}
	
	@GetMapping("/ogrenci-guncelle")
	public String ogrenciGuncelle(@RequestParam("ogrenciId") int ogrId, Model model) {
		
		Ogrenci ogr = ogrenciServisi.getOgrenci(ogrId);
		model.addAttribute("ogrenci", ogr);
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "ogrenci-form";
	}
	
	@GetMapping("/ogrenci-sil")
	public String ogrenciSil(@RequestParam("ogrenciId") int ogrId) {
		
		ogrenciServisi.deleteOgrenci(ogrId);
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";;
		return "redirect:/ogrenci/list";
	}
	
	@RequestMapping("/index")
	public String anaSayfa() {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		return "redirect:../index";
	}
}
