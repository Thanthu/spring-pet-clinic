package com.thanthu.petclinic.services.map;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.Owner;
import com.thanthu.petclinic.services.OwnerService;
import com.thanthu.petclinic.services.PetService;
import com.thanthu.petclinic.services.PetTypeService;

@Service
@Profile({ "default", "map" })
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner object) {
		if (object != null) {
			if (object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							petTypeService.save(pet.getPetType());
						}
					} else {
						throw new RuntimeException("Pet Type is required.");
					}

					if (pet.getId() == null) {
						petService.save(pet);
					}
				});
			}
		}
		return super.save(object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst()
				.orElse(null);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
