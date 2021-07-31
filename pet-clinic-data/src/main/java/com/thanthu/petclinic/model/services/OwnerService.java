package com.thanthu.petclinic.model.services;

import com.thanthu.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
}
