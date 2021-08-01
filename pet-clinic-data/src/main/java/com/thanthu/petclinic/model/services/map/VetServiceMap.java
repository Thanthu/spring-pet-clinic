package com.thanthu.petclinic.model.services.map;

import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.Vet;
import com.thanthu.petclinic.model.services.CrudService;
import com.thanthu.petclinic.model.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

}
