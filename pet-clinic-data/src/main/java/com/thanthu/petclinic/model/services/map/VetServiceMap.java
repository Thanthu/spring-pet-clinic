package com.thanthu.petclinic.model.services.map;

import com.thanthu.petclinic.model.Vet;
import com.thanthu.petclinic.model.services.CrudService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

	@Override
	public Vet save(Vet object) {
		return save(object.getId(), object);
	}

}
