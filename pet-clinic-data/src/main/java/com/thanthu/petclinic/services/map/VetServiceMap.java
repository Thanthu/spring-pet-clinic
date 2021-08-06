package com.thanthu.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.Vet;
import com.thanthu.petclinic.services.SpecialityService;
import com.thanthu.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;

	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Vet save(Vet object) {
		if (!object.getSpecialities().isEmpty()) {
			object.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					specialityService.save(speciality);
				}
			});
		}
		return super.save(object);
	}

}
