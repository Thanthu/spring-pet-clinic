package com.thanthu.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.PetType;
import com.thanthu.petclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}
