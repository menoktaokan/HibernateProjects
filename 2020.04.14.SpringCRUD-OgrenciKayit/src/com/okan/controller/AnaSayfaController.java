package com.okan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnaSayfaController {
	
	
	@RequestMapping("/index")
	public String anaSayfa() {
		
		return "index";
	}
}
