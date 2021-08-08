package com.thanthu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thanthu.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
