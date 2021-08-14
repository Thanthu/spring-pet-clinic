package com.thanthu.petclinic.services;

import java.util.List;

import com.thanthu.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
	
}
