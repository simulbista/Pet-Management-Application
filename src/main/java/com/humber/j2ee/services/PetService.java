package com.humber.j2ee.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.humber.j2ee.models.Pet;
import com.humber.j2ee.repository.PetRepository;

@Service
public class PetService {
	
	@Autowired
	PetRepository petRepository;
	
	//add a single pet record
	public void addPet(Pet pet) {
		petRepository.save(pet);
	}
	
	//get all pet records
	public List<Pet> getAllPets(){
		return petRepository.findAll();
	}
	
	//update pet
	public void updatePet(Pet pet) {
		petRepository.save(pet);
	}
	
	//delete pet by id
	public void deletePetById(int id){
		petRepository.deleteById(id);
	}
	
//	//add multiple pets (list of pets)
//	@Transactional
////	transactional ensures that entire batch of entity insertions happens within a single transaction, 
////	providing better performance.
//	public void addMultiplePets(List<Pet> pets) {
//		petRepository.saveAll(pets);
//	}
}
