package com.humber.j2ee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.humber.j2ee.services.PetService;

@Controller
@RequestMapping("/pet")
public class PetMVCController {

//	get app name from application.properties file
	@Value("${pet.application.name}")
	private String appName;
	
	@Autowired
	PetService petService;
	
//	display pet info in the home page for non admin users
	@GetMapping("/")
//	model is passing values to the html file where it is read by thymeleaf
	public String home(Model model, @RequestParam(required=false) String success) {
		model.addAttribute("petAppName",appName);
		model.addAttribute("success",success);
		model.addAttribute("pets", petService.getAllPets());
		return "home";
	}
	
//  delete api endpoint for the user in the home page
	@GetMapping("/delete/{id}")
	public String deletePet(@PathVariable int id) {
		petService.deletePetById(id);
		return "redirect:/pet/?success=Pet Deleted Successfully!";
	}
	
}
