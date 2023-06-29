package com.humber.j2ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.humber.j2ee.models.Pet;
import com.humber.j2ee.services.PetService;

@SpringBootApplication
public class PetManagementAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PetManagementAppApplication.class, args);
	}
	
	@Autowired
	PetService petService;
	
	@Override
	public void run(String... args) throws Exception {
//		adding 5 pets to the h2 database on program startup
        petService.addPet(new Pet(0,"Rocky", Pet.Type.DOG, "Pitbull"));
        petService.addPet(new Pet(0,"Snowy", Pet.Type.DOG, "Shihtzu"));
        petService.addPet(new Pet(0,"Bela", Pet.Type.CAT, "Siamese"));
        petService.addPet(new Pet(0,"Mowy", Pet.Type.CAT, "Persian"));
        petService.addPet(new Pet(0,"Kali", Pet.Type.DOG, "Retriever"));
	}

}
