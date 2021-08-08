package com.thanthu.petclinic.services.map;

import com.thanthu.petclinic.model.Visit;
import com.thanthu.petclinic.services.VisitService;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Visit save(Visit object) {
		if (object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null
				|| object.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(object);
	}

}
