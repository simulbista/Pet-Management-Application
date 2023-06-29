package com.humber.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.humber.j2ee.models.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {

}
