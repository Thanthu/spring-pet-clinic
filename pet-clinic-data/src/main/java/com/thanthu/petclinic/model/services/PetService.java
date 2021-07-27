package com.thanthu.petclinic.model.services;

import java.util.Set;

import com.thanthu.petclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
	
}
