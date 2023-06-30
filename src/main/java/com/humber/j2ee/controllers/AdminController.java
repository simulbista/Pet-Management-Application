package com.humber.j2ee.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.humber.j2ee.models.Pet;
import com.humber.j2ee.services.PetService;

@Controller
@RequestMapping("/pet/admin")
public class AdminController {

//	get app name from application.properties file
	@Value("${pet.application.name}")
	private String appName;
	
	@Autowired
	PetService petService;
	
	//admin page
	@GetMapping("/")
	public String petDetail(Model model, @RequestParam(required=false) String success) {
		model.addAttribute("pets", petService.getAllPets());
		model.addAttribute("success",success);
		return "admin";
	}
	
	//get id to update when update button is clicked and get the respective pet detail and display in the form to be updated by the admin
	@GetMapping("/updatebyid/{id}")
	public String getIdToUpdate(Model model, @PathVariable int id) {
		Optional<Pet> petToUpdate;
		petToUpdate = petService.getPetById(id);
		model.addAttribute("pet",petToUpdate.orElse(null));
		return "petform";
	}
	
	//when the admin hits update in the form
	@PostMapping("/update")
	public String updatePet(@ModelAttribute("pet") Pet updatedPet) {
	    petService.updatePet(updatedPet);
	    return "redirect:/pet/admin/?success=Pet Updated Successfully!";
	}
	
	//open the form to add pet
	@GetMapping("/add")
	public String addPet(Model model) {
//		since im using the same form to add and update, the form for update asks for pet to be filled in by default, hence sending empty pet object
		model.addAttribute("pet",new Pet());
		return "petform";
	}
	
	//to save the pet data that is submitted from the form 
	@PostMapping("/add")
	public String addPet(@ModelAttribute("pet") Pet pet, Model model) {
	    petService.addPet(pet);
	    return "redirect:/pet/admin/?success=Pet Added Successfully!";
	}
	
}
