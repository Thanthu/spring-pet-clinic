package com.thanthu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thanthu.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
