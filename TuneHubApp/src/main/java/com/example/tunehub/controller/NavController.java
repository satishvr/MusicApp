package com.example.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/map-register")
	public String mapRegister(){
		return "register";
	}
	@GetMapping("/map-login")
	public String mapLogin(){
		return "login";
	}
	@GetMapping("/map-songs")
	public String mapSongs(){
		return "addsongs";
	}
	@GetMapping("/samplePayment")
	public String razorPay(){
		return "samplePayment";
	}

}
