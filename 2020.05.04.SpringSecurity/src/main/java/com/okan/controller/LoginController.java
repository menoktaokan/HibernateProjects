package com.okan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("loginForm")
	public String showLogin() {
		
		return "custom-login";
	}

}