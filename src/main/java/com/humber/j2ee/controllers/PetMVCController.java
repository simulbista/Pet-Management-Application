package com.humber.j2ee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humber.j2ee.services.PetService;

@Controller
@RequestMapping("/pet")
public class PetMVCController {

//	get app name from application.properties file
	@Value("${pet.application.name}")
	private String appName;
	
	@Autowired
	PetService petService;
	
	@GetMapping("/")
//	model is passing values to the html file where it is read by thymeleaf
	public String home(Model model) {
		model.addAttribute("petAppName",appName);
		return "home";
	}
}
