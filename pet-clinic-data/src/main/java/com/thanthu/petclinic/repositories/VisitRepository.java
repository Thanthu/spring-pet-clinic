package com.thanthu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thanthu.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
