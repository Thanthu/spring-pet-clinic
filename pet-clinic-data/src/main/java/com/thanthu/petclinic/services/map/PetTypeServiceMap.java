package com.thanthu.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.PetType;
import com.thanthu.petclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}
