package com.thanthu.petclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.PetType;
import com.thanthu.petclinic.repositories.PetTypeRepository;
import com.thanthu.petclinic.services.PetTypeService;

@Service
@Profile("jpa")
public class PetTypeServiceJpa implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<PetType>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}
