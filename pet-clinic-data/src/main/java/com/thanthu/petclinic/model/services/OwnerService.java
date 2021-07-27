package com.thanthu.petclinic.model.services;

import java.util.Set;

import com.thanthu.petclinic.model.Owner;

public interface OwnerService {

	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
	
}
