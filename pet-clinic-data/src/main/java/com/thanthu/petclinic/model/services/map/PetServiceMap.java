package com.thanthu.petclinic.model.services.map;

import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.Pet;
import com.thanthu.petclinic.model.services.CrudService;
import com.thanthu.petclinic.model.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet object) {
		return save(object.getId(), object);
	}

}
