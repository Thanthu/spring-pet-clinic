package com.thanthu.petclinic.model.services.map;

import com.thanthu.petclinic.model.Pet;
import com.thanthu.petclinic.model.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

	@Override
	public Pet save(Pet object) {
		return save(object.getId(), object);
	}

}
