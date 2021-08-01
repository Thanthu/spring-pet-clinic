package com.thanthu.petclinic.model.services.map;

import com.thanthu.petclinic.model.Owner;
import com.thanthu.petclinic.model.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

	@Override
	public Owner save(Owner object) {
		return save(object.getId(), object);
	}

}
