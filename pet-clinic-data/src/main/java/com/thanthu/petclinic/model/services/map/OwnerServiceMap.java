package com.thanthu.petclinic.model.services.map;

import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.Owner;
import com.thanthu.petclinic.model.services.CrudService;
import com.thanthu.petclinic.model.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner save(Owner object) {
		return save(object.getId(), object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
