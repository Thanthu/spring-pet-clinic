package com.thanthu.petclinic.model.services;

import java.util.Set;

import com.thanthu.petclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
	
}
