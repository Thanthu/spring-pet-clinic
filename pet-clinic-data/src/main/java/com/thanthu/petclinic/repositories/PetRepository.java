package com.thanthu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thanthu.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
