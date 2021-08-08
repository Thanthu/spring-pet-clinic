package com.thanthu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thanthu.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
